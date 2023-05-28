package services;

import api.WeatherApi;
import entity.WeatherEntity;

public class WeatherConverter {

    public WeatherConverter() {
    }

    public WeatherEntity createWeather(WeatherApi api){
        WeatherEntity weather = new WeatherEntity();

        weather.setCity(api.getLocation().getName());
        weather.setRegion(api.getLocation().getRegion());
        weather.setCountry(api.getLocation().getCountry());
        weather.setLat(api.getLocation().getLat());
        weather.setLon(api.getLocation().getLon());
        weather.setEpoch(api.getLocation().getLocaltime_epoch());
        weather.setLocaltime(api.getLocation().getLocaltime());
        weather.setTemp_c(api.getCurrent().getTemp_c());
        weather.setC_text(api.getCurrent().getConditions().getText());
        weather.setC_icon(api.getCurrent().getConditions().getIcon());
        weather.setWind_kph(api.getCurrent().getWind_kph());
        weather.setPressure_mb(api.getCurrent().getPressure_mb());
        weather.setPrecip_mm(api.getCurrent().getPrecip_mm());
        weather.setHumidity(api.getCurrent().getHumidity());
        weather.setCloud(api.getCurrent().getCloud());
        weather.setFeelslike_c(api.getCurrent().getFeelslike_c());
        weather.setUv(api.getCurrent().getUv());

        return weather;
    }

}
