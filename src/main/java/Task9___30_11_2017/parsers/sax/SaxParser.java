package Task9___30_11_2017.parsers.sax;

import Task9___30_11_2017.model.Gem;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParser extends DefaultHandler{
    private Gem gem = new Gem();

    public Gem getResult(){
        return gem;
    }
    String thisElementName;
    Attributes attributes;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        thisElementName = qName;
        this.attributes = attributes;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        thisElementName = "";
        attributes = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
//        switch ("")
    }
}
