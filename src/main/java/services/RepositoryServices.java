package services;

import entity.WeatherEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

public class RepositoryServices {

    //----------------------------------CREATE----------------------------------------
    public static void create(WeatherEntity weather) {
        final EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        final EntityManager manager = factory.createEntityManager();
        if (weather == null) {
            System.out.println("Weather not available to persist, line 16, RepositoryServices.");
            return;
        }
        if (isPersisted(weather.getCity())) {
            try {
                manager.getTransaction().begin();
                manager.persist(weather);
                manager.getTransaction().commit();
                System.out.println(weather + " persisted");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            manager.close();
            factory.close();
            }
        } else {
            System.out.println("Weather for " + weather.getCity() + " already persisted.");
        }
    }

    //----------------------------------READ----------------------------------------
    public static WeatherEntity read(String city) {
        if (city == null) city = "";
        WeatherEntity fromDb = null;
        try {
            fromDb = findByCity(city);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return fromDb;
    }

    //----------------------------------UPDATE----------------------------------------
    public static WeatherEntity update(WeatherEntity weather) {
        final EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        final EntityManager manager = factory.createEntityManager();

        if (weather == null) System.out.println("Weather does not exist, cannot update!");
        WeatherEntity updated = new WeatherEntity();

        try {
            manager.getTransaction().begin();
            updated = manager.merge(weather);
            manager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            manager.close();
            factory.close();
        }
        return updated;
    }


    //----------------------------------DELETE----------------------------------------
    public static boolean delete(String city) {
        if (city == null) city = "";
        WeatherEntity weather = findByCity(city);
        final EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        final EntityManager manager = factory.createEntityManager();
        if (weather == null || weather.getId() == null || isPersisted(city)) {
            System.out.println("Weather does not exist, cannot delete!, line 55, RepositoryServices.");
            return false;
        }
        try {
            manager.getTransaction().begin();
            manager.remove(manager.merge(weather));
            manager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            manager.close();
            factory.close();
        }
        return true;
    }

    //----------------------------------HELPERS----------------------------------------
    public static boolean isPersisted(String city) {
        final EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        final EntityManager manager = factory.createEntityManager();
        List<WeatherEntity> entityFromDB = new ArrayList<>();

        if (city != null) {
            try {
                TypedQuery<WeatherEntity> query = manager.createQuery(
                        "select w from WeatherEntity w " +
                                "where lower(w.city) like lower(:city)",
                        WeatherEntity.class);

                query.setParameter("city", "%" + city + "%");
                entityFromDB = query.getResultList();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                manager.close();
                factory.close();
            }
        }
        return entityFromDB.size() == 0;
    }

    private static WeatherEntity findByCity(String city) {
        final EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        final EntityManager manager = factory.createEntityManager();
        List<WeatherEntity> entityFromDB = new ArrayList<>();

        if (city != null) {
            TypedQuery<WeatherEntity> query = manager.createQuery(
                    "select w from WeatherEntity w " +
                            "where lower(w.city) like lower(:city)",
                    WeatherEntity.class);

            query.setParameter("city", "%" + city + "%");
            entityFromDB = query.getResultList();
        }
        manager.close();
        factory.close();
        if (entityFromDB.isEmpty()) return null;
        else return entityFromDB.get(0);
    }

    public static List<WeatherEntity> findByCountry(String country) {
        final EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        final EntityManager manager = factory.createEntityManager();
        List<WeatherEntity> cities = new ArrayList<>();

        if (country != null) {
            TypedQuery<WeatherEntity> query = manager.createQuery(
                    "select w from WeatherEntity w " +
                            "where lower(w.country) like lower(:country)",
                    WeatherEntity.class);

            query.setParameter("country", "%" + country + "%");
            cities = query.getResultList();
        }
        manager.close();
        factory.close();
        if (cities.isEmpty()) return new ArrayList<>();
        else return cities;
    }


}
