package Task4___16_11_2017.observers;

import Task4___16_11_2017.data.SimpleDataHandler;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class StatisticsDisplay implements Observer, Display{
    private Float minTemperature;
    private Float maxTemperature;
    private Observable observable;

    private JFrame frame;
    private JTextArea textArea;


    public StatisticsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);

        frame = new JFrame("Statistics");
        frame.setSize(340, 100);
        textArea = new JTextArea();
        frame.getContentPane().add(textArea);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void display() {
        String text = "Statistics for this program:\n" +"min: "+ minTemperature + " C degrees and max: " + maxTemperature + " C degrees";
        System.out.println(text);
        textArea.setText(text);

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
