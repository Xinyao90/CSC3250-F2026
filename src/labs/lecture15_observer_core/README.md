# Lab 15 — Observer registry and lifecycle

Complete registerObserver, removeObserver, and notifyObservers in WeatherData. The sample-setting path and RecordingObserver are supplied.

Inside `starter`: `javac *.java`, `java RegistryDemo`, `java RegistryChecks`.

Expected demo: first has count 2 and last temperature 82; second has count 2 and last temperature 78. The solution passes 10 visible checks.

Submit code, successful console evidence, a subscription/event trace, and UML showing Subject, Observer, WeatherData, and RecordingObserver. No concrete-observer branches are allowed in the source loop. No JUnit is required.

## Policies for the minimal example
One thread; non-null observers; each object registered at most once; no changes to subscriptions or source state during callbacks; callbacks return normally. Registration sends no initial snapshot and replays no history. Removal does not destroy or reset an observer. The pattern alone does not guarantee ordering, delivery isolation, thread safety, or replay.

The instructor keeps a separate reference solution.
