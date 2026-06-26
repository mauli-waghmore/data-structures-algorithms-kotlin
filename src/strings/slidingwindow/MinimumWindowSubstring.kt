package strings.slidingwindow

/**
 * Minimum Window Substring
 * ------------------------
 * Given two strings `s` and `t`, return the smallest substring of `s` that
 * contains every character of `t`, including duplicate characters.
 *
 * If no valid substring exists, return an empty string.
 *
 * Example:
 *   s = "ADOBECODEBANC"
 *   t = "ABC"
 *   Output: "BANC"
 *
 * Explanation:
 *   "BANC" is the smallest substring containing `A`, `B`, and `C`.
 *
 * Another Example:
 *   s = "a"
 *   t = "aa"
 *   Output: ""
 *
 * Explanation:
 *   The string `s` contains only one `a`, but `t` requires two occurrences.
 *
 * Approach:  Use a sliding window with two frequency arrays.
 *
 *            The `required` array stores the frequency of every character
 *            needed from `t`.
 *
 *            The `window` array stores the frequency of characters currently
 *            present between the left and right pointers.
 *
 *            Expand the window by moving the right pointer. When a newly added
 *            character is still required, increase `matched`.
 *
 *            Once `matched` becomes equal to `t.length`, the current window
 *            contains every required character. Shrink it from the left while
 *            it remains valid and record the smallest valid window.
 *
 * Time:      O(m + n) — where `m` is the length of `s` and `n` is the length
 *            of `t`. Each character is added to and removed from the window
 *            at most once.
 *
 * Space:     O(1) — the two frequency arrays always have a fixed size of 52
 *            for uppercase and lowercase English letters.
 */

fun minimumWindowSubstring(s: String, t: String): String {
    if (t.length > s.length) return ""

    val required = IntArray(52)
    val window = IntArray(52)

    for (ch in t) {
        required[indexOf(ch)]++
    }

    var left = 0
    var matched = 0

    var minimumStart = 0
    var minimumLength = Int.MAX_VALUE

    for (right in s.indices) {
        val rightIndex = indexOf(s[right])

        window[rightIndex]++

        if (window[rightIndex] <= required[rightIndex]) {
            matched++
        }

        while (matched == t.length) {
            val currentLength = right - left + 1

            if (currentLength < minimumLength) {
                minimumLength = currentLength
                minimumStart = left
            }

            val leftIndex = indexOf(s[left])

            window[leftIndex]--

            if (window[leftIndex] < required[leftIndex]) {
                matched--
            }

            left++
        }
    }

    return if (minimumLength == Int.MAX_VALUE) {
        ""
    } else {
        s.substring(minimumStart, minimumStart + minimumLength)
    }
}

private fun indexOf(ch: Char): Int {
    return if (ch in 'A'..'Z') {
        ch - 'A'
    } else {
        26 + (ch - 'a')
    }
}

fun main() {
    val s = "ADOBECODEBANC"
    val t = "ABC"

    println("Input String:")
    println(s)

    println("\nTarget String:")
    println(t)

    println("\nMinimum Window Substring:")
    println(minimumWindowSubstring(s, t))
}
