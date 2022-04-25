package dev.overlax.booker.model;

import java.time.LocalDateTime;

public class BookTo {
    private final Integer id;
    private final LocalDateTime addTime;
    private final LocalDateTime editTime;
    private final String description;
    private final int pages;
    private final int currentPage;
    private final int progress;

    public BookTo(Integer id, LocalDateTime addTime, LocalDateTime editTime, String description, int pages, int currentPage, int progress) {
        this.id = id;
        this.addTime = addTime;
        this.editTime = editTime;
        this.description = description;
        this.pages = pages;
        this.currentPage = currentPage;
        this.progress = progress;
    }

    public Integer getId() {
        return id;
    }

    public LocalDateTime getAddTime() {
        return addTime;
    }

    public LocalDateTime getEditTime() {
        return editTime;
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

    public int getProgress() {
        return progress;
    }

    @Override
    public String toString() {
        return "BookTo{" +
                "id=" + id +
                ", addTime=" + addTime +
                ", editTime=" + editTime +
                ", description='" + description + '\'' +
                ", pages=" + pages +
                ", currentPage=" + currentPage +
                ", readPercent=" + progress +
                '}';
    }
}
