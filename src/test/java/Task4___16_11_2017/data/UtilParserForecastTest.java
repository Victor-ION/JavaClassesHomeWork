package Task4___16_11_2017.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Test;

import java.io.FileReader;
import java.util.Date;

import static org.junit.Assert.*;

public class UtilParserForecastTest {

    @Test
    public void getCorrectDayWeatherForecast() throws Exception{
//        System.out.println(new Date(1511373600l * 1000));
//        System.out.println(new Date(1511384400l * 1000));
//        System.out.println(new Date(1511395200l * 1000));
        JsonParser parser = new JsonParser();
        JsonObject mainObj = parser.parse(new FileReader("src/main/java/Task4___16_11_2017/data/exampleJsons/forecastWeather.json")).getAsJsonObject();
        JsonArray list = mainObj.get("list").getAsJsonArray();
        for (JsonElement e : list){
            JsonObject elem = e.getAsJsonObject();
            long datetime = elem.get("dt").getAsLong();
//            System.out.println(new Date(datetime * 1000));
        }
//        System.out.println(list.size());
        assertEquals(40, list.size());
//        System.out.println(list);
    }

}