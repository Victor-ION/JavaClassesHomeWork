package Task7___24_11_2017.searchService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class M {
    public static void main(String[] args) {
//        Pattern pattern = Pattern.compile("(\\w)+");
//        Matcher matcher = pattern.matcher("Gf fv3, lfd. ");
        for (String s : "Gf fv3,.! аппарт lfd. ".split("[^а-яА-Яa-zA-Z]+")){
            System.out.println(s);
        }
    }
}
