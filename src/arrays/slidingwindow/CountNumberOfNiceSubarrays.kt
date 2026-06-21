package arrays.slidingwindow

/**
 * Count Number of Nice Subarrays
 * ------------------------------
 * Given an integer array `nums` and an integer `k`, return the number of
 * non-empty subarrays that contain exactly `k` odd numbers.
 *
 * A subarray is a contiguous part of the array.
 *
 * Example 1:
 *   nums = [1, 1, 2, 1, 1], k = 3
 *   Output: 2
 *
 * Explanation:
 *   The subarrays containing exactly 3 odd numbers are:
 *   [1, 1, 2, 1]
 *   [1, 2, 1, 1]
 *
 * Example 2:
 *   nums = [4, 8, 2], k = 1
 *   Output: 0
 *
 * Explanation:
 *   The array does not contain any odd numbers, so there are no subarrays
 *   containing exactly 1 odd number.
 *
 * Approach:  Use a sliding window to count subarrays containing at most `k`
 *            odd numbers, then subtract the count of subarrays containing
 *            at most `k - 1` odd numbers.
 *
 *            Exactly(k) = AtMost(k) - AtMost(k - 1)
 *
 * Time:      O(n) — each element is added and removed from the window at most once.
 * Space:     O(1) — only pointers, odd count, and result variables are used.
 */

fun countAtMost(nums: IntArray, k: Int): Int {
    if (k < 0) return 0

    var left = 0
    var remainingOdds = k
    var subarrayCount = 0

    for (right in nums.indices) {
        if (nums[right] % 2 != 0) {
            remainingOdds--
        }

        while (remainingOdds < 0) {
            if (nums[left] % 2 != 0) {
                remainingOdds++
            }

            left++
        }

        subarrayCount += right - left + 1
    }

    return subarrayCount
}

fun countNumberOfNiceSubarrays(nums: IntArray, k: Int): Int {
    return countAtMost(nums, k) - countAtMost(nums, k - 1)
}

fun main() {
    val nums = intArrayOf(1, 1, 2, 1, 1)
    val k = 3

    println("Input Array:")
    println(nums.joinToString(prefix = "[", postfix = "]"))

    println("\nValue of k:")
    println(k)

    println("\nNumber of Nice Subarrays:")
    println(countNumberOfNiceSubarrays(nums, k))
}
