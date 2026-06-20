package arrays.slidingwindow

/**
 * Binary Subarray With Sum
 * ------------------------
 * Given a binary array `nums`, containing only 0s and 1s, and an integer `goal`,
 * return the number of non-empty subarrays whose sum is exactly equal to `goal`.
 *
 * A subarray is a contiguous part of the array.
 *
 * Example 1:
 *   nums = [1, 0, 0, 1, 1, 0], goal = 2
 *   Output: 7
 *
 * Explanation:
 *   The subarrays with sum exactly equal to 2 are:
 *   [1, 0, 0, 1]
 *   [1, 0, 0, 1, 1]
 *   [0, 0, 1, 1]
 *   [0, 1, 1]
 *   [0, 1, 1, 0]
 *   [1, 1]
 *   [1, 1, 0]
 *
 * Example 2:
 *   nums = [0, 0, 0, 0, 0, 0], goal = 0
 *   Output: 21
 *
 * Explanation:
 *   All subarrays contain only 0s, so every subarray has sum 0.
 *   Total subarrays = n * (n + 1) / 2 = 6 * 7 / 2 = 21.
 *
 * Approach:  sliding window to count subarrays with sum at most `goal`, then
 *            subtract the count of subarrays with sum at most `goal - 1`.
 *            This gives the count of subarrays with sum exactly equal to `goal`.
 *
 *            Exactly(goal) = AtMost(goal) - AtMost(goal - 1)
 *
 * Time:      O(n) — each element is added and removed from the window at most once.
 * Space:     O(1) — only pointers, sum, and count variables are used.
 */

fun numSubarraysWithSum(nums: IntArray, goal: Int): Int {
    return atMost(nums, goal) - atMost(nums, goal - 1)
}

fun atMost(nums: IntArray, goal: Int): Int {
    if (goal < 0) return 0

    var left = 0
    var sum = 0
    var count = 0

    for (right in nums.indices) {
        sum += nums[right]

        while (sum > goal) {
            sum -= nums[left]
            left++
        }

        count += right - left + 1
    }

    return count
}

fun main() {
    val nums = intArrayOf(1, 0, 0, 1, 1, 0)
    val goal = 2

    println("Input Array:")
    println(nums.contentToString())

    println("\nGoal:")
    println(goal)

    println("\nBinary Subarray With Sum:")
    println(numSubarraysWithSum(nums, goal))
}
