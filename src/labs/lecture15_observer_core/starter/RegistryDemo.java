// CSC-3250 classroom adaptation of the SimUDuck / Weather-O-Rama examples.
// Conceptual source: Freeman & Robson, Head First Design Patterns, 2nd ed.
// Original classroom scaffolding and visible checks; no external libraries required.
public class RegistryDemo {
    public static void main(String[] args) {
        WeatherData weather = new WeatherData();
        RecordingObserver first = new RecordingObserver();
        RecordingObserver second = new RecordingObserver();
        weather.registerObserver(first);
        weather.setMeasurements(80, 65, 30.4f);
        weather.registerObserver(second);
        weather.setMeasurements(82, 70, 29.2f);
        weather.removeObserver(first);
        weather.setMeasurements(78, 90, 29.2f);
        System.out.println("first: count " + first.getUpdates() + ", last temperature " + first.getTemperature());
        System.out.println("second: count " + second.getUpdates() + ", last temperature " + second.getTemperature());
    }
}
