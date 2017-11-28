package Task6___21_11_2017.loader;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TextLoaderTest {

    @Test
    public void loadFromFile() throws Exception {
        TextLoader loader = new TextLoader();
        loader.loadFromFile("src/main/java/Task6___21_11_2017/loader/testFileWithText.txt");
//        System.out.println(loader.getText());
        assertTrue(loader.getText().endsWith("ence?"));
    }

}