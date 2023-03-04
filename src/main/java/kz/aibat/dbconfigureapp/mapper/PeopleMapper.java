package kz.aibat.dbconfigureapp.mapper;

import kz.aibat.dbconfigureapp.dto.PeopleDTO;
import kz.aibat.dbconfigureapp.model.People;
import org.mapstruct.Mapper;

@Mapper
public interface PeopleMapper {
    PeopleDTO peopleToPeopleDTO(People people);

    People peopleDTOToPeople(PeopleDTO peopleDTO);
}
