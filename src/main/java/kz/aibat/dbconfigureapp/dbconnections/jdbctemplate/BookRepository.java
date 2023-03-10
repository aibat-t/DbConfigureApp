package kz.aibat.dbconfigureapp.dbconnections.jdbctemplate;

import kz.aibat.dbconfigureapp.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {

    int save(Book book);

    int update(Book book);

    int deleteById(Long id);

    List<Book> findAll();

    Optional<Book> findById(Long id);
}
