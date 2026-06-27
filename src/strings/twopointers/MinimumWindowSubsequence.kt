package strings.twopointers

/**
 * Minimum Window Subsequence
 * --------------------------
 * Given two strings `s1` and `s2`, return the minimum window substring of `s1`
 * such that `s2` is a subsequence of that window.
 *
 * If there is no such window, return an empty string.
 *
 * Example:
 *   s1 = "abcdebdde", s2 = "bde"
 *   Output: "bcde"
 *
 * Explanation:
 *   The substring "bcde" contains "bde" as a subsequence.
 *
 *   b c d e
 *   |   | |
 *   b   d e
 *
 *   Another valid window is "bdde", but "bcde" appears earlier with the same
 *   length, so we return "bcde".
 *
 * Another Example:
 *   s1 = "fgrqsqsnodwmxzkzxwqegkndaa", s2 = "kzed"
 *   Output: "kzxwqegknd"
 *
 * Explanation:
 *   The substring "kzxwqegknd" contains "kzed" as a subsequence.
 *
 *   k z x w q e g k n d
 *   | |       |       |
 *   k z       e       d
 *
 * Approach:  Use two pointers to first move forward and find a valid window
 *            where `s2` appears as a subsequence in `s1`.
 *
 *            Once a valid window is found, move backward from the end of that
 *            window to shrink it as much as possible.
 *
 *            After shrinking, update the minimum window answer and continue
 *            searching from the next possible start position.
 *
 * Time:      O(n * m) in the worst case, where `n` is the length of `s1`
 *            and `m` is the length of `s2`.
 *
 * Space:     O(1) — no extra data structure is used.
 */

fun minWindow(s1: String, s2: String): String {
    if (s1.isEmpty() || s2.isEmpty()) return ""

    val n = s1.length
    val m = s2.length

    var i = 0
    var startIndex = -1
    var minLen = Int.MAX_VALUE

    while (i < n) {
        var j = 0

        while (i < n) {
            if (s1[i] == s2[j]) {
                j++

                if (j == m) {
                    break
                }
            }

            i++
        }

        if (j < m) break

        val end = i
        j = m - 1

        while (i >= 0) {
            if (s1[i] == s2[j]) {
                j--

                if (j < 0) {
                    break
                }
            }

            i--
        }

        val start = i
        val windowLen = end - start + 1

        if (windowLen < minLen) {
            minLen = windowLen
            startIndex = start
        }

        i = start + 1
    }

    return if (startIndex == -1) "" else s1.substring(startIndex, startIndex + minLen)
}

fun main() {
    val s1 = "abcdebdde"
    val s2 = "bde"

    println("Input String 1:")
    println(s1)

    println("\nInput String 2:")
    println(s2)

    println("\nMinimum Window Subsequence:")
    println(minWindow(s1, s2))
}
