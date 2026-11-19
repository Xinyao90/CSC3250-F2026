package factory.lecture20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Product abstraction shared by the two regional stores. */
public abstract class Pizza {
    private final String name;
    private final List<String> steps = new ArrayList<>();
    protected Dough dough;
    protected Sauce sauce;
    protected Cheese cheese;

    protected Pizza(String name) {
        this.name = name;
    }

    public final String getName() { return name; }
    public final Dough getDough() { return dough; }
    public final Sauce getSauce() { return sauce; }
    public final Cheese getCheese() { return cheese; }

    public abstract void prepare();

    public void bake() { recordStep("bake"); }
    public void cut() { recordStep("cut: diagonal slices"); }
    public void box() { recordStep("box"); }

    protected final void recordStep(String step) { steps.add(step); }

    public final List<String> getSteps() {
        return Collections.unmodifiableList(new ArrayList<>(steps));
    }
}
