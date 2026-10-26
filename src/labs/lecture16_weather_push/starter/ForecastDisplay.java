// CSC-3250 classroom adaptation of the SimUDuck / Weather-O-Rama examples.
// Conceptual source: Freeman & Robson, Head First Design Patterns, 2nd ed.
// Original classroom scaffolding and visible checks; no external libraries required.
public class ForecastDisplay implements Observer, DisplayElement {
    private final WeatherData weatherData;
    private float currentPressure = 29.92f;
    private float lastPressure = 29.92f;
    private int updates;
    public ForecastDisplay(WeatherData source) {
        weatherData = source;
        source.registerObserver(this);
    }
    @Override public void update(float t, float h, float p) {
        // TODO: complete this observer update
        throw new UnsupportedOperationException("TODO: complete this observer update");
    }
    public String getTrend() {
        if (currentPressure > lastPressure) return "Improving";
        if (currentPressure < lastPressure) return "Worsening";
        return "Unchanged";
    }
    @Override public void display() { System.out.println("Forecast: " + getTrend()); }
    public int getUpdates() { return updates; }
}
