package Task6___21_11_2017.model;

import Task6___21_11_2017.model.symbols.Symbol;
import Task6___21_11_2017.parsers.SentenceParser;

public class Sentence implements Element {
    private SentenceParser sentenceParser;


    public void setSymbols(Symbol[] symbols) {
        sentenceParser = new SentenceParser();
        sentenceParser.parse(symbols);
    }

    /**
     * create Sentence objects and parser for it
     *
     * @param source initial data
     */
    public Sentence(String source) {
        sentenceParser = new SentenceParser();
        sentenceParser.parse(source);


    }

    /**
     * create Sentence objects and parser for it
     *
     * @param symbols initial data
     */
    public Sentence(Symbol[] symbols) {
        setSymbols(symbols);
    }

    @Override
    public String toString() {
        return sentenceParser.getSourceSentence();
    }

    @Override
    public String getStringRepresentation() {
        return toString();
    }

    public String getStringRepresentationTrim() {
        return getStringRepresentation().trim();
    }

    public Integer getWordsCount() {
        return sentenceParser.getWordsList().size();
    }

    public SentenceParser getSentenceParser() {
        return sentenceParser;
    }
}
