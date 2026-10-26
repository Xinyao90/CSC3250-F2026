// CSC-3250 classroom adaptation of the SimUDuck / Weather-O-Rama examples.
// Conceptual source: Freeman & Robson, Head First Design Patterns, 2nd ed.
// Original classroom scaffolding and visible checks; no external libraries required.
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weather = new WeatherData();
        new CurrentConditionsDisplay(weather);
        new StatisticsDisplay(weather);
        ForecastDisplay forecast = new ForecastDisplay(weather);
        weather.setMeasurements(80, 65, 30.4f);
        weather.setMeasurements(82, 70, 29.2f);
        weather.setMeasurements(78, 90, 29.2f);
        System.out.println("-- Forecast unsubscribed --");
        weather.removeObserver(forecast);
        weather.setMeasurements(62, 90, 28.1f);
    }
}
