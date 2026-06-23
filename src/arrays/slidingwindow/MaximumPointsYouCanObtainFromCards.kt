package arrays.slidingwindow

/**
 * Maximum Points You Can Obtain from Cards
 * ----------------------------------------
 * Given an integer array `cardScore`, where each element represents the score
 * of a card arranged in a row, choose exactly `k` cards.
 *
 * In each step, a card can be chosen either from the beginning or the end
 * of the row.
 *
 * Return the maximum total score that can be obtained.
 *
 * Example:
 *   cardScore = [1, 2, 3, 4, 5, 6], k = 3
 *   Output: 15
 *
 * Explanation:
 *   Choosing the three rightmost cards gives the maximum score:
 *   4 + 5 + 6 = 15.
 *
 * Another Example:
 *   cardScore = [5, 4, 1, 8, 7, 1, 3], k = 3
 *   Output: 12
 *
 * Explanation:
 *   Choose the first two cards from the beginning and one card from the end:
 *   5 + 4 + 3 = 12.
 *
 * Approach:  Start by taking the first `k` cards from the beginning and
 *            calculate their total score.
 *
 *            Then, one card at a time, remove a card from the right side of
 *            the selected prefix and replace it with a card from the end of
 *            the array.
 *
 *            This checks every possible combination:
 *
 *            - k cards from the beginning and 0 from the end
 *            - k - 1 cards from the beginning and 1 from the end
 *            - k - 2 cards from the beginning and 2 from the end
 *            - ...
 *            - 0 cards from the beginning and k from the end
 *
 *            Track the maximum score among all combinations.
 *
 * Time:      O(k) — at most `k` combinations are checked.
 *
 * Space:     O(1) — only a few variables are used.
 */

fun maxScore(cards: IntArray, k: Int): Int {
    val n = cards.size
    var total = 0

    for (i in 0..<k) {
        total += cards[i]
    }

    var maxPoints = total

    for (i in 0..<k) {
        total -= cards[k - 1 - i]
        total += cards[n - 1 - i]

        maxPoints = maxOf(maxPoints, total)
    }

    return maxPoints
}

fun main() {
    val cards = intArrayOf(1, 2, 3, 4, 5, 6, 1)
    val k = 3

    println("Input Cards:")
    println(cards.joinToString(prefix = "[", postfix = "]"))

    println("\nNumber of Cards to Pick:")
    println(k)

    println("\nMaximum Score:")
    println(maxScore(cards, k))
}
