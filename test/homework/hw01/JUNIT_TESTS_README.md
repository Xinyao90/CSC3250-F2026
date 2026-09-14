# HW1 JUnit 5 Tests

## One shared test suite

Students and the instructor use **the exact same JUnit 5 tests** for Homework 1.
There are **no hidden JUnit tests** and no additional instructor-only functional test cases.

The tests are intentionally provided with the starter code so that you can run them while developing and know exactly what behavior will be checked during grading.

## Test folders

```text
test/
└── inventory/
    ├── model/
    │   ├── SupplierTest.java
    │   ├── ProductTest.java
    │   └── InventoryItemTest.java
    └── service/
        └── WarehouseTest.java
```

## What the tests check

### Supplier
- Constructor and getters
- Instance fields are private

### Product
- Constructor and getters
- Supplier reference is stored correctly
- Instance fields are private

### InventoryItem
- Constructor and getters
- Instance fields are private
- Positive stock additions
- Rejection of zero/negative additions
- Valid stock removal
- Rejection of negative, zero, and excessive removal
- Invalid operations leave quantity unchanged
- Removing exactly all available stock is allowed
- Repeated updates produce the correct quantity
- `needsReorder()` uses `quantity <= reorderLevel`

### Warehouse
- Constructor, name, and empty initial inventory
- Instance fields are private
- `addProduct()` creates an `InventoryItem`
- Duplicate product IDs are rejected
- Duplicate checking is based on `productId`, not object identity
- Null products and negative values are rejected without changing inventory
- Initial quantity `0` and reorder level `0` are allowed
- `findItem()` finds the correct product and returns `null` when missing
- `addStock()` and `removeStock()` delegate correctly
- Invalid stock requests do not change quantity
- The returned inventory list cannot be structurally modified from outside the class
- The required Laptop/Mouse/Keyboard scenario produces the expected results
- `displayInventory()` includes the required product information and reorder status

## Important

Passing the JUnit tests verifies the required Java behavior, but the complete homework grade can also include non-JUnit requirements from the assignment, such as:

- UML diagram correctness
- package/project organization
- code readability and naming
- required Git/GitHub submission requirements

## IntelliJ

Use JUnit 5 / JUnit Jupiter. In IntelliJ, mark the `test` directory as **Test Sources Root** if necessary, then run all tests from the `test` folder or individual test classes.
