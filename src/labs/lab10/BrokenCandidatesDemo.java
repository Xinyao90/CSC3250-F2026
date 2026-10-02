package labs.lab10;
import labs.lab10.candidates.CandidateDigitalProduct;
import labs.lab10.candidates.CandidateWorkshopProduct;
/** Observes both candidates separately. Never patches the common service. */
public class BrokenCandidatesDemo {
    public static void main(String[] args) {
        CheckoutService service = new CheckoutService();
        Product guide = new CandidateDigitalProduct("D200", "Java Guide", 15.0, "guide.pdf");
        Product workshop = new CandidateWorkshopProduct("W300", "Java Workshop", 30.0, "Room A");
        System.out.println(service.deliveryLine(guide));
        try { System.out.println(service.deliveryLine(workshop)); }
        catch (IllegalStateException ex) {
            System.out.println("Observed: " + ex.getClass().getSimpleName() + ": " + ex.getMessage());
        }
    }
}
