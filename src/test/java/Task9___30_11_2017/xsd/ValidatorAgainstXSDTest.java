package Task9___30_11_2017.xsd;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidatorAgainstXSDTest {
    @Test
    public void validateIncorrect() throws Exception {
        String xsdFile = "src/test/java/Task9___30_11_2017/xsd/xsdIncorrect.xsd";
        String xmlFile = "src/main/java/Task9___30_11_2017/xmls/first.xml";

        String s = ValidatorAgainstXSD.validate(xsdFile, xmlFile);
//        System.out.println(s);
        assertTrue(s.startsWith("XML is NOT valid"));

    }

    @Test
    public void validate() throws Exception {
        String xsdFile = "src/main/java/Task9___30_11_2017/xsd/schema.xsd";
        String xmlFile = "src/main/java/Task9___30_11_2017/xmls/first.xml";

        String s = ValidatorAgainstXSD.validate(xsdFile, xmlFile);
//        System.out.println(s);
        assertTrue(s.startsWith("XML is valid"));

    }

}