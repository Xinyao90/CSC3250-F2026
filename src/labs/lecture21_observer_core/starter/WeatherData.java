// CSC-3250 classroom adaptation of the SimUDuck / Weather-O-Rama examples.
// Conceptual source: Freeman & Robson, Head First Design Patterns, 2nd ed.
// Original classroom scaffolding and visible checks; no external libraries required.
import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {
    private final List<Observer> observers;
    private float temperature, humidity, pressure;
    public WeatherData() { observers = new ArrayList<>(); }
    public void registerObserver(Observer observer) { // TODO: register the observer reference
        throw new UnsupportedOperationException("TODO: register the observer reference"); }
    public void removeObserver(Observer observer) { // TODO: remove the observer reference
        throw new UnsupportedOperationException("TODO: remove the observer reference"); }
    public void notifyObservers() {
        // TODO: notify every registered observer with the current sample
        throw new UnsupportedOperationException("TODO: notify every registered observer with the current sample");
    }
    public void setMeasurements(float t, float h, float p) {
        temperature = t;
        humidity = h;
        pressure = p;
        measurementsChanged();
    }
    public void measurementsChanged() { notifyObservers(); }
    public float getTemperature() { return temperature; }
    public float getHumidity() { return humidity; }
    public float getPressure() { return pressure; }
}
