package Task4___16_11_2017;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;

import static org.junit.Assert.*;

public class MainTest {
    @Test
    public void IntegrationTest() throws Exception{
        StringBuilder sb = new StringBuilder();
        try(BufferedReader bf = new BufferedReader(new FileReader("src/main/java/Task4___16_11_2017/data/exampleJsons/currentWeather.json"))){
            String s;
            while ((s = bf.readLine()) != null){
                sb.append(s);
            }
        }

    }

    public String readFromFileToString(String fileName){
        return "";
    }

}