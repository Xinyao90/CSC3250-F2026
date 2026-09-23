package labs.lab07;

public class PhysicalProduct extends Product {

    public PhysicalProduct(String id, String name, double price) {

        /*
         * TODO 1:
         * Replace the placeholder arguments below.
         *
         * The Product superclass should receive the
         * id, name, and price passed to this constructor.
         *
         * Question:
         * Why do we need super(...) here?
         */
        super("TODO-ID", "TODO-NAME", 0.0);
    }

    @Override
    public String deliveryInstructions() {

        /*
         * TODO 2:
         * A physical product should return:
         *
         * "Ship to address"
         */

        return "TODO";
    }

    @Override
    public String description() {

        /*
         * TODO 3:
         *
         * Reuse Product's description() rather than
         * rebuilding the label yourself.
         *
         * The result should look like:
         *
         * P100: Notebook [physical]
         *
         * Hint:
         * super.description()
         */

        return super.description();
    }
}