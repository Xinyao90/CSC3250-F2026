// CSC-3250 classroom adaptation of the SimUDuck / Weather-O-Rama examples.
// Conceptual source: Freeman & Robson, Head First Design Patterns, 2nd ed.
// Original classroom scaffolding and visible checks; no external libraries required.
public class RecordingObserver implements Observer {
    private int updates;
    private float temperature, humidity, pressure;
    public void update(float t, float h, float p) {
        updates++;
        temperature = t; humidity = h; pressure = p;
    }
    public int getUpdates() { return updates; }
    public float getTemperature() { return temperature; }
    public float getHumidity() { return humidity; }
    public float getPressure() { return pressure; }
}
