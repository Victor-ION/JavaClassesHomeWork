package Task6___21_11_2017.parsers;

import Task6___21_11_2017.model.Word;
import Task6___21_11_2017.model.symbols.Symbol;

import java.util.ArrayList;
import java.util.Arrays;

public class SentenceParser {
    private ArrayList<Word> wordsList;
    private String sourceSentence;
    private Symbol[] symbols;

    /**
     * main method for parser
     *
     * @param symbols initial data
     */
    public void parse(Symbol[] symbols) {
        this.symbols = symbols;
        if (sourceSentence == null) {
            sourceSentence = toStringSymbols(symbols);
        }
        wordsList = new ArrayList<>();
        findAllWords(symbols, wordsList);
    }

    /**
     * main method for parser with initial data as string
     *
     * @param sourceSentence initial data
     */
    public void parse(String sourceSentence) {
        if (sourceSentence == null || sourceSentence.isEmpty())
            throw new IllegalArgumentException("sourceSentence is empty!");
        this.sourceSentence = sourceSentence;

        // read all chars and convert them to symbols grouped in array
        char[] charArr = sourceSentence.toCharArray();
        Symbol[] symbols = new Symbol[charArr.length];
        for (int i = 0; i < charArr.length; i++) {
            symbols[i] = SymbolParser.getExactSymbol(charArr[i]);
        }
        parse(symbols);


    }

    /**
     * split text of the sentence into words and add them to the list
     *
     * @param symbols source sentence data
     * @param list    for result
     */
    public void findAllWords(Symbol[] symbols, ArrayList<Word> list) {
        boolean prevIsOrdinary = false;
        int ordinaryStart = 0;
        for (int i = 0; i < symbols.length; i++) {
            // find end of word
            Symbol curr = symbols[i];
            if (prevIsOrdinary) {

                if (!curr.isOrdinarySymbol()) {
                    Symbol[] wordSymbols = Arrays.copyOfRange(symbols, ordinaryStart, i);

                    // will throw an exception if wordSymbols are not OrdinarySymbols
                    list.add(new Word(wordSymbols));
                    prevIsOrdinary = false;
                } else if (i == symbols.length - 1) {
                    Symbol[] wordSymbols = Arrays.copyOfRange(symbols, ordinaryStart, i);

                    // will throw an exception if wordSymbols are not OrdinarySymbols
                    list.add(new Word(wordSymbols));
                    prevIsOrdinary = false;
                }
            } else {
                // word start
                if (curr.isOrdinarySymbol()) {
                    if (i == symbols.length - 1) {
                        Symbol[] arr = {curr};
                        list.add(new Word(arr));
                    }
                    prevIsOrdinary = true;
                    ordinaryStart = i;
                }
            }
        }

    }

    public ArrayList<Word> getWordsList() {
        return wordsList;
    }

    public Symbol[] getSymbols() {
        return symbols;
    }

    public String getSourceSentence() {
        if (sourceSentence == null) {
            sourceSentence = toStringSymbols(symbols);
        }
        return sourceSentence;
    }

    /**
     * convert symbols array to string
     *
     * @param symbols source data
     * @return result string
     */
    public String toStringSymbols(Symbol[] symbols) {
        StringBuilder sb = new StringBuilder();
        for (Symbol s : symbols) {
            sb.append(s.toString());
        }
        return sb.toString();
    }
}
