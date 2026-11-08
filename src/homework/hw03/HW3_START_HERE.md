# Homework 3 Strategy Observer and Decorator

## Your task

Complete a small fantasy-game program in which a character can change weapons, notify interested objects after an attack, and use weapons with layered effects. The program uses Strategy, Observer, and Decorator together.

Complete **only the eight TODO methods** in these three files:

- `GameCharacter.java`
- `FireWeapon.java`
- `PowerWeapon.java`

Keep the supplied constructors, validation, fields, method signatures, interfaces, supporting classes, and public tests unchanged. Use the declared interfaces when delegating; do not select behavior with branches for particular weapon or observer classes.

## Grading and submission

| Component | Brightspace question | Points |
|---|---|---:|
| Ten conceptual questions | Questions 1 through 10 | 30 |
| Implementation and JUnit screenshot | Question 11 | 60 |
| GitHub source link | Question 12 | 10 |
| Total | | 100 |

The conceptual section is open-book with no enforced timer. You may consult the lecture materials, this README, supplied files, and your own code.

The implementation has **30 public JUnit tests, worth 2 points each**. The same unchanged `Hw3PublicTest` class is used by students and the instructor. There are no additional hidden tests. The instructor may rerun the suite on the submitted code.

Submit everything through the HW3 Brightspace quiz. **No separate Brightspace assignment submission or README reflection is required.**

## Set up your workspace

1. Pull the latest course repository and locate `src/homework/hw03`.
2. Copy that entire folder into `src/homework/hw03` in your own existing course repository. If you received the starter ZIP, copy its `src/homework/hw03` folder to the same location.
3. Keep `package homework.hw03;` at the top of every Java file. In IntelliJ, `src` should be a source root, so the package path is `homework/hw03` beneath it.
4. Use the JUnit 5 library already configured for HW2. The supplied test imports `org.junit.jupiter.api`. If those imports are unresolved, add JUnit 5 to the module using the same process as HW2 before debugging your implementation.
5. Read the supplied interfaces and the TODO comments. The starter code is designed to compile; unfinished methods deliberately throw `UnsupportedOperationException` so failing tests identify unfinished work.

You do not need a GUI, keyboard input, a database, random damage, or a new character subclass for each weapon.

## Understand the pattern roles

| Pattern | Role in this program | Responsibility |
|---|---|---|
| Strategy | `GameCharacter` is the context; `WeaponBehavior` is the strategy interface. | The character delegates to its current weapon and can replace that weapon reference. |
| Observer | `GameCharacter` implements `CombatSubject`; observers implement `CombatObserver`. | Each attack publishes one event to the observers currently registered with that character. |
| Decorator | `WeaponBehavior` is the component interface; `WeaponDecorator` holds another `WeaponBehavior`. | `FireWeapon` and `PowerWeapon` wrap a weapon and add an effect while keeping the same interface. |

A class or interface may participate in more than one pattern. `WeaponBehavior` is a Strategy interface in the character-to-weapon relationship and a Component interface in the wrapper-to-weapon relationship.

## Supplied contracts and classes

```java
public interface WeaponBehavior {
    int damage();
    String description();
}

public interface CombatObserver {
    void update(AttackEvent event);
}
```

| Type | Supplied behavior |
|---|---|
| `SwordBehavior` | `damage()` returns `10`; `description()` returns `"Sword"`. |
| `BowBehavior` | `damage()` returns `6`; `description()` returns `"Bow"`. |
| `WeaponDecorator` | Stores the wrapped weapon in the protected final field `wrapped`. Its constructor and null guard are supplied. |
| `AttackEvent` | An immutable object containing one attack's results. Read it with `getCharacterName()`, `getWeaponDescription()`, and `getDamage()`. |
| `CombatLog` | Records received events. `getUpdateCount()` starts at `0`. `getLastEvent()` returns `null` until the first update. |
| `CombatSubject` | Declares `registerObserver(CombatObserver)` and `removeObserver(CombatObserver)`. |
| `GameDemo` | Demonstrates the completed program. It does not replace the public test suite. |
| `Hw3PublicTest` | Contains the 30 public JUnit tests used for implementation grading. |

In `GameCharacter`, the constructor accepts a character name and initial weapon. The supplied getters are `getName()` and `getWeaponBehavior()`.

## Task 1 Complete GameCharacter

### setWeaponBehavior

After the supplied validation, replace this character's current weapon reference with the argument. Keep the same character object and the same registered observers.

The setter configures behavior only. It must not call `damage()`, call `description()`, perform an attack, or notify observers. The next call to `attack()` uses the newly stored weapon. Changing one character's weapon must not change another character's weapon.

Two characters may hold references to the same weapon object. Storing a weapon reference does not copy the weapon or transfer exclusive ownership.

### attack

For each call:

1. Ask the current weapon for its damage **exactly once** and its description **exactly once**.
2. Create one new `AttackEvent` containing the character's name and those results.
3. Call `update(event)` once on every observer currently registered with this character.
4. Pass the **same event object** to every observer and return that event to the caller.

The method must work with no registered observers. It still computes and returns the event. Each later attack creates its own event and obtains current values from the current weapon; do not reuse an earlier event or cache an earlier weapon result.

Delegate through `WeaponBehavior`. A new weapon implementation must work without adding a concrete-type branch to `GameCharacter`. Observers receive the result of one attack; the program must not recalculate damage separately for each observer.

### registerObserver

After the supplied validation, add the observer if it is not already registered. Registering the same observer object twice has no additional effect. Registration must not call `update` or replay earlier attacks.

Hint: the supplied list supports `contains` and `add`. Under the assumptions below, membership identifies the same observer instance.

### removeObserver

After the supplied validation, remove the observer if it is registered. Removing a non-member, or removing the same observer again, has no effect on the remaining registrations. A removed observer receives no future events unless it registers again.

Hint: the list's `remove` operation already handles a missing entry. Registration lists belong to individual characters; do not share one static list among all characters.

## Task 2 Complete FireWeapon

Implement both methods by delegating to `wrapped`:

- `damage()` returns the wrapped weapon's damage plus `4`.
- `description()` returns the wrapped description followed by exactly `" + fire"`.

Each method calls the corresponding wrapped method exactly once. It does not call the other wrapped method.

For a wrapped sword, the results are `14` and `"Sword + fire"`. A wrapped bow gives `10` and `"Bow + fire"`.

## Task 3 Complete PowerWeapon

Implement both methods by delegating to `wrapped`:

- `damage()` returns twice the wrapped weapon's damage.
- `description()` returns the wrapped description followed by exactly `" x2"`.

Each method calls the corresponding wrapped method exactly once. It does not call the other wrapped method.

For a wrapped sword, the results are `20` and `"Sword x2"`. A wrapped bow gives `12` and `"Bow x2"`.

## Rules for both decorators

The supplied constructors store the wrapped reference. Constructing a decorator does not call the wrapped methods. The decorator uses the wrapped object's current result whenever its own method is called; do not hard-code the sword's value or cache a result during construction.

The wrapped object may be a base weapon, another decorator, or another implementation of `WeaponBehavior`. Repeated effects are allowed. Do not mutate the wrapped object or accumulate an effect across calls.

| Expression | Damage | Description |
|---|---:|---|
| `new FireWeapon(new SwordBehavior())` | 14 | `Sword + fire` |
| `new PowerWeapon(new SwordBehavior())` | 20 | `Sword x2` |
| `new PowerWeapon(new FireWeapon(new SwordBehavior()))` | 28 | `Sword + fire x2` |
| `new FireWeapon(new PowerWeapon(new SwordBehavior()))` | 24 | `Sword x2 + fire` |
| `new FireWeapon(new FireWeapon(new SwordBehavior()))` | 18 | `Sword + fire + fire` |

Compute from the innermost object outward. These particular effects depend on order because adding four and doubling do not produce the same result in both orders.

## Scope assumptions

All homework examples and public checks use valid character names, non-null weapons, non-null observers, and damage values small enough to avoid integer overflow. Keep the supplied validation unchanged.

Observers do not override `equals`, do not change registrations or weapons while an attack is being published, and do not throw exceptions from `update`. Notification order is not graded. No concurrency or exception-recovery mechanism is required.

Weapon methods may be called repeatedly. The supplied test doubles can count calls or return changing values to check that your code actually delegates. You do not need to write test doubles or JUnit assertions.

## Run the public tests

1. Open `Hw3PublicTest.java` in IntelliJ.
2. Run the **entire class**, using the run icon beside the class declaration or the class-level Run command.
3. Confirm that the results show **30 tests**. Running one method is not a full-suite result.
4. Read the failed test names and assertion messages, fix the corresponding TODO methods, and rerun the entire class.
5. When finished, run `GameDemo` as an additional demonstration.

The test names are grouped by Strategy, Observer, and Decorator, with ten tests in each group. Each passing test contributes two implementation points. All 30 passing earns 60/60. For example, 23 passing tests earns 46/60. Only this unchanged public suite is used for these points.

## Submit through the quiz

### Questions 1 through 10

Answer the conceptual questions. Unless a question describes a defect, assume the implementation satisfies this specification.

### Question 11 JUnit screenshot

Run the entire `Hw3PublicTest` class against your final code. Attach one clear PNG or JPG screenshot showing:

- The `Hw3PublicTest` class name and your HW3 project context.
- The overall result with 30 tests and the number passed and failed.
- The test-results panel, with failed tests expanded when applicable.

If tests still fail, submit your actual results for partial credit. Do not omit the screenshot or modify, disable, or remove supplied tests.

### Question 12 GitHub link

Commit and push your work to your existing course repository. Paste the link to `src/homework/hw03`. A repository link is acceptable if you also give the folder path.

Your repository must contain your completed `GameCharacter.java`, `FireWeapon.java`, and `PowerWeapon.java`, together with all supplied HW3 files. Make sure the instructor has access.

The ten GitHub points are for an accessible link and clear folder path (4), the three implementation files being committed and pushed (4), and all supplied support files and public tests being present and unchanged (2). Functional correctness is scored through the public tests in Question 11.

**The screenshot and GitHub submission must represent the same code version.** If you change the code after taking your screenshot, rerun the suite and replace the screenshot.
