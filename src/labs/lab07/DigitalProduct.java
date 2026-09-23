package labs.lab07;

public class DigitalProduct extends Product {

    private final String downloadFile;

    public DigitalProduct(
            String id,
            String name,
            double price,
            String downloadFile) {

        /*
         * TODO 1:
         * Pass id, name, and price to Product.
         *
         * Replace these placeholder values.
         */
        super("TODO-ID", "TODO-NAME", 0.0);

        /*
         * TODO 2:
         * Validate downloadFile.
         *
         * It must not be:
         *   - null
         *   - blank
         *
         * If invalid, throw IllegalArgumentException.
         */

        this.downloadFile = downloadFile;
    }

    public String getDownloadFile() {
        return downloadFile;
    }

    @Override
    public String deliveryInstructions() {

        /*
         * TODO 3:
         *
         * Return:
         *
         * "Download " + downloadFile
         *
         * Example:
         * Download guide.pdf
         */

        return "TODO";
    }

    @Override
    public String description() {

        /*
         * TODO 4:
         *
         * Reuse the superclass implementation.
         *
         * Expected example:
         *
         * D200: Java Guide [digital]
         */

        return super.description();
    }
}
