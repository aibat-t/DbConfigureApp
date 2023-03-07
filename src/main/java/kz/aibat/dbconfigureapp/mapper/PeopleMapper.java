package kz.aibat.dbconfigureapp.mapper;

import kz.aibat.dbconfigureapp.dto.PersonDTO;
import kz.aibat.dbconfigureapp.model.Person;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PeopleMapper {
    PersonDTO personToPersonDTO(Person people);

    Person personDTOToPerson(PersonDTO personDTO);

    List<PersonDTO> personListToPersonDTOList(List<Person> personList);
}
