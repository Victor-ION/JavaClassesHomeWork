package Task4___16_11_2017;

import Task4___16_11_2017.data.DataLoader;
import Task4___16_11_2017.data.SimpleDataHandler;
import Task4___16_11_2017.observers.CurrentConditionsDisplay;
import Task4___16_11_2017.observers.ForecastDisplay;
import Task4___16_11_2017.observers.StatisticsDisplay;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.*;

public class MainTest {
    @Test
    public void IntegrationTest() throws Exception {
        String currentWeather = readFromFileToString("src/main/java/Task4___16_11_2017/data/exampleJsons/currentWeather.json");
        String currentWeather2 = readFromFileToString("src/main/java/Task4___16_11_2017/data/exampleJsons/currentWeather2.json");
        String forecastWeather = readFromFileToString("src/main/java/Task4___16_11_2017/data/exampleJsons/forecastWeather.json");
        String forecastWeather2 = readFromFileToString("src/main/java/Task4___16_11_2017/data/exampleJsons/forecastWeather2.json");


        SimpleDataHandler handler = new SimpleDataHandler();
        WeatherObservable observable = new WeatherObservable(handler);
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(observable);
        ForecastDisplay forecastDisplay = new ForecastDisplay(observable);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(observable);

        DataLoader loader = new DataLoader();
        DataLoader mockLoader = Mockito.spy(loader);
//        doReturn(currentWeather).when(mockLoader).getCurrentWeather();
        when(mockLoader.getCurrentWeather()).thenReturn(currentWeather);
        when(mockLoader.getForecastWeather()).thenReturn(forecastWeather);

        handler.setDataLoader(mockLoader);
        observable.update();

        doReturn(currentWeather2).when(mockLoader).getCurrentWeather();
        when(mockLoader.getForecastWeather()).thenReturn(forecastWeather2);
        observable.update();


//        while (true){
//            observable.update();
//            try {
//                Thread.sleep(20000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }

    public String readFromFileToString(String fileName) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bf = new BufferedReader(new FileReader(fileName))) {
            String s;
            while ((s = bf.readLine()) != null) {
                sb.append(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

}