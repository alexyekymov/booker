package dev.overlax.booker.util;

import dev.overlax.booker.model.Book;
import dev.overlax.booker.model.BookTo;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class BooksUtil {

    public static List<Book> books = Arrays.asList(
            new Book(LocalDateTime.of(2006, Month.MAY, 31, 16, 0),
                    LocalDateTime.of(2006, Month.SEPTEMBER, 22, 4, 15),
                    "J.K. ROWLING - HARRY POTTER", 732, 732),
            new Book(LocalDateTime.of(2022, Month.APRIL, 18, 11, 0),
                    LocalDateTime.of(2022, Month.APRIL, 21, 14, 10),
                    "HEAD FIRST - DESIGN PATTERNS", 651, 49),
            new Book(LocalDateTime.of(2022, Month.JANUARY, 2, 18, 0),
                    LocalDateTime.of(2022, Month.FEBRUARY, 23, 23, 25),
                    "A. Bhargava - Grokking Algorithms", 288, 60),
            new Book(LocalDateTime.of(2021, Month.DECEMBER, 1, 0, 15),
                    LocalDateTime.of(2022, Month.FEBRUARY, 24, 0, 50),
                    "Harry Potter and methods of rationality", 412, 303)
    );

    public static List<BookTo> getTos(Collection<Book> books) {
        return books.stream()
                .map(book -> createTo(book, calcProgress(book)))
                .collect(Collectors.toList());
    }

    private static int calcProgress(Book book) {
        double div = (double) book.getCurrentPage() / book.getPages() * 100;
        return (int) div;
    }

    private static BookTo createTo(Book book, int progress) {
        return new BookTo(book.getId(), book.getAddTime(), book.getEditTime(), book.getDescription(), book.getPages(), book.getCurrentPage(), progress);
    }
}
