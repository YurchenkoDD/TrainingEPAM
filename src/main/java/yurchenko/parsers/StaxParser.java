package yurchenko.parsers;

import lombok.extern.slf4j.Slf4j;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

@Slf4j
public class StaxParser {
    public void StaxParser() {
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader streamReader = factory.createXMLStreamReader(new FileReader("plant_catalog.xml"));

            while (streamReader.hasNext()) {
                streamReader.next();
                if (streamReader.getEventType() == XMLStreamReader.START_ELEMENT) {
                    if (streamReader.getLocalName().equalsIgnoreCase("plant")) {
                        log.info("<PLANT>");
                    }
                    if (streamReader.getLocalName().equalsIgnoreCase("common")) {
                        log.info("<COMMON>{}</COMMON>", streamReader.getElementText());
                    }
                    if (streamReader.getLocalName().equalsIgnoreCase("botanical")) {
                        log.info("<BOTANICAL>{}</BOTANICAL>", streamReader.getElementText());
                    }
                    if (streamReader.getLocalName().equalsIgnoreCase("zone")) {
                        log.info("<ZONE>{}</ZONE>", streamReader.getElementText());
                    }
                    if (streamReader.getLocalName().equalsIgnoreCase("light")) {
                        log.info("<LIGHT>{}</LIGHT>", streamReader.getElementText());
                    }
                    if (streamReader.getLocalName().equalsIgnoreCase("price")) {
                        log.info("<PRICE>{}</PRICE>", streamReader.getElementText());
                    }
                    if (streamReader.getLocalName().equalsIgnoreCase("availability")) {
                        log.info("<AVAILABILITY>{}</AVAILABILITY>", streamReader.getElementText());
                        log.info("</PLANT>");
                    }

                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }
}