# HW2 - Setup and shared tests

## 1. Files and Java version

Use the course JDK in IntelliJ (JDK 17 or 21 is suitable). The supplied source
uses Java 8-compatible language features and APIs. A full JDK is needed for the
optional terminal runner because it invokes `javac`, not only `java`.

The required layout is relative to your existing course repository root:

```text
src/homework/hw02/
  Priceable.java
  Product.java
  RegularProduct.java
  DiscountedProduct.java       EDIT
  ServiceFee.java
  PriceCalculator.java        EDIT
  PricingDemo.java
test/homework/hw02/
  Hw2Checks.java               shared assertions; DO NOT EDIT
  Hw2PublicTest.java           JUnit adapter; DO NOT EDIT
  Hw2CheckRunner.java          terminal adapter; DO NOT EDIT
homework/hw02/
  README.md                   EDIT: two design explanations
  CSC3250_HW2_Student_Instructions.docx
  PUBLIC_RUBRIC.md
  SETUP_AND_TESTING.md
  EXPECTED_OUTPUT.txt
  run_checks.sh
  run_checks.cmd
  .gitignore
```

This is a separate, simplified HW2 model. It does not use HW1 suppliers,
inventory quantities, warehouse operations, or delivery-related lab classes.
Use only `homework.hw02.Product` here.

## 2. IntelliJ setup

1. Open your existing course project after merging the HW2 files. Select the
   course JDK in **File > Project Structure > Project**.
2. In the Project view, mark `src` as **Sources Root** and `test` as
   **Test Sources Root** if they are not already configured. These are the
   folders immediately ABOVE `homework`, not the `hw02` folders.
3. Reuse the JUnit 5/Jupiter dependency already configured for HW1 when available.
   Do not add a second, conflicting JUnit version to the same module.
4. When JUnit is missing, open **File > Project Structure > Libraries**, click
   **+ > From Maven**, and enter `org.junit.jupiter:junit-jupiter:5.13.4`.
   Accept the dependencies and associate the library with the course module.
   This uses IntelliJ's library download; it does not require installing Maven
   or converting your project to a Maven project. The download needs internet.
5. Open `test/homework/hw02/Hw2PublicTest.java`. Run the whole class using the
   gutter run icon. It should discover **21 tests**.

Students and instructor use byte-for-byte identical checking files. JUnit
methods delegate to `Hw2Checks`; that file contains the assertions. You do not
have to understand or modify the checking infrastructure to complete the HW.

## 3. Work sequence

Run the starter once. Compilation should succeed, but the TODO exceptions make
the checks fail. Finish the `DiscountedProduct` constructor and rerun the A
checks. Finish its purchase-price method and rerun the A/C checks. Then finish
`PriceCalculator.total` and run the full suite. Remove each TODO placeholder
exception from the code you complete.

Run the supplied `PricingDemo.main` after completing the TODOs. Its output is
in `EXPECTED_OUTPUT.txt`. Formatting in the demo is not a graded requirement;
the numerical methods must return unrounded `double` values.

## 4. Optional command-line check (no external test library)

From the repository root on macOS/Linux:
```bash
bash homework/hw02/run_checks.sh
```

From the repository root on Windows (PowerShell or Command Prompt):
```text
.\homework\hw02\run_checks.cmd
```

These scripts compile only the HW2 source and the two dependency-free checking
files. They do not compile other labs, do not need Maven/Gradle, and do not need
a JUnit JAR. Classes go into `homework/hw02/.build`, which is locally ignored by
Git. After a successful check, you can run the demo from the same root:
```text
java -cp homework/hw02/.build homework.hw02.PricingDemo
```

The terminal adapter calls the EXACT SAME 21 check methods as the JUnit
adapter. This is not an extra or hidden test suite. A passing terminal run is
useful while coding; the requested submission evidence remains one IntelliJ
screenshot of the JUnit suite.

## 5. Common setup problems

| Symptom | What to check |
|---|---|
| `Cannot resolve symbol junit` | Add/associate JUnit 5 with the module that owns `test`. |
| `Required type Product; provided labs...Product` | Remove the lab/HW1 import. All HW2 code uses `homework.hw02`. |
| `Package name does not correspond to file path` | Source roots are `src` and `test`, not `src/homework/hw02`. |
| Duplicate class errors | Keep only one HW2 source copy and one HW2 test copy in the project. |
| A TODO exception is reported | Expected in the starter; replace the marked placeholder with your implementation. |
| `javac` not found | Configure a full JDK on PATH or use the IntelliJ JDK for IDE execution. |
| Other labs fail to compile | Use the supplied HW2-only terminal runner while resolving unrelated project errors. |

## Setup references

Official JUnit 5.13.4 User Guide, sections on supported Java versions,
assertions, and IDE support: https://docs.junit.org/5.13.4/user-guide/

Official IntelliJ instructions for JUnit dependencies and test roots:
https://www.jetbrains.com/help/idea/junit.html

Official IntelliJ source-root documentation:
https://www.jetbrains.com/help/idea/content-roots.html

Version 5.13.4 is a pinned compatible setup option, not a claim about the latest
JUnit release. No JUnit binary is bundled in this package.
