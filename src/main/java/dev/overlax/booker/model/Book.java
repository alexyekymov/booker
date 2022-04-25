package dev.overlax.booker.model;

import java.time.LocalDateTime;

public class Book {
    private Integer id;
    private LocalDateTime addTime;
    private LocalDateTime editTime;
    private final String description;
    private final int pages;
    private int currentPage;

    //TODO: DELETE after adding db
    public Book(Integer id, LocalDateTime addTime, LocalDateTime editTime, String description, int pages, int currentPage) {
        this.id = id;
        this.addTime = addTime;
        this.editTime = editTime;
        this.description = description;
        this.pages = pages;
        this.currentPage = currentPage;
    }

    //TODO: DELETE too
    public Book(LocalDateTime addTime, LocalDateTime editTime, String description, int pages, int currentPage) {
        this(null, addTime, editTime, description, pages, currentPage);
    }

    public Book(Integer id, String description, int pages, int currentPage) {
        this(id, null, null, description, pages, currentPage);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getAddTime() {
        return addTime;
    }

    public void setAddTime(LocalDateTime addTime) {
        this.addTime = addTime;
    }

    public LocalDateTime getEditTime() {
        return editTime;
    }

    public void setEditTime(LocalDateTime editTime) {
        this.editTime = editTime;
    }

    public String getDescription() {
        return description;
    }

    public int getPages() {
        return pages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public boolean isNew() {
        return id == null;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", addTime=" + addTime +
                ", editTime=" + editTime +
                ", description='" + description + '\'' +
                ", pages=" + pages +
                ", currentPage=" + currentPage +
                '}';
    }
}
