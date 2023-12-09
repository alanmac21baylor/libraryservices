package com.lmsloans.events.model;

public class BookChangeModel {
    private String type;
    private String action;
    private Long bookId;

    // Constructors, getters, and setters
    public BookChangeModel(String type, String action, Long bookId) {
        this.type = type;
        this.action = action;
        this.bookId = bookId;
    }

    // Getters and setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
}
