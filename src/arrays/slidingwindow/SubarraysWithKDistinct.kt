package arrays.slidingwindow

/**
 * Subarray with K Different Integers
 * ----------------------------------
 * Given an integer array `nums` and an integer `k`, return the number of
 * contiguous subarrays that contain exactly `k` distinct integers.
 *
 * A good subarray is a contiguous part of the array containing exactly
 * `k` different integers.
 *
 * Example:
 *   nums = [1, 2, 1, 2, 3], k = 2
 *   Output: 7
 *
 * Explanation:
 *   The 7 subarrays containing exactly 2 distinct integers are:
 *   [1, 2], [2, 1], [1, 2], [2, 3],
 *   [1, 2, 1], [2, 1, 2], [1, 2, 1, 2]
 *
 * Another Example:
 *   nums = [1, 2, 1, 3, 4], k = 3
 *   Output: 3
 *
 * Explanation:
 *   The 3 subarrays containing exactly 3 distinct integers are:
 *   [1, 2, 1, 3], [2, 1, 3], [1, 3, 4]
 *
 * Approach:  Count the number of subarrays containing at most `k`
 *            distinct integers.
 *
 *            Then count the number of subarrays containing at most
 *            `k - 1` distinct integers.
 *
 *            Subtract the two results:
 *
 *            exactly k distinct
 *            = at most k distinct - at most k - 1 distinct
 *
 *            A sliding window is used to count subarrays with at most
 *            a given number of distinct integers.
 *
 *            For every right boundary, shrink the left boundary until
 *            the window becomes valid.
 *
 *            The number of valid subarrays ending at `right` is:
 *
 *            right - left + 1
 *
 * Time:      O(n) — each element enters and leaves the window at most once.
 *
 * Space:     O(n) — the frequency map may store up to `n` distinct values.
 */

private fun atMostK(nums: IntArray, k: Int): Int {
    if (k < 0) return 0

    val frequency = mutableMapOf<Int, Int>()
    var remainingDistinct = k
    var left = 0
    var count = 0

    for (right in nums.indices) {
        val current = nums[right]

        frequency[current] = frequency.getOrDefault(current, 0) + 1

        if (frequency[current] == 1) {
            remainingDistinct--
        }

        while (remainingDistinct < 0) {
            val leftValue = nums[left]

            frequency[leftValue] = frequency.getValue(leftValue) - 1

            if (frequency[leftValue] == 0) {
                remainingDistinct++
                frequency.remove(leftValue)
            }

            left++
        }

        count += right - left + 1
    }

    return count
}

fun subarraysWithKDistinct(nums: IntArray, k: Int): Int {
    return atMostK(nums, k) - atMostK(nums, k - 1)
}

fun main() {
    val nums = intArrayOf(1, 2, 1, 2, 3)
    val k = 2

    println("Input Array:")
    println(nums.joinToString(prefix = "[", postfix = "]"))

    println("\nNumber of Distinct Integers:")
    println(k)

    println("\nNumber of Good Subarrays:")
    println(subarraysWithKDistinct(nums, k))
}
