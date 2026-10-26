# Lab 20 — SimUDuck Strategy integration

Use the supplied completed behavior classes. Complete only the TODO methods and constructors.

1. Delegate Duck.performFly and Duck.performQuack to the stored collaborators.
2. Configure MallardDuck, RubberDuck, DecoyDuck, and ModelDuck as shown in the slides.
3. Complete the setters; keep the supplied null guards.
4. Run MiniDuckSimulator and StrategyChecks.
5. Submit UML and a before/after reference diagram showing one ModelDuck and the replaced flight reference.

Inside `starter`: `javac *.java`, `java MiniDuckSimulator`, `java StrategyChecks`.
Expected demonstration: Squeak; No flight; No flight; Rocket-powered flight.
The solution passes 12 visible checks. Do not add instanceof branches, recursive performFly calls, or fixed strategy construction inside performFly.

Classroom adaptations: protected behavior fields; public display; non-null setter validation; simplified console messages. The roles and collaboration follow the author's example.
The instructor keeps a separate reference solution.
