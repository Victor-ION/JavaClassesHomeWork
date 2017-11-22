package Task4___16_11_2017.observers;

import Task4___16_11_2017.WeatherObservable;
import Task4___16_11_2017.data.SimpleDataHandler;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer, Display {
    private float temperature;
    private float humidity;
    private String weatherDescription;
    private Observable observable;

    public CurrentConditionsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }



    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature + " C degrees and " + humidity + "% humidity\n" + weatherDescription);

    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof SimpleDataHandler){
            SimpleDataHandler handler = (SimpleDataHandler) arg;
            temperature = handler.getCurrentWeatherDAO().getTemperature();
            humidity = handler.getCurrentWeatherDAO().getHumidity();
            weatherDescription = handler.getCurrentWeatherDAO().getWeatherDescription();
            display();
        }
    }
}
