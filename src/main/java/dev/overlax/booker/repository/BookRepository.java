package dev.overlax.booker.repository;

import dev.overlax.booker.model.Book;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import static dev.overlax.booker.util.BooksUtil.books;

public class BookRepository implements Repository {

    private final Map<Integer, Book> repository = new ConcurrentHashMap<>();
    private final AtomicInteger counter = new AtomicInteger(0);

    {
        books.forEach(this::save);
    }

    @Override
    public Book save(Book book) {
        book.setEditTime(LocalDateTime.now());

        if (book.isNew()) {
            book.setId(counter.incrementAndGet());
            book.setAddTime(LocalDateTime.now());
            repository.put(book.getId(), book);
            return book;
        }
        book.setAddTime(repository.get(book.getId()).getAddTime());

        return repository.computeIfPresent(book.getId(), (id, oldBook) -> book);
    }

    @Override
    public boolean delete(int id) {
        return repository.remove(id) != null;
    }

    @Override
    public Book get(int id) {
        return repository.get(id);
    }

    @Override
    public Collection<Book> getAll() {
        return repository.values();
    }
}
