# CSC 3250 - Homework 2: Product Pricing Extension
## Brightspace edition | 60 code + 30 quiz + 10 design
Read `homework/hw02/CSC3250_HW2_Brightspace_Student_Instructions.docx` first.

**Complete two Java files and the HW2 Brightspace quiz. There is no README reflection.**
- `src/homework/hw02/DiscountedProduct.java`: validate/store the rate and calculate purchase price.
- `src/homework/hw02/PriceCalculator.java`: complete the required generic total method.
- In Brightspace: complete the 10-question HW2 quiz (30 points).

All other Java files, the tests, and the demonstration are supplied. Do not edit them.
No HW1 repair, UML diagram, GUI, database, custom collection, new tests, or new demo is required.

## Add to your existing course repository
Merge the contents of this package into the repository root. Preserve all other coursework.
Do not create another repository or put the outer ZIP folder inside `src`.

```text
YourCourseRepository/
  src/homework/hw02/       Java source (edit only the two files above)
  test/homework/hw02/      three published checking files (do not edit)
  homework/hw02/          instructions, setup, public rubric, and runners
```

Every HW2 Java file uses `package homework.hw02;`. Do not import an HW1/lab Product.
Mark `src` as Sources Root and `test` as Test Sources Root in IntelliJ.
Detailed setup: `homework/hw02/SETUP_AND_TESTING.md`.

## Run the shared checks
Run `Hw2PublicTest` in IntelliJ with the course JUnit 5 setup. The goal is 21 passing checks.
The starter compiles but intentionally fails until the TODOs are complete.
The instructor uses the same public checks, not hidden functional tests.

The existing check weights total 80 RAW test points. Your HW2 Code score is
`raw subtotal x 0.75`, out of 60. The runner displays both; do not use the percentage
of green tests because the checks have different weights.

## Complete and submit
Complete the Brightspace HW2 quiz after working on the code: 10 questions, two attempts,
highest score retained, open-book, no enforced time limit. Follow the dates in Brightspace.
Submit your GitHub repository link and one IntelliJ screenshot showing the HW2 JUnit result.
The goal is 21/21, but submit your actual result even when some checks still fail.
Push your latest work and give the instructor repository access. No source ZIP or README
explanation is required. The quiz is a separate required step; uploading evidence does not complete it.
