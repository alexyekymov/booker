package dev.overlax.booker.repository;

import dev.overlax.booker.model.Book;

import java.util.Collection;

public interface Repository {

    Book save(Book book);

    boolean delete(int id);

    Book get(int id);

    Collection<Book> getAll();
}
