package yurchenko.parsers;

import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

@Slf4j
public class DomParser {
    public void parseByDom() {
        try {
            File inputFile = new File("plant_catalog.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document document = dBuilder.parse(inputFile);
            document.getDocumentElement().normalize();
            NodeList nList = document.getElementsByTagName("PLANT");
            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    log.info("<PLANT>");
                    log.info("<COMMON>{}</COMMON>", eElement.getElementsByTagName("COMMON").item(0).getTextContent());
                    log.info("<BOTANICAL>{}</BOTANICAL>", eElement.getElementsByTagName("BOTANICAL").item(0).getTextContent());
                    log.info("<ZONE>{}</ZONE>", eElement.getElementsByTagName("ZONE").item(0).getTextContent());
                    log.info("<LIGHT>{}</LIGHT>", eElement.getElementsByTagName("LIGHT").item(0).getTextContent());
                    log.info("<PRICE>{}</PRICE>", eElement.getElementsByTagName("PRICE").item(0).getTextContent());
                    log.info("<AVAILABILITY>{}</AVAILABILITY>", eElement.getElementsByTagName("AVAILABILITY").item(0).getTextContent());
                    log.info("</PLANT>");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
