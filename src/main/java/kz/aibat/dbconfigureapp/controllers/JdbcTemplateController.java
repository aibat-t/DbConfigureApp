package kz.aibat.dbconfigureapp.controllers;

import kz.aibat.dbconfigureapp.dto.BookDTO;
import kz.aibat.dbconfigureapp.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> show(@PathVariable("id") Long id) {
        return new ResponseEntity<>(bookService.getBookById(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public int save(@RequestBody BookDTO bookDTO) {
        return bookService.saveBook(bookDTO);
    }

    @PatchMapping("/update/{id}")
    public int update(@PathVariable("id") Long id, @RequestBody BookDTO bookDTO) {
        return bookService.updateBook(id, bookDTO);
    }

    @DeleteMapping("/delete/{id}")
    public int delete(@PathVariable("id") Long id) {
        return bookService.deleteBook(id);
    }
}
