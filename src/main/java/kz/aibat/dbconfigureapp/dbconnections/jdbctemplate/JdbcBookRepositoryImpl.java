package kz.aibat.dbconfigureapp.dbconnections.jdbctemplate;

import kz.aibat.dbconfigureapp.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JdbcBookRepositoryImpl implements BookRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcBookRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(Book book) {
        return jdbcTemplate.update("INSERT INTO book (name, price) values (?, ?)", book.getName(), book.getPrice());
    }

    @Override
    public int update(Book book) {
        return jdbcTemplate.update("UPDATE book SET price=? where id=?",book.getPrice(), book.getId());
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM book where id = ?", id);
    }

    @Override
    public List<Book> findAll() {
        return jdbcTemplate.query("SELECT * FROM book", new BookRowMapper());
    }

    @Override
    public Optional<Book> findById(Long id) {
        try {
            return jdbcTemplate.queryForObject(
                    "SELECT * FROM book WHERE id = ?",
                    (rs, rowNum) -> Optional.of(new Book(
                                    rs.getLong("id"),
                                    rs.getString("name"),
                                    rs.getBigDecimal("price")
                            )
                    ),
                    id
            );
        }catch (EmptyResultDataAccessException e){
            return Optional.empty();
        }

    }
}
