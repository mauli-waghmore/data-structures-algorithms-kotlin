package arrays.heap

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class MaxHeapTest {

    @Test
    fun `inserts single value into max heap`() {
        val maxHeap = MaxHeap()

        maxHeap.insertInHeap(10)

        assertEquals(listOf(10), maxHeap.getHeap())
        assertEquals(10, maxHeap.peek())
    }

    @Test
    fun `keeps largest value at root after two insertions`() {
        val maxHeap = MaxHeap()

        maxHeap.insertInHeap(10)
        maxHeap.insertInHeap(30)

        assertEquals(listOf(30, 10), maxHeap.getHeap())
        assertEquals(30, maxHeap.peek())
    }

    @Test
    fun `keeps max heap property after multiple insertions`() {
        val maxHeap = MaxHeap()

        maxHeap.insertInHeap(10)
        maxHeap.insertInHeap(30)
        maxHeap.insertInHeap(20)
        maxHeap.insertInHeap(50)
        maxHeap.insertInHeap(40)

        assertEquals(listOf(50, 40, 20, 10, 30), maxHeap.getHeap())
        assertEquals(50, maxHeap.peek())
    }

    @Test
    fun `inserts values already in descending order`() {
        val maxHeap = MaxHeap()

        maxHeap.insertInHeap(50)
        maxHeap.insertInHeap(40)
        maxHeap.insertInHeap(30)
        maxHeap.insertInHeap(20)
        maxHeap.insertInHeap(10)

        assertEquals(listOf(50, 40, 30, 20, 10), maxHeap.getHeap())
        assertEquals(50, maxHeap.peek())
    }

    @Test
    fun `inserts values in ascending order`() {
        val maxHeap = MaxHeap()

        maxHeap.insertInHeap(10)
        maxHeap.insertInHeap(20)
        maxHeap.insertInHeap(30)
        maxHeap.insertInHeap(40)
        maxHeap.insertInHeap(50)

        assertEquals(50, maxHeap.peek())
        assertTrue(isValidMaxHeap(maxHeap.getHeap()))
    }

    @Test
    fun `handles duplicate values`() {
        val maxHeap = MaxHeap()

        maxHeap.insertInHeap(10)
        maxHeap.insertInHeap(10)
        maxHeap.insertInHeap(10)

        assertEquals(listOf(10, 10, 10), maxHeap.getHeap())
        assertEquals(10, maxHeap.peek())
    }

    @Test
    fun `handles negative values`() {
        val maxHeap = MaxHeap()

        maxHeap.insertInHeap(-10)
        maxHeap.insertInHeap(-30)
        maxHeap.insertInHeap(-5)
        maxHeap.insertInHeap(-20)

        assertEquals(-5, maxHeap.peek())
        assertTrue(isValidMaxHeap(maxHeap.getHeap()))
    }

    @Test
    fun `handles mixed positive and negative values`() {
        val maxHeap = MaxHeap()

        maxHeap.insertInHeap(-10)
        maxHeap.insertInHeap(40)
        maxHeap.insertInHeap(0)
        maxHeap.insertInHeap(25)
        maxHeap.insertInHeap(-5)

        assertEquals(40, maxHeap.peek())
        assertTrue(isValidMaxHeap(maxHeap.getHeap()))
    }

    @Test
    fun `returns null peek for empty heap`() {
        val maxHeap = MaxHeap()

        assertEquals(null, maxHeap.peek())
        assertEquals(emptyList(), maxHeap.getHeap())
    }

    @Test
    fun `validates max heap property for many values`() {
        val maxHeap = MaxHeap()

        val values = listOf(15, 10, 20, 17, 8, 25, 30, 5, 40, 1)

        for (value in values) {
            maxHeap.insertInHeap(value)
        }

        assertEquals(40, maxHeap.peek())
        assertTrue(isValidMaxHeap(maxHeap.getHeap()))
    }

    private fun isValidMaxHeap(heap: List<Int>): Boolean {
        for (parentIndex in heap.indices) {
            val leftChildIndex = 2 * parentIndex + 1
            val rightChildIndex = 2 * parentIndex + 2

            if (leftChildIndex < heap.size && heap[parentIndex] < heap[leftChildIndex]) {
                return false
            }

            if (rightChildIndex < heap.size && heap[parentIndex] < heap[rightChildIndex]) {
                return false
            }
        }

        return true
    }
}
