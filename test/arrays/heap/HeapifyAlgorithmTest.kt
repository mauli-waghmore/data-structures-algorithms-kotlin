package arrays.heap

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class HeapifyAlgorithmTest {

    @Test
    fun `heapifies single value`() {
        val heapifyAlgorithm = HeapifyAlgorithm()

        heapifyAlgorithm.addValue(10)
        heapifyAlgorithm.buildMaxHeap()

        assertEquals(listOf(10), heapifyAlgorithm.getHeap())
        assertEquals(10, heapifyAlgorithm.peek())
    }

    @Test
    fun `heapifies two values with larger value second`() {
        val heapifyAlgorithm = HeapifyAlgorithm()

        heapifyAlgorithm.addValue(10)
        heapifyAlgorithm.addValue(30)
        heapifyAlgorithm.buildMaxHeap()

        assertEquals(listOf(30, 10), heapifyAlgorithm.getHeap())
        assertEquals(30, heapifyAlgorithm.peek())
    }

    @Test
    fun `heapifies multiple values into max heap`() {
        val heapifyAlgorithm = HeapifyAlgorithm()

        heapifyAlgorithm.addValue(10)
        heapifyAlgorithm.addValue(30)
        heapifyAlgorithm.addValue(20)
        heapifyAlgorithm.addValue(50)
        heapifyAlgorithm.addValue(40)

        heapifyAlgorithm.buildMaxHeap()

        assertEquals(listOf(50, 40, 20, 30, 10), heapifyAlgorithm.getHeap())
        assertEquals(50, heapifyAlgorithm.peek())
    }

    @Test
    fun `heapifies values already in max heap order`() {
        val heapifyAlgorithm = HeapifyAlgorithm()

        heapifyAlgorithm.addValue(50)
        heapifyAlgorithm.addValue(40)
        heapifyAlgorithm.addValue(30)
        heapifyAlgorithm.addValue(20)
        heapifyAlgorithm.addValue(10)

        heapifyAlgorithm.buildMaxHeap()

        assertEquals(listOf(50, 40, 30, 20, 10), heapifyAlgorithm.getHeap())
        assertEquals(50, heapifyAlgorithm.peek())
    }

    @Test
    fun `heapifies values in ascending order`() {
        val heapifyAlgorithm = HeapifyAlgorithm()

        heapifyAlgorithm.addValue(10)
        heapifyAlgorithm.addValue(20)
        heapifyAlgorithm.addValue(30)
        heapifyAlgorithm.addValue(40)
        heapifyAlgorithm.addValue(50)

        heapifyAlgorithm.buildMaxHeap()

        assertEquals(50, heapifyAlgorithm.peek())
        assertTrue(isValidMaxHeap(heapifyAlgorithm.getHeap()))
    }

    @Test
    fun `handles duplicate values`() {
        val heapifyAlgorithm = HeapifyAlgorithm()

        heapifyAlgorithm.addValue(10)
        heapifyAlgorithm.addValue(10)
        heapifyAlgorithm.addValue(10)

        heapifyAlgorithm.buildMaxHeap()

        assertEquals(listOf(10, 10, 10), heapifyAlgorithm.getHeap())
        assertEquals(10, heapifyAlgorithm.peek())
    }

    @Test
    fun `handles negative values`() {
        val heapifyAlgorithm = HeapifyAlgorithm()

        heapifyAlgorithm.addValue(-10)
        heapifyAlgorithm.addValue(-30)
        heapifyAlgorithm.addValue(-5)
        heapifyAlgorithm.addValue(-20)

        heapifyAlgorithm.buildMaxHeap()

        assertEquals(-5, heapifyAlgorithm.peek())
        assertTrue(isValidMaxHeap(heapifyAlgorithm.getHeap()))
    }

    @Test
    fun `handles mixed positive and negative values`() {
        val heapifyAlgorithm = HeapifyAlgorithm()

        heapifyAlgorithm.addValue(-10)
        heapifyAlgorithm.addValue(40)
        heapifyAlgorithm.addValue(0)
        heapifyAlgorithm.addValue(25)
        heapifyAlgorithm.addValue(-5)

        heapifyAlgorithm.buildMaxHeap()

        assertEquals(40, heapifyAlgorithm.peek())
        assertTrue(isValidMaxHeap(heapifyAlgorithm.getHeap()))
    }

    @Test
    fun `returns null peek for empty heap`() {
        val heapifyAlgorithm = HeapifyAlgorithm()

        heapifyAlgorithm.buildMaxHeap()

        assertEquals(null, heapifyAlgorithm.peek())
        assertEquals(emptyList(), heapifyAlgorithm.getHeap())
    }

    @Test
    fun `validates max heap property for many values`() {
        val heapifyAlgorithm = HeapifyAlgorithm()

        val values = listOf(15, 10, 20, 17, 8, 25, 30, 5, 40, 1)

        for (value in values) {
            heapifyAlgorithm.addValue(value)
        }

        heapifyAlgorithm.buildMaxHeap()

        assertEquals(40, heapifyAlgorithm.peek())
        assertTrue(isValidMaxHeap(heapifyAlgorithm.getHeap()))
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
