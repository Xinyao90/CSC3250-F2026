package homework.hw02;

/** A complete example subtype: a regular product has no discount. Do not edit. */
public class RegularProduct extends Product {
    public RegularProduct(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double getPurchasePrice() {
        return getPrice();
    }
}
