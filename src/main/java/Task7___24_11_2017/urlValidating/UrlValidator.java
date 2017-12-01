package Task7___24_11_2017.urlValidating;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlValidator {

    public static boolean validate(String url){
        Pattern pattern = Pattern.compile("(?:^|[\\W])((ht|f)tp(s?):\\/\\/|www\\.)"
                        + "(([\\w\\-]+\\.){1,}?([\\w\\-.~]+\\/?)*"
                        + "[\\p{Alnum}.,%_=?&#\\-+()\\[\\]\\*$~@!:/{};']*)",
                Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
        Matcher matcher = pattern.matcher(url);
        return matcher.find()&&matcher.start()==0;
    }
}
