package com.bookstore.model;

import java.util.Date;

public class Book implements Comparable<Book> {
    private String id;
    private String author;
    private String title;
    private String genre;
    private Date publishDate;
    private Double price;
    private String description;
    public Book() {
    }
    public Book(String id, String author, String title, String genre, Date publishDate, Double price, String description) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.publishDate = publishDate;
        this.price = price;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publisDate) {
        this.publishDate = publishDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = (double) Math.round(price);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int compareTo(Book book) {
        return this.title.compareToIgnoreCase(book.title);
    }
}
