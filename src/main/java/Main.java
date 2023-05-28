import services.ExecuteServices;

public class Main {

    public static void main(String[] args) {

        //final WeatherEntity paris = ExecuteServices.findPersistedEntity("Paris");
        //ExecuteServices.deletePersistedEntity("London");
        ExecuteServices.fetchAndPersistNew("Barcelona");

    }
}
