package com.lmsbooks.entity;

public class LoanRequestDTO {
    private Long bookId;

    public LoanRequestDTO(Long bookId) {
        this.bookId = bookId;
    }

    // Getters and setters
    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
}