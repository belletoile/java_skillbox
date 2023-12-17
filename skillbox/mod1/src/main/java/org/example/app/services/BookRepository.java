package org.example.app.services;

import org.apache.log4j.Logger;
import org.example.web.dto.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository implements ProjectRepository<Book> {

    private final Logger logger = Logger.getLogger(BookRepository.class);
    private final List<Book> repo = new ArrayList<>();

    @Override
    public List<Book> retreiveAll() {
        return new ArrayList<>(repo);
    }

    @Override
    public void store(Book book) {
        if (!book.getAuthor().isEmpty() || !book.getTitle().isEmpty() || book.getSize() != null) {
            book.setId(book.hashCode());
            logger.info("store new book:" + book);
            repo.add(book);
        } else {
            logger.info("At least one field is not filled in");
        }
    }

    @Override
    public boolean removeItemById(Integer bookIdToRemove) {
        for (Book book : retreiveAll()) {
            if (book.getId().equals(bookIdToRemove)) {
                logger.info("remove book completed: " + book);
                return repo.remove(book);
            }
        }
        return false;
    }

    @Override
    public boolean removeByRegex(String regex) {
        int countRemoveBook = 0;
        for (Book book : retreiveAll()) {
            if (book.getTitle().contains(regex) ||
                    book.getAuthor().contains(regex) ||
                    book.getSize().toString().contains(regex)) {
                countRemoveBook++;
                logger.info(book +" was deleted by regex = " + regex);
                repo.remove(book);
            }
        }
        logger.info("Count of deleted books = " + countRemoveBook);
        return false;
    }


}

