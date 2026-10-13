# Lab 12 — Student Instructions

Week 6 • Four focused TODOs • 30 minutes of guided lab time

## Set up Lab 12; keep earlier labs unchanged

Unzip Lab12_Student_Starter. Copy the supplied package folders into your existing course repository as shown below. The baseline classes are complete; only edit the named TODO files. Do not copy an Instructor_Solution folder into your student repository.

```text
src/labs/lab12/          package labs.lab12
test/labs/lab12/         Lab12Test.java
```

In IntelliJ, mark src as Sources Root and test as Test Sources Root. Do not mark each lab folder as a source root. Use JDK 17 or newer at Java 17 language level. Keep all package declarations unchanged. Use only this lab’s Product type; do not import Product from another lab.

## Public tests and expected starter behavior

Run Lab12Test from IntelliJ’s test gutter. Use the course’s JUnit 5 library. For a fresh setup, add the Maven library org.junit.jupiter:junit-jupiter:5.10.2 under Project Structure → Libraries and apply it to the module with test scope. The starter is designed to compile; some tests fail until you complete the TODOs. Those failures are part of the exercise.

The student and instructor versions use the same 24 public tests. Do not edit tests to hide a failure. The design/reflection checklist is also part of demonstrating completion; passing tests alone does not explain the design.

## Work and submission routine

Work in Driver/Navigator pairs and switch roles halfway through the lab. Before coding, state the relevant contract and predict the result. After coding, run the tests and explain what changed and what stayed unchanged.

Commit the lab source, matching test folder, and requested reasoning to your GitHub repository. For this Brightspace submission, provide the direct src/labs/lab12 folder link and ONE passing IntelliJ/JUnit screenshot. The screenshot should show Lab12Test and its passing results. No terminal Git screenshot is required.

The archive README also contains an optional command-line test runner. It requires the official standalone JUnit JAR; the JAR is not bundled. IntelliJ is sufficient for the required work.

## Lab 12 • Build a generic iterable catalog

### Requirement and starting point

Implement ItemCatalog<T> as a new reusable component. The earlier Product-only Catalog remains supplied for comparison. The labs.lab12 package contains its own complete store and checkout baseline, so it does not depend on your Lab 11 being finished. Do not import classes from another lab.

| Member / property | Required contract |
| --- | --- |
| add(T item) | Reject null with NullPointerException before modifying storage. Append and retain duplicate entries. |
| size() / get(int) | Report entry count; return T for a valid zero-based index. Invalid indexes throw IndexOutOfBoundsException. These methods are supplied. |
| iterator() | Return a fresh SnapshotIterator each time. The constructor structure is supplied. |
| hasNext() | Check whether a value remains without advancing the cursor. |
| next() | Return the current element and advance once. At exhaustion, throw NoSuchElementException, even when hasNext was not called first. |
| Snapshot policy | Copy current element references at iterator creation; retain order. Later appends are invisible to that old iterator. |
| remove() | Unsupported; inherit Iterator’s default UnsupportedOperationException behavior. |

Keep items private and do not extend ArrayList. The catalog implements Iterable<T>, not the whole Collection or List interface. Each iterator owns its own snapshot and cursor. Copying the references does not clone or freeze element objects, and this single-threaded design does not promise thread safety.

### Bounded report

```text
public static <T extends Product> double totalUnitPrice(Iterable<T> products)
```

Keep this signature. Reject a null source or null element with NullPointerException; add one getPrice() per element; return 0.0 for an empty source. This method must also accept a suitable Java List, not only ItemCatalog. It does not include cart quantities.

## Lab 12 • Implement and test the four TODOs

| Time | Checkpoint and actions |
| --- | --- |
| 2 min | Open labs.lab12 and assign Driver/Navigator roles. |
| 5 min | 1. Locate T, items, snapshot, and cursor. Predict empty/one-element iteration and the store outputs. Record order, duplicate, null, and later-addition policies. |
| 15 min | 2. Complete ItemCatalog.add, SnapshotIterator.hasNext, SnapshotIterator.next, and CatalogReports.totalUnitPrice. Switch roles at lab elapsed minute 15. |
| 8 min | 3. Run all 24 public tests and both demos. Complete the comparison and reflection. |

### Implementation hints

add should validate before calling the list’s append operation. hasNext compares cursor with the snapshot size and never increments. next performs its own exhaustion check; after reading a valid entry, advance exactly once. You may use separate get, increment, and return statements instead of cursor++ inside get. The bound on the report method gives T access to Product.getPrice without a cast.

Do not alter iterator() or replace the supplied snapshot helper with an exposed list iterator. Do not remove generics, cast objects to Product, add cart quantities, change package imports, or modify public tests.

### Evidence beyond one successful loop

The 24 tests cover typed retrieval, insertion order, duplicates, null and index validation, enhanced for, empty and exhausted next, repeated hasNext, next without prior hasNext, independent iterators, repeated/nested traversal, snapshot membership, unsupported remove, reference sharing, existing product dispatch, bounded services with different Iterable inputs, collection comparison, and retained injected checkout behavior.

### Expected outputs to check

```text
Catalog unit-price sum: 65.00
Cart subtotal (with quantities): 115.00
Old snapshot: A
New traversal: A B
```

The store Demo prints the three familiar delivery lines first, followed by the lines above. CollectionComparisonDemo inserts A, A, B: ArrayList and ItemCatalog retain three entries; LinkedHashSet retains two distinct String values. Do not infer product-ID uniqueness without defining matching equality semantics.

## Lab 12 • Compare the contracts and submit

### Complete a comparison in your lab folder

| Property | ItemCatalog<T> | ArrayList<T> | LinkedHashSet<T> |
| --- | --- | --- | --- |
| Encounter order | Your answer | Your answer | Your answer |
| Duplicate entries | Your answer | Your answer | Your answer |
| Null elements | Your answer | Your answer | Your answer |
| Indexed retrieval | Your answer | Your answer | Your answer |
| Iteration policy | Your answer | Your answer | Your answer |
| Snapshot creation cost | Your answer | Your answer | Your answer |

Use the lecture and the official Java 17 API descriptions, not only one experimental run. The custom catalog intentionally has a different policy. Standard fail-fast behavior is best-effort bug detection, not a thread-safety mechanism or a guarantee on which correct code should rely.

### Reflection prompts

Explain what T connects in the generic class and what the Product bound makes available. Explain why each traversal needs its own cursor. Predict the number of visits in a nested two-by-two loop. After making an iterator over A and appending B, explain what old and new traversals see and whether the element objects were cloned. Compare the optional Iterator.remove contract with the always-available Product delivery contract. Finally, explain 65.00 versus 115.00.

### Completion and submission

Commit lab12 source, unchanged public tests, the comparison. Submit the direct lab12 GitHub folder link and one passing IntelliJ/JUnit screenshot in Brightspace. A new UML diagram and a terminal Git screenshot are not required.

Optional early finish: compare the required snapshot iterator with an iterator over an unmodifiable live view. Explain the different behavior after a later append and the allocation tradeoff. Keep the required snapshot implementation and public tests unchanged.

### Official reference starting points

Oracle Java SE 17 API: java.lang.Iterable; java.util.Iterator, ArrayList, LinkedHashSet, Collection. Oracle Java Tutorials: Generic Types and Bounded Type Parameters. Full source references and tool setup appear in the archive README and the lecture materials.
