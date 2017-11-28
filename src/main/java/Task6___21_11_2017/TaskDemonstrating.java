package Task6___21_11_2017;

import Task6___21_11_2017.loader.TextLoader;
import Task6___21_11_2017.model.Sentence;
import Task6___21_11_2017.model.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TaskDemonstrating {
    public static void main(String[] args) {
        String path = "src/main/java/Task6___21_11_2017/loader/textFile.txt";
        completeTask(path);
    }

    /**
     * Вывести все предложения заданного текста в порядке возрастания
     * количества слов в каждом из них.
     */
    public static void completeTask(String pathToFile) {
        TextLoader loader = new TextLoader();
        loader.loadFromFile(pathToFile);

        Text text = new Text(loader.getText());
        ArrayList<Sentence> fromText = text.getTextParser().getSentencesList();

        ArrayList<Sentence> copySentences = new ArrayList<>(fromText);


//        Collections.sort(copySentences,
//                (o1, o2) -> o1.getWordsCount() - o2.getWordsCount());
        Collections.sort(copySentences, Comparator.comparing(Sentence::getWordsCount));

        for (Sentence s : copySentences) {
            System.out.println(s.getStringRepresentationTrim() + " |||count = " + s.getWordsCount());
            System.out.println("///////////");
        }
    }
}
