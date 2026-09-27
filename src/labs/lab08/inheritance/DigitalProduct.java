package labs.lab08.inheritance;

public class DigitalProduct extends Product {
    private final String downloadFile;

    public DigitalProduct(String id, String name, double price, String downloadFile) {
        super(id, name, price);

        if (downloadFile == null || downloadFile.isBlank()) {
            throw new IllegalArgumentException("Download file cannot be blank.");
        }

        this.downloadFile = downloadFile;
    }

    @Override
    public String deliveryInstructions() {
        return "Download " + downloadFile;
    }
}
