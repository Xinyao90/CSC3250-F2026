package labs.lab08.inheritance;

public class PhysicalProduct extends Product {

    public PhysicalProduct(String id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public String deliveryInstructions() {
        return "Ship to address";
    }
}
