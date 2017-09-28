package PO52.Myhytdinov.wdad.learn.xml;

import java.time.LocalDateTime;

/**
 * Created by myhytdinov on 25.09.2017.
 */
public class TestXmlTask {
    public static void main(String[] args) throws Exception {
        XmlTask xmlDoc=new XmlTask("Test.xml");
        xmlDoc.loadReaders();
        System.out.println(xmlDoc.getReaders()[1].getData());

    }
}
