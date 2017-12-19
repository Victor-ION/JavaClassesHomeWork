package Task9___30_11_2017.parsers.sax;

import Task9___30_11_2017.model.Gem;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SaxGemParser {
    private final static Logger logger = LogManager.getLogger(SaxGemParser.class);
    public static Gem parse(String filename){
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser parser = spf.newSAXParser();
            SaxParserDefHandler saxParserDefHandler = new SaxParserDefHandler();

            File file = new File(filename);
            parser.parse(file, saxParserDefHandler);
            Gem gem = saxParserDefHandler.getResult();
            return gem;
        } catch (ParserConfigurationException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        } catch (SAXException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return null;

    }
}
