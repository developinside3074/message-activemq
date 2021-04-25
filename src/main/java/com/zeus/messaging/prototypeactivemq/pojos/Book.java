package com.zeus.messaging.prototypeactivemq.pojos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Book implements Serializable {

    @JsonCreator
    public Book(@JsonProperty("bookId") String bookId, @JsonProperty("title")String title) {
        this.bookId = bookId;
        this.title = title;
    }

    private final String bookId;
    private final String title;

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", title='" + title + '\'' +
                '}';
    }


}
