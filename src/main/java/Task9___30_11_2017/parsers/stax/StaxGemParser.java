package Task9___30_11_2017.parsers.stax;

import Task9___30_11_2017.model.Gem;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class StaxGemParser {
    private final static Logger logger = LogManager.getLogger(StaxGemParser.class);


    public static Gem parse(String fileName){
        Gem gem = new Gem();

        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLStreamReader reader = null;
        try {
            reader = xmlInputFactory.createXMLStreamReader(new FileInputStream(fileName));
            while (reader.hasNext()){
                int type = reader.next();
                switch (type){
                    case XMLStreamConstants.START_ELEMENT:{
                        String tagName = reader.getLocalName();
                        switch (tagName){
                            case "gem":{
                                gem.setUnicName(reader.getAttributeValue(0));
                                break;
                            }
                            case "typeName":{
                                gem.setTypeName(reader.getElementText());
                                break;
                            }
                            case "preciousness":{
                                gem.setPreciousness(reader.getElementText());
                                break;
                            }
                            case "origin":{
                                gem.setOrigin(reader.getElementText());
                                break;
                            }
                            case "color":{
                                gem.getVisualParameters().setColor(reader.getElementText());
                                break;
                            }
                            case "transparency":{
                                gem.getVisualParameters().setTransparency(reader.getElementText());
                                break;
                            }
                            case "facetCount":{
                                gem.getVisualParameters().setFacetCount(reader.getElementText());
                                break;
                            }
                            case "value":{
                                gem.setValue(reader.getElementText());
                                break;
                            }
                        }
                        break;
                    }
//                    case XMLStreamConstants.END_ELEMENT:{
//                        String tagName = reader.getLocalName();
//                    }

                }
            }

        } catch (XMLStreamException e) {
            logger.error(e.getMessage());
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
        }

        return gem;
    }
}
