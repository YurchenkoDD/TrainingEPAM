package yurchenko;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;


public class XmlValidator {
    /**
     * Validation xml by xsd
     *
     * @param xsdPath - path to XSD
     * @param xmlPath - path to XML
     * @return true if the document has passed validation, else return false
     */
    public static boolean validateXml(String xsdPath, String xmlPath) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
            javax.xml.validation.Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
        } catch (IOException | org.xml.sax.SAXException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
        return true;
    }
}
