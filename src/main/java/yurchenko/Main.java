package yurchenko;

import yurchenko.parsers.DomParser;
import yurchenko.parsers.StaxParser;

public class Main {
    public static void main(String[] args){
        StaxParser staxParser = new StaxParser();
        DomParser domParser = new DomParser();
        XsdToXml convert = new XsdToXml();
        ModifyCatalog modify = new ModifyCatalog();
        convert.createXml(3);
        domParser.parseByDom();
        staxParser.StaxParser();
        System.out.println(XmlValidator.validateXml("src/main/resources/book.xsd", "book.xml"));
        modify.modify("plant_catalog.xml");
    }
}
