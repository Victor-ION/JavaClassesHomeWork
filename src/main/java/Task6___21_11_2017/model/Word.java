package Task6___21_11_2017.model;

import Task6___21_11_2017.model.symbols.OrdinarySymbol;
import Task6___21_11_2017.model.symbols.Symbol;

public class Word implements Element {
    private OrdinarySymbol[] symbols;
    private String stringRepresentation;

    public Word(OrdinarySymbol[] symbols) {
        this.symbols = symbols;
    }

    /**
     * creates Word obj from symbols arr
     *
     * @param symbolsUnchecked initial data
     */
    public Word(Symbol[] symbolsUnchecked) {
        OrdinarySymbol[] checked = new OrdinarySymbol[symbolsUnchecked.length];
        for (int i = 0; i < symbolsUnchecked.length; i++) {
            Symbol symbol = symbolsUnchecked[i];
            if (symbol instanceof OrdinarySymbol) {
                checked[i] = (OrdinarySymbol) symbol;
            } else {
                throw new IllegalArgumentException("Not Ordinary Symbols in input array");
            }
        }
        this.symbols = checked;
    }

    public OrdinarySymbol[] getSymbols() {
        return symbols;
    }

    public void setSymbols(OrdinarySymbol[] symbols) {
        this.symbols = symbols;
        stringRepresentation = null;
    }

    @Override
    public String toString() {
        if (stringRepresentation == null) {

            StringBuilder sb = new StringBuilder();
            for (Symbol s : symbols) {
                sb.append(s.toString());
            }
            stringRepresentation = sb.toString();
        }
        return stringRepresentation;
    }

    @Override
    public String getStringRepresentation() {
        return toString();
    }
}
