package PO52.Myhytdinov.wdad.learn.xml;

import java.time.LocalDateTime;

/**
 * Created by myhytdinov on 25.09.2017.
 */
public class TestXmlTask {
    public static void main(String[] args) throws Exception {
        XmlTask xmlDoc=new XmlTask("Test.xml");

        Author author = new Author("Airat","Chumavoy");
        LocalDateTime dateTime = LocalDateTime.of(2016,7,16,0,0);
        Book book;
        book = new Book(author,"алилуя",1998,"мультик",dateTime);
        Reader reader = new Reader(null,"Aleksander","Chumavoy");

        xmlDoc.addBook(reader,book);
    }
}
