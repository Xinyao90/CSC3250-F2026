# HW2 - Public rubric and shared check map

The total is **100 points**: 80 from the published checks, 10 from the public
source-review checklist, and 10 from the two README explanations. The instructor
and students use the same `Hw2PublicTest`, `Hw2Checks`, and `Hw2CheckRunner` files.
There are no hidden functional tests. Keep all supplied files unchanged.

## Automated portion: 80 points

Each named check earns its listed points when all its assertions pass. A failed
check earns zero for that check. Checks have different weights; do not calculate
the grade as the percentage of green tests. A09 includes three invalid values
under one four-point check. The terminal runner prints the weighted subtotal.

| ID | Published check | Points |
|---|---|---:|
| A01 | Constructor stores ID, name, original price, and rate | 4 |
| A02 | 25% discount through a Product reference | 4 |
| A03 | Fractional price without rounding | 4 |
| A04 | Zero discount | 4 |
| A05 | 100% discount | 4 |
| A06 | Zero original price | 4 |
| A07 | Reject a negative rate | 4 |
| A08 | Reject a rate above 1.0 | 4 |
| A09 | Reject NaN and both infinities | 4 |
| A10 | Independent product discounts | 4 |
| B01 | Total List<Product> | 5 |
| B02 | Total List<DiscountedProduct> | 5 |
| B03 | Total mixed List<Priceable> | 5 |
| B04 | Total List<ServiceFee> | 5 |
| B05 | Empty list returns zero | 5 |
| B06 | Count repeated entries and keep numerical precision | 5 |
| C01 | Repeated purchase-price calls preserve original values | 2 |
| C02 | Preserve list size, order, and references | 2 |
| C03 | Preserve object values after totaling | 2 |
| C04 | Fresh sum on every calculator call | 2 |
| C05 | Accept a read-only list | 2 |

Category totals: A01-A10 = 40; B01-B06 = 30; C01-C05 = 10.

## Source review: 10 points

| Requirement | Points |
|---|---:|
| Keep the supplied hierarchy and `Priceable` contract; preserve supplied files, package, public signatures, and the provided `getDiscountRate()` getter. | 2 |
| Keep the discount in the provided private instance field; use inherited product state, not duplicate price/ID/name fields or static application state. | 2 |
| Keep exactly `public <T extends Priceable> double total(List<T> items)`; no raw types or casts. | 2 |
| Total prices through `getPurchasePrice()`; no `instanceof`, `getClass()`, or product-type/ID/name branches and no discount formula in the calculator. | 3 |
| Use clear names/formatting, leave no placeholder exceptions, and do not hard-code test answers. | 1 |

A correct output alone does not establish the required design. For this exercise,
`List<? extends Priceable>` is not the requested method signature: the assignment
specifically practices a named, bounded type parameter. This does not mean the
wildcard form is generally an incorrect design.

## README explanations: 10 points

Write 100-150 words TOTAL for the two answers in `homework/hw02/README.md`.

Question 1 (5): Why can the calculator process a `DiscountedProduct` without a
new discounted-product branch? Identify the operation/common contract (2),
explain dynamic dispatch in this code (2), and keep discount responsibility in
the subtype rather than the calculator (1).

Question 2 (5): Why does `ServiceFee` implement `Priceable` rather than extend
`Product` in this model? Explain the domain relationship accurately (2), explain
the pricing capability expressed by the interface (2), and connect it to the
common calculator without unnecessary product state (1).

Use your own words and the actual class/method names. A list of generic OOD
vocabulary without relating it to this code does not earn full credit. The word
range is a scope guide, not a separate unpublished penalty.

## Scope and edge cases

A discount rate is a **fraction**, not a whole-number percentage. Rates must be
finite and in [0.0, 1.0]; NaN and both infinities are invalid. Invalid rates must
throw `IllegalArgumentException`; the exact exception message is not graded.
`Double.isFinite(rate)` is provided as a hint. Ordinary product-field validation
is already supplied; do not reimplement it.

`getPrice()` always returns the original stored price. Purchase-price methods
return unrounded double values and do not alter object state. The calculator
counts every entry (even a repeated reference), uses a fresh local total each
call, and does not alter input objects, list order, entries, or size. It must also
accept an unmodifiable list.

Assume calculator arguments are non-null, contain no null elements, and contain
valid Priceable objects with a finite total representable as a double. Null and
overflow handling are not required or graded. No persistence, custom containers,
iterators, setters, new tests, or new UML diagram are required.
