<div align="center">

# 🧩 Data Structures & Algorithms in Kotlin

##### One problem a day — clean, documented, and tested.

[![CI](https://img.shields.io/github/actions/workflow/status/mauli-waghmore/data-structures-algorithms-kotlin/ci.yml?style=flat-square&label=CI&logo=github&logoColor=white)](https://github.com/mauli-waghmore/data-structures-algorithms-kotlin/actions/workflows/ci.yml)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.0-7F52FF?style=flat-square&logo=kotlin&logoColor=white)](https://kotlinlang.org)
[![JDK](https://img.shields.io/badge/JDK-17-007396?style=flat-square&logo=openjdk&logoColor=white)](https://adoptium.net)
[![Gradle](https://img.shields.io/badge/Gradle-8.14-02303A?style=flat-square&logo=gradle&logoColor=white)](https://gradle.org)
[![License](https://img.shields.io/badge/License-MIT-3DA639?style=flat-square)](LICENSE)
[![Problems Solved](https://img.shields.io/badge/Problems%20Solved-1-success?style=flat-square)](#-progress)

[**📊 Progress**](#-progress) &nbsp;·&nbsp; [**📇 Problems**](#-problem-index) &nbsp;·&nbsp; [**🚀 Run**](#-run--test) &nbsp;·&nbsp; [**➕ Add a problem**](#-adding-a-problem)

</div>

---

## 📊 Progress

<!-- STATS:START -->
<div align="center">

| &nbsp;🧮 Solved&nbsp; | &nbsp;🔥 Current streak&nbsp; | &nbsp;🏆 Longest streak&nbsp; | &nbsp;🗓️ Active (30d)&nbsp; |
|:--:|:--:|:--:|:--:|
| **`1`** | **`0`** days | **`0`** days | **`0`** / 30 |

**🔥 Daily activity** &nbsp;·&nbsp; <sub>2026-05-19 → 2026-06-17</sub>

⬜⬜⬜⬜⬜⬜⬜<br>⬜⬜⬜⬜⬜⬜⬜<br>⬜⬜⬜⬜⬜⬜⬜<br>⬜⬜⬜⬜⬜⬜⬜<br>⬜🔴

<sub>🟩 solved &nbsp;·&nbsp; ⬜ missed &nbsp;·&nbsp; 🔴 today (pending)</sub>

</div>

<b>📚 Problems by category</b>

```mermaid
%%{init: {"xyChart": {"plotColorPalette": "#7F52FF"}}}%%
xychart-beta
    title "Problems by category"
    x-axis ["Strings"]
    y-axis "Solved" 0 --> 2
    bar [1]
```
<!-- STATS:END -->

<div align="center"><sub>Everything above is generated from <code>src/</code> on every push — never edited by hand.</sub></div>

## 📇 Problem index

<!-- INDEX:START -->
| #  | Date | Problem | Category | Technique | Time | Space | Tests |
|----|------|---------|----------|-----------|------|-------|-------|
| 01 | — | [Line Wrap (Word Wrap)](src/strings/greedy/LineWrap.kt) | Strings | Greedy | O(n) | O(n) | [view](test/strings/greedy/LineWrapTest.kt) |
<!-- INDEX:END -->

## 🚀 Run & test

> Requires **JDK 17+**. Gradle ships via the wrapper — no local install needed.

```bash
./gradlew test                                            # run all tests
./gradlew build                                           # compile + test
./gradlew runProblem -Pmain=strings.greedy.LineWrapKt     # run one problem's main()
```

## ➕ Adding a problem

The tracking is automatic — to log a new problem I only:

1. Add **`src/<category>/<technique>/Name.kt`** with the standard KDoc header
   (title on the first line, plus `Time:` and `Space:` lines — see [LineWrap.kt](src/strings/greedy/LineWrap.kt)).
2. Add **`test/<category>/<technique>/NameTest.kt`** with its tests.
3. Push — the streak, graph, index, badge, and version all update themselves.

<details>
<summary><b>🗂️ Project structure</b></summary>

<br>

```
data-structures-algorithms-kotlin/
├── src/<category>/<technique>/*.kt    # solutions  (package mirrors the path)
├── test/<category>/<technique>/*.kt   # tests       (mirror of src/)
├── scripts/generate_readme.py         # rebuilds the progress + index sections
├── .github/workflows/                 # CI (build + test) and progress tracking
├── build.gradle.kts                   # Gradle (Kotlin DSL); version = problem count
└── settings.gradle.kts
```

</details>

## 📜 License

MIT — see [LICENSE](LICENSE).

---

<div align="center">
<sub>⭐ Star the repo if it helps you · Built with Kotlin · One problem a day.</sub>
</div>
