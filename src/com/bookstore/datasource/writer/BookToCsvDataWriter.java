package com.bookstore.datasource.writer;

import com.bookstore.datasource.reader.JsonDataReader;
import com.bookstore.model.Book;
import com.bookstore.utils.DateUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookToCsvDataWriter extends CsvDataWriter {

    public static final String csvFile = System.getProperty("user.dir") + "/data/output/books.csv";

    public String[] books2Array(Book book) {
        String[] bookArray = new String[0];
        try {
            bookArray = new String[]{book.getId(),
                    book.getAuthor(),
                    book.getTitle(),
                    book.getGenre(),
                    Double.toString(book.getPrice()),
                    DateUtils.getStringFromDate(book.getPublishDate(), DateUtils.DATE_FORMAT),
                    book.getDescription()
            };

            return bookArray;
        } catch (ParseException e) {
            throw new RuntimeException("Invalid Date object: " + book.getPublishDate(), e);
        }
    }
    @Override

    public void writeData(ArrayList<Book> books) {
        try {
            String[] header = {JsonDataReader.FieldNames.ID,
                    JsonDataReader.FieldNames.AUTHOR,
                    JsonDataReader.FieldNames.TITLE,
                    JsonDataReader.FieldNames.GENRE,
                    JsonDataReader.FieldNames.PRICE,
                    JsonDataReader.FieldNames.PUBLISH_DATE,
                    JsonDataReader.FieldNames.DESCRIPTION};

            List<String[]> booksArray = books.stream().map(this::books2Array).collect(Collectors.toList());
            booksArray.add(0, header);
            super.writeToCsvFile(booksArray, new File(csvFile));

        } catch (FileNotFoundException e) {
            throw new RuntimeException("No such file or directory " + csvFile, e);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write to CSV file " + csvFile, e);
        }
    }
}
