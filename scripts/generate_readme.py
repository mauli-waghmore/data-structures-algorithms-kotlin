#!/usr/bin/env python3
import os
import re
import subprocess
from datetime import datetime, timezone

ROOT = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
SRC = os.path.join(ROOT, "src")
README = os.path.join(ROOT, "README.md")


def prettify(name):
    return name.replace("_", " ").replace("-", " ").title()


def clean_complexity(value):
    value = value.strip()
    for sep in ("—", " - "):
        if sep in value:
            value = value.split(sep, 1)[0]
            break
    else:
        value = re.split(r"\s{2,}", value, maxsplit=1)[0]
    return value.strip() or "—"


def parse_header(path):
    title, time, space = None, "—", "—"
    in_doc = False
    with open(path, encoding="utf-8") as handle:
        for raw in handle:
            line = raw.strip()
            if "/**" in line:
                in_doc = True
                continue
            if in_doc and "*/" in line:
                break
            if not in_doc:
                continue
            if line.startswith("*"):
                line = line[1:].strip()
            if not line or set(line) <= {"-"}:
                continue
            if title is None:
                title = line
                continue
            lower = line.lower()
            if lower.startswith("time:"):
                time = clean_complexity(line.split(":", 1)[1])
            elif lower.startswith("space:"):
                space = clean_complexity(line.split(":", 1)[1])
    return title, time, space


def added_date(rel_path):
    try:
        result = subprocess.run(
            ["git", "log", "--diff-filter=A", "--follow", "--format=%as", "--", rel_path],
            cwd=ROOT, capture_output=True, text=True, check=False,
        )
        lines = [l for l in result.stdout.splitlines() if l.strip()]
        return lines[-1] if lines else ""
    except Exception:
        return ""


def collect_problems():
    problems = []
    for dirpath, _, filenames in os.walk(SRC):
        for filename in filenames:
            if not filename.endswith(".kt"):
                continue
            full = os.path.join(dirpath, filename)
            rel = os.path.relpath(full, ROOT).replace(os.sep, "/")
            parts = rel.split("/")
            if len(parts) < 4:
                continue
            category = parts[1]
            technique = parts[2]
            title, time, space = parse_header(full)
            if not title:
                title = prettify(filename[:-3])
            test_rel = "test/" + rel[len("src/"):]
            test_rel = test_rel[:-3] + "Test.kt"
            test_exists = os.path.exists(os.path.join(ROOT, test_rel))
            problems.append({
                "title": title, "time": time, "space": space,
                "category": category, "technique": technique,
                "solution": rel, "test": test_rel, "test_exists": test_exists,
                "date": added_date(rel),
            })
    problems.sort(key=lambda p: (p["date"] or "9999-99-99", p["category"], p["technique"], p["title"]))
    return problems


def build_index(problems):
    if not problems:
        return "_No problems yet — add your first one under `src/`._"
    header = (
        "| #  | Date | Problem | Category | Technique | Time | Space | Tests |\n"
        "|----|------|---------|----------|-----------|------|-------|-------|"
    )
    rows = []
    for i, p in enumerate(problems, 1):
        tests = "[view]({})".format(p["test"]) if p["test_exists"] else "—"
        rows.append("| {:02d} | {} | [{}]({}) | {} | {} | {} | {} | {} |".format(
            i, p["date"] or "—", p["title"], p["solution"],
            prettify(p["category"]), prettify(p["technique"]),
            p["time"], p["space"], tests,
        ))
    return header + "\n" + "\n".join(rows)


def build_stats(problems):
    today = datetime.now(timezone.utc).strftime("%Y-%m-%d")
    total = len(problems)
    counts = {}
    for p in problems:
        counts[p["category"]] = counts.get(p["category"], 0) + 1
    cats = sorted(counts)
    if cats:
        labels = ", ".join('"{}"'.format(prettify(c)) for c in cats)
        values = ", ".join(str(counts[c]) for c in cats)
        ymax = max(counts.values()) + 1
        graph = (
            "```mermaid\n"
            "xychart-beta\n"
            '    title "Problems solved by category"\n'
            "    x-axis [{}]\n".format(labels) +
            '    y-axis "Solved" 0 --> {}\n'.format(ymax) +
            "    bar [{}]\n".format(values) +
            "```"
        )
    else:
        graph = "_No problems yet._"
    header = "**Problems solved:** {}  ·  **Last updated:** {}".format(total, today)
    return total, header + "\n\n" + graph


def replace_region(text, name, payload):
    start = "<!-- {}:START -->".format(name)
    end = "<!-- {}:END -->".format(name)
    pattern = re.compile(re.escape(start) + ".*?" + re.escape(end), re.DOTALL)
    return pattern.sub(start + "\n" + payload + "\n" + end, text)


def main():
    problems = collect_problems()
    total, stats = build_stats(problems)
    index = build_index(problems)

    with open(README, encoding="utf-8") as handle:
        text = handle.read()

    text = replace_region(text, "STATS", stats)
    text = replace_region(text, "INDEX", index)
    text = re.sub(r"(Problems%20Solved-)\d+", lambda m: m.group(1) + str(total), text)

    with open(README, "w", encoding="utf-8") as handle:
        handle.write(text)

    print("Generated README for {} problem(s).".format(total))


if __name__ == "__main__":
    main()
