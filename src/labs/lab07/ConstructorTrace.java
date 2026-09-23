package labs.lab07;

public class ConstructorTrace {

    public static void main(String[] args) {

        System.out.println(
                "Creating a PhysicalProduct...");

        PhysicalProduct product =
                new PhysicalProduct(
                        "P1",
                        "Keyboard",
                        40.0,
                        2.5);

        System.out.println(
                "Object creation finished.");
    }
}
