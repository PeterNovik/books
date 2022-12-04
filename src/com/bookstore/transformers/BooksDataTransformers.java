package com.bookstore.transformers;

import com.bookstore.model.Book;
import com.bookstore.utils.DateUtils;
import java.time.DayOfWeek;
import java.util.function.Predicate;

public class BooksDataTransformers {

    public static Predicate<Book> dayFilter = (book-> !DateUtils.getDayOfWeekAsString(((Book) book).getPublishDate()).
            equalsIgnoreCase(DayOfWeek.SATURDAY.toString()));
    public static Predicate<Book> nameFilter = (book-> !book.getAuthor().contains("Peter") );
    public static void price2Int(Book book){
        book.setPrice((double)Math.round( book.getPrice().doubleValue() ) );
    }
}

