package Task6___21_11_2017.model;

import Task6___21_11_2017.parsers.TextParser;

public class Text implements Element {
    private TextParser textParser;

    /**
     * create Text obj ant parser for it
     *
     * @param sourceText initial data
     */
    public Text(String sourceText) {
        this.textParser = new TextParser();
        textParser.parse(sourceText);
    }

    public Integer getSentenceCount() {
        return textParser.getSentencesList().size();
    }

    public TextParser getTextParser() {
        return textParser;
    }

    @Override
    public String getStringRepresentation() {
        return getTextParser().getSourceText();
    }
}
