package Task9___30_11_2017.xsd;

public class ValidatingDemo {
    public static void main(String[] args) {
        String xsdFile = "src/main/java/Task9___30_11_2017/xsd/schema.xsd";
        String xmlFile = "src/main/java/Task9___30_11_2017/xmls/first.xml";
        System.out.println(ValidatorAgainstXSD.validate(xsdFile, xmlFile));
    }
}
