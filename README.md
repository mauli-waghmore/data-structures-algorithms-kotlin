<div align="center">

# 🧩 Data Structures & Algorithms in Kotlin

##### One problem a day — clean, documented, and tested.

[![CI](https://img.shields.io/github/actions/workflow/status/mauli-waghmore/data-structures-algorithms-kotlin/ci.yml?style=flat-square&label=CI&logo=github&logoColor=white)](https://github.com/mauli-waghmore/data-structures-algorithms-kotlin/actions/workflows/ci.yml)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.0.21-7F52FF?style=flat-square&logo=kotlin&logoColor=white)](https://kotlinlang.org)
[![JDK](https://img.shields.io/badge/JDK-17-007396?style=flat-square&logo=openjdk&logoColor=white)](https://adoptium.net)
[![Gradle](https://img.shields.io/badge/Gradle-8.14.4-02303A?style=flat-square&logo=gradle&logoColor=white)](https://gradle.org)
[![License](https://img.shields.io/badge/License-MIT-3DA639?style=flat-square)](LICENSE)
[![Problems Solved](https://img.shields.io/badge/Problems%20Solved-7-success?style=flat-square)](#-progress)

[**📊 Progress**](#-progress) &nbsp;·&nbsp; [**📇 Problems**](#-problem-index) &nbsp;·&nbsp; [**🚀 Run**](#-run--test) &nbsp;·&nbsp; [**➕ Add a problem**](#-adding-a-problem)

</div>

---

## 📊 Progress

<!-- STATS:START -->
<div align="center">

🧮 **7** solved &nbsp;·&nbsp; 🔥 **7**-day streak &nbsp;·&nbsp; 🏆 **7** longest &nbsp;·&nbsp; 🗓️ **7** / 30 active

🔥 **Daily activity** &nbsp;·&nbsp; 2026-05-25 → 2026-06-23

<img src="assets/activity.svg" alt="30-day activity calendar" width="320">

</div>

<b>📚 Problems by category</b>

```mermaid
%%{init: {"xyChart": {"plotColorPalette": "#7F52FF"}}}%%
xychart-beta
    title "Problems by category"
    x-axis ["Arrays", "Strings"]
    y-axis "Solved" 0 --> 5
    bar [4, 3]
```
<!-- STATS:END -->

<div align="center"><sub>Everything above is generated from <code>src/</code> on every push — never edited by hand.</sub></div>

## 📇 Problem index

<!-- INDEX:START -->
| # | Problem | Topic | Time | Space | Test | Added |
|:---:|:--|:--|:---:|:---:|:---:|:---:|
| 01 | [Line Wrap (Word Wrap)](src/strings/greedy/LineWrap.kt) | `Strings` · `Greedy` | `O(n)` | `O(n)` | [🧪](test/strings/greedy/LineWrapTest.kt) | 2026-06-17 |
| 02 | [Fruit Into Baskets](src/arrays/slidingwindow/FruitIntoBaskets.kt) | `Arrays` · `Sliding Window` | `O(n)` | `O(1)` | [🧪](test/arrays/slidingwindow/FruitIntoBasketsTest.kt) | 2026-06-18 |
| 03 | [Longest Repeating Character Replacement](src/strings/slidingwindow/LongestRepeatingCharacterReplacement.kt) | `Strings` · `Sliding Window` | `O(n)` | `O(1)` | [🧪](test/strings/slidingwindow/LongestRepeatingCharacterReplacementTest.kt) | 2026-06-19 |
| 04 | [Binary Subarray With Sum](src/arrays/slidingwindow/BinarySubarrayWithSum.kt) | `Arrays` · `Sliding Window` | `O(n)` | `O(1)` | [🧪](test/arrays/slidingwindow/BinarySubarrayWithSumTest.kt) | 2026-06-20 |
| 05 | [Count Number of Nice Subarrays](src/arrays/slidingwindow/CountNumberOfNiceSubarrays.kt) | `Arrays` · `Sliding Window` | `O(n)` | `O(1)` | [🧪](test/arrays/slidingwindow/CountNumberOfNiceSubarraysTest.kt) | 2026-06-21 |
| 06 | [Number of Substrings Containing All Three Characters](src/strings/slidingwindow/NumberOfSubstringsContainingAllThreeCharacters.kt) | `Strings` · `Sliding Window` | `O(n)` | `O(1)` | [🧪](test/strings/slidingwindow/NumberOfSubstringsContainingAllThreeCharactersTest.kt) | 2026-06-22 |
| 07 | [Maximum Points You Can Obtain from Cards](src/arrays/slidingwindow/MaximumPointsYouCanObtainFromCards.kt) | `Arrays` · `Sliding Window` | `O(k)` | `O(1)` | [🧪](test/arrays/slidingwindow/MaximumPointsYouCanObtainFromCardsTest.kt) | 2026-06-23 |
<!-- INDEX:END -->

## 🚀 Run & test

> Requires **JDK 17+**. Gradle ships via the wrapper — no local install needed.

```bash
./gradlew test                                            # run all tests
./gradlew build                                           # compile + test
python3 scripts/generate_readme.py --check                # verify generated README sections
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
run `./gradlew build` and `python3 scripts/generate_readme.py --check`, and **push** — the
streak, graph, index, badge, and version all update themselves.

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
