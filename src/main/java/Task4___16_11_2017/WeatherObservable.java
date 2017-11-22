package Task4___16_11_2017;

import Task4___16_11_2017.data.DataHandler;

import java.util.Observable;

public class WeatherObservable extends Observable{
//    private float temperature;
//    private float humidity;
//    private float pressure;

    // all data is here
    private DataHandler dataHandler;

    public WeatherObservable(DataHandler dataHandler) {
        this.dataHandler = dataHandler;
    }


    public void update() {
        dataHandler.update();
        measurementsChanged();
    }

    public void measurementsChanged(){
        setChanged();
        notifyObservers(dataHandler);
    }




//    public float getTemperature() {
//        return temperature;
//    }
//
//    public float getHumidity() {
//        return humidity;
//    }
//
//    public float getPressure() {
//        return pressure;
//    }
}
