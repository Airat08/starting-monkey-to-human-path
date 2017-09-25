package PO52.Myhytdinov.wdad.learn.xml;

import java.time.LocalDateTime;

/**
 * Created by myhytdinov on 25.09.2017.
 */
public class TestXmlTask {
    public static void main(String[] args) throws Exception {
        XmlTask xmlDoc=new XmlTask("src\\firstTestXml.xml");
        Author author = new Author("Мама","Чолли");
        Reader reader = new Reader(new Book(author,"петух", LocalDateTime.now(),"Мультик"),LocalDateTime.now());
        xmlDoc.addBook(reader,new Book(author,"петух", LocalDateTime.now(),"Мультик"));

    }
}
