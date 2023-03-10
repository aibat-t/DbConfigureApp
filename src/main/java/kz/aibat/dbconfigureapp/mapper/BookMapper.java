package kz.aibat.dbconfigureapp.mapper;

import kz.aibat.dbconfigureapp.dto.BookDTO;
import kz.aibat.dbconfigureapp.model.Book;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDTO bookToBookDTO(Book book);
    Book bookDTOToBook(BookDTO bookDTO);
    List<BookDTO> bookListToBookDTOList(List<Book> bookList);
}
