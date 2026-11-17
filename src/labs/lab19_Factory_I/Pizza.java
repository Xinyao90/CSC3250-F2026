package factory.lecture19;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Product abstraction. Its steps make the workflow visible to students. */
public abstract class Pizza {
    private final String name;
    private final List<String> steps = new ArrayList<>();

    protected Pizza(String name) {
        this.name = name;
    }

    public final String getName() {
        return name;
    }

    public void prepare() {
        recordStep("prepare");
    }

    public void bake() {
        recordStep("bake");
    }

    public void cut() {
        recordStep("cut: diagonal slices");
    }

    public void box() {
        recordStep("box");
    }

    protected final void recordStep(String step) {
        steps.add(step);
    }

    /** A read-only snapshot of this pizza's observed lifecycle. */
    public final List<String> getSteps() {
        return Collections.unmodifiableList(new ArrayList<>(steps));
    }
}
