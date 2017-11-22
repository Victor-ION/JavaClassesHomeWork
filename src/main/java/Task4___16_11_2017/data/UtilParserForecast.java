package Task4___16_11_2017.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class UtilParserForecast {
    private JsonObject mainElement;

    public UtilParserForecast(String forecastWeatherDataFromLoader) {
        JsonParser parser = new JsonParser();
        JsonObject mainObject = parser.parse(forecastWeatherDataFromLoader).getAsJsonObject();
        JsonArray list = mainObject.get("list").getAsJsonArray();
        mainElement = list.get(8).getAsJsonObject();

    }



    public float getTemperature() {
        JsonObject main = mainElement.getAsJsonObject("main");
        float temperature = main.get("temp").getAsFloat();
        return temperature;
    }

    public float getHumidity() {
        JsonObject main = mainElement.getAsJsonObject("main");
        float humidity = main.get("humidity").getAsInt();
        return humidity;
    }

    public String getWeatherDescription() {
        JsonArray weather = mainElement.getAsJsonArray("weather");
        JsonObject obj = weather.get(0).getAsJsonObject();
        return obj.get("description").getAsString();
    }
}
