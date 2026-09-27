package labs.lab08.composition;

public class DownloadDelivery extends DeliveryMethod {
    private final String downloadFile;

    public DownloadDelivery(String downloadFile) {
        // TODO 2:
        // Reject null or blank downloadFile with IllegalArgumentException.
        // Then assign the field.
        this.downloadFile = downloadFile;
    }

    @Override
    public String instructions() {
        // TODO 3:
        // Return exactly: Download <filename>
        // Example: Download guide.pdf
        return "";
    }
}
