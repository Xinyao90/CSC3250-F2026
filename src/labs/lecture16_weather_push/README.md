# Lab 22 — Weather Station (push)

Compile this project separately from the other version. Both use the same class names with different callback contracts.

Inside `starter`: `javac *.java`, `java WeatherStation`, `java WeatherChecks`.

Complete each concrete display's update method. For pull, also complete the subject's no-argument callback invocation. Preserve the supplied fields, getters, display methods, and sample-setting order. The complete solution passes 12 visible checks.

Use the lecture's sample table to predict each observer's state for (80,65,30.4), (82,70,29.2), and (78,90,29.2). Forecast then unsubscribes before (62,90,28.1), so only current conditions and statistics print for the fourth sample.

Deliver code, successful checks, a call-flow diagram for each version, and an explanation comparing callback arguments with callback-triggered getter calls. No JUnit is required.

Classroom adaptations: explicit imports, protected/non-null safeguards where stated, first-reading initialization of statistics bounds, simplified console output, inspection getters and counters for visible checks. The forecast is a toy pressure-trend rule, not real meteorological advice.

## Policies for the minimal example
One thread; non-null observers; each object registered at most once; no changes to subscriptions or source state during callbacks; callbacks return normally. Registration sends no initial snapshot and replays no history. Removal does not destroy or reset an observer. The pattern alone does not guarantee ordering, delivery isolation, thread safety, or replay.

The instructor keeps a separate reference solution.
