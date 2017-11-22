package Task4___16_11_2017.data.dao;

import Task4___16_11_2017.data.SimpleDataHandler;

public class StatisticsWeatherDao extends CurrentWeatherDAO{
    private Float minTemperature;
    private Float maxTemperature;

    public StatisticsWeatherDao(SimpleDataHandler simpleDataHandler) {
        super(simpleDataHandler);
    }

    @Override
    public void update() {
        super.update();
        if (minTemperature == null) minTemperature = getTemperature();
        if (maxTemperature == null) maxTemperature = getTemperature();
        if (getTemperature()>maxTemperature) maxTemperature = getTemperature();
        else if (getTemperature()<minTemperature) minTemperature = getTemperature();
    }

    public float getMinTemperature() {
        return minTemperature;
    }

    public float getMaxTemperature() {
        return maxTemperature;
    }
}
