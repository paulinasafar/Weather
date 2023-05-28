package api;

public class WeatherCurrent {

    private Long last_updated_epoch;
    private String last_updated;
    private Double temp_c;
    private Double temp_f;
    private String is_day;
    private WeatherConditions condition;
    private Double wind_mph;
    private Double wind_kph;
    private Integer wind_degree;
    private String wind_dir;
    private Double pressure_mb;
    private Double pressure_in;
    private Double precip_mm;
    private Double precip_in;
    private Double humidity;
    private Double cloud;
    private Double feelslike_c;
    private Double feelslike_f;
    private Double vis_km;
    private Double vis_miles;
    private Double uv;
    private Double gust_mph;
    private Double gust_kph;

    public WeatherCurrent() {
    }

    public WeatherCurrent(Long last_updated_epoch, String last_updated, Double temp_c, Double temp_f, String dayNo, WeatherConditions condition, Double wind_mph, Double wind_kph, Integer wind_degree, String wind_dir, Double pressure_mb, Double pressure_in, Double precip_mm, Double precip_in, Double humidity, Double cloud, Double feelslike_c, Double feelslike_f, Double vis_km, Double vis_miles, Double uv, Double gust_mph, Double gust_kph) {
        this.last_updated_epoch = last_updated_epoch;
        this.last_updated = last_updated;
        this.temp_c = temp_c;
        this.temp_f = temp_f;
        this.is_day = dayNo;
        this.condition = condition;
        this.wind_mph = wind_mph;
        this.wind_kph = wind_kph;
        this.wind_degree = wind_degree;
        this.wind_dir = wind_dir;
        this.pressure_mb = pressure_mb;
        this.pressure_in = pressure_in;
        this.precip_mm = precip_mm;
        this.precip_in = precip_in;
        this.humidity = humidity;
        this.cloud = cloud;
        this.feelslike_c = feelslike_c;
        this.feelslike_f = feelslike_f;
        this.vis_km = vis_km;
        this.vis_miles = vis_miles;
        this.uv = uv;
        this.gust_mph = gust_mph;
        this.gust_kph = gust_kph;
    }

    public Long getLast_updated_epoch() {
        return last_updated_epoch;
    }

    public void setLast_updated_epoch(Long last_updated_epoch) {
        this.last_updated_epoch = last_updated_epoch;
    }

    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }

    public Double getTemp_c() {
        return temp_c;
    }

    public void setTemp_c(Double temp_c) {
        this.temp_c = temp_c;
    }

    public Double getTemp_f() {
        return temp_f;
    }

    public void setTemp_f(Double temp_f) {
        this.temp_f = temp_f;
    }

    public String getIs_day() {
        return this.is_day;
    }

    public void setIs_day(String is_day) {
        this.is_day = is_day;
    }

    public WeatherConditions getConditions() {
        return condition;
    }

    public void setConditions(WeatherConditions condition) {
        this.condition = condition;
    }

    public Double getWind_mph() {
        return wind_mph;
    }

    public void setWind_mph(Double wind_mph) {
        this.wind_mph = wind_mph;
    }

    public Double getWind_kph() {
        return wind_kph;
    }

    public void setWind_kph(Double wind_kph) {
        this.wind_kph = wind_kph;
    }

    public Integer getWind_degree() {
        return wind_degree;
    }

    public void setWind_degree(Integer wind_degree) {
        this.wind_degree = wind_degree;
    }

    public String getWind_dir() {
        return wind_dir;
    }

    public void setWind_dir(String wind_dir) {
        this.wind_dir = wind_dir;
    }

    public Double getPressure_mb() {
        return pressure_mb;
    }

    public void setPressure_mb(Double pressure_mb) {
        this.pressure_mb = pressure_mb;
    }

    public Double getPressure_in() {
        return pressure_in;
    }

    public void setPressure_in(Double pressure_in) {
        this.pressure_in = pressure_in;
    }

    public Double getPrecip_mm() {
        return precip_mm;
    }

    public void setPrecip_mm(Double precip_mm) {
        this.precip_mm = precip_mm;
    }

    public Double getPrecip_in() {
        return precip_in;
    }

    public void setPrecip_in(Double precip_in) {
        this.precip_in = precip_in;
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

    public Double getFeelslike_f() {
        return feelslike_f;
    }

    public void setFeelslike_f(Double feelslike_f) {
        this.feelslike_f = feelslike_f;
    }

    public Double getVis_km() {
        return vis_km;
    }

    public void setVis_km(Double vis_km) {
        this.vis_km = vis_km;
    }

    public Double getVis_miles() {
        return vis_miles;
    }

    public void setVis_miles(Double vis_miles) {
        this.vis_miles = vis_miles;
    }

    public Double getUv() {
        return uv;
    }

    public void setUv(Double uv) {
        this.uv = uv;
    }

    public Double getGust_mph() {
        return gust_mph;
    }

    public void setGust_mph(Double gust_mph) {
        this.gust_mph = gust_mph;
    }

    public Double getGust_kph() {
        return gust_kph;
    }

    public void setGust_kph(Double gust_kph) {
        this.gust_kph = gust_kph;
    }

    @Override
    public String toString() {
        return "last_updated_epoch=" + last_updated_epoch +
                ", last_updated='" + last_updated + '\'' +
                ", temp_c=" + temp_c + " C" +
                ", temp_f=" + temp_f + " F" +
                ", day=" + this.is_day +
                ", condition: " + condition +
                ", wind_mph=" + wind_mph + " mph" +
                ", wind_kph=" + wind_kph + " km/h" +
                ", wind_degree=" + wind_degree +
                ", wind_dir='" + wind_dir + '\'' +
                ", pressure_mb=" + pressure_mb +
                ", pressure_in=" + pressure_in +
                ", precip_mm=" + precip_mm + " mm" +
                ", precip_in=" + precip_in + " in" +
                ", humidity=" + humidity + " %" +
                ", cloud=" + cloud + " %" +
                ", feelslike_c=" + feelslike_c + " C" +
                ", feelslike_f=" + feelslike_f + " F" +
                ", vis_km=" + vis_km + " km" +
                ", vis_miles=" + vis_miles + " m" +
                ", uv=" + uv +
                ", gust_mph=" + gust_mph + " mph" +
                ", gust_kph=" + gust_kph + " km/h";
    }
}



