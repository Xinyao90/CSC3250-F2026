package support;

/** Small visible checking utility. No JUnit setup or test-writing is required. */
public class VisibleChecks {
    private final String suite;
    private int passed;
    private int total;

    public VisibleChecks(String suite) {
        this.suite = suite;
    }

    public void expectDouble(String label, double actual, double expected) {
        record(label, Math.abs(actual - expected) <= 1e-9,
                "expected " + expected + ", received " + actual);
    }

    public void expectInt(String label, int actual, int expected) {
        record(label, actual == expected,
                "expected " + expected + ", received " + actual);
    }

    public void expectText(String label, String actual, String expected) {
        record(label, expected.equals(actual),
                "expected [" + expected + "], received [" + actual + "]");
    }

    public void expectTrue(String label, boolean condition) {
        record(label, condition, "required condition was false");
    }

    private void record(String label, boolean success, String detail) {
        total++;
        if (success) {
            passed++;
            System.out.println("PASS  " + label);
        } else {
            System.out.println("FAIL  " + label + " -- " + detail);
        }
    }

    public void finish() {
        System.out.println(suite + ": " + passed + "/" + total + " checks passed.");
        if (passed != total) {
            System.exit(1);
        }
    }
}
