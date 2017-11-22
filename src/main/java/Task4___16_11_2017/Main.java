package Task4___16_11_2017;

import Task4___16_11_2017.data.SimpleDataHandler;
import Task4___16_11_2017.observers.CurrentConditionsDisplay;
import Task4___16_11_2017.observers.ForecastDisplay;

public class Main {
    public static void main(String[] args) {
        SimpleDataHandler handler = new SimpleDataHandler();
        WeatherObservable observable = new WeatherObservable(handler);
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(observable);
        ForecastDisplay forecastDisplay = new ForecastDisplay(observable);
        observable.addObserver(currentConditionsDisplay);
        while (true){
            observable.update();
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
