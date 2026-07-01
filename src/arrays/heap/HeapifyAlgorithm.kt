package arrays.heap

/**
 * Heapify Algorithm
 * -----------------
 * A heap is a complete binary tree that follows the heap property.
 *
 * In a max heap:
 *   Every parent node is greater than or equal to its child nodes.
 *
 * Heap is usually stored using an array or list.
 *
 * For index `i`:
 *   parent index      = (i - 1) / 2
 *   left child index  = 2 * i + 1
 *   right child index = 2 * i + 2
 *
 * Example:
 *   Array = [10, 30, 20, 50, 40]
 *
 * After heapify:
 *   [50, 40, 20, 30, 10]
 *
 * Explanation:
 *   Original array:
 *     [10, 30, 20, 50, 40]
 *
 *   Start heapifying from the last non-leaf node.
 *
 *   Last non-leaf node index:
 *     n / 2 - 1
 *     5 / 2 - 1 = 1
 *
 *   Heapify index 1:
 *     Value = 30
 *     Left child = 50
 *     Right child = 40
 *     50 is greater than 30, so swap.
 *     [10, 50, 20, 30, 40]
 *
 *   Heapify index 0:
 *     Value = 10
 *     Left child = 50
 *     Right child = 20
 *     50 is greater than 10, so swap.
 *     [50, 10, 20, 30, 40]
 *
 *   Now heapify index 1 again:
 *     Value = 10
 *     Left child = 30
 *     Right child = 40
 *     40 is greater than 10, so swap.
 *     [50, 40, 20, 30, 10]
 *
 *   Final max heap:
 *     [50, 40, 20, 30, 10]
 *
 * Approach:
 *   1. Store all values in an array or list.
 *   2. Find the last non-leaf node using n / 2 - 1.
 *   3. Start heapifying from the last non-leaf node.
 *   4. Compare the current node with its left and right child.
 *   5. Swap with the larger child if needed.
 *   6. Repeat until the heap property is restored.
 *   7. Move to the previous non-leaf node and repeat.
 *
 * This process is called heapify.
 *
 * Time:
 *   O(n) — building a heap from an array takes linear time.
 *
 * Space:
 *   O(1) — no extra space is used except variables.
 */

class HeapifyAlgorithm {
    private val heap = mutableListOf<Int>()

    fun addValue(value: Int) {
        heap.add(value)
    }

    fun buildMaxHeap() {
        val lastNonLeafIndex = heap.size / 2 - 1

        for (index in lastNonLeafIndex downTo 0) {
            heapifyDown(index)
        }
    }

    private fun heapifyDown(index: Int) {
        var currentIndex = index

        while (currentIndex < heap.size) {
            val leftChildIndex = 2 * currentIndex + 1
            val rightChildIndex = 2 * currentIndex + 2

            var largestIndex = currentIndex

            if (
                leftChildIndex < heap.size &&
                heap[leftChildIndex] > heap[largestIndex]
            ) {
                largestIndex = leftChildIndex
            }

            if (
                rightChildIndex < heap.size &&
                heap[rightChildIndex] > heap[largestIndex]
            ) {
                largestIndex = rightChildIndex
            }

            if (largestIndex != currentIndex) {
                swap(currentIndex, largestIndex)
                currentIndex = largestIndex
            } else {
                break
            }
        }
    }

    fun peek(): Int? {
        return heap.firstOrNull()
    }

    fun getHeap(): List<Int> {
        return heap.toList()
    }

    fun printHeap() {
        println(heap)
    }

    private fun swap(index1: Int, index2: Int) {
        val temp = heap[index1]
        heap[index1] = heap[index2]
        heap[index2] = temp
    }
}

fun main() {
    val maxHeap = HeapifyAlgorithm()

    maxHeap.addValue(10)
    maxHeap.addValue(30)
    maxHeap.addValue(20)
    maxHeap.addValue(50)
    maxHeap.addValue(40)

    println("Original Array:")
    maxHeap.printHeap()

    maxHeap.buildMaxHeap()

    println("\nAfter Heapify:")
    maxHeap.printHeap()

    println("\nMaximum Value:")
    println(maxHeap.peek())
}
