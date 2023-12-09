package com.lmsbooks.repository;

import com.lmsbooks.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByISBN(String ISBN);
}