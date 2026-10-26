// CSC-3250 classroom adaptation of the SimUDuck / Weather-O-Rama examples.
// Conceptual source: Freeman & Robson, Head First Design Patterns, 2nd ed.
// Original classroom scaffolding and visible checks; no external libraries required.
public class RegistryChecks {
    public static void main(String[] args) {
        WeatherData weather = new WeatherData();
        weather.setMeasurements(5, 10, 30);
        CheckSupport.check(CheckSupport.close(weather.getTemperature(), 5), "empty registry accepts state updates");
        RecordingObserver a = new RecordingObserver();
        RecordingObserver b = new RecordingObserver();
        weather.registerObserver(a);
        CheckSupport.check(a.getUpdates() == 0, "registration does not replay or notify");
        weather.setMeasurements(80, 65, 30.4f);
        CheckSupport.check(a.getUpdates() == 1 && CheckSupport.close(a.getTemperature(), 80), "registered observer receives current state");
        CheckSupport.check(CheckSupport.close(a.getHumidity(), 65) && CheckSupport.close(a.getPressure(), 30.4f), "all sample fields are stored before delivery");
        weather.registerObserver(b);
        CheckSupport.check(b.getUpdates() == 0, "late observer has no automatic historical samples");
        weather.setMeasurements(82, 70, 29.2f);
        CheckSupport.check(a.getUpdates() == 2 && b.getUpdates() == 1, "each registered observer receives one callback");
        weather.removeObserver(a);
        weather.setMeasurements(78, 90, 29.2f);
        CheckSupport.check(a.getUpdates() == 2 && CheckSupport.close(a.getTemperature(), 82), "removal preserves old local state and stops delivery");
        CheckSupport.check(b.getUpdates() == 2 && CheckSupport.close(b.getTemperature(), 78), "other observers continue receiving updates");
        weather.removeObserver(a);
        CheckSupport.check(a.getUpdates() == 2, "removing an absent observer does not notify it");
        weather.registerObserver(a);
        weather.setMeasurements(60, 40, 30);
        CheckSupport.check(a.getUpdates() == 3 && b.getUpdates() == 3, "same object can resubscribe for future samples");
        CheckSupport.finish();
    }
}
