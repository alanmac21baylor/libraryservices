package com.lmsbooks.service;

import com.lmsbooks.entity.Book;
import com.lmsbooks.entity.LoanRequestDTO;
import com.lmsbooks.events.source.BookChangeSource;
import com.lmsbooks.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Random;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class BookService {


    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private BookChangeSource bookChangeSource;
    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    private void randomlyRunLong(){
        Random rand = new Random();
        if (rand.nextBoolean()) { // 50% chance to run long
            sleep();
        }
    }

    private void sleep(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
    }
    @CircuitBreaker(name = "bookService")
    public Book addBook(Book book) {
        if (book.getTitle().isEmpty()) {
            throw new RuntimeException("Deliberate Exception to Trigger Circuit Breaker");
        }
        book = bookRepository.save(book);
        bookChangeSource.publishBookChange("CREATED", book.getId());
        LoanRequestDTO loanRequest  = new LoanRequestDTO(book.getId());
        restTemplate.postForObject("http://LoanManagementService/loans/create", loanRequest , Void.class);
        return book;
    }


    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookByISBN(String ISBN) {
        return bookRepository.findByISBN(ISBN);
    }

//    public void addBook(Book book) {
//        bookRepository.save(book);
//    }

    public void updateBook(Book book) {
        bookRepository.save(book);
    }
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
