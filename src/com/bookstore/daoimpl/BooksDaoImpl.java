package com.bookstore.daoimpl;

import com.bookstore.dao.BooksDao;
import com.bookstore.datasource.writer.BookToCsvDataWriter;
import com.bookstore.transformers.BooksDataTransformers;
import com.bookstore.datasource.reader.JsonDataReader;
import com.bookstore.model.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class BooksDaoImpl implements BooksDao {

    private ArrayList<Book> books;

    public BooksDaoImpl() {
        books = new ArrayList<>();
    }

    @Override
    public ArrayList<Book> getAllBooks() {
        return books;
    }

    @Override
    public void filterBooks() {
        books = (ArrayList<Book>) books.stream()
                .filter(BooksDataTransformers.dayFilter.and(BooksDataTransformers.nameFilter))
                .collect(Collectors.toList());
    }

    @Override
    public void roundPrice() {
        books.forEach(BooksDataTransformers::price2Int);
    }

    public void loadBooks() {
        JsonDataReader reader = new JsonDataReader();
        books = reader.readData();
    }

    @Override
    public void sortBooks() {
        Collections.sort(books);
    }

    @Override
    public void saveBooks() {
        BookToCsvDataWriter writer = new BookToCsvDataWriter();
        writer.writeData(books);
    }
}
