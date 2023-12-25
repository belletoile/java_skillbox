package org.example.app.services;

import org.apache.log4j.Logger;
import org.example.web.dto.Book;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository implements ProjectRepository<Book>, ApplicationContextAware {

    private final Logger logger = Logger.getLogger(BookRepository.class);
    //private final List<Book> repo = new ArrayList<>();
    private ApplicationContext context;

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public BookRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Book> retreiveAll() {
        List<Book> books = jdbcTemplate.query("SELECT * FROM books", (ResultSet rs,int rowNum) -> {
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setAuthor(rs.getString("author"));
            book.setTitle(rs.getString("title"));
            book.setSize(rs.getInt("size"));
            return book;
        });
        return new ArrayList<>(books);
    }

    @Override
    public void store(Book book) {
        if (!book.getAuthor().isEmpty() || !book.getTitle().isEmpty() || book.getSize() != null) {
            MapSqlParameterSource parameterSource = new MapSqlParameterSource();
            parameterSource.addValue("author", book.getAuthor());
            parameterSource.addValue("title", book.getTitle());
            parameterSource.addValue("size", book.getSize());
            jdbcTemplate.update("INSERT INTO books(author, title, size) VALUES(:author, :title, :size)", parameterSource);
            logger.info("store new book:" + book);
        } else {
            logger.info("At least one field is not filled in");
        }
    }

    @Override
    public boolean removeItemById(Integer bookIdToRemove) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", bookIdToRemove);
        jdbcTemplate.update("DELETE FROM books WHERE id = :id", parameterSource);
        logger.info("remove book completed");
        return true;
    }

    @Override
    public boolean removeByRegex(String regex) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("regex", regex);
        int countRemoveBook = 0;
        jdbcTemplate.update("DELETE FROM books WHERE author = :regex or title = :regex or CAST(size AS CHAR) = :regex", parameterSource);
//        for (Book book : retreiveAll()) {
//            if (book.getTitle().contains(regex) ||
//                    book.getAuthor().contains(regex) ||
//                    book.getSize().toString().contains(regex)) {
//                countRemoveBook++;
//                logger.info(book +" was deleted by regex = " + regex);
//                //repo.remove(book);
//            }
//        }
//        logger.info("Count of deleted books = " + countRemoveBook);
        return true;
    }

    public void removeItemByRegex(String regex) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("regex", regex);
        jdbcTemplate.update("DELETE FROM books " +
                "WHERE title LIKE :regex " +
                "OR author LIKE :regex " +
                "OR CAST(size AS CHAR) LIKE :regex;", source);
        logger.info("remove book by regular expression completed");
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    private void defaultInti() {
        logger.info("default INIT in book repo bean");
    }

    private void defaultDestroy() {
        logger.info("default DESTROY in book repo bean");
    }
}

