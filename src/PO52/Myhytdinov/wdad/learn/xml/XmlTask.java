package PO52.Myhytdinov.wdad.learn.xml;
import org.w3c.dom.*;

import javax.xml.crypto.dsig.TransformException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.List;

/**
 * Created by myhytdinov on 25.09.2017.
 */
public class XmlTask {

    private final File xmlFile;
    private String filePath;
    private Document document;

    public XmlTask(String filePath) throws Exception {
        this.filePath = filePath;
        xmlFile = new File(filePath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(false);
        DocumentBuilder builder = factory.newDocumentBuilder();
        document = builder.parse(xmlFile);
    }

    public List<Reader> negligentReaders()//возвращающий список читателей – должников (у
    // которых книга на руках уже более 2-х недель).

    {
        return negligentReaders();
    }

    public void removeBook (Reader reader, Book book)//удаляющий запись о книге у заданного читателя.
    //Записывает результат в этот же xml-документ.
    {

    }

    public void addBook (Reader reader, Book book)//добавляющий запись о книге заданному читателю.
    //Записывает результат в этот же xml-документ.
    {

    }

    public List<Book> listOfBooksSetReader()//возвращает
    //список книг заданного читателя, которые он должен был вернуть

    {
        return listOfBooksSetReader();
    }
}
