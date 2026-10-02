# Lab 10 — Diagnose and repair the subtype promises

The original Product, PhysicalProduct, DigitalProduct, WorkshopProduct, CartItem, Catalog, ShoppingCart, and CheckoutService are supplied and working. `candidates/` contains two **deliberately defective** alternatives. Do not interpret them as errors in last week's baseline.

## Parent contract for this exercise
For every successfully constructed Product: ID/name are nonblank; price is finite and nonnegative; deliveryInstructions() is immediately available without subtype-specific setup; it returns useful, non-null, nonblank text normally; querying it does not change ID, name, or price.

## 30-minute lab
- Launch: 1 minute. Run the public tests before editing.
- Diagnosis: 7 minutes. Run `BrokenCandidatesDemo`. Complete the two-row diagnosis table.
- Repairs: 10 minutes. Repair CandidateDigitalProduct's null return and CandidateWorkshopProduct's extra confirmation gate. Remove obsolete setup members.
- Retest: 10 minutes. Run every public test and Demo; preserve all three instruction lines and subtotal 115.00.
- Submission: 2 minutes. Save evidence and reflection.

Keep Product, client methods, the mixed-cart fixture, and tests unchanged. Do not skip a candidate or add a subtype branch in checkout. Valid constructor checks must stay. These are implementation repairs; no new UML is required. The separate Lecture 8 digital-under-physical example illustrates a hierarchy repair, not another required coding task.

## Submit
Commit repairs, unchanged tests, and the completed diagnosis table. Brightspace: direct GitHub lab10 folder link + one screenshot of the full passing JUnit run. No Git terminal screenshot is required.

Reflection: Why is the null a weaker result guarantee? Why can a no-argument method impose a stronger precondition? Why do these cases need implementation repairs while the physical-shipping counterexample needs a different hierarchy?
