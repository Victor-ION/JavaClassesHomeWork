package Task7___24_11_2017.searchService.parsers;

import Task7___24_11_2017.searchService.model.Word;
import org.junit.Test;

import java.net.URL;
import java.util.ArrayList;
import java.util.Set;

import static org.junit.Assert.*;

public class PageParserTest {
    @Test
    public void loadHtml() throws Exception {
        String s = PageParser.loadHtml(new URL("https://uk.wikipedia.org/wiki/%D0%9E%D1%87%D0%B8%D1%89%D0%B5%D0%BD%D0%BD%D1%8F_%D1%81%D1%82%D1%96%D1%87%D0%BD%D0%B8%D1%85_%D0%B2%D0%BE%D0%B4"));
        System.out.println(s);
        assertTrue(s.length() >0);
    }

    @Test
    public void getRegularText() throws Exception{
        String s = PageParser.loadHtml(new URL("https://uk.wikipedia.org/wiki/%D0%9E%D1%87%D0%B8%D1%89%D0%B5%D0%BD%D0%BD%D1%8F_%D1%81%D1%82%D1%96%D1%87%D0%BD%D0%B8%D1%85_%D0%B2%D0%BE%D0%B4"));
        String regText = PageParser.getRegularText(s);
        assertTrue(regText.length() > 0);
//        System.out.println(regText);
//        System.out.println(regText.length());

    }

    @Test
    public void parseWords() throws Exception {
        String s = PageParser.loadHtml(new URL("https://uk.wikipedia.org/wiki/%D0%9E%D1%87%D0%B8%D1%89%D0%B5%D0%BD%D0%BD%D1%8F_%D1%81%D1%82%D1%96%D1%87%D0%BD%D0%B8%D1%85_%D0%B2%D0%BE%D0%B4"));
        int delim = 0;
        ArrayList<Word> res = PageParser.parseWords(s);
        for (Word w : res){
            if (delim == 10) break;
//            System.out.println(w);
            delim++;
        }
        assertTrue(res.size()>0);
    }

    @Test
    public void findInnerUrls() throws Exception {
        String s = PageParser.loadHtml(new URL("https://uk.wikipedia.org/wiki/%D0%9E%D1%87%D0%B8%D1%89%D0%B5%D0%BD%D0%BD%D1%8F_%D1%81%D1%82%D1%96%D1%87%D0%BD%D0%B8%D1%85_%D0%B2%D0%BE%D0%B4"));
//        System.out.println(s.length());
        assertTrue(s.length()>0);
        Set<String> set = PageParser.findInnerUrls(s);
//        System.out.println(set.size());
        assertTrue(set.size() > 0);
        for(String s2 : set){
//            System.out.println(s2);
        }
    }

}