package labs.lab09;
/** Complete only the TODOs. Product already owns common state and validation. */
public class WorkshopProduct extends Product {
    private final String room;
    public WorkshopProduct(String id, String name, double price, String room) {
        super(id, name, price);
        // TODO 1: Reject null or blank room with IllegalArgumentException.
        // Hint: follow DigitalProduct's validation pattern.
        this.room = room;
    }
    public String getRoom() { return room; }
    @Override public String deliveryInstructions() {
        // TODO 2: Return "Attend in " followed by this workshop's room.
        return "";
    }
    @Override public String description() {
        // TODO 3: Reuse super.description(); append " [workshop]".
        return super.description();
    }
}
