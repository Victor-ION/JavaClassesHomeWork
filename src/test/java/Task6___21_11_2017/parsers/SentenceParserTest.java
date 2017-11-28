package Task6___21_11_2017.parsers;

import Task6___21_11_2017.model.Word;
import Task6___21_11_2017.model.symbols.Symbol;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SentenceParserTest {
    private SentenceParser sentenceParser;
    @Before
    public void setUp() throws Exception {
        sentenceParser = new SentenceParser();
    }

    @Test
    public void parse() throws Exception {
        sentenceParser.parse("This just a happened at the moment");
//        System.out.println(sentenceParser.getWordsList().get(0));
//        System.out.println(sentenceParser.getWordsList().get(5));
        assertEquals(7, sentenceParser.getWordsList().size());


    }

    @Test
    public void parse1() throws Exception {
        sentenceParser.parse("This just a happened at the moment a");
        assertEquals(8, sentenceParser.getWordsList().size());

        SentenceParser sentenceParser2 = new SentenceParser();
        Symbol[] arr = sentenceParser.getSymbols();
        sentenceParser2.parse(arr);
        assertEquals(8, sentenceParser.getWordsList().size());
    }

    @Test
    public void findAllWords() throws Exception {
        sentenceParser.parse("This just a happened at the moment a");
        Symbol[] arr = sentenceParser.getSymbols();
        ArrayList<Word> list = new ArrayList<Word>();
        sentenceParser.findAllWords(arr, list);
        assertEquals(8, list.size());
        for (Word w : list){
//            System.out.println(w);
        }
    }

    @Test
    public void getSourceSentence() throws Exception {
        sentenceParser.parse("This just a happened at the moment a");
        assertEquals("This just a happened at the moment a", sentenceParser.getSourceSentence());
    }



}