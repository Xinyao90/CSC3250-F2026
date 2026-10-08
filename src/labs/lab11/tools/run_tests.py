"""Run public tests without Maven. Requires Python 3, JDK 17+, and the JUnit JAR."""
from pathlib import Path
import argparse, subprocess, sys, tempfile
parser = argparse.ArgumentParser()
parser.add_argument("junit_jar", type=Path, help="Path to junit-platform-console-standalone-1.10.2.jar")
parser.add_argument("--lab", choices=["11"], default="11")
args = parser.parse_args()
jar = args.junit_jar.expanduser().resolve()
if not jar.is_file(): parser.error("JUnit JAR does not exist: " + str(jar))
root = Path(__file__).resolve().parents[1]
labs = [args.lab]
files = [p for lab in labs for folder in ["src", "test"] for p in (root/folder/"labs"/("lab"+lab)).rglob("*.java")]
try:
    with tempfile.TemporaryDirectory(prefix="csc3250-tests-") as tmp:
        # Argument file avoids long command lines and keeps build output out of the repo.
        argfile = Path(tmp)/"sources.txt"
        argfile.write_text("\n".join('"'+str(p).replace("\\", "/")+'"' for p in files), encoding="utf-8")
        subprocess.run(["javac", "--release", "17", "-encoding", "UTF-8", "-cp", str(jar), "-d", tmp, "@"+str(argfile)], check=True)
        result = subprocess.run(["java", "-jar", str(jar), "execute", "--class-path", tmp,
            "--scan-class-path", "--disable-banner", "--details", "summary"])
        sys.exit(result.returncode)
except FileNotFoundError:
    parser.exit(2, "Java tools not found. Install/configure a JDK 17+ and retry.\n")
except subprocess.CalledProcessError as exc:
    parser.exit(exc.returncode, "Compilation failed; see Java diagnostics above.\n")
