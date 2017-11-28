package Task6___21_11_2017.model.symbols;

import Task6___21_11_2017.parsers.SymbolParser;

public class SpaceSymbol extends Symbol {
    public SpaceSymbol(Character charValue) {
        super(charValue);
        if (!SymbolParser.isSpace(charValue)) throw new IllegalArgumentException("Incorrect symbol subtype");
    }

    @Override
    public boolean isPunctuationSymbol() {
        return false;
    }

    @Override
    public boolean isSentenceEndingSymbol() {
        return false;
    }

    @Override
    public boolean isSpaceSymbol() {
        return true;
    }

    @Override
    public boolean isOrdinarySymbol() {
        return false;
    }
}
