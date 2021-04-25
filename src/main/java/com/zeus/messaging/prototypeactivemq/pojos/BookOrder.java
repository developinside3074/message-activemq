package com.zeus.messaging.prototypeactivemq.pojos;

public class BookOrder {

    public BookOrder(String bookOrderId, Book book, Custumer custumer) {
        this.bookOrderId = bookOrderId;
        this.book = book;
        this.custumer = custumer;
    }

    private final String bookOrderId;
    private final Book book;
    private final Custumer custumer;

    public String getBookOrderId() {
        return bookOrderId;
    }

    public Book getBook() {
        return book;
    }

    public Custumer getCustumer() {
        return custumer;
    }
}
