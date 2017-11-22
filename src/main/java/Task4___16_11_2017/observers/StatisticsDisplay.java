package Task4___16_11_2017.observers;

import Task4___16_11_2017.data.SimpleDataHandler;

import java.util.Observable;
import java.util.Observer;

public class StatisticsDisplay implements Observer, Display{
    private Float minTemperature;
    private Float maxTemperature;
    private Observable observable;


    public StatisticsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Statistics for this program:\n" +"min: "+ minTemperature + " C degrees and max: " + maxTemperature + " C degrees");
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof SimpleDataHandler){
            SimpleDataHandler handler = (SimpleDataHandler) arg;
            maxTemperature = handler.getStetisticsWeatherDAO().getMaxTemperature();
            minTemperature = handler.getStetisticsWeatherDAO().getMinTemperature();
            display();
        }
    }
}
