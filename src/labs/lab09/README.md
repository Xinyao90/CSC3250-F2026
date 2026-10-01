# Lab 9 — Extend the store, keep the common client

## Requirement and model
The existing store sells Notebook (20.00) and Java Guide (15.00). Add Java Workshop (30.00, Room A). Reuse the abstract Product and the existing responsibilities. Catalog contains Product references; CartItem owns one line total; ShoppingCart calculates subtotal; CheckoutService coordinates instruction output.

## 30-minute checkpoints
1. **5 minutes:** sketch WorkshopProduct under Product; keep CartItem–Product association; predict three delivery lines and subtotal.
2. **10 minutes:** complete the three WorkshopProduct TODOs (room validation, instructions, description).
3. **12 minutes:** complete CheckoutService's two TODOs; run Demo and all public tests; explain the dispatch call.
4. **3 minutes total including launch/submission:** save and check evidence.

The new read-only `Catalog.getProducts()` and `ShoppingCart.getItems()` accessors are supplied; they are not new student TODOs. Do not change the old subtype implementations or the arithmetic methods. Do not use instanceof, casts, getClass(), or subtype switches to choose delivery behavior.

## Exact results
`WorkshopProduct.deliveryInstructions()` returns `Attend in Room A` for Room A.
Its description is `W300: Java Workshop [workshop]` for sample W300.
The cart contains 2 notebooks, 3 guides, and 1 workshop:

```text
Notebook -> Ship to address
Java Guide -> Download guide.pdf
Java Workshop -> Attend in Room A
Subtotal: 115.00
```

There is one instruction line per CartItem, not one per unit. The physical/digital-only baseline subtotal is 85.00. A valid workshop requires no setup call after construction. Reject a null or blank room using IllegalArgumentException.

## Run and submit
Open this folder's pom.xml in IntelliJ; use JDK 17+. Run `lab09.Demo`, then the full public `Lab09Test` class. Optional complete transfer demo: `lab09.compositiondemo.CompositionTransferDemo`.

Commit source, tests, UML sketch, and reflection to lab09. Brightspace: direct GitHub lab09 folder link and one screenshot showing the full passing JUnit run. No Git terminal screenshot is required.

Reflection: Which classes changed? Which processing/arithmetic methods stayed the same? Trace the workshop call through a Product reference. Why does the composition-based alternative still use polymorphism?
