package services;

import entity.WeatherEntity;
import http.GetCurrentWeather;

import java.util.List;

public class ExecuteServices {

    public static WeatherEntity fetchAndPersistNew(String city) {
        GetCurrentWeather http = new GetCurrentWeather(city);
        final WeatherEntity weather = http.getWeather();
        RepositoryServices.create(weather);
        return weather;
    }

    public static WeatherEntity findPersistedEntity(String city) {
        final WeatherEntity read = RepositoryServices.read(city);
        if (read == null) {
            System.out.println("Weather for " + city + " not found.");
            return null;
        }
        System.out.println("Found: " + read);
        return read;
    }

    public static WeatherEntity updatePersistedEntity(WeatherEntity entity) {
        entity.setTemp_c(20.0);
        final WeatherEntity updated = RepositoryServices.update(entity);
        if (updated == null) {
            System.out.println("Weather for " + entity.getCity() + " not updated.");
            return null;
        }
        System.out.println(updated + " updated");
        return updated;
    }

    public static boolean deletePersistedEntity(String city) {
        final boolean isDeleted = RepositoryServices.delete(city);
        System.out.println("Weather for " + city + " is deleted: " + isDeleted);
        return true;
    }

    public static List<WeatherEntity> fetchByCountry(String country) {
        final List<WeatherEntity> cities = RepositoryServices.findByCountry(country);
        for (WeatherEntity e : cities) {
            System.out.println(e + ", ");
        }
        return cities;
    }




}
