package PO52.Myhytdinov.wdad.learn.xml;
import java.time.LocalDateTime;
/**
 * Created by myhytdinov on 25.09.2017.
 */
public class Reader {
    private Book book;
    private LocalDateTime data;

    public Reader(Book book, LocalDateTime data) {
        this.book = book;
        this.data = data;
    }

    public Book getBook() {
        return book;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}

