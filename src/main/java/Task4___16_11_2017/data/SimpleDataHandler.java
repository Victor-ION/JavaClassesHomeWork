package Task4___16_11_2017.data;

import Task4___16_11_2017.data.dao.ForecastWeatherDAO;
import Task4___16_11_2017.data.dao.CurrentWeatherDAO;

public class SimpleDataHandler implements DataHandler{
    private DataLoader dataLoader;
    private CurrentWeatherDAO currentWeatherDAO;
    private ForecastWeatherDAO forecastWeatherDAO;

    public SimpleDataHandler() {
        dataLoader = new DataLoader();
        currentWeatherDAO = new CurrentWeatherDAO(this);
        forecastWeatherDAO = new ForecastWeatherDAO(this);
    }

    @Override
    public void update() {
        dataLoader.update();
        currentWeatherDAO.update();
        forecastWeatherDAO.update();
    }

    public CurrentWeatherDAO getCurrentWeatherDAO() {
        return currentWeatherDAO;
    }

    public ForecastWeatherDAO getForecastWeatherDAO() {
        return forecastWeatherDAO;
    }

    public DataLoader getDataLoader() {
        return dataLoader;
    }
}
