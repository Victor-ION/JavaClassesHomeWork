package Task4___16_11_2017.data;

import Task4___16_11_2017.data.dao.SimpleCurrentWeatherDAO;

public class SimpleDataHandler implements DataHandler{
    private DataLoader dataLoader;
    private SimpleCurrentWeatherDAO currentWeatherDAO;

    public SimpleDataHandler() {
        dataLoader = new DataLoader();
        currentWeatherDAO = new SimpleCurrentWeatherDAO(this);
    }

    @Override
    public void update() {
        dataLoader.update();
        currentWeatherDAO.update();
    }

    public SimpleCurrentWeatherDAO getCurrentWeatherDAO() {
        return currentWeatherDAO;
    }

    public DataLoader getDataLoader() {
        return dataLoader;
    }
}
