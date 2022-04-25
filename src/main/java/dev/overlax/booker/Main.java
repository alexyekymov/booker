package dev.overlax.booker;

import dev.overlax.booker.model.BookTo;
import dev.overlax.booker.repository.BookRepository;
import dev.overlax.booker.repository.Repository;
import dev.overlax.booker.util.BooksUtil;

import java.util.List;

public class Main {
    static Repository repository = new BookRepository();

    public static void main(String[] args) {
        List<BookTo> books = BooksUtil.getTos(repository.getAll());
        books.forEach(System.out::println);
    }
}
