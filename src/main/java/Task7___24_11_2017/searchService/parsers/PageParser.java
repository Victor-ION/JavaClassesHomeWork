package Task7___24_11_2017.searchService.parsers;

import Task7___24_11_2017.searchService.model.Word;
import org.jsoup.Jsoup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PageParser {
    /**
     * download all html from specified url
     *
     * @param url from where data should be download
     * @return String representation of html
     */
    public static String loadHtml(URL url) {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()))) {
            String s;
            StringBuilder sb = new StringBuilder();
            while ((s = bf.readLine()) != null) {
                sb.append(s);
                sb.append(System.lineSeparator());
            }
            // remove last unnecessary lineSeparator
            sb.delete(sb.lastIndexOf(System.lineSeparator()), sb.length());
            return sb.toString();

        } catch (IOException e) {
//            e.printStackTrace();
            throw new RuntimeException("Failed to load htmlText");
        }
    }

    public static ArrayList<Word> parseWords(String htmlText) {
        ArrayList<Word> list = new ArrayList<>();
        String regularText = getRegularText(htmlText);

//        Pattern pattern = Pattern.compile("(\\w)+");
//        Matcher matcher = pattern.matcher(regularText);
//        String[] arr = regularText.split("[^а-яА-Яa-zA-Z]+");
        String[] arr = regularText.split("[^а-яА-Яa-zA-Zії]+");
        for (String s : arr) {
            // to avoid short words
            if (s.length()<3) continue;

            Word w = new Word(s);
            int ind = list.indexOf(w);
            if (ind == -1) {
                list.add(w);
            } else {
                list.get(ind).meetAgain();
            }
        }
        list.sort((o1, o2) -> o2.getFreq() - o1.getFreq());
//        list.sort(Comparator.comparing(Word::getFreq));
        return list;
    }

    public static String getRegularText(String htmlText) {
        String regularText = Jsoup.parse(htmlText).text();
        return regularText;
    }

    public static Set<String> findInnerUrls(String htmlText) {
        Set<String> set = new HashSet<>();
        String regexp1 = "_^(?:(?:https?|ftp)://)(?:\\S+(?::\\S*)?@)?(?:(?!10(?:\\.\\d{1,3}){3})(?!127(?:\\.\\d{1,3}){3})(?!169\\.254(?:\\.\\d{1,3}){2})(?!192\\.168(?:\\.\\d{1,3}){2})(?!172\\.(?:1[6-9]|2\\d|3[0-1])(?:\\.\\d{1,3}){2})(?:[1-9]\\d?|1\\d\\d|2[01]\\d|22[0-3])(?:\\.(?:1?\\d{1,2}|2[0-4]\\d|25[0-5])){2}(?:\\.(?:[1-9]\\d?|1\\d\\d|2[0-4]\\d|25[0-4]))|(?:(?:[a-z\\x{00a1}-\\x{ffff}0-9]+-?)*[a-z\\x{00a1}-\\x{ffff}0-9]+)(?:\\.(?:[a-z\\x{00a1}-\\x{ffff}0-9]+-?)*[a-z\\x{00a1}-\\x{ffff}0-9]+)*(?:\\.(?:[a-z\\x{00a1}-\\x{ffff}]{2,})))(?::\\d{2,5})?(?:/[^\\s]*)?$_iuS";
        String regexp2 = "_(^|[\\s.:;?\\-\\]<\\(])(https?://[-\\w;/?:@&=+$\\|\\_.!~*\\|'()\\[\\]%#,☺]+[\\w/#](\\(\\))?)(?=$|[\\s',\\|\\(\\).:;?\\-\\[\\]>\\)])_i";
//
//        while (i != -1){
//
//        }
//        Pattern pattern = Pattern.compile("во.*");
//        Pattern pattern = Pattern.compile(regexp2);
        Pattern pattern = Pattern.compile("(?:^|[\\W])((ht|f)tp(s?):\\/\\/|www\\.)"
                        + "(([\\w\\-]+\\.){1,}?([\\w\\-.~]+\\/?)*"
                        + "[\\p{Alnum}.,%_=?&#\\-+()\\[\\]\\*$~@!:/{};']*)",
                Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
        Matcher matcher = pattern.matcher(htmlText);
        int start = 0;
        while (matcher.find(start)){
            String urlString = matcher.group();
            set.add(urlString.substring(1));
            start = matcher.end() + 1;
        }
        return set;
    }
}
