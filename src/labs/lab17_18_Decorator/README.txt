CSC 3250 Decorator Labs
Student starter package for Lectures 17 and 18

These labs use small Java programs to practice the Decorator pattern. A wrapper
has the same component type as the object it holds. A call on the wrapper can
therefore delegate to a base object or to another wrapper.

The starter compiles before you complete it. Four method pairs intentionally
return placeholder values, so some visible checks initially fail. Complete the
TODO classes listed below. Keep the supplied checks unchanged.

Requirements

Use a Java Development Kit (JDK) version 8 or later. No Maven, Gradle, JUnit, or
external dependencies are required. The package names are coffee, weapons,
support, and io. Keep the folder structure shown in sources.txt.

Compile and run

Open a terminal in this folder, the folder that contains sources.txt.

macOS or Linux:
    bash build.sh
    java -cp out coffee.CoffeeChecks
    java -cp out weapons.WeaponChecks

Windows Command Prompt:
    build.cmd
    java -cp out coffee.CoffeeChecks
    java -cp out weapons.WeaponChecks

On either platform, the following commands also work directly:
    javac -d out @sources.txt
    java -cp out coffee.CoffeeChecks
    java -cp out weapons.WeaponChecks

The build scripts create the out directory for you. If you use the direct
commands, create out first. If javac is not recognized, check that a JDK is
installed and its bin folder is on PATH. An IDE may also compile the project:
open this folder, mark src as the source folder, and run the desired main class.

run_checks.sh and run_checks.cmd compile once and run both core check suites.
The script exits with a nonzero status when either suite fails. During Lecture
17, the weapons suite is expected to remain incomplete. Run CoffeeChecks alone
while working on that lab.

Initial starter results
    Coffee: 9/20 checks passed.
    Weapons: 7/20 checks passed.

Final core results
    Coffee: 20/20 checks passed.
    Weapons: 20/20 checks passed.

The same visible checks accompany the instructor solution. The checks include a
custom Beverage and a custom Weapon so your decorators must use the supplied
component. A decorator must work for every suitable component, including another
decorator. You do not need to write any checking framework code.

LAB A  Coffee condiments
Suggested working time 18 minutes

Goal
Complete two condiment decorators, predict a nested call, and explain what
happens to an existing reference when a new wrapper is created.

Provided classes
    Beverage               Common abstract type
    Espresso               Base price 1.99
    HouseBlend             Base price 0.89
    DarkRoast              Base price 0.99
    CondimentDecorator     Stores a Beverage reference and rejects null
    Mocha                  Completed wrapper, adds 0.20
    Whip                   TODO wrapper, adds 0.10
    Soy                    TODO wrapper, adds 0.15

Every Beverage supports:
    String getDescription()
    double cost()

Step 1  Predict before running  3 minutes
Read the completed Mocha class. Then trace this expression on paper:

    Beverage base = new DarkRoast();
    Beverage drink = new Whip(new Mocha(new Mocha(base)));

Draw a separate box for each created object. Label each stored beverage
reference. Predict drink.cost(), base.cost(), and drink.getDescription().

Step 2  Complete the two wrappers  7 minutes
Edit only src/coffee/Whip.java and src/coffee/Soy.java.

Each getDescription() must ask the wrapped beverage for its description, then
append the decorator's suffix. The exact suffixes are ", Whip" and ", Soy".
Each cost() must ask the wrapped beverage for its cost, then add the price of
that one condiment. The constructor and superclass field are already provided.

Avoid building a new base beverage inside a decorator. The constructor already
receives the object that the caller wants to decorate. Avoid hardcoding a total
for one specific order. Repeated condiments are allowed in this exercise.

Step 3  Run the visible checks and demo  4 minutes
Rebuild after saving your edits:
    javac -d out @sources.txt
    java -cp out coffee.CoffeeChecks
    java -cp out coffee.CoffeeDemo

Completed CoffeeDemo output:
    Dark Roast, Mocha, Mocha, Whip
    Total: $1.49
    Original base: $0.99
    House Blend, Whip, Soy
    Total: $1.14

The examples use double to keep the arithmetic close to the introductory
textbook example. The checks use a tolerance of 1e-9. Two-decimal formatting
changes how the result is displayed. It does not change the stored value.

Step 4  Explain the design  4 minutes
C1. List the objects that receive cost() calls for the first drink, starting
    with the outermost wrapper. Then list the returned values in reverse order.

C2. Why can a Whip contain a Mocha even though their classes are different?

C3. Does constructing the new Whip change the object referred to by base?
    Explain what base and drink refer to after construction.

C4. Suppose a Caramel decorator is added later. Which existing component
    implementations would need to change? Which setup code might change?

C5. A method receives a Beverage parameter and prints getDescription() and
    cost(). Why can it receive both a plain Espresso and a decorated drink?

Completion checklist
    Both TODO classes compile.
    CoffeeChecks reports 20/20.
    Your object diagram shows four objects for the first drink.
    Your explanations refer to objects, stored references, and delegation.

LAB B  Weapon enhancements
Suggested working time 25 minutes

Goal
Transfer the same wrapper structure to a new setting. Implement enhancements
that combine without requiring a subclass for every possible combination.

Provided classes
    Weapon                 Common interface
    Sword                  Base damage 10, description "Sword"
    WeaponDecorator        Stores a Weapon reference and rejects null
    SharpenedWeapon        Completed wrapper, adds 3
    FlamingWeapon          TODO wrapper, adds 5
    FrostWeapon            TODO wrapper, adds 2

Every Weapon supports:
    int damage()
    String description()

Step 1  Compare the two designs  3 minutes
Compare Beverage with Weapon and CondimentDecorator with WeaponDecorator.
Identify the component, concrete component, decorator base, and concrete
decorators. Beverage is an abstract class; Weapon is an interface. The shared
wrapper idea works with either form of component abstraction.

Step 2  Implement Flaming and Frost  8 minutes
Edit src/weapons/FlamingWeapon.java and src/weapons/FrostWeapon.java.

Each damage() delegates to weapon.damage() and adds its own enhancement.
Each description() delegates to weapon.description() and appends its suffix:
", Flaming" or ", Frost". SharpenedWeapon is a complete worked example.

Step 3  Verify the behavior  5 minutes
    javac -d out @sources.txt
    java -cp out weapons.WeaponChecks
    java -cp out weapons.WeaponDemo

Completed WeaponDemo output:
    Sword, Sharpened, Flaming
    Damage: 18
    Original base damage: 10
    Sword, Sharpened, Flaming, Frost
    Damage: 20

Step 4  Reason about shared references  5 minutes
Trace the following statements:

    Weapon sword = new Sword();
    Weapon first = new FlamingWeapon(sword);
    Weapon second = new FrostWeapon(sword);

W1. How many objects were created? Which object does each local variable refer
    to? Which object do the wrappers share?

W2. Predict sword.damage(), first.damage(), and second.damage(). Explain why
    the two wrappers do not automatically combine with each other.

W3. Explain why these two expressions both produce damage 18. Are their
    description strings also identical?
    new FlamingWeapon(new SharpenedWeapon(new Sword()))
    new SharpenedWeapon(new FlamingWeapon(new Sword()))

Step 5  Design transfer  4 minutes
W4. Propose one additional enhancement. Specify its damage rule and description
    suffix. Explain how a client would use it without changing Sword.

W5. A class stores its wrapped reference in a final field. Does final mean the
    object being referenced can never change its internal state? Explain.

W6. What is one cost of using many small decorator objects? Give a concrete
    example involving configuration, tracing, or a component-specific method.

Completion checklist
    Both TODO classes compile.
    WeaponChecks reports 20/20.
    Your diagram distinguishes a nested chain from two wrappers sharing a base.
    Your design explanation states which part of the behavior each object owns.

OPTIONAL  When order changes the result

DoubleDamageWeapon is supplied as a completed extension. It multiplies the
wrapped damage by two. Complete the core lab first.

Predict the results before running ExtensionChecks:
    new DoubleDamageWeapon(new FlamingWeapon(new Sword()))
    new FlamingWeapon(new DoubleDamageWeapon(new Sword()))

Run:
    java -cp out weapons.ExtensionChecks

Expected final summary:
    Optional order extension: 6/6 checks passed.

Explain why adding 3 and adding 5 can be reordered for the damage calculation,
while doubling and adding 5 can produce different values. Also examine the
order of the description suffixes.

OPTIONAL  King and queen integration

Run:
    java -cp out weapons.CharacterDemo

GameCharacter stores a configurable Weapon and delegates its attack behavior.
That configurable behavior role connects with the earlier Strategy lesson.
The wrappers inside the selected Weapon illustrate Decorator. Identify each
relationship separately. Calling a setter only assigns the chosen reference;
it does not create a decorator by itself.

OPTIONAL  Java I/O example

Run:
    java -cp out io.DecoratorIODemo

Expected output:
    42

The demo wraps a ByteArrayInputStream in a BufferedInputStream, then wraps that
in a DataInputStream. All participate in the InputStream class hierarchy.
DataInputStream also offers readInt(), which reads the four bytes as an int.
An InputStream-typed variable exposes the InputStream methods; the extra
readInt() method needs an appropriate DataInputStream or DataInput reference.
The try-with-resources statement closes the outer stream and its wrapped chain.