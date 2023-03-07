package kz.aibat.dbconfigureapp.controllers;

import kz.aibat.dbconfigureapp.dao.jdbcapi.PersonDAO;
import kz.aibat.dbconfigureapp.dto.PersonDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/jdbcapi")
@RequiredArgsConstructor
public class JdbcApiController {

    private final PersonDAO personDAO;

    @GetMapping()
    public ResponseEntity<List<PersonDTO>> list(){
        return new ResponseEntity<>(personDAO.index(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> list(@PathVariable("id") Long id){
        return null;
    }
}
