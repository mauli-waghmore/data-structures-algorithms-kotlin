package arrays.heap

/**
 * Max Heap Delete Root
 * --------------------
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
 *   Heap = [50, 40, 20, 10, 30]
 *
 * Delete root value = 50
 *
 * Output heap:
 *   [40, 30, 20, 10]
 *
 * Explanation:
 *   Original heap:
 *     [50, 40, 20, 10, 30]
 *
 *   Delete root 50:
 *     Replace root with last element 30.
 *     [30, 40, 20, 10]
 *
 *   Compare 30 with its children 40 and 20:
 *     40 is greater than 30, so swap.
 *     [40, 30, 20, 10]
 *
 *   Compare 30 with its child 10:
 *     30 is greater than 10, so no swap.
 *
 *   Final heap:
 *     [40, 30, 20, 10]
 *
 * Approach:
 *   1. Store the root value.
 *   2. Replace the root with the last element.
 *   3. Remove the last element.
 *   4. Compare the current node with its left and right child.
 *   5. Swap with the larger child if needed.
 *   6. Repeat until the heap property is restored.
 *
 * This process is called heapify down or bubble down.
 *
 * Time:
 *   O(log n) — in the worst case, the root moves from root to leaf.
 *
 * Space:
 *   O(1) — no extra space is used except variables.
 */

class MaxHeapRootDeletion {
    private val heap = mutableListOf<Int>()

    fun addValue(value: Int) {
        heap.add(value)
    }

    fun deleteRoot(): Int? {
        if (heap.isEmpty()) {
            return null
        }

        val rootValue = heap[0]

        heap[0] = heap.last()
        heap.removeAt(heap.lastIndex)

        heapifyDown(0)

        return rootValue
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
    val maxHeap = MaxHeapRootDeletion()

    maxHeap.addValue(50)
    maxHeap.addValue(40)
    maxHeap.addValue(20)
    maxHeap.addValue(10)
    maxHeap.addValue(30)

    println("Max Heap:")
    maxHeap.printHeap()

    println("\nDeleted Root:")
    println(maxHeap.deleteRoot())

    println("\nHeap After Deleting Root:")
    maxHeap.printHeap()

    println("\nMaximum Value:")
    println(maxHeap.peek())
}
