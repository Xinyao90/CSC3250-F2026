# CSC 3250 - Homework 2: Product Pricing Extension

Read `homework/hw02/CSC3250_HW2_Student_Instructions.docx` first.

**Student work: two Java files and one short README.**

Complete:
- `src/homework/hw02/DiscountedProduct.java` (constructor and purchase-price method)
- `src/homework/hw02/PriceCalculator.java` (one generic method)
- `homework/hw02/README.md` (two explanations; 100-150 words total)

All other Java files, checks, and the demonstration are supplied. Do not edit them.
You do not need your HW1 code. Do not add a UML diagram, GUI, database, custom
collection, iterator, new tests, or a new demonstration program.

## Put the files in your course repository

Merge the contents of this package into your existing course repository root.
Preserve any existing `src`, `test`, and `homework` contents; add the HW2
subfolders rather than replacing the existing folders. Do not place the outer
ZIP folder inside `src`, and do not run `git init` again.

```text
YourCourseRepository/
  HW2_START_HERE.md
  src/homework/hw02/       seven supplied/source Java files
  test/homework/hw02/      three shared checking files
  homework/hw02/          instructions, README, setup, rubric, scripts
```

Keep the package `homework.hw02` in every HW2 Java file. Do not import
`Product` from HW1 or a lab. Mark the repository's `src` as Sources Root and
`test` as Test Sources Root in IntelliJ; do not mark `homework/hw02` as a source root.
See `homework/hw02/SETUP_AND_TESTING.md` for the full setup steps.

## Run the shared checks

In IntelliJ, run `Hw2PublicTest` using your JUnit 5 library. The starter is
compilable but intentionally fails the checks until the TODOs are complete.
The goal is all 21 checks passing, not a particular ordering of the results.

Optional command-line check from the repository root (no JUnit download):

macOS/Linux:
```bash
bash homework/hw02/run_checks.sh
```
Windows PowerShell or Command Prompt:
```text
.\homework\hw02\run_checks.cmd
```

Both runners call the same public checks. The automated subtotal is 80 points;
design review and your explanations account for the remaining 20 points.

## Submit in Brightspace

Submit your GitHub repository link and one IntelliJ screenshot showing all 21
HW2 JUnit tests passing. Keep your explanations in `homework/hw02/README.md`.
Make sure the instructor has repository access and your latest changes are pushed.
Follow the due date shown in Brightspace. Do not submit a second ZIP of your code.
