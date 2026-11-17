# CSC3250 Lecture 19: Factory Method lab

## Goal and time

Complete a Chicago pizza store while preserving the shared ordering workflow. Allow 18–20 minutes. The runnable classes are in `src/factory/lecture19/`.

## Run the project

Use a JDK version 11 or later. JDK 17 or 21 works. There are no external libraries.

- IntelliJ: open this folder as a project, choose a JDK, right-click `src` and select **Mark Directory as → Sources Root** if IntelliJ has not detected it, then run `FactoryMethodChecks.main`. Run `FactoryMethodDemo.main` after completing the lab.
- macOS/Linux terminal: `sh run.sh` for checks or `sh run.sh demo` for the demonstration.
- Windows Command Prompt: `run.bat` for checks or `run.bat demo` for the demonstration.

The scripts compile Java 11 source to Java 11 bytecode. A full JDK also checks Java 11 API compatibility with `--release 11`. The fallback uses the JDK compiler module when the launcher is present but `javac` is not on the path.

## Read the shared workflow first (3 minutes)

Open `PizzaStore.java` and `NYPizzaStore.java`. Follow one call to `orderPizza("cheese")`.

1. The concrete store's `createPizza` chooses a product object.
2. The inherited `orderPizza` calls `prepare`, `bake`, `cut`, and `box` in that order.
3. Each product method records its visible action in `getSteps()`.

`orderPizza` is `final` in this lab so subclasses cannot replace the shared ordering sequence. This is a classroom design choice. The essential Factory Method mechanism is the overridable creation method.

## Complete the two tasks (8 minutes)

| Task | File | Required change |
| --- | --- | --- |
| TODO 19A | `ChicagoPizzaStore.java` | Return a new `ChicagoStyleCheesePizza` for `"cheese"`, a new `ChicagoStyleVeggiePizza` for `"veggie"`, and throw `IllegalArgumentException` for any unsupported value. |
| TODO 19B | `ChicagoStyleCheesePizza.java` | Override `cut()` by recording exactly `"cut: square slices"` once. |

Keep the factory method focused on creating and returning the product. `orderPizza` already runs all four lifecycle steps.

## Contract

- Supported input strings are exactly `"cheese"` and `"veggie"` in lowercase.
- `null` and unsupported strings must throw `IllegalArgumentException`. The base `orderPizza` handles `null` before calling the factory method.
- Every successful order returns a new, fully processed pizza.
- The default trace is `[prepare, bake, cut: diagonal slices, box]`.
- Chicago cheese uses `[prepare, bake, cut: square slices, box]`.
- In this exercise Chicago veggie keeps the inherited diagonal cut. Only Chicago cheese has a cut override.
- `getSteps()` returns a read-only snapshot. Checks observe behavior through this public method.

## Check and explain (7 minutes)

Run all 12 checks. The starter compiles before you edit it, but incomplete tasks produce `UnsupportedOperationException` failures. Finish both TODOs and rerun until the result is `12 passed, 0 failed`.

Then explain to a partner:

1. Why does `PizzaStore.orderPizza` work even though it does not name `ChicagoStyleCheesePizza`?
2. Which object selects the concrete pizza class?
3. When the local variable has type `Pizza`, why does `cut()` still record square slices for Chicago cheese?
4. What would be wrong with preparing the pizza inside `createPizza` as well as in `orderPizza`?

## Expected demo after completion

```text
NY Style Cheese Pizza
[prepare, bake, cut: diagonal slices, box]
Chicago Style Cheese Pizza
[prepare, bake, cut: square slices, box]
```

## Optional extension

Add a new regional `PizzaStore` subclass and its cheese/veggie products. Keep `PizzaStore.orderPizza` unchanged. Explain why adding a new region fits this extension point, while adding a new menu type may require updates in existing concrete stores.

## Completion checklist

- [ ] Both TODOs are complete.
- [ ] All 12 visible checks pass.
- [ ] The demo output matches the expected names and workflow.
- [ ] You can identify the Creator, Concrete Creator, Product, and Concrete Product roles.

These are original classroom examples inspired by Chapter 4 of *Head First Design Patterns*, 2nd edition, Eric Freeman and Elisabeth Robson (O'Reilly, 2020). All checks are included in both student and instructor packages. This lab does not require students to write JUnit tests.
