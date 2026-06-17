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

🧮 **1** solved &nbsp;·&nbsp; 🔥 **0**-day streak &nbsp;·&nbsp; 🏆 **0** longest &nbsp;·&nbsp; 🗓️ **0** / 30 active

**🔥 Daily activity** &nbsp;·&nbsp; <sub>2026-05-19 → 2026-06-17</sub>

<img src="assets/activity.svg" alt="30-day activity calendar" width="320">

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
| # | Problem | Topic | Time | Space | Test | Added |
|:---:|:--|:--|:---:|:---:|:---:|:---:|
| 01 | [Line Wrap (Word Wrap)](src/strings/greedy/LineWrap.kt) | `Strings` · `Greedy` | `O(n)` | `O(n)` | [🧪](test/strings/greedy/LineWrapTest.kt) | — |
<!-- INDEX:END -->

## 🚀 Run & test

> Requires **JDK 17+**. Gradle ships via the wrapper — no local install needed.

```bash
./gradlew test                                            # run all tests
./gradlew build                                           # compile + test
./gradlew runProblem -Pmain=strings.greedy.LineWrapKt     # run one problem's main()
./gradlew reviewRandom                                    # pick a past problem to revisit 🎯
```

## ➕ Adding a problem

One command scaffolds **both** files (solution + test) from the template — no boilerplate:

```bash
./gradlew newProblem -Pid=arrays.two_pointers.TwoSum
```

That creates `src/arrays/two_pointers/TwoSum.kt` (with the KDoc header — fill in the
problem, `Time:` and `Space:`) and `test/arrays/two_pointers/TwoSumTest.kt`. Then solve it,
run `./gradlew test`, and **push** — the streak, graph, index, badge, and version all
update themselves.

<details>
<summary><b>🗂️ Project structure</b></summary>

<br>

```
data-structures-algorithms-kotlin/
├── src/<category>/<technique>/*.kt    # solutions  (package mirrors the path)
├── test/<category>/<technique>/*.kt   # tests       (mirror of src/)
├── scripts/generate_readme.py         # rebuilds the progress + index sections
├── assets/activity.svg                # generated 30-day activity calendar
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
