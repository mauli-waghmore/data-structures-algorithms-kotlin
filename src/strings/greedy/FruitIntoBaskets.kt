package strings.greedy

/**
 * Fruit Into Baskets
 * ------------------
 * Given an integer array `fruits`, where `fruits[i]` represents the type of fruit
 * on the ith tree, find the maximum number of fruits that can be collected.
 *
 * There are only two baskets, and each basket can hold only one type of fruit.
 * Each basket can hold an unlimited number of fruits.
 *
 * Starting from any tree, move only to the right and pick exactly one fruit from
 * each tree. Stop when a fruit type is found that cannot fit into either basket.
 *
 * Example:
 *   fruits = [1, 2, 1, 2, 3]
 *   Output: 4
 *
 * Explanation:
 *   We can collect fruits from the subarray [1, 2, 1, 2].
 *   It contains only two fruit types: 1 and 2.
 *
 * Approach:  sliding window with a HashMap to keep counts of fruit types in the
 *            current window. Expand the right pointer, and if more than two fruit
 *            types are present, shrink from the left until only two types remain.
 *
 * Time:      O(n) — each fruit is added and removed from the window at most once.
 * Space:     O(1) — at most three fruit types are stored temporarily in the map.
 */

fun fruitsIntoBaskets(fruits: IntArray): Int {
    val baskets = HashMap<Int, Int>()

    var left = 0
    var maxFruits = 0

    for (right in fruits.indices) {
        baskets[fruits[right]] = baskets.getOrDefault(fruits[right], 0) + 1

        while (baskets.size > 2) {
            baskets[fruits[left]] = baskets[fruits[left]]!! - 1

            if (baskets[fruits[left]] == 0) {
                baskets.remove(fruits[left])
            }

            left++
        }

        maxFruits = maxOf(maxFruits, right - left + 1)
    }

    return maxFruits
}

fun main() {
    val fruits = intArrayOf(1, 2, 1, 2, 3)

    println("Input Fruits:")
    println(fruits.joinToString(prefix = "[", postfix = "]"))

    println("\nMaximum Fruits Collected:")
    println(fruitsIntoBaskets(fruits))
}
