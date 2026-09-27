# CSC 3250 - Lab 8: Inheritance vs. Object Composition

## Goal
Compare two designs that satisfy the same delivery requirements:

1. **Inheritance baseline** - delivery varies through `Product` subclasses.
2. **Object composition** - `Product` stores a `DeliveryMethod` collaborator and delegates delivery behavior.

The inheritance implementation is complete. Your work is in `lab08.composition`.

## UML relationship for the composition version

```text
Product 0..* -------- 1 DeliveryMethod
```

Use a **plain association**. Each `Product` uses exactly one `DeliveryMethod`; a stateless or immutable helper may be shared by many products.

## TODOs

1. `ShippingDelivery.instructions()`
2. Validate and assign `DownloadDelivery.downloadFile`
3. `DownloadDelivery.instructions()`
4. `Product.deliveryInstructions()` delegates to `deliveryMethod`
5. Extend `Lab08Demo` with pickup delivery
6. Validate and assign `PickupDelivery.location`
7. `PickupDelivery.instructions()`

## Required output strings

- `ShippingDelivery.instructions()` -> `Ship to address`
- `DownloadDelivery("guide.pdf").instructions()` -> `Download guide.pdf`
- `PickupDelivery("Student Center").instructions()` -> `Pick up at Student Center`

## Rules

- Do **not** use `instanceof` in `Product`.
- Do **not** use a switch/if-chain on delivery type in `Product`.
- Do **not** modify the inheritance baseline.
- When adding pickup delivery, do **not** modify `Product`, `ShippingDelivery`, or `DownloadDelivery`.
- Use the provided visible JUnit tests; there are no surprise tests for this lab.

## Run tests

In IntelliJ, run `Lab08Test`.

Or in a terminal from the project root:

```bash
mvn test
```

## Expected demo behavior after TODOs are complete

```text
Notebook: Ship to address
Java Guide: Download guide.pdf
Notebook line total: $40.0
Guide line total: $45.0
Pickup Notebook: Pick up at Student Center
```

## Design questions

1. Where does delivery behavior vary in the inheritance design?
2. Where does delivery behavior vary in the composition design?
3. Why can `PickupDelivery` be added without editing `Product`?
4. Why is `Product`--`DeliveryMethod` shown as a plain association rather than a UML filled diamond?
5. If a new `ExpressDelivery` option is added, which design requires a new `Product` subtype?

## Submission

Commit the `lab08` project to your CSC3250 course repository. Submit:

- GitHub repository link
- one screenshot showing all JUnit tests passing
- one screenshot showing `Lab08Demo` output
- Git commit/push evidence
- your UML sketch and short comparison answers
