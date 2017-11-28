package Task6___21_11_2017.parsers;

import Task6___21_11_2017.model.Sentence;
import Task6___21_11_2017.model.symbols.Symbol;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TextParserTest {
    private TextParser parser;
    @Before
    public void setUp(){
        parser = new TextParser();
    }

    @Test
    public void parse() throws Exception {
        parser.parse("This is first sentence. This is second sentence!! Is this the third sentence?");
//        for (Sentence s : parser.getSentencesList()){
//            System.out.println(s.getStringRepresentation());
//        }
        assertEquals(3, parser.getSentencesList().size());
        assertEquals(" This is second sentence!!", parser.getSentencesList().get(1).getStringRepresentation());
    }

    @Test
    public void findAllSentences() throws Exception {
        parser.parse("This is first sentence. This is second sentence!! Is this the third sentence?");
        Symbol[] arr = parser.getSymbols();
        ArrayList<Sentence> list = new ArrayList<>();
        parser.findAllSentences(arr, list);
        assertEquals(3, list.size());
    }

    @Test
    public void parseSymbols() throws Exception {
        Symbol[] arr = parser.parseSymbols("Th is");
        assertEquals(5, arr.length);
        assertTrue(arr[3].getCharValue().equals('i'));
    }


}