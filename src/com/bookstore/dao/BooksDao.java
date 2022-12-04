package com.bookstore.dao;

import com.bookstore.model.Book;
import java.util.ArrayList;

public interface BooksDao {
    ArrayList<Book> getAllBooks();

    void filterBooks();
    void roundPrice();

    void loadBooks();

    void sortBooks();

    void saveBooks();

}
