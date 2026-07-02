package arrays.heap

/**
 * Heap Sort Algorithm
 * -------------------
 * Heap sort is a comparison-based sorting algorithm that uses a heap.
 *
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
 * After heap sort:
 *   [10, 20, 30, 40, 50]
 *
 * Explanation:
 *   Original array:
 *     [10, 30, 20, 50, 40]
 *
 *   Step 1: Build a max heap.
 *
 *   After building max heap:
 *     [50, 40, 20, 30, 10]
 *
 *   Step 2: Swap the root node with the last element.
 *
 *     Root = 50
 *     Last element = 10
 *
 *     [10, 40, 20, 30, 50]
 *
 *   Now 50 is in its correct sorted position.
 *
 *   Step 3: Reduce heap size and heapify the root again.
 *
 *     Heap part:
 *       [10, 40, 20, 30]
 *
 *     Sorted part:
 *       [50]
 *
 *   After heapify:
 *     [40, 30, 20, 10, 50]
 *
 *   Step 4: Repeat the process.
 *
 *     Swap 40 with 10:
 *       [10, 30, 20, 40, 50]
 *
 *     Heapify:
 *       [30, 10, 20, 40, 50]
 *
 *     Swap 30 with 20:
 *       [20, 10, 30, 40, 50]
 *
 *     Heapify:
 *       [20, 10, 30, 40, 50]
 *
 *     Swap 20 with 10:
 *       [10, 20, 30, 40, 50]
 *
 *   Final sorted array:
 *     [10, 20, 30, 40, 50]
 *
 * Approach:
 *   1. Store all values in an array or list.
 *   2. Build a max heap from the array.
 *   3. Swap the root element with the last element.
 *   4. Reduce the heap size by one.
 *   5. Heapify the root node to restore the max heap property.
 *   6. Repeat until the heap size becomes 1.
 *
 * This process is called heap sort.
 *
 * Time:
 *   O(n log n) — building heap takes O(n), and removing elements takes O(log n).
 *
 * Space:
 *   O(1) — heap sort is an in-place sorting algorithm.
 */

class HeapSortAlgorithm {
    private val heap = mutableListOf<Int>()

    fun addValue(value: Int) {
        heap.add(value)
    }

    fun heapSort() {
        buildMaxHeap()

        var heapSize = heap.size

        for (index in heap.size - 1 downTo 1) {
            swap(0, index)

            heapSize--

            heapifyDown(0, heapSize)
        }
    }

    private fun buildMaxHeap() {
        val lastNonLeafIndex = heap.size / 2 - 1

        for (index in lastNonLeafIndex downTo 0) {
            heapifyDown(index, heap.size)
        }
    }

    private fun heapifyDown(index: Int, heapSize: Int) {
        var currentIndex = index

        while (currentIndex < heapSize) {
            val leftChildIndex = 2 * currentIndex + 1
            val rightChildIndex = 2 * currentIndex + 2

            var largestIndex = currentIndex

            if (
                leftChildIndex < heapSize &&
                heap[leftChildIndex] > heap[largestIndex]
            ) {
                largestIndex = leftChildIndex
            }

            if (
                rightChildIndex < heapSize &&
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

    fun getSortedArray(): List<Int> {
        return heap.toList()
    }

    fun printArray() {
        println(heap)
    }

    private fun swap(index1: Int, index2: Int) {
        val temp = heap[index1]
        heap[index1] = heap[index2]
        heap[index2] = temp
    }
}

fun main() {
    val heapSort = HeapSortAlgorithm()

    heapSort.addValue(10)
    heapSort.addValue(30)
    heapSort.addValue(20)
    heapSort.addValue(50)
    heapSort.addValue(40)

    println("Original Array:")
    heapSort.printArray()

    heapSort.heapSort()

    println("\nAfter Heap Sort:")
    heapSort.printArray()

    println("\nSorted Array:")
    println(heapSort.getSortedArray())
}
