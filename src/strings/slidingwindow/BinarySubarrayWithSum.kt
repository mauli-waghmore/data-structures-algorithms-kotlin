package strings.slidingwindow

/**
 * Binary Subarray With Sum
 * ------------------------
 *
 * Problem Statement:
 * You are given a binary array `nums` containing only 0s and 1s,
 * and an integer `goal`.
 *
 * Return the number of non-empty subarrays of `nums` that sum to `goal`.
 *
 * A subarray is a contiguous part of the array.
 *
 * Input Format:
 *      nums = [1, 0, 0, 1, 1, 0]
 *      goal = 2
 *
 * Output Format:
 *      6
 *
 * Example 1:
 *      Input:
 *          nums = [1, 0, 0, 1, 1, 0], goal = 2
 *
 *      Output:
 *          6
 *
 *      Explanation:
 *          The subarrays with sum exactly equal to 2 are:
 *          [1, 0, 0, 1]
 *          [0, 0, 1, 1]
 *          [0, 1, 1]
 *          [1, 1]
 *          [1, 1, 0]
 *          [0, 0, 1, 1, 0]
 *
 * Example 2:
 *      Input:
 *          nums = [0, 0, 0, 0, 0, 0], goal = 0
 *
 *      Output:
 *          21
 *
 *      Explanation:
 *          All subarrays contain only 0s, so every subarray has sum 0.
 *          Total subarrays = n * (n + 1) / 2 = 6 * 7 / 2 = 21.
 *
 * Approach:
 *      Use sliding window to count subarrays with sum at most `goal`
 *      and subtract subarrays with sum at most `goal - 1`.
 *
 *      Exactly(goal) = AtMost(goal) - AtMost(goal - 1)
 *
 * Time Complexity:
 *      O(n), where n is the size of the array.
 *
 * Space Complexity:
 *      O(1), because no extra data structure is used.
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
