# CSC3250 Lecture 20: Abstract Factory lab

## Goal and time

Use one `CheesePizza` recipe with two regional ingredient families.

## Run the project

Use a JDK version 11 or later. JDK 17 or 21 works. There are no external libraries.

- IntelliJ: open this folder, choose a JDK, mark `src` as **Sources Root** if needed, and run `AbstractFactoryChecks.main`. Run `AbstractFactoryDemo.main` after completing the lab.
- macOS/Linux terminal: `sh run.sh` for checks or `sh run.sh demo` for the demonstration.
- Windows Command Prompt: `run.bat` for checks or `run.bat demo` for the demonstration.

## Inspect the design

`PizzaStore.orderPizza` keeps the shared workflow. Its factory method creates a `CheesePizza` with an ingredient factory. `CheesePizza.prepare` asks that factory for the ingredients.

| Family | Dough | Sauce | Cheese |
| --- | --- | --- | --- |
| New York | `ThinCrustDough` | `MarinaraSauce` | `ReggianoCheese` |
| Chicago | `ThickCrustDough` | `PlumTomatoSauce` | `MozzarellaCheese` |

`PizzaIngredientFactory` returns the abstractions `Dough`, `Sauce`, and `Cheese`. The concrete factory chooses each implementation. This lab uses three ingredient categories to keep the exercise manageable. The textbook also discusses other categories.

## Complete the tasks

| Task | File | Required change |
| --- | --- | --- |
| TODO 20A | `ChicagoPizzaIngredientFactory.java` | `createDough()` returns a new `ThickCrustDough`. |
| TODO 20B | `ChicagoPizzaIngredientFactory.java` | `createSauce()` returns a new `PlumTomatoSauce`. |
| TODO 20C | `ChicagoPizzaIngredientFactory.java` | `createCheese()` returns a new `MozzarellaCheese`. |
| TODO 20D | `CheesePizza.java` | In `prepare()`, call all three methods on the supplied `ingredientFactory`, store the returned objects in `dough`, `sauce`, and `cheese`, and record `"prepare"` once. |

The NY factory is a complete example. `CheesePizza.prepare()` must work with any implementation of `PizzaIngredientFactory` by calling its interface methods.

## Contract

- Both regional stores support the exact lowercase string `"cheese"` in this focused lab.
- `null` and all unsupported strings throw `IllegalArgumentException`.
- Both stores create the same runtime class, `CheesePizza`, with a different factory object.
- Each successful order requests one dough, one sauce, and one cheese object during `prepare()`.
- The pizza retains those exact returned ingredient objects.
- Both stores use `[prepare, bake, cut: diagonal slices, box]`. This exercise focuses on ingredient creation.
- The family is a design/configuration responsibility. The Java interfaces alone cannot prevent a badly implemented factory from mixing regions.

## Check and trace

Run all 14 checks. The starter compiles before edits, but unfinished tasks fail with a named `UnsupportedOperationException`. A completed lab reports `14 passed, 0 failed`.

Trace a Chicago cheese order aloud:

1. Which object receives `orderPizza("cheese")`?
2. Which `createPizza` implementation runs?
3. Which factory reference reaches the `CheesePizza` constructor?
4. During `prepare()`, which concrete dough, sauce, and cheese objects return?
5. Which part of the workflow stays in `PizzaStore`?

## Exit questions

1. Identify the Factory Method and Abstract Factory mechanisms present in this same program.
2. Which files change when a third regional family uses the same ingredient categories?
3. What extra changes are needed if every family must also supply a new `Clams` product category?

## Expected demo after completion

```text
NY: Cheese Pizza
  Thin crust dough
  Marinara sauce
  Reggiano cheese
  [prepare, bake, cut: diagonal slices, box]
Chicago: Cheese Pizza
  Thick crust dough
  Plum tomato sauce
  Mozzarella cheese
  [prepare, bake, cut: diagonal slices, box]
```

## Optional extension

Create a third family implementing the existing three operations, add its concrete ingredient classes, and configure a new regional store with that factory. The `CheesePizza` recipe can stay unchanged. Explain why a new required product category such as `Clams` has a wider impact: add the product abstraction, extend the factory interface, update every concrete factory, and update recipes that need clams.

## Completion checklist

- [ ] TODOs 20A–20D are complete.
- [ ] All 14 visible checks pass.
- [ ] Both stores use the same recipe class and different ingredient families.
- [ ] You can distinguish subclass-based creation in `PizzaStore` from object-based ingredient creation in `CheesePizza`.

These are original classroom examples inspired by Chapter 4 of *Head First Design Patterns*, 2nd edition, Eric Freeman and Elisabeth Robson (O'Reilly, 2020).
