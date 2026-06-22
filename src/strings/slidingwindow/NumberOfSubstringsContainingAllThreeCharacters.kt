package strings.slidingwindow

/**
 * Number of Substrings Containing All Three Characters
 * ----------------------------------------------------
 * Given a string `s` consisting only of the characters 'a', 'b', and 'c',
 * return the number of substrings that contain at least one occurrence of
 * all three characters.
 *
 * Example:
 *   s = "abcba"
 *   Output: 5
 *
 * Explanation:
 *   The valid substrings are:
 *   "abc", "abcb", "abcba", "bcba", and "cba".
 *
 * Another Example:
 *   s = "ccabcc"
 *   Output: 8
 *
 * Explanation:
 *   The valid substrings are:
 *   "ccab", "ccabc", "ccabcc", "cab",
 *   "cabc", "cabcc", "abc", and "abcc".
 *
 * Approach:  Use a sliding window with a frequency array of size 3 to track
 *            the counts of 'a', 'b', and 'c' in the current window.
 *
 *            Expand the window using the right pointer.
 *
 *            When the window contains all three characters, every substring
 *            starting at the current `left` position and ending at `right`
 *            or any index after `right` is valid.
 *
 *            Therefore, add:
 *
 *            s.length - right
 *
 *            Then shrink the window from the left and continue checking for
 *            more valid starting positions.
 *
 * Time:      O(n) — each character is added to and removed from the window
 *            at most once.
 *
 * Space:     O(1) — only three character frequencies are stored.
 */

fun numberOfSubStrings(str: String): Int {
    val freq = IntArray(3)

    var left = 0
    var result = 0

    for (right in str.indices) {
        freq[str[right] - 'a']++

        while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
            result += str.length - right

            freq[str[left] - 'a']--
            left++
        }
    }

    return result
}

fun main() {
    val str = "abcabcacc"

    println("Input String:")
    println(str)

    println("\nNumber of Substrings Containing All Three Characters:")
    println(numberOfSubStrings(str))
}
