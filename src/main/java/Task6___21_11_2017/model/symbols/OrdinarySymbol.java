package Task6___21_11_2017.model.symbols;


import Task6___21_11_2017.parsers.SymbolParser;

public class OrdinarySymbol extends Symbol {
    public OrdinarySymbol(Character charValue) {
        super(charValue);
        if (!SymbolParser.isOrdinary(charValue)) throw new IllegalArgumentException("Incorrect symbol subtype!");
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
        return false;
    }

    @Override
    public boolean isOrdinarySymbol() {
        return true;
    }
}
