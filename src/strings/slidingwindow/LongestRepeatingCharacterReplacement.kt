package strings.slidingwindow

/**
 * Longest Repeating Character Replacement
 * ---------------------------------------
 * Given a string `s` containing only uppercase English letters and an integer
 * `k`, return the length of the longest substring that can be converted into
 * a substring containing the same letter by replacing at most `k` characters.
 *
 * Example:
 *   s = "AABABBA", k = 1
 *   Output: 4
 *
 * Explanation:
 *   We can replace one 'A' to get the substring "BBBB".
 *   The longest substring with the same character has length 4.
 *
 * Another Example:
 *   s = "BAABAABBBAAA", k = 2
 *   Output: 6
 *
 * Explanation:
 *   We can change two 'B' characters to 'A' and get a substring "AAAAAA".
 *
 * Approach:  sliding window with a frequency map/array to track character
 *            counts in the current window. Keep the count of the most frequent
 *            character. If the number of replacements needed
 *            `(window size - max frequency)` becomes greater than `k`, shrink
 *            the window from the left.
 *
 * Time:      O(n) — each character is added to and removed from the window at
 *            most once.
 * Space:     O(1) — only 26 uppercase English letter counts are stored.
 */

fun characterReplacement(s: String, k: Int): Int {
    val freq = HashMap<Char, Int>()

    var left = 0
    var maxFreq = 0
    var maxLen = 0

    for (right in s.indices) {
        freq[s[right]] = freq.getOrDefault(s[right], 0) + 1

        maxFreq = maxOf(maxFreq, freq[s[right]]!!)

        while ((right - left + 1) - maxFreq > k) {
            freq[s[left]] = freq[s[left]]!! - 1
            left++
        }

        maxLen = maxOf(maxLen, right - left + 1)
    }

    return maxLen
}

fun main() {
    val s = "AABABBA"
    val k = 1

    println("Input String:")
    println(s)

    println("\nK:")
    println(k)

    println("\nLongest Repeating Character Replacement:")
    println(characterReplacement(s, k))
}
