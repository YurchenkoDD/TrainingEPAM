package yurchenko;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;


public class XsdToXml {
    public void createXML(int number) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            StreamResult file = new StreamResult(new File("book.xml"));
            createBooks(document, number);
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(document);
            transformer.transform(source, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Document createBooks(Document document, int number) {
        Element rootElement = document.createElementNS("", "Books");
        rootElement.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
        rootElement.setAttribute("xsi:noNamespaceSchemaLocation", "book.xsd");
        document.appendChild(rootElement);
        for (int i = 0; i < number; i++) {
            Element book = document.createElement("book");
            book.appendChild(getAuthor(document));
            book.appendChild(getField(document, "numberofpages", Integer.toString((int) (Math.random() * 1000))));
            book.appendChild(getField(document, "name", stringGen()));
            book.appendChild(getField(document, "publisher", stringGen()));
            rootElement.appendChild(book);
        }
        return document;
    }

    private Node getAuthor(Document document) {
        Element author = document.createElement("author");
        author.appendChild(getField(document, "firstname", stringGen()));
        author.appendChild(getField(document, "lastname", stringGen()));
        author.appendChild(getField(document, "secondname", stringGen()));
        return author;
    }

    private Node getField(Document document, String field, String value) {
        Element node = document.createElement(field);
        node.appendChild(document.createTextNode(value));
        return node;
    }

    private String stringGen() {
        String string = "abcdeklman";
        StringBuilder randString = new StringBuilder();
        int count = (int) (Math.random() * 9 + 3);
        for (int i = 0; i < count; i++)
            randString.append(string.charAt((int) (Math.random() * string.length())));
        return randString.toString();
    }
}
