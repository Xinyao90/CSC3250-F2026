// CSC-3250 classroom adaptation of the SimUDuck / Weather-O-Rama examples.
// Conceptual source: Freeman & Robson, Head First Design Patterns, 2nd ed.
// Original classroom scaffolding and visible checks; no external libraries required.
public class WeatherChecks {
    public static void main(String[] args) {
        WeatherData weather = new WeatherData();
        CurrentConditionsDisplay current = new CurrentConditionsDisplay(weather);
        StatisticsDisplay stats = new StatisticsDisplay(weather);
        ForecastDisplay forecast = new ForecastDisplay(weather);
        CheckSupport.check(current.getUpdates() == 0 && stats.getCount() == 0, "constructors register without replay");
        weather.setMeasurements(80, 65, 30.4f);
        CheckSupport.check(CheckSupport.close(current.getTemperature(), 80) && CheckSupport.close(current.getHumidity(), 65), "current display receives complete new sample");
        CheckSupport.check(stats.getCount() == 1 && CheckSupport.close(stats.getMinimum(), 80) && CheckSupport.close(stats.getMaximum(), 80), "first statistics sample initializes bounds");
        CheckSupport.check(forecast.getTrend().equals("Improving"), "first forecast compares with the configured baseline");
        weather.setMeasurements(82, 70, 29.2f);
        CheckSupport.check(CheckSupport.close(stats.getAverage(), 81), "two-reading average is correct");
        CheckSupport.check(forecast.getTrend().equals("Worsening"), "falling pressure preserves the previous reading");
        weather.setMeasurements(78, 90, 29.2f);
        CheckSupport.check(stats.getCount() == 3 && CheckSupport.close(stats.getAverage(), 80) && CheckSupport.close(stats.getMaximum(), 82) && CheckSupport.close(stats.getMinimum(), 78), "three-reading statistics are correct");
        CheckSupport.check(forecast.getTrend().equals("Unchanged"), "equal pressure produces unchanged trend");
        weather.removeObserver(forecast);
        weather.setMeasurements(62, 90, 28.1f);
        CheckSupport.check(forecast.getUpdates() == 3 && current.getUpdates() == 4 && stats.getCount() == 4, "removal stops only the selected observer");
        weather.registerObserver(forecast);
        CheckSupport.check(forecast.getUpdates() == 3, "resubscription does not immediately replay");
        weather.setMeasurements(60, 40, 27.5f);
        CheckSupport.check(forecast.getUpdates() == 4 && forecast.getTrend().equals("Worsening"), "resubscription resumes future delivery with retained local state");
        WeatherData coldSource = new WeatherData();
        StatisticsDisplay coldStats = new StatisticsDisplay(coldSource);
        coldSource.setMeasurements(-10, 50, 30);
        coldSource.setMeasurements(-20, 50, 30);
        CheckSupport.check(CheckSupport.close(coldStats.getMaximum(), -10) && CheckSupport.close(coldStats.getMinimum(), -20) && CheckSupport.close(coldStats.getAverage(), -15), "statistics work for negative temperatures");
        CheckSupport.finish();
    }
}
