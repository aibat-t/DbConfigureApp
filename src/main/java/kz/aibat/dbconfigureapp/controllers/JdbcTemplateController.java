package kz.aibat.dbconfigureapp.controllers;

import kz.aibat.dbconfigureapp.dto.BookDTO;
import kz.aibat.dbconfigureapp.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jdbctemplate")
@RequiredArgsConstructor
public class JdbcTemplateController {

    private final BookService bookService;

    @GetMapping()
    public ResponseEntity<List<BookDTO>> list(){
        return new ResponseEntity<>(bookService.getBookList(), HttpStatus.OK);
    }
}
