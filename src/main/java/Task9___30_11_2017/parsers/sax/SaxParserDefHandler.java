package Task9___30_11_2017.parsers.sax;

import Task9___30_11_2017.model.Gem;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParserDefHandler extends DefaultHandler{
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
        switch (thisElementName){
            case "gem":{
                String unicName = attributes.getValue("unicName");
                gem.setUnicName(unicName);
                break;
            }
            case "typeName":{
                String typeName = new String(ch, start, length);
                gem.setTypeName(typeName);
                break;
            }
            case "preciousness":{
                String preciousness = new String(ch, start, length);
                gem.setPreciousness(preciousness);
                break;
            }
            case "origin":{
                String origin = new String(ch, start, length);
                gem.setOrigin(origin);
                break;
            }
            case "color":{
                String color = new String(ch, start, length);
                gem.getVisualParameters().setColor(color);
                break;
            }
            case "transparency":{
                String transparency = new String(ch, start, length);
                gem.getVisualParameters().setTransparency(transparency);
                break;
            }
            case "facetCount":{
                String facetCount = new String(ch, start, length);
                gem.getVisualParameters().setFacetCount(facetCount);
                break;
            }
            case "value":{
                String value = new String(ch, start, length);
                gem.setValue(value);
                break;
            }
        }
    }
}
