#!/usr/bin/env bash
# Run only HW2. Requires a JDK with javac and java on PATH; no JUnit download.
set -euo pipefail
SCRIPT_DIR="$(cd -- "$(dirname -- "${BASH_SOURCE[0]}")" && pwd)"
ROOT="$(cd -- "$SCRIPT_DIR/../.." && pwd)"
BUILD="$SCRIPT_DIR/.build"
for tool in javac java; do
    if ! command -v "$tool" >/dev/null 2>&1; then
        printf 'Missing %s. Install/configure a JDK and reopen your terminal.\n' "$tool" >&2
        exit 2
    fi
done
mkdir -p "$BUILD"
# Only remove the known HW2 class directory, never source or other coursework.
rm -rf "$BUILD/homework/hw02"
javac -encoding UTF-8 -d "$BUILD" \
    "$ROOT"/src/homework/hw02/*.java \
    "$ROOT/test/homework/hw02/Hw2Checks.java" \
    "$ROOT/test/homework/hw02/Hw2CheckRunner.java"
java -cp "$BUILD" homework.hw02.Hw2CheckRunner
