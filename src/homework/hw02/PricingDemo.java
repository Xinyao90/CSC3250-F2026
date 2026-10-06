package homework.hw02;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/** Supplied demonstration. Run after completing the TODOs; do not edit. */
public class PricingDemo {
    public static void main(String[] args) {
        RegularProduct keyboard = new RegularProduct("P100", "Keyboard", 100.0);
        DiscountedProduct headphones =
                new DiscountedProduct("P200", "Headphones", 80.0, 0.25);
        ServiceFee giftWrapping = new ServiceFee("Gift wrapping", 5.0);

        List<Priceable> items = new ArrayList<>();
        items.add(keyboard);
        items.add(headphones);
        items.add(giftWrapping);

        PriceCalculator calculator = new PriceCalculator();
        System.out.printf(Locale.US, "Regular product purchase price: %.2f%n",
                keyboard.getPurchasePrice());
        System.out.printf(Locale.US, "Discounted product original price: %.2f%n",
                headphones.getPrice());
        System.out.printf(Locale.US, "Discount rate: %.0f%%%n",
                headphones.getDiscountRate() * 100.0);
        System.out.printf(Locale.US, "Discounted product purchase price: %.2f%n",
                headphones.getPurchasePrice());
        System.out.printf(Locale.US, "Service fee: %.2f%n", giftWrapping.getPurchasePrice());
        System.out.printf(Locale.US, "Mixed total: %.2f%n", calculator.total(items));
        System.out.printf(Locale.US, "Original price after calculation: %.2f%n",
                headphones.getPrice());
    }
}
