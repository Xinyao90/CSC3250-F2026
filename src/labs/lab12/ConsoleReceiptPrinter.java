package labs.lab12;
import java.util.Objects;
/** Destination: the Java console. */
public class ConsoleReceiptPrinter implements ReceiptPrinter {
    @Override public void print(String receipt) {
        System.out.println(Objects.requireNonNull(receipt, "receipt"));
    }
}
