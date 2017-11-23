package Task4___16_11_2017.observers;

import Task4___16_11_2017.data.SimpleDataHandler;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay implements Observer, Display{
    private float temperature;
    private float humidity;
    private String weatherDescription;
    private Observable observable;

    private JFrame frame;
    private JTextArea textArea;

    public ForecastDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);

        frame = new JFrame("Forecast");
        frame.setSize(580, 100);
        textArea = new JTextArea();
        frame.getContentPane().add(textArea);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void display() {
        String text ="Forecast (Weather through ~24 hours) conditions: " + temperature + " C degrees and " + humidity + "% humidity\n" + weatherDescription;
        System.out.println(text);
        textArea.setText(text);

    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof SimpleDataHandler){
            SimpleDataHandler handler = (SimpleDataHandler) arg;
            temperature = handler.getForecastWeatherDAO().getTemperature();
            humidity = handler.getForecastWeatherDAO().getHumidity();
            weatherDescription = handler.getForecastWeatherDAO().getWeatherDescription();
            display();
        }
    }
}
