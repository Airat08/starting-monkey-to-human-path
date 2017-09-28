package PO52.Myhytdinov.wdad.learn.xml;
import com.sun.org.apache.regexp.internal.RE;
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
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by myhytdinov on 25.09.2017.
 */
public class XmlTask {

    private final File xmlFile;
    private String filePath;
    private Document document;
    private Reader[] readers;

    public XmlTask(String filePath) throws Exception {
        this.filePath = filePath;
        xmlFile = new File(filePath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(false);
        DocumentBuilder builder = factory.newDocumentBuilder();
        document = builder.parse(xmlFile);
        readers = new Reader[document.getElementsByTagName("reader").getLength()];
    }

    public List<Reader> negligentReaders()//возвращающий список читателей – должников (у
    // которых книга на руках уже более 2-х недель).
    {
        List<Reader> list = new ArrayList<>();
        /*NodeList nodeList  = document.getElementsByTagName("reader");
        for (int i = 0; i < nodeList.getLength(); i++) {//количество читателей

            Element element = (Element) nodeList.item(i);//берем одного читателя
            NodeList nodeList1 = element.getElementsByTagName("book");

            for (int j = 0; j < nodeList1.getLength(); j++) {//кол-во книг у читателя
                Element element1 = (Element) nodeList1.item(j);
                Node node = element1.getElementsByTagName("year").item(0);

                if (LocalDateTime.now().getDayOfYear()-Integer.parseInt(node.getTextContent())>0)
                {

                    list.add()
                }
            }
        }*/

        return list;
    }

    public void removeBook (Reader reader, Book book)//удаляющий запись о книге у заданного читателя.
    //Записывает результат в этот же xml-документ.
    {

    }

    public void addBook (Reader reader, Book book) throws Exception
    //добавляющий запись о книге заданному читателю.
    //Записывает результат в этот же xml-документ.
    {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
       // transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        //initialize StreamResult with File object to save to file
        StreamResult result = new StreamResult(new StringWriter());
        DOMSource source = new DOMSource(document);
        transformer.transform(source, result);

        String xmlString = result.getWriter().toString();
        System.out.println(xmlString);

        PrintWriter output = new PrintWriter("Checks.xml");
        output.println(xmlString);
        output.close();
    }

    public List<Book> listOfBooksSetReader()//возвращает
    //список книг заданного читателя, которые он должен был вернуть

    {
        return listOfBooksSetReader();
    }

    private void saveTransformXML() throws TransformException {
        try {
            Transformer transformer = TransformerFactory.newInstance()
                    .newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(filePath));
            transformer.transform(source, result);
        } catch (TransformerConfigurationException ex) {
        } catch (TransformerException ex) {
        }
    }

    public void loadReaders()
    {
        Book[] books;
        String firstname;
        String secondname;
        LocalDateTime data;

        NodeList nodeListReaders = document.getElementsByTagName("reader");
        for (int i = 0; i < readers.length; i++) {
            Element reader = (Element) nodeListReaders.item(i);

            firstname = reader.getAttribute("firstname").toString();
            secondname = reader.getAttribute("secondname").toString();

            NodeList nodeListBooks = reader.getElementsByTagName("book");
            books = new Book[nodeListBooks.getLength()];
            for (int j = 0; j < nodeListBooks.getLength(); j++) {
                Element book = (Element) nodeListBooks.item(j);

                NodeList authors = book.getElementsByTagName("autor");
                NodeList genres = book.getElementsByTagName("genre");
                NodeList takedatas = book.getElementsByTagName("takedate");

                Element author = (Element) authors.item(0);
                Element genre = (Element) genres.item(0);
                Element takedata = (Element) takedatas.item(0);

                books[j] = new Book(new Author(author.getElementsByTagName("firstname").item(0).getTextContent().toString(),
                        author.getElementsByTagName("secondname").item(0).getTextContent().toString()),
                        book.getElementsByTagName("name").item(0).getTextContent(),Integer.parseInt(book.getElementsByTagName("printyear").item(0).getTextContent().toString()),
                        genre.getAttribute("value").toString());
                data = LocalDateTime.of(Integer.valueOf(takedata.getAttribute("year")),Integer.valueOf(takedata.getAttribute("month")),Integer.valueOf(takedata.getAttribute("day")),
                        0,0);
                readers[i] = new Reader(books,firstname,secondname,data);
            }

        }
    }

    public Reader[] getReaders() {
        return readers;
    }
}
