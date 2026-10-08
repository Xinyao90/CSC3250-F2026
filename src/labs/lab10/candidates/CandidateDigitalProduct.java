package labs.lab10.candidates;
import labs.lab10.Product;
/** Deliberately defective candidate; the original DigitalProduct is unchanged. */
public class CandidateDigitalProduct extends Product {
    private final String downloadFile;
    public CandidateDigitalProduct(String id, String name, double price, String downloadFile) {
        super(id, name, price);
        if (downloadFile == null || downloadFile.isBlank())
            throw new IllegalArgumentException("Download file required");
        this.downloadFile = downloadFile;
    }
    @Override public String deliveryInstructions() {
        // TODO 1: State the weakened promise, then repair this return value.
        return null;
//        return "Download " + downloadFile;
    }
}
