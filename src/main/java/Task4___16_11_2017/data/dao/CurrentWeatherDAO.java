package Task4___16_11_2017.data.dao;

import Task4___16_11_2017.data.SimpleDataHandler;
import Task4___16_11_2017.data.UtilParserWeather;

public class CurrentWeatherDAO implements DayWeatherDAO {
    private float temperature;
    private float humidity;
    private String weatherDescription;
    private SimpleDataHandler simpleDataHandler;

    public void update(){
        String currentWeatherDataFromLoader = simpleDataHandler.getDataLoader().getCurrentWeather();
        UtilParserWeather parserWeather = new UtilParserWeather(currentWeatherDataFromLoader);
        temperature  = parserWeather.getTemperature();
        humidity = parserWeather.getHumidity();
        weatherDescription = parserWeather.getWeatherDescription();

    }

    @Override
    public float getTemperature() {
        return temperature;
    }

    @Override
    public float getHumidity() {
        return humidity;
    }

    @Override
    public String getWeatherDescription() {
        return weatherDescription;
    }

    public CurrentWeatherDAO(SimpleDataHandler simpleDataHandler) {
        this.simpleDataHandler = simpleDataHandler;
    }
}
