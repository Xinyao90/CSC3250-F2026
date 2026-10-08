package labs.lab11;
public class DigitalProduct extends Product {
    private final String downloadFile;
    public DigitalProduct(String id, String name, double price, String downloadFile) {
        super(id, name, price);
        if (downloadFile == null || downloadFile.isBlank()) {
            throw new IllegalArgumentException("Download file required");
        }
        this.downloadFile = downloadFile;
    }
    public String getDownloadFile() { return downloadFile; }
    @Override public String deliveryInstructions() { return "Download " + downloadFile; }
    @Override public String description() { return super.description() + " [digital]"; }
}
