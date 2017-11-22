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
    private String forecastWeather;

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
        String currentWeatherUrl = urlsProperties.getProperty("currentWeather");
        currentWeather = loadUrl(currentWeatherUrl);
        String forecastWeatherUrl = urlsProperties.getProperty("forecastWeather");
        forecastWeather = loadUrl(forecastWeatherUrl);
    }

    private String loadUrl(String urlString) {
        try {
            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();
            connection.setRequestProperty(ACCEPT_CHARSET, UTF_8);
            return readResponse(connection);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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

    public String getForecastWeather() {
        return forecastWeather;
    }

    public void setForecastWeather(String forecastWeather) {
        this.forecastWeather = forecastWeather;
    }

    public static void main(String[] args) {
        DataLoader dataLoader = new DataLoader();
        dataLoader.loadCurrentWeather();
        System.out.println(dataLoader.getCurrentWeather());


    }
}
