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
import java.time.LocalDateTime;
import java.util.ArrayList;
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
        List<Reader> list = new ArrayList<>();
        NodeList nodeList = document.getElementsByTagName("reader");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            //if ((LocalDateTime)(element.getElementsByTagName("data").item(0).getTextContent()))
        }
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
}
