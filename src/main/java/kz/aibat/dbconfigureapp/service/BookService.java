package kz.aibat.dbconfigureapp.service;

import kz.aibat.dbconfigureapp.dbconnections.jdbctemplate.JdbcBookRepositoryImpl;
import kz.aibat.dbconfigureapp.dto.BookDTO;
import kz.aibat.dbconfigureapp.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final JdbcBookRepositoryImpl jdbcBookRepository;

    private final BookMapper mapper = Mappers.getMapper(BookMapper.class);

    public List<BookDTO> getBookList(){
        return mapper.BookListToBookDTOList(jdbcBookRepository.findAll());
    }
}
