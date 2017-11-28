package Task6___21_11_2017.model.symbols;

import Task6___21_11_2017.parsers.SymbolParser;

public class SentenceEndingSymbol extends Symbol {
    public SentenceEndingSymbol(Character charValue) {
        super(charValue);
        if (!SymbolParser.isSentenceEnding(charValue)) throw new IllegalArgumentException("Incorrect symbol subtype");
    }

    @Override
    public boolean isPunctuationSymbol() {
        return false;
    }

    @Override
    public boolean isSentenceEndingSymbol() {
        return true;
    }

    @Override
    public boolean isSpaceSymbol() {
        return false;
    }

    @Override
    public boolean isOrdinarySymbol() {
        return false;
    }
}
