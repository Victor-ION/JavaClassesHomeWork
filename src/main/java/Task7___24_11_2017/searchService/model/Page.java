package Task7___24_11_2017.searchService.model;

import Task7___24_11_2017.searchService.parsers.PageParser;

import java.net.URL;
import java.util.ArrayList;
import java.util.Set;

public class Page {
    private URL url;
    private String htmlText;
    private Set<String> innerUrls;
    private ArrayList<Word> words;

    public Page(URL url) {
        this.url = url;
        loadInfo(url);
    }

    public void loadInfo(URL url) {
        htmlText = PageParser.loadHtml(url);
        words = PageParser.parseWords(htmlText);
    }




    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public String getHtmlText() {
        return htmlText;
    }

    public void setHtmlText(String htmlText) {
        this.htmlText = htmlText;
    }

    public Set<String> getInnerUrls() {
        if (innerUrls == null){
            innerUrls = findInnerUrls();
        }
        return innerUrls;
    }


    public Set<String> findInnerUrls() {
        return PageParser.findInnerUrls(htmlText);
    }

    public void setInnerUrls(Set<String> innerUrls) {
        this.innerUrls = innerUrls;
    }

    public ArrayList<Word> getWords() {
        return words;
    }

    public void setWords(ArrayList<Word> words) {
        this.words = words;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Page page = (Page) o;

        return url != null ? url.equals(page.url) : page.url == null;
    }

    @Override
    public int hashCode() {
        return url != null ? url.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Page{" +
                "url=" + url + "\n"+
                printWords(getWords()) +
                '}';
    }

    public String printWords(ArrayList<Word> words) {
        StringBuilder sb = new StringBuilder("Words:\n");
        for (int i = 0; i<10; i++){
            sb.append("\t");
            sb.append(words.get(i).toString());
            sb.append("\n");
        }
        return sb.toString();
    }

}
