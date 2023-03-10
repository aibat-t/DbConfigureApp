package kz.aibat.dbconfigureapp.service;

import kz.aibat.dbconfigureapp.dbconnections.jdbctemplate.JdbcBookRepositoryImpl;
import kz.aibat.dbconfigureapp.dto.BookDTO;
import kz.aibat.dbconfigureapp.mapper.BookMapper;
import kz.aibat.dbconfigureapp.model.Book;
import lombok.RequiredArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final JdbcBookRepositoryImpl jdbcBookRepository;

    private final BookMapper mapper = Mappers.getMapper(BookMapper.class);

    public List<BookDTO> getBookList(){
        return mapper.bookListToBookDTOList(jdbcBookRepository.findAll());
    }

    public BookDTO getBookById(Long id) {
        Optional<Book> opBook = jdbcBookRepository.findById(id);
        if(opBook.isEmpty()){
            throw new ObjectNotFoundException("book do not exist", id);
        }
        return mapper.bookToBookDTO(opBook.get());
    }

    public int saveBook(BookDTO bookDTO){
        return jdbcBookRepository.save(mapper.bookDTOToBook(bookDTO));
    }

    public int updateBook(Long id, BookDTO bookDTO) {
        Book book = mapper.bookDTOToBook(bookDTO);
        book.setId(id);
        return jdbcBookRepository.update(book);
    }

    public int deleteBook(Long id) {
        return jdbcBookRepository.deleteById(id);
    }
}
