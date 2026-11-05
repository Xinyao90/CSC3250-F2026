// CSC-3250 classroom adaptation of the SimUDuck / Weather-O-Rama examples.
// Conceptual source: Freeman & Robson, Head First Design Patterns, 2nd ed.
// Original classroom scaffolding and visible checks; no external libraries required.
public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
