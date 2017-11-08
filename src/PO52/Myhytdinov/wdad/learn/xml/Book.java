package PO52.Myhytdinov.wdad.learn.xml;

import java.time.LocalDateTime;

/**
 * Created by myhytdinov on 25.09.2017.
 */
public class Book {
    private Author author;
    private String name;
    private int printYear;//год печати
    private String genre;//жанр
    private LocalDateTime data;

    public Book(Author author, String name, int printYear, String genre, LocalDateTime data) {
        this.author = author;
        this.name = name;
        this.printYear = printYear;
        this.genre = genre;
        this.data = data;
    }

    public Author getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public int getPrintYear() {
        return printYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrintYear(int printYear) {
        this.printYear = printYear;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
