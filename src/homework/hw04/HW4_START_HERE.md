# Homework 4 Campus Dining Menu System

CSC3250 Object-Oriented Design and Development

Complete a Java program that creates food items for campus dining locations, organizes items into nested menus, and iterates over a menu's immediate children. You will implement Factory Method, Composite, and Iterator. This homework is self-contained and does not depend on your HW3 implementation.

**Submit all HW4 work through the Brightspace homework quiz.** Answer Questions 1-10, upload one JUnit results screenshot in Question 11, and paste your GitHub link in Question 12. No separate Brightspace assignment submission or README reflection is required.

## Before starting

Get the HW4 starter files provided for the course. If you are using the course GitHub repository, pull its latest version and copy the entire `src/homework/hw04` folder into your own course workspace. If you are using the student starter ZIP, extract it and copy that same folder. Keep the Java package declaration `package homework.hw04;`.

Open your existing course project in IntelliJ. Keep the folder under the project's Java source root. Reuse the JUnit 5 configuration from HW3. If `org.junit.jupiter.api` imports are unresolved, add the JUnit 5 library to your project's dependencies; the public suite uses JUnit Jupiter 5.11.4. The source is compatible with Java 8 and later. An installed course JDK and the JUnit library are required; the ZIP contains source files, not an IDE or JDK.

Read the requirements below before editing. The starter compiles after JUnit is configured, but the eight incomplete methods throw `UnsupportedOperationException`. Failed tests before implementation are expected.

## Points and submissions

| Part | Required work | Points |
| --- | --- | ---: |
| A | Ten conceptual questions, 3 points each | 30 |
| B | One screenshot of the complete public JUnit suite; 30 tests, 2 points each | 60 |
| C | GitHub link to your committed and pushed HW4 source folder | 10 |
| Total | All work submitted through the same quiz | 100 |

This is an open-book homework quiz with no enforced timer. You may consult the lectures, these instructions, supplied files, and your own code. Students and the instructor use the **same unchanged `Hw4PublicTest.java`**. There are no hidden implementation tests. The instructor may rerun this suite on the code linked in your submission.

## Files to complete

Complete exactly eight TODO methods in these four files:

| Editable file | Methods to complete | Number |
| --- | --- | ---: |
| `CafeMenuCreator.java` | `createItem(String code)` | 1 |
| `DinerMenuCreator.java` | `createItem(String code)` | 1 |
| `Menu.java` | `add`, `getItemCount`, `getVegetarianCount`, `iterator` | 4 |
| `MenuIterator.java` | `hasNext`, `next` | 2 |

Preserve the supplied class and interface relationships, fields, constructors, method names, signatures, and null checks. Replace only the TODO placeholder bodies after any supplied validation. Do not modify the public tests or other supplied Java files. Do not disable, remove, or skip tests.

The complete supplied files are `MenuComponent.java`, `MenuItem.java`, `Coffee.java`, `VeggieSandwich.java`, `Tea.java`, `ChickenSandwich.java`, `MenuCreator.java`, `MenuDemo.java`, and `Hw4PublicTest.java`.

## Program model

Every component implements this interface:

```java
public interface MenuComponent {
    String getName();
    int getItemCount();
    int getVegetarianCount();
}
```

A `MenuItem` is a leaf representing one food or drink item. A `Menu` is a composite that can contain items and other menus. Both support the two count operations through `MenuComponent`. The supplied leaf objects are immutable and have these fixed properties:

| Concrete class | Name returned by getName | Item count | Vegetarian count |
| --- | --- | ---: | ---: |
| `Coffee` | `Coffee` | 1 | 1 |
| `VeggieSandwich` | `Veggie Sandwich` | 1 | 1 |
| `Tea` | `Tea` | 1 | 1 |
| `ChickenSandwich` | `Chicken Sandwich` | 1 | 0 |

Each product has a public no-argument constructor. `MenuItem.isVegetarian()` returns its supplied boolean flag. You do not need to implement prices, ordering, payment, a user interface, or file access.

## Part 1 Factory Method

`MenuCreator` is the abstract creator. Its supplied `buildMenu(String name, List<String> codes)` operation creates a menu, calls `createItem(code)` once for each code in list order, adds the created items, and returns the menu. The concrete creator's overridden `createItem` determines which products the common workflow receives.

Complete the two concrete factory methods according to this table:

| Creator | Exact request code | Required new object |
| --- | --- | --- |
| `CafeMenuCreator` | `"drink"` | `Coffee` |
| `CafeMenuCreator` | `"main"` | `VeggieSandwich` |
| `DinerMenuCreator` | `"drink"` | `Tea` |
| `DinerMenuCreator` | `"main"` | `ChickenSandwich` |

Request codes are case-sensitive. Every other non-null code, including `"MAIN"` or `"dessert"`, must throw `IllegalArgumentException`. The exception message is not graded. Each valid request must create a fresh object; requesting the same code twice must not return the same object reference. Keep the supplied null guards.

You may use `if` statements or a `switch` inside these two creation methods. Keep the supplied creator hierarchy and inherited `buildMenu` workflow. Factory Method is demonstrated by the superclass workflow calling an overridable creation operation.

For example, after a correct implementation:

```java
MenuCreator cafe = new CafeMenuCreator();
MenuItem item = cafe.createItem("main");
System.out.println(item.getName()); // Veggie Sandwich
```

## Part 2 Composite

Each `Menu` has its own list of child references and a supplied name. Complete these operations:

- `add(component)` appends that exact component reference to the end of this menu's list. Preserve insertion order. Do not clone or flatten a submenu. Repeated references are allowed and count once for each occurrence in the list.
- `getItemCount()` returns the sum of the item counts reported by all immediate children. An empty menu returns `0`.
- `getVegetarianCount()` returns the sum of the vegetarian counts reported by all immediate children. An empty menu returns `0`.
- `iterator()` returns a fresh `MenuIterator` over this menu's immediate children, as described in Part 3.

For the counting methods, call the operations declared by `MenuComponent`. Do not use `instanceof`, downcasts, or concrete class/name checks. A child may be another menu or a different implementation of `MenuComponent`. The public tests include custom components that report more than one item, so assuming every child counts as one is incorrect.

Compute counts from the current children on every call. Repeated calls must not accumulate an old total. If a submenu receives another item after being attached to a parent, later parent counts must reflect the change.

Consider this example:

```java
Menu lunch = new Menu("Lunch Menu");
lunch.add(new VeggieSandwich());
lunch.add(new ChickenSandwich());

Menu campus = new Menu("Campus Menu");
campus.add(new Coffee());
campus.add(lunch);

System.out.println(campus.getItemCount());       // 3
System.out.println(campus.getVegetarianCount()); // 2
```

The group itself does not add another food item. If `lunch.add(new Tea())` runs next, the campus counts become `4` and `3`.

All input structures are acyclic: a menu never contains itself directly or indirectly. Cycle detection is not required. Inputs and list entries are non-null, and count totals fit in `int`. Preserve supplied validation; additional validation behavior is not assessed.

## Part 3 Iterator

`MenuIterator` implements `java.util.Iterator<MenuComponent>`. Its constructor and fields are supplied. Complete the traversal using its list reference and its own `position` field. Do not delegate the traversal to an existing list iterator.

- `hasNext()` returns `true` exactly when another element remains. It must not move the position, even when called repeatedly.
- `next()` returns the same reference as the next list element and advances the position exactly once. It must work even if the caller has not first called `hasNext()`.
- When no element remains, `next()` throws `NoSuchElementException`. This also applies to an initially empty list. Do not return `null` at exhaustion.
- Traversal visits immediate children in insertion order. A child menu is returned as one component; it is not expanded or skipped.
- Every iterator has its own position. Advancing one iterator must not advance another.
- `Menu.iterator()` must create a new `MenuIterator` each time, so the menu supports an enhanced `for` loop and independent traversals.

In the Composite example above, iterating over `campus` returns the `Coffee` object and then the `Lunch Menu` object. It does not return the two sandwiches separately. To visit lunch's immediate children, obtain an iterator from `lunch`.

The collection is not modified while an iterator is in use. You do not need to implement concurrent-modification checks, a recursive iterator, or `remove()`. The inherited `remove()` operation remains unsupported.

## Run the supplied demo

After completing all eight methods, run `MenuDemo.main` in IntelliJ. The demo builds Cafe Menu and Diner Menu from the two creators and places them inside Campus Menu. Its expected output is:

```text
Campus Menu items: 4
Campus Menu vegetarian items: 3
Direct children of Campus Menu:
Cafe Menu (items=2, vegetarian=2)
Diner Menu (items=2, vegetarian=1)
```

The demo is a useful illustration. Implementation credit comes from the full public test suite.

## Run the complete public JUnit suite

1. Open `Hw4PublicTest.java` in IntelliJ.
2. Use the run icon beside the class declaration and run the entire `Hw4PublicTest` class. Running one test method is not sufficient.
3. Check that all 30 tests were discovered. The suite has 10 Factory Method tests, 10 Composite tests, and 10 Iterator tests.
4. Read failed-test messages, correct your implementation, and rerun the entire class.
5. Commit and push the code version you intend to submit. Keep your test results and GitHub version consistent; if you change code, rerun the suite and take a new screenshot.
6. Prepare one clear PNG or JPG screenshot showing the class name, HW4 project context, all 30 tests in the overall result, passed/failed counts, and the test-results panel. Expand failures when applicable.

Each passing public test earns 2 implementation points, up to 60. A test with several assertions earns its 2 points only when the entire test passes. If some tests still fail, submit the actual results for partial credit. Do not omit the screenshot or alter the supplied tests.

## Submit through the homework quiz

**Questions 1-10:** Answer the conceptual questions. Unless a question describes a defect, assume the HW4 classes satisfy this specification. Java snippets use the supplied package and the stated standard-library imports.

**Question 11:** Attach the one JUnit screenshot described above. The screenshot and the GitHub submission must represent the same code version.

**Question 12:** Paste the GitHub link to your `src/homework/hw04` folder. A repository link is acceptable if you also give the folder path. Make sure the instructor can access the repository and that your latest work is committed and pushed. Include all 13 Java files and this README.

The 10 GitHub points cover an accessible link and clear folder path (2), all required source files, public tests, and README being present (4), and committed/pushed code consistent with the screenshot (4). Functional correctness is scored in Question 11.

## Reference

Course lectures on Factory Method, Iterator, and Composite; Head First Design Patterns, second edition, Chapters 4 and 9. Java Iterator contract: https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html. This README and the supplied public tests define the exact HW4 requirements.
