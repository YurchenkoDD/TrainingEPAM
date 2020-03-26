package yurchenko;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ModifyCatalog {
    public void modify(String filename) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            StreamResult file = new StreamResult(new File("new_plant_catalog.xml"));
            Element rootElement = document.createElementNS("", "CATALOG");
            document.appendChild(rootElement);
            List<Plant> plantList = parseXmlFile(filename);
            assert plantList != null;
            for (Plant plant : plantList) {
                if (!plant.getZone().equals("Свет или тень")) {
                    rootElement.appendChild(getPlant(document, plant));
                }
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(document);
            transformer.transform(source, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Get a node through a plant's object
     *
     * @param document - name of document
     * @param plant    - plant's object
     * @return node
     */
    private Node getPlant(Document document, Plant plant) {
        Element node = document.createElement("PLANT");
        node.appendChild(getField(document, "COMMON", plant.getCommon()));
        node.appendChild(getField(document, "BOTANICAL", plant.getBotanical()));
        node.appendChild(getField(document, "ZONE", plant.getZone()));
        node.appendChild(getField(document, "LIGHT", plant.getLight()));
        node.appendChild(getField(document, "PRICE", plant.getPrice()));
        node.appendChild(getField(document, "AVAILABILITY", plant.getAvailability()));
        return node;
    }

    private Node getField(Document document, String field, String value) {
        Element node = document.createElement(field);
        node.appendChild(document.createTextNode(value));
        return node;
    }

    private List<Plant> parseXmlFile(String file) {
        try {
            File xmlFile = new File(file);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder;
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("PLANT");
            List<Plant> plantUseDomList = new ArrayList<>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                plantUseDomList.add(getPlant(nodeList.item(i)));
            }
            return plantUseDomList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Get values from a node
     *
     * @param node - input node
     * @return plant's object
     */
    private Plant getPlant(Node node) {
        Plant plant = new Plant();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            plant.setCommon(getValue("COMMON", element));
            plant.setBotanical(getValue("BOTANICAL", element));
            plant.setZone(getValue("ZONE", element));
            plant.setLight(getValue("LIGHT", element));
            plant.setPrice(getValue("PRICE", element));
            plant.setAvailability(getValue("AVAILABILITY", element));
        }
        return plant;
    }

    private String getValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }
}
