package com.bookstore.datasource.reader;

import com.bookstore.model.Book;
import java.util.ArrayList;

public abstract class BaseDataReader {
    public abstract ArrayList<Book> readData();

}
