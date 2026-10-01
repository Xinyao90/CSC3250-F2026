package labs.lab09.compositiondemo;
import java.util.List;
public class CompositionTransferDemo {
    public static void main(String[] args) {
        List<Product> products = List.of(
            new Product("P100", "Notebook", 20, new ShippingDelivery()),
            new Product("D200", "Java Guide", 15, new DownloadDelivery("guide.pdf")),
            new Product("W300", "Java Workshop", 30, new WorkshopAttendance("Room A")));
        for (Product p : products) System.out.println(p.getName() + " -> " + p.deliveryInstructions());
    }
}
