package Task7___24_11_2017.searchService.model;

import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class WordTest {
    @Before
    public void initPool(){
        Word.stringPool = new ArrayList<>();
    }
    @After
    public void clearPool(){
        Word.stringPool = new ArrayList<>();
    }
    @Test
    public void getValue() throws Exception {
        Word word = new Word("hello");
        assertEquals("hello", word.getValue());

    }

    @Test
    public void equals(){
        Word word = new Word("hello");
        word.meetAgain();
        Word word2 = new Word("hello");
        assertEquals(word, word2);

    }
    @Test
    public void getFreq() throws Exception {
        Word word = new Word("hello");
        Word word2 = new Word("hello");
        word2.meetAgain();
        assertEquals(1, word.getFreq());
        assertEquals(2, word2.getFreq());

    }

    @Test
    public void meetAgain() throws Exception {
        Word word = new Word("hello");
        word.meetAgain();
        assertEquals(2, word.getFreq());


    }

}