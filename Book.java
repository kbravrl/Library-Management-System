/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Library;

public class Book {

    private long bookId;
    private String nameOfBook;
    private String categoryOfBook;
    private String authorOfBook;
    private String publishingHouseOfBook;

    public Book(long bookId, String nameOfBook, String categoryOfBook, String authorOfBook, String publishingHouseOfBook) {
        this.bookId = bookId;
        this.nameOfBook = nameOfBook;
        this.categoryOfBook = categoryOfBook;
        this.authorOfBook = authorOfBook;
        this.publishingHouseOfBook = publishingHouseOfBook;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getNameOfBook() {
        return nameOfBook;
    }

    public void setNameOfBook(String nameOfBook) {
        this.nameOfBook = nameOfBook;
    }

    public String getCategoryOfBook() {
        return categoryOfBook;
    }

    public void setCategoryOfBook(String categoryOfBook) {
        this.categoryOfBook = categoryOfBook;
    }

    public String getAuthorOfBook() {
        return authorOfBook;
    }

    public void setAuthorOfBook(String authorOfBook) {
        this.authorOfBook = authorOfBook;
    }

    public String getPublishingHouseOfBook() {
        return publishingHouseOfBook;
    }

    public void setPublishingHouseOfBook(String publishingHouseOfBook) {
        this.publishingHouseOfBook = publishingHouseOfBook;
    }

    @Override
    public String toString() {
        return String.format("%-5d %-15s %-15s %-15s %-20s \r\n", bookId, nameOfBook, categoryOfBook, authorOfBook, publishingHouseOfBook);
    }
}
