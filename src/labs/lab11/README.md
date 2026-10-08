# CSC3250 — Lab 11: Refactor and inject receipt output

**Student package.** Complete only the four indicated TODOs.

## Start here

Read `CSC3250_Lab11_Student_Instructions.docx` or `STUDENT_INSTRUCTIONS.md`. This is the same lab described in Lecture 11; the Java source, public method signatures, and public tests have not been redesigned for this separate package.

## Where to put the files

```text
YourCourseRepository/
  src/labs/lab11/       Java files and REFLECTION.md
  test/labs/lab11/      Lab11Test.java
```

Copy the contents into the matching existing folders. Do not replace older lab folders, change package declarations, copy a second `src` under `src`, or import a Product class from another lab. The ZIP is not a Git repository; keep using your existing course repository.

Mark **src** as Sources Root and **test** as Test Sources Root, not `lab11`. Use JDK 17 or newer at Java 17 language level and the course JUnit 5 library. For a fresh library configuration, the pinned coordinate in the existing course materials is `org.junit.jupiter:junit-jupiter:5.10.2`.

## Four focused edits

`CheckoutService.java`: TODOs 1–3.

`RecordingReceiptPrinter.java`: TODO 4.

All other Java source and test files are supplied. The before-refactoring program `labs.lab11.TightlyCoupledCheckout` runs immediately. `labs.lab11.Demo` is expected to fail until the TODOs are complete.

## Public tests

Run the entire `Lab11Test` class. There are **16 public test methods**. The student and instructor copies are byte-for-byte identical; there are no additional hidden grading tests in this package. The starter is intended to compile but have TODO-related failures. Design and reasoning are reviewed using the published handout; green tests alone do not demonstrate those items.

## Optional command-line runner

IntelliJ is sufficient. The alternative runner requires Python 3, a JDK, and the official `junit-platform-console-standalone-1.10.2.jar` outside the repository. No JUnit JAR is bundled.

```text
python3 tools/run_tests.py /absolute/path/to/junit-platform-console-standalone-1.10.2.jar --lab 11
```

On Windows, use `py` or `python` instead of `python3` and quote paths containing spaces. Build output is placed in a temporary directory. A compilation error or failing test returns a nonzero status.

## Submission

Commit `src/labs/lab11`, `test/labs/lab11`, and the design evidence described in the handout. Keep the UML/comparison and reflection in the source lab folder so they are reachable from its link. Brightspace receives **the direct GitHub lab-folder link and one passing IntelliJ/JUnit screenshot**. No terminal screenshot is required.

## Lecture alignment

Lecture 11 slides 28–32 contain the lab launch, three checkpoints, and submission. The sample cart retains Notebook, Java Guide, and Java Workshop with subtotal 115.00. Receipt output is the new requirement, not a reclassification of the previous checkout as defective. The interface and formatter are supplied.

`REFERENCES.md` retains the reference list supplied with the lecture package. Exact lab contracts are in the Java comments and handout.
