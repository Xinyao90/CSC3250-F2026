package labs.lab10;
public class PhysicalProduct extends Product {
    public PhysicalProduct(String id, String name, double price) { super(id, name, price); }
    @Override public String deliveryInstructions() { return "Ship to address"; }
    @Override public String description() { return super.description() + " [physical]"; }
}
