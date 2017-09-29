package PO52.Myhytdinov.wdad.learn.xml;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by myhytdinov on 25.09.2017.
 */
public class TestXmlTask {
    public static void main(String[] args) throws Exception {
        XmlTask xmlDoc=new XmlTask("Test.xml");

        Author author = new Author("Aleksander","Pushkin");
        LocalDateTime dateTime = LocalDateTime.of(2016,8,9,0,0);
        Book book;
        book = new Book(author,"Master and Margarita",1833,"novel",dateTime);
        Reader reader = new Reader(null,"Alecksey","Bugai");
        Reader[] readers = xmlDoc.getReaders();
        //xmlDoc.addBook(reader,book);
        //System.out.println(xmlDoc.listOfBooksSetReader(readers[0]).get(0).getName());
        //xmlDoc.removeBook(reader,book);

        System.out.println(xmlDoc.negligentReaders().get(0).getFirstName());
    }
}
