package api;

public class WeatherApi {

    private WeatherLocation   location;
    private WeatherCurrent current;

    public WeatherLocation getLocation() {
        return location;
    }

    public WeatherCurrent getCurrent() {
        return current;
    }

    @Override
    public String toString() {
        return "WEATHER: " +
//                "weather=" + weather +
                "\nLOCATION = \n" + location +
                ", \nCURRENT= \n" + current;
    }
}
