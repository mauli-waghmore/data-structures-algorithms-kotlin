package arrays.heap

/**
 * Max Heap Insertion
 * ------------------
 * A max heap is a complete binary tree where every parent node is greater than
 * or equal to its child nodes.
 *
 * In a max heap, the largest element is always present at the root.
 *
 * Heap is usually stored using an array or list.
 *
 * For index `i`:
 *   parent index      = (i - 1) / 2
 *   left child index  = 2 * i + 1
 *   right child index = 2 * i + 2
 *
 * Example:
 *   Insert values = [10, 30, 20, 50, 40]
 *
 * Output heap:
 *   [50, 40, 20, 10, 30]
 *
 * Explanation:
 *   Insert 10:
 *     [10]
 *
 *   Insert 30:
 *     [10, 30]
 *     30 is greater than parent 10, so swap.
 *     [30, 10]
 *
 *   Insert 20:
 *     [30, 10, 20]
 *     20 is smaller than parent 30, so no swap.
 *
 *   Insert 50:
 *     [30, 10, 20, 50]
 *     50 is greater than parent 10, so swap.
 *     [30, 50, 20, 10]
 *     50 is greater than parent 30, so swap again.
 *     [50, 30, 20, 10]
 *
 *   Insert 40:
 *     [50, 30, 20, 10, 40]
 *     40 is greater than parent 30, so swap.
 *     [50, 40, 20, 10, 30]
 *
 * Approach:
 *   1. Add the new value at the end of the heap.
 *   2. Compare it with its parent.
 *   3. If the value is greater than the parent, swap them.
 *   4. Repeat until the heap property is restored.
 *
 * This process is called heapify up or bubble up.
 *
 * Time:
 *   O(log n) — in the worst case, the new value moves from leaf to root.
 *
 * Space:
 *   O(1) — no extra space is used except variables.
 */

class MaxHeap {
    private val heap = mutableListOf<Int>()

    fun insertInHeap(value: Int) {
        heap.add(value)

        var currentIndex = heap.lastIndex

        while (currentIndex > 0) {
            val parentIndex = (currentIndex - 1) / 2

            if (heap[currentIndex] > heap[parentIndex]) {
                swap(currentIndex, parentIndex)
                currentIndex = parentIndex
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
    val maxHeap = MaxHeap()

    maxHeap.insertInHeap(10)
    maxHeap.insertInHeap(30)
    maxHeap.insertInHeap(20)
    maxHeap.insertInHeap(50)
    maxHeap.insertInHeap(40)

    println("Max Heap:")
    maxHeap.printHeap()

    println("\nMaximum Value:")
    println(maxHeap.peek())
}
