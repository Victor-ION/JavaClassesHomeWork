package Task6___21_11_2017.parsers;

import Task6___21_11_2017.model.symbols.OrdinarySymbol;
import Task6___21_11_2017.model.symbols.PunctuationSymbol;
import Task6___21_11_2017.model.symbols.SentenceEndingSymbol;
import Task6___21_11_2017.model.symbols.SpaceSymbol;
import org.junit.Test;

import static org.junit.Assert.*;

public class SymbolParserTest {
    @Test
    public void getExactSymbol() throws Exception {
        assertTrue(SymbolParser.getExactSymbol('a') instanceof OrdinarySymbol);
        assertTrue(SymbolParser.getExactSymbol(' ') instanceof SpaceSymbol);
        assertTrue(SymbolParser.getExactSymbol('.') instanceof SentenceEndingSymbol);
        assertTrue(SymbolParser.getExactSymbol(',') instanceof PunctuationSymbol);
    }

    @Test
    public void isPunctuation() throws Exception {
        assertTrue(SymbolParser.isPunctuation(','));

    }

    @Test
    public void isSentenceEnding() throws Exception {
        assertTrue(SymbolParser.isSentenceEnding('!'));
        assertTrue(SymbolParser.isSentenceEnding('?'));
        assertTrue(SymbolParser.isSentenceEnding('.'));

    }

    @Test
    public void isSpace() throws Exception {
        assertTrue(SymbolParser.isSpace(' '));
        assertTrue(SymbolParser.isSpace('\n'));
        assertTrue(SymbolParser.isSpace('\t'));

    }

    @Test
    public void isOrdinary() throws Exception {
        assertFalse(SymbolParser.isOrdinary(' '));
        assertFalse(SymbolParser.isOrdinary('?'));
        assertFalse(SymbolParser.isOrdinary(','));
        assertTrue(SymbolParser.isOrdinary('d'));

    }

}