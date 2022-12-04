package com.bookstore.datasource.writer;

import com.bookstore.model.Book;

import java.util.ArrayList;

public abstract class BaseDataWriter {
    public abstract void writeData(ArrayList<Book> books);
}
