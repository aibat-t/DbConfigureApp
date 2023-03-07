package kz.aibat.dbconfigureapp.dao.jdbcapi;

import kz.aibat.dbconfigureapp.dto.PersonDTO;
import kz.aibat.dbconfigureapp.mapper.PeopleMapper;
import kz.aibat.dbconfigureapp.model.Person;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private static final String URL = "jdbc:postgresql://localhost:5432/DBConfigure";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";
    private static Connection connection;

    private final PeopleMapper mapper = Mappers.getMapper(PeopleMapper.class);

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<PersonDTO> index() {
        List<Person> people = new ArrayList<>();

        try{
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Person";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()){
                Person person = new Person();

                person.setId(resultSet.getLong("id"));
                person.setName(resultSet.getString("name"));
                person.setSurname(resultSet.getString("surname"));
                person.setBirthDate(resultSet.getTimestamp("birth_date").toLocalDateTime());
                person.setEmail(resultSet.getString("email"));

                people.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return mapper.personListToPersonDTOList(people);
    }

    public PersonDTO show(Long id) {
        return null;
    }
}
