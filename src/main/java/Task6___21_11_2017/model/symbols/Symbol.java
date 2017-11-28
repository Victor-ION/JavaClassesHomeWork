package Task6___21_11_2017.model.symbols;

import Task6___21_11_2017.model.Element;

public abstract class Symbol implements Element {
    private final Character charValue;

    public Symbol(Character charValue) {
        this.charValue = charValue;
    }

    public Character getCharValue() {
        return charValue;
    }


    @Override
    public String toString() {
        return getCharValue().toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Symbol symbol = (Symbol) o;

        return getCharValue() != null ? getCharValue().equals(symbol.getCharValue()) : symbol.getCharValue() == null;
    }

    @Override
    public int hashCode() {
        return getCharValue() != null ? getCharValue().hashCode() : 0;
    }

    @Override
    public String getStringRepresentation() {
        return toString();
    }

    public abstract boolean isPunctuationSymbol();

    public abstract boolean isSentenceEndingSymbol();

    public abstract boolean isSpaceSymbol();

    public abstract boolean isOrdinarySymbol();
}
