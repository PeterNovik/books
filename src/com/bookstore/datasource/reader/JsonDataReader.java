package com.bookstore.datasource.reader;

import com.bookstore.model.Book;
import com.bookstore.utils.DateUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.text.ParseException;
import java.util.ArrayList;

public class JsonDataReader extends FileDataReader {

    public static final String jsonFile = System.getProperty("user.dir") +"/data/input/books.json";
    public static class FieldNames{
        public static final String ID = "@id";
        public static final String AUTHOR = "author";
        public static final String TITLE = "title";
        public static final String GENRE = "genre";
        public static final String PRICE = "price";
        public static final String DESCRIPTION = "description";
        public static final String PUBLISH_DATE = "publish_date";
    }

    @Override
    public ArrayList<Book> readData() {
        JSONParser parser = new JSONParser();
        try {

            ArrayList<Book> books = new ArrayList<Book>();

            Object obj = parser.parse(getFileReader( jsonFile ));
            JSONArray booksJsonArray = (JSONArray) obj;


            booksJsonArray.forEach(item -> {
                JSONObject jsonBook = (JSONObject) item;
                try {
                    books.add(new Book((String) jsonBook.get(FieldNames.ID),
                            (String) jsonBook.get(FieldNames.AUTHOR),
                            (String) jsonBook.get(FieldNames.TITLE),
                            (String) jsonBook.get(FieldNames.GENRE),
                            DateUtils.getDateFromString((String) jsonBook.get(FieldNames.PUBLISH_DATE), DateUtils.DATE_FORMAT),
                            (Double) jsonBook.get(FieldNames.PRICE),
                            (String) jsonBook.get(FieldNames.DESCRIPTION)));
                } catch (ParseException e) {
                    throw new RuntimeException("Invalid Date string: "+ jsonBook.get(FieldNames.PUBLISH_DATE), e);
                }

            });

            return books;

        } catch(FileNotFoundException e) {
             throw new RuntimeException("json file not found: " + jsonFile, e);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load file: " + jsonFile, e);
        } catch (org.json.simple.parser.ParseException e) {
            throw new RuntimeException("Invalid json format in: " + jsonFile, e);
        }
    }



}
