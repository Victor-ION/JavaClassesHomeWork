package Task6___21_11_2017.parsers;

import Task6___21_11_2017.model.Sentence;
import Task6___21_11_2017.model.symbols.Symbol;

import java.util.ArrayList;
import java.util.Arrays;

public class TextParser {
    private ArrayList<Sentence> sentencesList;

    private String sourceText;
    private Symbol[] symbols;

    public TextParser() {
    }

    /**
     * main method for parsing text
     *
     * @param sourceText initial data
     */
    public void parse(String sourceText) {
        if (sourceText == null || sourceText.isEmpty())
            throw new IllegalArgumentException("sourceText is empty!");
        this.sourceText = sourceText;

        sentencesList = new ArrayList<>();
        symbols = parseSymbols(sourceText);
        findAllSentences(symbols, sentencesList);


    }

    /**
     * split text by sentences and add them in list
     *
     * @param symbols       represents source text
     * @param sentencesList place where sentences should be added
     */
    public void findAllSentences(Symbol[] symbols, ArrayList<Sentence> sentencesList) {
        boolean wasEnd = false;
        int startPoint = 0;
        for (int i = 0; i < symbols.length; i++) {
            Symbol curr = symbols[i];
            if (i == symbols.length - 1) {
                Symbol sentenceSymbols[] = Arrays.copyOfRange(symbols, startPoint, i + 1);
                Sentence sentence = new Sentence(sentenceSymbols);
                sentencesList.add(sentence);
//                startPoint = i;
//                wasEnd = false;
            }

            if (curr.isSentenceEndingSymbol()) {
                wasEnd = true;
            } else if (wasEnd) {
                Symbol sentenceSymbols[] = Arrays.copyOfRange(symbols, startPoint, i);
                Sentence sentence = new Sentence(sentenceSymbols);
                sentencesList.add(sentence);
                startPoint = i;
                wasEnd = false;
            }
        }
    }

    /**
     * convert text in string into symbols array
     *
     * @param sourceText string data
     * @return symbols array
     */
    public Symbol[] parseSymbols(String sourceText) {
        Symbol[] arr = new Symbol[sourceText.length()];
        char[] charArr = sourceText.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            arr[i] = SymbolParser.getExactSymbol(charArr[i]);
        }
        return arr;
    }


    public Symbol[] getSymbols() {
        return symbols;
    }


    public String getSourceText() {
        return sourceText;
    }


    public ArrayList<Sentence> getSentencesList() {
        return sentencesList;
    }


}
