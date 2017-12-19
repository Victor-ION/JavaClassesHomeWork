package Task9___30_11_2017.parsers.dom;

import Task9___30_11_2017.model.Gem;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DomGemParser {
    private final static Logger logger = LogManager.getLogger(DomGemParser.class);

    public static Gem parse(String filename){
        DocumentBuilderFactory factory = null;
        DocumentBuilder db = null;
        try{
            factory = DocumentBuilderFactory.newInstance();
            db = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e){
            logger.error(e.getMessage());
        }

        Document doc = null;
        try{
            File file = new File(filename);
            doc = db.parse(file);
        } catch (SAXException| IOException e){
            logger.error(e.getMessage());
        }

        Gem gem = new Gem();

        Element root = doc.getDocumentElement();
        gem.setUnicName(root.getAttribute("unicName"));

        NodeList list = root.getElementsByTagName("typeName");
        Element element = (Element)list.item(0);
        gem.setTypeName(element.getTextContent());

        list = root.getElementsByTagName("preciousness");
        element = (Element)list.item(0);
        gem.setPreciousness(element.getTextContent());

        list = root.getElementsByTagName("origin");
        element = (Element)list.item(0);
        gem.setOrigin(element.getTextContent());

        list = root.getElementsByTagName("value");
        element = (Element)list.item(0);
        gem.setValue(element.getTextContent());



        list = root.getElementsByTagName("visualParam");
        element = (Element)list.item(0);

        NodeList list2 = element.getElementsByTagName("color");
        Element element2 = (Element) list2.item(0);
        gem.getVisualParameters().setColor(element2.getTextContent());

        list2 = element.getElementsByTagName("transparency");
        element2 = (Element) list2.item(0);
        gem.getVisualParameters().setTransparency(element2.getTextContent());

        list2 = element.getElementsByTagName("facetCount");
        element2 = (Element) list2.item(0);
        gem.getVisualParameters().setFacetCount(element2.getTextContent());

        return gem;
    }
}
