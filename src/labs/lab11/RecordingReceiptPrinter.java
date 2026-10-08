package labs.lab11;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
/** Destination: an in-memory record, useful for tests and demonstrations. */
public class RecordingReceiptPrinter implements ReceiptPrinter {
    private final List<String> receipts = new ArrayList<>();
    @Override public void print(String receipt) {
        // TODO 4: reject null, then append the exact receipt once. Do not print it.
        throw new UnsupportedOperationException("TODO: record receipt");
    }
    /** Unmodifiable live view; observation is not required by ReceiptPrinter. */
    public List<String> getReceipts() { return Collections.unmodifiableList(receipts); }
}
