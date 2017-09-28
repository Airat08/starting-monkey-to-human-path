package PO52.Myhytdinov.wdad.learn.xml;
import java.time.LocalDateTime;
/**
 * Created by myhytdinov on 25.09.2017.
 */
public class Reader {
    private Book[] book;
    private String firstName;
    private String secondName;

    public Reader(Book[] book, String firstName, String secondName) {
        this.book = book;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public Book[] getBook() {
        return book;
    }

    public void setBook(Book[] book) {
        this.book = book;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

}

