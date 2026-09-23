# CSC 3250 — Lab 7
## Building a Product Class Hierarchy

### Learning Goals

By the end of this lab, you should be able to:

- create a subclass using `extends`
- initialize superclass state using `super(...)`
- distinguish inherited state from subclass-specific state
- override superclass methods
- reuse superclass behavior using `super.method()`
- use a superclass reference to work with different subclasses
- explain why `CartItem` has a `Product` rather than being a `Product`

---

## Classes

You will work with:

- `Product`
- `PhysicalProduct`
- `DigitalProduct`
- `CartItem`
- `Lab05Demo`

The intended relationships are:

```text
                  Product
                 /       \
                /         \
 PhysicalProduct         DigitalProduct


 CartItem ───────────────> Product