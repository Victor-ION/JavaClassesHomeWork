package Task7___24_11_2017.searchService;

import Task7___24_11_2017.searchService.model.Page;
import Task7___24_11_2017.searchService.model.Word;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainFinder {
    public static void main(String[] args) throws IOException{
//        String s = "https://uk.wikipedia.org/wiki/%D0%9E%D1%87%D0%B8%D1%89%D0%B5%D0%BD%D0%BD%D1%8F_%D1%81%D1%82%D1%96%D1%87%D0%BD%D0%B8%D1%85_%D0%B2%D0%BE%D0%B4";
        String s = "https://stackoverflow.com/questions/5713558/detect-and-extract-url-from-a-string";
        URL url = new URL(s);
        List<Page> pages = findPages(url, 20);
        printPages(pages);

        System.out.println("\n///////////////////////////////\n");

        List<Page> pagesSortedByWordFreq = getPagesByWordFreq("and", pages);
        printPages(pagesSortedByWordFreq);

    }


    /**
     * по произвольному URL перейти и спомощью регулярного выражения найти 20 URL
     * каждому указываете ключевые слова с частотами
     */
    public static List<Page> findPages(URL url, int count) {
        ArrayList<Page> pages = new ArrayList<>();
        Page firstPage = new Page(url);
        pages.add(firstPage);
        int itr = 0;
        while (pages.size() < count){
            Page page = pages.get(itr);
            for (String urlString : page.findInnerUrls() ){
                if (pages.size() >= count) break;

                try {
                    URL urlSub = new URL(urlString);
                    Page anotherPage = new Page(urlSub);
                    pages.add(anotherPage);
                }
                catch (Exception e){
                    // some problems with loading html
                    // or
                    // not valid url, go further

                }
            }
            itr++;
        }
        return pages;
    }

    /**
     * print results of found pages
     * @param pages source of data
     */
    public static void printPages(List<Page> pages) {
        for (Page p : pages){
            System.out.println(p);
            System.out.println();
        }
    }

    /**
     * по указаному слову найти все URL упорядоченые по возрастанию частоты слова
     */
    public  static List<Page> getPagesByWordFreq(String findWord, List<Page> pages){
        ArrayList<Page> res = new ArrayList<>(pages);
        Word word = new Word(findWord);
        res.sort(new Comparator<Page>() {
            @Override
            public int compare(Page o1, Page o2) {
                int ind1 = o1.getWords().indexOf(word);
                int ind2 = o2.getWords().indexOf(word);
                if (ind1 == -1){
                    if (ind2 == -1) return 0;
                    else return -1;
                }
                else if (ind2 == -1) return 1;
                else return Integer.compare(o1.getWords().get(ind1).getFreq(), o2.getWords().get(ind2).getFreq());
            }
        });
        return res;
    }

}
