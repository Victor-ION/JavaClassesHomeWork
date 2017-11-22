package Task4___16_11_2017.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class UtilParserWeather {
    private JsonObject mainObject;

    public UtilParserWeather(String currentWeatherDataFromLoader) {
        parse(currentWeatherDataFromLoader);
    }

    private void parse(String currentWeatherDataFromLoader) {
        JsonParser parser = new JsonParser();
        mainObject = parser.parse(currentWeatherDataFromLoader).getAsJsonObject();
    }


    public float getTemperature() {
        JsonObject main = mainObject.getAsJsonObject("main");
        float temperature = main.get("temp").getAsFloat();
        return temperature;
    }

    public float getHumidity() {
        JsonObject main = mainObject.getAsJsonObject("main");
        float humidity = main.get("humidity").getAsInt();
        return humidity;
    }

    public String getWeatherDescription() {
        JsonArray weather = mainObject.getAsJsonArray("weather");
        JsonObject obj = weather.get(0).getAsJsonObject();
        return obj.get("description").getAsString();
    }
}
