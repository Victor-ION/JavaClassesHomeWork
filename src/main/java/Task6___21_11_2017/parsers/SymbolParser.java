package Task6___21_11_2017.parsers;

import Task6___21_11_2017.model.symbols.*;

import java.util.HashSet;
import java.util.Set;

public class SymbolParser {
    public static final Set<Character> punctuationSymbols = new HashSet<>();

    static {
        char[] arr = {',', ':', ';', '(', ')', '—', '[', ']', '{', '}', '\"', '<', '>',};
        for (char c : arr) {
            punctuationSymbols.add(c);
        }
    }

    public static final Set<Character> sentenceEndings = new HashSet<>();

    static {
        char[] arr = {'.', '!', '?'};
        for (char c : arr) {
            sentenceEndings.add(c);
        }
    }

    public static final Set<Character> spaceSymbols = new HashSet<>();

    static {
        char[] arr = {' ', '\t', '\n'};
        for (char c : arr) {
            spaceSymbols.add(c);
        }
    }

    /**
     * choose exct obj that should be created
     *
     * @param c initial char
     * @return exact symbol
     */
    public static Symbol getExactSymbol(char c) {
        if (isPunctuation(c)) return new PunctuationSymbol(c);
        if (isSentenceEnding(c)) return new SentenceEndingSymbol(c);
        if (isSpace(c)) return new SpaceSymbol(c);
        return new OrdinarySymbol(c);

    }

    public static boolean isPunctuation(char c) {
        return punctuationSymbols.contains(c);
    }

    public static boolean isSentenceEnding(char c) {
        return sentenceEndings.contains(c);
    }

    public static boolean isSpace(char c) {
        if (Character.isSpaceChar(c)) return true;
        return spaceSymbols.contains(c);
    }

    public static boolean isOrdinary(char c) {
        return !(isPunctuation(c) || isSentenceEnding(c) || isSpace(c));
    }
}
