package Task4___16_11_2017.data.dao;

import Task4___16_11_2017.data.SimpleDataHandler;
import Task4___16_11_2017.data.UtilParserForecast;

public class ForecastWeatherDAO implements DayWeatherDAO {
    private float temperature;
    private float humidity;
    private String weatherDescription;
    private SimpleDataHandler simpleDataHandler;


    public void update(){
        String forecastWeatherDataFromLoader = simpleDataHandler.getDataLoader().getForecastWeather();
        UtilParserForecast parserForecast = new UtilParserForecast(forecastWeatherDataFromLoader);
        temperature  = parserForecast.getTemperature();
        humidity = parserForecast.getHumidity();
        weatherDescription = parserForecast.getWeatherDescription();

    }
    public ForecastWeatherDAO(SimpleDataHandler simpleDataHandler) {
        this.simpleDataHandler = simpleDataHandler;
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
}
