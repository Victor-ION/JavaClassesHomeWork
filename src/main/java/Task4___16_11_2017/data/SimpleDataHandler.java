package Task4___16_11_2017.data;

import Task4___16_11_2017.data.dao.ForecastWeatherDAO;
import Task4___16_11_2017.data.dao.CurrentWeatherDAO;
import Task4___16_11_2017.data.dao.StatisticsWeatherDao;

public class SimpleDataHandler implements DataHandler{
    private DataLoader dataLoader;
    private CurrentWeatherDAO currentWeatherDAO;
    private ForecastWeatherDAO forecastWeatherDAO;
    private StatisticsWeatherDao stetisticsWeatherDAO;

    public SimpleDataHandler() {
        dataLoader = new DataLoader();
        currentWeatherDAO = new CurrentWeatherDAO(this);
        forecastWeatherDAO = new ForecastWeatherDAO(this);
        stetisticsWeatherDAO = new StatisticsWeatherDao(this);

    }

    @Override
    public void update() {
        dataLoader.update();
        currentWeatherDAO.update();
        forecastWeatherDAO.update();
        stetisticsWeatherDAO.update();
    }

    public CurrentWeatherDAO getCurrentWeatherDAO() {
        return currentWeatherDAO;
    }

    public ForecastWeatherDAO getForecastWeatherDAO() {
        return forecastWeatherDAO;
    }

    public StatisticsWeatherDao getStetisticsWeatherDAO() {
        return stetisticsWeatherDAO;
    }

    public DataLoader getDataLoader() {
        return dataLoader;
    }

    public void setDataLoader(DataLoader dataLoader) {
        this.dataLoader = dataLoader;
    }
}
