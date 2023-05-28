package http;

import api.WeatherApi;
import com.google.gson.Gson;
import entity.WeatherEntity;
import services.WeatherConverter;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class GetCurrentWeather {

    //http://api.weatherapi.com/v1/current.json?key=safarpaulina@gmail.com&q=London&aqi=no

    private final String city;

    public GetCurrentWeather(String city) {
        this.city = city;
    }

    private String getRequestCall() {
        String WEATHER_API_URL = "http://api.weatherapi.com/v1/current.json?key=";
        String apiKey = "729a2a592df14a1a819105526232404";
        return WEATHER_API_URL + apiKey + "&q=" + city + "&aqi=no";
    }

    private HttpRequest createRequest() {
        final String requestCall = getRequestCall();

        return HttpRequest.newBuilder()
                .uri(URI.create(requestCall))
                .build();
    }

    private HttpResponse getResponse() {
        HttpResponse<String> response = null;
        HttpClient client = HttpClient.newHttpClient();
        final HttpRequest request = createRequest();

        try {
            response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return response;
    }

    private WeatherApi convertToWeatherApi() {
        final String json = getResponse().body().toString();

        WeatherApi weather;
        Gson gson = new Gson();

        try {
            weather = gson.fromJson(json, WeatherApi.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return weather;
    }

    public WeatherEntity getWeather() {
        WeatherConverter converter = new WeatherConverter();
        final WeatherApi api = convertToWeatherApi();
        if (api == null) return new WeatherEntity();
        return converter.createWeather(api);
    }



}
