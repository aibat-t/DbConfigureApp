package kz.aibat.dbconfigureapp.dbconnections.jdbctemplate;

import kz.aibat.dbconfigureapp.model.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();

        book.setId(rs.getLong("id"));
        book.setName(rs.getString("name"));
        book.setPrice(rs.getBigDecimal("price"));

        return book;
    }
}
