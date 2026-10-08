package labs.lab11;
public class WorkshopProduct extends Product {
    private final String room;
    public WorkshopProduct(String id, String name, double price, String room) {
        super(id, name, price);
        if (room == null || room.isBlank()) { throw new IllegalArgumentException("Room required"); }
        this.room = room;
    }
    public String getRoom() { return room; }
    @Override public String deliveryInstructions() { return "Attend in " + room; }
    @Override public String description() { return super.description() + " [workshop]"; }
}
