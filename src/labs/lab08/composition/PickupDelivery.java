package labs.lab08.composition;

public class PickupDelivery extends DeliveryMethod {
    private final String location;

    public PickupDelivery(String location) {
        // TODO 6:
        // Reject null or blank location with IllegalArgumentException.
        // Then assign the field.
        this.location = location;
    }

    @Override
    public String instructions() {
        // TODO 7:
        // Return exactly: Pick up at <location>
        return "";
    }
}
