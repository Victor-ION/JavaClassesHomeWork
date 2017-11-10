package Task2___07_11_2017;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleHelper {
    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static String readLine() throws Exception{
        return bufferedReader.readLine();
    }
    public static int readInt() throws Exception{
        String s = readLine();
        return Integer.parseInt(s);
    }
}
