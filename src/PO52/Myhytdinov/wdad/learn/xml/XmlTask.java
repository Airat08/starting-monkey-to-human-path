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
import java.time.Period;
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
        loadReaders();
        List<Reader> list = new ArrayList<>();
        for (int i = 0; i < readers.length; i++) {
            if (getResult(LocalDate.now(),readers[i].getTakedate().toLocalDate())==true)
                list.add(readers[i]);
        }
        return list;
    }

    private boolean getResult(LocalDate firstDate, LocalDate secondDate) {
        Period period = Period.between(secondDate, firstDate);
        if (period.getYears()>0) return true;
        else if (period.getYears()==0 && period.getMonths()>0) return true;
        else if (period.getDays()==0 && period.getMonths()==0 && period.getDays()>14) return true;
        return false;
    }

    public void removeBook (Reader reader, Book book) throws Exception
    //удаляющий запись о книге у заданного читателя.
    //Записывает результат в этот же xml-документ.
    {
        String forename;
        String surname;
        NodeList nodeListReaders = document.getElementsByTagName("reader");
        for (int i = 0; i < nodeListReaders.getLength(); i++)
        {
            Element readers = (Element) nodeListReaders.item(i);
            forename = readers.getAttribute("firstname");
            surname = readers.getAttribute("secondname");

            if (forename.equals(reader.getFirstName()) && //сравниваем имя и фамилие читателя с заданным
                    surname.equals(reader.getSecondName())) {
                NodeList nodeListBook = readers.getElementsByTagName("book");
                NodeList nodeListTakeDate = readers.getElementsByTagName("takedate");
                for (int j = 0; j < nodeListBook.getLength(); j++) {
                    Element books = (Element) nodeListBook.item(j);
                    Element takedate = (Element)  nodeListTakeDate.item(j);
                    NodeList nodeListAuthor = books.getElementsByTagName("author");
                    Element author = (Element) nodeListAuthor.item(0);
                    if (book.getAuthor().getFirstName().equals(author.getElementsByTagName("firstname").item(0).getTextContent()) &&
                            book.getAuthor().getSecondName().equals(author.getElementsByTagName("secondname").item(0).getTextContent()) &&
                            book.getName().equals(books.getElementsByTagName("name").item(0).getTextContent()))
                    {
                        nodeListReaders.item(i).removeChild(books);
                        nodeListReaders.item(i).removeChild(takedate);
                    }
                }
            }
        }
        saveTransformXML();
    }

    public void addBook (Reader reader, Book book) throws Exception
    //добавляющий запись о книге заданному читателю.
    //Записывает результат в этот же xml-документ.
    {
        String forename;
        String surname;
        NodeList nodeListReaders = document.getElementsByTagName("reader");
        for (int i = 0; i < nodeListReaders.getLength(); i++)
        {
            Element element = (Element) nodeListReaders.item(i);
            forename = element.getAttribute("firstname");
            surname = element.getAttribute("secondname");

            if (forename.equals(reader.getFirstName()) &&
                    surname.equals(reader.getSecondName()))
            {
               Element bookk = document.createElement("book");
                element.appendChild(bookk);

                Element autor = document.createElement("author");
                bookk.appendChild(autor);

                Element firstname = document.createElement("firstname");
                firstname.appendChild(document.createTextNode(book.getAuthor().getFirstName()));
                autor.appendChild(firstname);


                Element secondname = document.createElement("secondname");
                secondname.appendChild(document.createTextNode(book.getAuthor().getSecondName()));
                autor.appendChild(secondname);

                Element name = document.createElement("name");
                name.appendChild(document.createTextNode(book.getName()));
                bookk.appendChild(name);

                Element printyear = document.createElement("printyear");
                printyear.appendChild(document.createTextNode(String.valueOf(book.getPrintYear())));
                bookk.appendChild(printyear);

                Element genre = document.createElement("genre");
                Attr attr = document.createAttribute("value");
                attr.setValue(book.getGenre());
                genre.setAttributeNode(attr);
                bookk.appendChild(genre);

                Element takedate = document.createElement("takedate");

                Attr day = document.createAttribute("day");
                day.setValue(String.valueOf(reader.getTakedate().getDayOfMonth()));
                takedate.setAttributeNode(day);


                Attr month = document.createAttribute("month");
                month.setValue(String.valueOf(reader.getTakedate().getMonthValue()));
                takedate.setAttributeNode(month);

                Attr year = document.createAttribute("year");
                year.setValue(String.valueOf(reader.getTakedate().getYear()));
                takedate.setAttributeNode(year);

                element.appendChild(takedate);

                saveTransformXML();
            }
        }
    }

    public List<Book> listOfBooksSetReader(Reader reader)//возвращает
    //список книг заданного читателя, которые он должен был вернуть

    {
        List<Book> bookList = new ArrayList<>();
        loadReaders();
        for (int i = 0; i < reader.getBook().length; i++) {
            bookList.add(reader.getBook()[i]);
        }
        return bookList;
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

    private void loadReaders()
    {
        Book[] books;
        String firstname;
        String secondname;
        LocalDateTime data;

        NodeList nodeListReaders = document.getElementsByTagName("reader");
        for (int i = 0; i < nodeListReaders.getLength(); i++) {
            Element reader = (Element) nodeListReaders.item(i);

            firstname = reader.getAttribute("firstname").toString();
            secondname = reader.getAttribute("secondname").toString();

            NodeList nodeListBooks = reader.getElementsByTagName("book");
            books = new Book[nodeListBooks.getLength()];
            for (int j = 0; j < nodeListBooks.getLength(); j++) {
                Element book = (Element) nodeListBooks.item(j);

                NodeList authors = book.getElementsByTagName("author");
                NodeList genres = book.getElementsByTagName("genre");
                NodeList takedatas = reader.getElementsByTagName("takedate");

                Element author = (Element) authors.item(0);
                Element genre = (Element) genres.item(0);
                Element takedata = (Element) takedatas.item(j);

                data = LocalDateTime.of(Integer.valueOf(takedata.getAttribute("year")),Integer.valueOf(takedata.getAttribute("month")),Integer.valueOf(takedata.getAttribute("day")),
                        0,0);
                books[j] = new Book(new Author(author.getElementsByTagName("firstname").item(0).getTextContent(),
                        author.getElementsByTagName("secondname").item(0).getTextContent()),
                        book.getElementsByTagName("name").item(0).getTextContent(),Integer.parseInt(book.getElementsByTagName("printyear").item(0).getTextContent()),
                        genre.getAttribute("value"));

                readers[i] = new Reader(books,firstname,secondname,data);
            }

        }
    }

    public Reader[] getReaders() {
        loadReaders();
        return readers;
    }
}
