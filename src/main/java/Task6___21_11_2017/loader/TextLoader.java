package Task6___21_11_2017.loader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextLoader {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    /**
     * load text file in string
     *
     * @param path for file
     */
    public void loadFromFile(String path) {
        if (path == null || path.isEmpty()) throw new IllegalArgumentException("Empty path");
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String s;
            while ((s = br.readLine()) != null) {
                sb.append(s);
                sb.append(System.lineSeparator());
            }
            sb.delete(sb.length() - 1, sb.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
        text = sb.toString();
    }
}
