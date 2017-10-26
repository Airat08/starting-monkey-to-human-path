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

    public Book(Author author, String name, int printYear, String genre) {
        this.author = author;
        this.name = name;
        this.printYear = printYear;
        this.genre = genre;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrintYear() {
        return printYear;
    }

    public void setPrintYear(int printYear) {
        this.printYear = printYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}