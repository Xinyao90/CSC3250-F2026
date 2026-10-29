// CSC-3250 classroom adaptation of the SimUDuck / Weather-O-Rama examples.
// Conceptual source: Freeman & Robson, Head First Design Patterns, 2nd ed.
// Original classroom scaffolding and visible checks; no external libraries required.
package labs.lab14_simuduck.starter;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public final class CheckSupport {
    private static int passed;
    private CheckSupport() { }
    public static void check(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
        passed++;
        System.out.println("PASS: " + message);
    }
    public static boolean close(float a, float b) {
        return Math.abs(a - b) < 0.0001f;
    }
    public static String capture(Runnable action) {
        PrintStream original = System.out;
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        PrintStream replacement = new PrintStream(bytes);
        try {
            System.setOut(replacement);
            action.run();
            replacement.flush();
            return bytes.toString().replace("\r\n", "\n").trim();
        } finally {
            System.setOut(original);
            replacement.close();
        }
    }
    public static void finish() {
        System.out.println("ALL " + passed + " CHECKS PASSED");
    }
}
