#!/usr/bin/env python3
import argparse
import os
import re
import subprocess
import sys
from datetime import datetime, timezone, date, timedelta

ROOT = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
SRC = os.path.join(ROOT, "src")
README = os.path.join(ROOT, "README.md")
ACTIVITY_SVG = os.path.join(ROOT, "assets", "activity.svg")

WINDOW_DAYS = 30
PRETTY_NAMES = {
    "binarysearch": "Binary Search",
    "linkedlist": "Linked List",
    "slidingwindow": "Sliding Window",
    "twopointers": "Two Pointers",
}


def prettify(name):
    if name in PRETTY_NAMES:
        return PRETTY_NAMES[name]
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


def markdown_cell(value):
    return value.replace("\\", "\\\\").replace("|", "\\|").replace("\n", " ")


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


def active_dates(problems):
    days = set()
    for p in problems:
        if p["date"]:
            try:
                days.add(date.fromisoformat(p["date"]))
            except ValueError:
                pass
    return days


def current_streak(days, today):
    cursor = today if today in days else today - timedelta(days=1)
    streak = 0
    while cursor in days:
        streak += 1
        cursor -= timedelta(days=1)
    return streak


def longest_streak(days):
    best = 0
    for d in days:
        if d - timedelta(days=1) in days:
            continue
        length, cursor = 0, d
        while cursor in days:
            length += 1
            cursor += timedelta(days=1)
        best = max(best, length)
    return best


def category_graph(problems):
    counts = {}
    for p in problems:
        counts[p["category"]] = counts.get(p["category"], 0) + 1
    cats = sorted(counts)
    if not cats:
        return "_No problems yet — add your first one under `src/`._"
    labels = ", ".join('"' + prettify(c) + '"' for c in cats)
    values = ", ".join(str(counts[c]) for c in cats)
    ymax = max(counts.values()) + 1
    init = '%%{init: {"xyChart": {"plotColorPalette": "#7F52FF"}}}%%'
    return (
        "```mermaid\n"
        + init + "\n"
        + "xychart-beta\n"
        + '    title "Problems by category"\n'
        + "    x-axis [" + labels + "]\n"
        + '    y-axis "Solved" 0 --> ' + str(ymax) + "\n"
        + "    bar [" + values + "]\n"
        + "```"
    )


CELL = 16
GAP = 4
PAD = 6
TOP = 20
WEEKDAYS = ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"]
CELL_STYLE = {
    "solved": ("#39d353", "1"),
    "missed": ("#3f4650", "1"),
    "out": ("#1f242d", "1"),
}
TODAY_STROKE = "#f0f6fc"


def day_status(day, days, today, window_start):
    if day < window_start or day > today:
        return "out"
    if day in days:
        return "solved"
    return "missed"


FONT = "-apple-system,Segoe UI,Helvetica,Arial,sans-serif"
LEGEND = [("solved", "solved"), ("missed", "missed"), ("today", "today")]


def activity_svg(days, today):
    window_start = today - timedelta(days=WINDOW_DAYS - 1)
    grid_start = window_start - timedelta(days=window_start.weekday())
    grid_end = today + timedelta(days=6 - today.weekday())

    weeks = []
    week = grid_start
    while week <= grid_end:
        weeks.append([
            (week + timedelta(days=i), day_status(week + timedelta(days=i), days, today, window_start))
            for i in range(7)
        ])
        week += timedelta(days=7)

    rows = len(weeks)
    grid_w = 7 * CELL + 6 * GAP
    grid_h = rows * CELL + (rows - 1) * GAP

    swatch, label_gap, item_gap, char_w = 11, 5, 18, 5.6
    item_w = [swatch + label_gap + len(label) * char_w for _, label in LEGEND]
    legend_w = sum(item_w) + item_gap * (len(LEGEND) - 1)

    content_w = max(grid_w, legend_w)
    width = PAD * 2 + content_w
    legend_gap, legend_h = 16, 16
    height = TOP + grid_h + legend_gap + legend_h + PAD

    grid_x = PAD + (content_w - grid_w) / 2
    legend_x = PAD + (content_w - legend_w) / 2
    legend_y = TOP + grid_h + legend_gap

    out = [
        '<svg xmlns="http://www.w3.org/2000/svg" width="{:.0f}" height="{:.0f}" '
        'viewBox="0 0 {:.0f} {:.0f}" role="img" aria-label="30-day activity">'.format(width, height, width, height)
    ]
    for col, label in enumerate(WEEKDAYS):
        x = grid_x + col * (CELL + GAP) + CELL / 2
        out.append(
            '<text x="{:.1f}" y="13" text-anchor="middle" font-family="{}" '
            'font-size="9" fill="#8b949e">{}</text>'.format(x, FONT, label)
        )
    for r, days_row in enumerate(weeks):
        for c, (day, status) in enumerate(days_row):
            fill, opacity = CELL_STYLE[status]
            x = grid_x + c * (CELL + GAP)
            y = TOP + r * (CELL + GAP)
            out.append(
                '<rect x="{:.1f}" y="{}" width="{}" height="{}" rx="3" fill="{}" opacity="{}"/>'.format(
                    x, y, CELL, CELL, fill, opacity
                )
            )
            if day == today:
                out.append(
                    '<rect x="{:.1f}" y="{:.1f}" width="{}" height="{}" rx="3" fill="none" '
                    'stroke="{}" stroke-width="1.5"/>'.format(
                        x + 0.75, y + 0.75, CELL - 1.5, CELL - 1.5, TODAY_STROKE
                    )
                )
    lx = legend_x
    for i, (status, label) in enumerate(LEGEND):
        if status == "today":
            out.append(
                '<rect x="{:.1f}" y="{:.1f}" width="{}" height="{}" rx="2.5" fill="none" '
                'stroke="{}" stroke-width="1.5"/>'.format(
                    lx + 0.75, legend_y + 0.75, swatch - 1.5, swatch - 1.5, TODAY_STROKE
                )
            )
        else:
            fill, opacity = CELL_STYLE[status]
            out.append(
                '<rect x="{:.1f}" y="{:.1f}" width="{}" height="{}" rx="2.5" fill="{}" opacity="{}"/>'.format(
                    lx, legend_y, swatch, swatch, fill, opacity
                )
            )
        out.append(
            '<text x="{:.1f}" y="{:.1f}" font-family="{}" font-size="10" fill="#8b949e">{}</text>'.format(
                lx + swatch + label_gap, legend_y + swatch - 1, FONT, label
            )
        )
        lx += item_w[i] + item_gap
    out.append("</svg>")
    return "\n".join(out) + "\n", window_start, today


def plural(n):
    return "" if n == 1 else "s"


def build_progress(problems, today=None):
    if today is None:
        today = datetime.now(timezone.utc).date()
    total = len(problems)
    days = active_dates(problems)

    streak = current_streak(days, today)
    longest = longest_streak(days)
    active_in_window = sum(1 for d in days if 0 <= (today - d).days < WINDOW_DAYS)

    svg, start, end = activity_svg(days, today)

    stat_line = (
        "🧮 **{}** solved &nbsp;·&nbsp; 🔥 **{}**-day streak "
        "&nbsp;·&nbsp; 🏆 **{}** longest &nbsp;·&nbsp; 🗓️ **{}** / 30 active"
    ).format(total, streak, longest, active_in_window)

    dashboard = (
        "<div align=\"center\">\n\n"
        + stat_line + "\n\n"
        + "🔥 **Daily activity** &nbsp;·&nbsp; " + start.isoformat() + " → " + end.isoformat() + "\n\n"
        + '<img src="assets/activity.svg" alt="30-day activity calendar" width="320">\n\n'
        + "</div>"
    )

    by_category = "<b>📚 Problems by category</b>\n\n" + category_graph(problems)

    return total, dashboard + "\n\n" + by_category, svg


def build_index(problems):
    if not problems:
        return "_No problems yet — create one with_ `./gradlew newProblem -Pid=category.technique.Name`"
    header = (
        "| # | Problem | Topic | Time | Space | Test | Added |\n"
        "|:---:|:--|:--|:---:|:---:|:---:|:---:|"
    )
    rows = []
    for i, p in enumerate(problems, 1):
        test = "[🧪]({})".format(p["test"]) if p["test_exists"] else "—"
        topic = "`{}` · `{}`".format(prettify(p["category"]), prettify(p["technique"]))
        rows.append("| {:02d} | [{}]({}) | {} | `{}` | `{}` | {} | {} |".format(
            i,
            markdown_cell(p["title"]),
            p["solution"],
            topic,
            markdown_cell(p["time"]),
            markdown_cell(p["space"]),
            test,
            p["date"] or "—",
        ))
    return header + "\n" + "\n".join(rows)


def replace_region(text, name, payload):
    start = "<!-- {}:START -->".format(name)
    end = "<!-- {}:END -->".format(name)
    pattern = re.compile(re.escape(start) + ".*?" + re.escape(end), re.DOTALL)
    updated, count = pattern.subn(start + "\n" + payload + "\n" + end, text)
    if count != 1:
        raise RuntimeError("Expected exactly one {} region in README.md.".format(name))
    return updated


def read_readme():
    with open(README, encoding="utf-8") as handle:
        return handle.read()


def readme_activity_end(text):
    match = re.search(r"\d{4}-\d{2}-\d{2}\s+(?:→|->)\s+(\d{4}-\d{2}-\d{2})", text)
    if not match:
        return None
    return date.fromisoformat(match.group(1))


def generate(readme_text=None, today=None):
    problems = collect_problems()
    total, progress, svg = build_progress(problems, today=today)
    index = build_index(problems)

    text = readme_text if readme_text is not None else read_readme()

    text = replace_region(text, "STATS", progress)
    text = replace_region(text, "INDEX", index)
    text = re.sub(r"(Problems%20Solved-)\d+", lambda m: m.group(1) + str(total), text)

    return text, svg, total


def main():
    parser = argparse.ArgumentParser(description="Generate README progress, index, and activity SVG.")
    parser.add_argument("--check", action="store_true", help="fail if generated files are not up to date")
    args = parser.parse_args()

    if args.check:
        current_readme = read_readme()
        text, svg, total = generate(current_readme, today=readme_activity_end(current_readme))
        if os.path.exists(ACTIVITY_SVG):
            with open(ACTIVITY_SVG, encoding="utf-8") as handle:
                current_svg = handle.read()
        else:
            current_svg = ""
        if current_readme != text or current_svg != svg:
            print("README.md or assets/activity.svg is out of date. Run: python3 scripts/generate_readme.py", file=sys.stderr)
            return 1
        print("README.md and assets/activity.svg are up to date for {} problem(s).".format(total))
        return 0

    text, svg, total = generate()

    with open(README, "w", encoding="utf-8") as handle:
        handle.write(text)

    os.makedirs(os.path.dirname(ACTIVITY_SVG), exist_ok=True)
    with open(ACTIVITY_SVG, "w", encoding="utf-8") as handle:
        handle.write(svg)

    print("Generated README + assets/activity.svg for {} problem(s).".format(total))
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
