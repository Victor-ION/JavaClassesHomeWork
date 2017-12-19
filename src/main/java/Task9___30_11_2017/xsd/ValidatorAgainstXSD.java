package Task9___30_11_2017.xsd;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class ValidatorAgainstXSD {
    private final static Logger logger = LogManager.getLogger(ValidatorAgainstXSD.class);

    public static String validate(String xsdFile, String xmlFile){
        String result = "";

        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new File(xsdFile));
            Validator validator = schema.newValidator();

            Source source = new StreamSource(new File(xmlFile));
            validator.validate(source);

            result = "XML is valid";
        } catch (SAXException e) {
            result = "XML is NOT valid reason:" + e;

        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return result;
    }
}
