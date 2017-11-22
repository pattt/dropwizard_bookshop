package com.pavel.bookshop.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.davidmoten.rx.jdbc.annotations.Column;

public class Book {
    private long id;
    private String content;

    public Book() {
    }

    public Book(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    @Column("book_id")
    public long getId() {
        return id;
    }

    @JsonProperty
    @Column("book_name")
    public String getContent() {
        return content;
    }


    public void setId(long id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
