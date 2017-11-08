package PO52.Myhytdinov.wdad.learn.xml;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by myhytdinov on 25.09.2017.
 */
public class TestXmlTask {
    public static void main(String[] args) throws Exception {
        XmlTask xmlDoc=new XmlTask("Test.xml");
        // XmlTask xmlDoc=new XmlTask("Test.xml");
        // xmlDoc.loadReaders();
        //System.out.println(xmlDoc.getReaders()[1].getData());

        Author author = new Author("проверка1","проверка2");
        LocalDateTime dateTime = LocalDateTime.of(2016,8,9,0,0);
        Book book;

                book = new Book(author,"трололо",1833,"novel");
        Book[] books = new Book[1];
        books[0] = book;
        Reader reader = new Reader(books,"Alecksey","Bugai",dateTime);
        //Reader[] readers = xmlDoc.getReaders();
        //xmlDoc.addBook(reader,book);
        //System.out.println(xmlDoc.listOfBooksSetReader(readers[0]).get(0).getName());
        xmlDoc.removeBook(reader,book);

        //System.out.println(xmlDoc.negligentReaders().get(0).getFirstName());
    }
}
