package kz.aibat.dbconfigureapp.controllers;

import kz.aibat.dbconfigureapp.dao.jdbcapi.PersonDAO;
import kz.aibat.dbconfigureapp.dto.PersonDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        return new ResponseEntity<>(personDAO.show(id), HttpStatus.OK);
    }

    @PutMapping("/save")
    public ResponseEntity<Integer> save(@RequestBody PersonDTO personDTO){
        return new ResponseEntity<>(personDAO.save(personDTO), HttpStatus.OK);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Integer> update(@RequestBody PersonDTO personDTO, @PathVariable("id") Long id){
        return new ResponseEntity<>(personDAO.update(id, personDTO), HttpStatus.OK);
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<Integer> delete(@PathVariable("id") Long id){
        return new ResponseEntity<>(personDAO.delete(id), HttpStatus.OK);
    }
}
