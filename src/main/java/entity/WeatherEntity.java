package entity;

import jakarta.persistence.*;

@Table(name = "weather_entity")
@Entity
public class WeatherEntity {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;
    //Location
    @Column(nullable = false)
    private String city;
    @Column
    private String region;
    @Column
    private String country;
    @Column
    private Double lat;
    @Column
    private Double lon;
    @Column
    private Long epoch;
    @Column
    private String localtime;
    //Current
    @Column
    private Double temp_c;
    @Column
    private String c_text;
    @Column
    private String c_icon;
    @Column
    private Double wind_kph;
    @Column
    private Double pressure_mb;
    @Column
    private Double precip_mm;
    @Column
    private Double humidity;
    @Column
    private Double cloud;
    @Column
    private Double feelslike_c;
    @Column
    private Double uv;

    public WeatherEntity() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Long getEpoch() {
        return epoch;
    }

    public void setEpoch(Long epoch) {
        this.epoch = epoch;
    }

    public String getLocaltime() {
        return localtime;
    }

    public void setLocaltime(String localtime) {
        this.localtime = localtime;
    }

    public Double getTemp_c() {
        return temp_c;
    }

    public void setTemp_c(Double temp_c) {
        this.temp_c = temp_c;
    }

    public String getC_text() {
        return c_text;
    }

    public void setC_text(String c_text) {
        this.c_text = c_text;
    }

    public String getC_icon() {
        return c_icon;
    }

    public void setC_icon(String c_icon) {
        this.c_icon = c_icon;
    }

    public Double getWind_kph() {
        return wind_kph;
    }

    public void setWind_kph(Double wind_kph) {
        this.wind_kph = wind_kph;
    }

    public Double getPressure_mb() {
        return pressure_mb;
    }

    public void setPressure_mb(Double pressure_mb) {
        this.pressure_mb = pressure_mb;
    }

    public Double getPrecip_mm() {
        return precip_mm;
    }

    public void setPrecip_mm(Double precip_mm) {
        this.precip_mm = precip_mm;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getCloud() {
        return cloud;
    }

    public void setCloud(Double cloud) {
        this.cloud = cloud;
    }

    public Double getFeelslike_c() {
        return feelslike_c;
    }

    public void setFeelslike_c(Double feelslike_c) {
        this.feelslike_c = feelslike_c;
    }

    public Double getUv() {
        return uv;
    }

    public void setUv(Double uv) {
        this.uv = uv;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "WeatherEntity: " +
                "id=" + id +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", temp_c=" + temp_c;
    }


}