package Task6___21_11_2017.model.symbols;

import Task6___21_11_2017.parsers.SymbolParser;

public class PunctuationSymbol extends Symbol {
    public PunctuationSymbol(Character charValue) {
        super(charValue);
        if (!SymbolParser.isPunctuation(charValue)) throw new IllegalArgumentException("Incorrect symbol subtype");
    }

    @Override
    public boolean isPunctuationSymbol() {
        return true;
    }

    @Override
    public boolean isSentenceEndingSymbol() {
        return false;
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
