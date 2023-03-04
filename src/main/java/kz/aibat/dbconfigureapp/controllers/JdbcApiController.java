package kz.aibat.dbconfigureapp.controllers;

import kz.aibat.dbconfigureapp.dto.PeopleDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jdbcapi")
public class JdbcApiController {

    @GetMapping()
    public ResponseEntity<PeopleDTO> list(){
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeopleDTO> list(@PathVariable("id") Long id){
        return null;
    }
}
