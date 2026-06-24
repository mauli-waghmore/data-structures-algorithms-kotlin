package strings.slidingwindow

/**
 * Longest Substring with At Most K Distinct Characters
 * ----------------------------------------------------
 * Given a string `str` and an integer `k`, return the length of the longest
 * substring containing at most `k` distinct characters.
 *
 * Example:
 *   str = "aababbcaacc", k = 2
 *   Output: 6
 *
 * Explanation:
 *   The longest substring containing at most two distinct characters is
 *   "aababb".
 *   Its length is 6.
 *
 * Another Example:
 *   str = "abcddefg", k = 3
 *   Output: 4
 *
 * Explanation:
 *   The longest substring containing at most three distinct characters is
 *   "bcdd".
 *   Its length is 4.
 *
 * Approach:  Use a sliding window and a frequency map to track the characters
 *            present in the current window.
 *
 *            Expand the window by moving the right pointer. When the number of
 *            distinct characters becomes greater than `k`, shrink the window
 *            from the left until the window contains at most `k` distinct
 *            characters again.
 *
 * Time:      O(n) — each character is added to and removed from the window at
 *            most once.
 *
 * Space:     O(k) — the frequency map stores at most `k + 1` distinct
 *            characters during processing.
 */

fun longestSubstringKDistinct(str: String, k: Int): Int {
    if (k == 0 || str.isEmpty()) return 0

    val freq = mutableMapOf<Char, Int>()

    var left = 0
    var maxLength = 0

    for (right in str.indices) {
        val currentChar = str[right]

        freq[currentChar] = freq.getOrDefault(currentChar, 0) + 1

        while (freq.size > k) {
            val leftChar = str[left]

            freq[leftChar] = freq.getValue(leftChar) - 1

            if (freq[leftChar] == 0) {
                freq.remove(leftChar)
            }

            left++
        }

        maxLength = maxOf(maxLength, right - left + 1)
    }

    return maxLength
}

fun main() {
    val str = "aababbcaacc"
    val k = 2

    println("Input String:")
    println(str)

    println("\nK:")
    println(k)

    println("\nLongest Substring with At Most K Distinct Characters:")
    println(longestSubstringKDistinct(str, k))
}
