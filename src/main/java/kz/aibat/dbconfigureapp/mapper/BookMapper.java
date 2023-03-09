package kz.aibat.dbconfigureapp.mapper;

import kz.aibat.dbconfigureapp.dto.BookDTO;
import kz.aibat.dbconfigureapp.model.Book;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDTO BookToBootDTO(Book book);
    Book BookDTOToBook(BookDTO bookDTO);

    List<BookDTO> BookListToBookDTOList(List<Book> bookList);
}
