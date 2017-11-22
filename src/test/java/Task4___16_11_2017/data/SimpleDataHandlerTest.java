package Task4___16_11_2017.data;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleDataHandlerTest {
    @Test
    public void updateTest() throws Exception {
        SimpleDataHandler handler = new SimpleDataHandler();
        handler.update();
        assertNotNull(handler.getCurrentWeatherDAO().getWeatherDescription());
        System.out.println(handler.getCurrentWeatherDAO().getWeatherDescription());
    }

}