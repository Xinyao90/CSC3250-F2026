package factory.lecture19;

public final class ChicagoStyleCheesePizza extends Pizza {
    public ChicagoStyleCheesePizza() {
        super("Chicago Style Cheese Pizza");
    }

    @Override
    public void cut() {
        // TODO 19B: record exactly one step: "cut: square slices".
        // This replaces the inherited cut implementation.
        throw new UnsupportedOperationException("TODO 19B: cut square slices");
    }
}
