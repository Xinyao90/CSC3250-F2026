// CSC-3250 classroom adaptation of the SimUDuck / Weather-O-Rama examples.
// Conceptual source: Freeman & Robson, Head First Design Patterns, 2nd ed.
// Original classroom scaffolding and visible checks; no external libraries required.
public class StatisticsDisplay implements Observer, DisplayElement {
    private final WeatherData weatherData;
    private int count;
    private float sum, minimum, maximum;
    public StatisticsDisplay(WeatherData source) {
        weatherData = source;
        source.registerObserver(this);
    }
    @Override public void update() {
        // TODO: complete this observer update
        throw new UnsupportedOperationException("TODO: complete this observer update");
    }
    @Override public void display() {
        if (count == 0) {
            System.out.println("Statistics: no readings");
        } else {
            System.out.printf(java.util.Locale.US, "Statistics: avg %.1f, max %.1f, min %.1f%n", getAverage(), maximum, minimum);
        }
    }
    public int getCount() { return count; }
    public float getAverage() {
        if (count == 0) throw new IllegalStateException("No readings yet");
        return sum / count;
    }
    public float getMinimum() {
        if (count == 0) throw new IllegalStateException("No readings yet");
        return minimum;
    }
    public float getMaximum() {
        if (count == 0) throw new IllegalStateException("No readings yet");
        return maximum;
    }
}
