package Task9___30_11_2017.parsers;

import Task9___30_11_2017.model.Gem;
import Task9___30_11_2017.parsers.dom.DomGemParser;
import Task9___30_11_2017.parsers.sax.SaxGemParser;
import Task9___30_11_2017.parsers.stax.StaxGemParser;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ParsingDemo {
    public static void main(String[] args) {
        demoSax();
        demoDom();
        demoStax();

        ArrayList<String> listFileNames = new ArrayList<>();
        listFileNames.add("src/main/java/Task9___30_11_2017/xmls/first.xml");
        listFileNames.add("src/main/java/Task9___30_11_2017/xmls/second.xml");
        listFileNames.add("src/main/java/Task9___30_11_2017/xmls/third.xml");

        List<Gem> gems = parseListOfXmls(listFileNames);
        for (Gem gem: gems){
            System.out.println(gem);
        }
    }

    public static void demoStax() {
        Gem gem = StaxGemParser.parse("src/main/java/Task9___30_11_2017/xmls/first.xml");
        System.out.println(gem);
        System.out.println();
    }

    public static void demoDom() {
        Gem gem = DomGemParser.parse("src/main/java/Task9___30_11_2017/xmls/first.xml");
        System.out.println(gem);
        System.out.println();
    }

    public static void demoSax() {
        Gem gem = SaxGemParser.parse("src/main/java/Task9___30_11_2017/xmls/first.xml");
        System.out.println(gem);
        System.out.println();

    }

    public static List<Gem> parseListOfXmls(List<String> fileNames){
        ArrayList<Gem> res = new ArrayList<>();

        for (String s : fileNames){
            Gem gem = DomGemParser.parse(s);
            res.add(gem);
        }

        res.sort(new Comparator<Gem>() {
            @Override
            public int compare(Gem o1, Gem o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        return res;
    }
}
