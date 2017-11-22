package Task4___16_11_2017.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;

public class DataLoader {
    private Properties urlsProperties;
    private String currentWeather;

    private static final String ACCEPT_CHARSET = "Accept-Charset";
    private static final String UTF_8 = "UTF-8";


    public void update(){
        loadCurrentWeather();
    }


    public DataLoader() {
        urlsProperties = new Properties();
        try {
            urlsProperties.load(new FileReader("src/main/java/Task4___16_11_2017/data/urls.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadCurrentWeather(){
        String urlString = urlsProperties.getProperty("currentWeather");
        try {
            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();
            connection.setRequestProperty(ACCEPT_CHARSET, UTF_8);
            currentWeather = readResponse(connection);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readResponse(URLConnection connection) throws IOException {
        StringBuilder builder = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))){
            String line;
            while ((line = br.readLine()) != null){
                builder.append(line);
            }
        }
        return builder.toString();
    }



    public String getCurrentWeather() {
        return currentWeather;
    }

    public void setCurrentWeather(String currentWeather) {
        this.currentWeather = currentWeather;
    }

    public static void main(String[] args) {
        DataLoader dataLoader = new DataLoader();
        dataLoader.loadCurrentWeather();
        System.out.println(dataLoader.getCurrentWeather());


    }
}
