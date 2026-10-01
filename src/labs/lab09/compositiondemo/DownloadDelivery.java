package labs.lab09.compositiondemo;
public class DownloadDelivery extends DeliveryMethod {
    private final String downloadFile;
    public DownloadDelivery(String downloadFile) {
        if (downloadFile == null || downloadFile.isBlank()) throw new IllegalArgumentException("File required");
        this.downloadFile = downloadFile;
    }
    @Override public String instructions() { return "Download " + downloadFile; }
}
