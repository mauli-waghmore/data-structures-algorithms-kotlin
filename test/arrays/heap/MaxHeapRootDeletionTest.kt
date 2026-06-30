package arrays.heap

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class MaxHeapRootDeletionTest {

    @Test
    fun `deletes root from max heap`() {
        val maxHeap = MaxHeapRootDeletion()

        maxHeap.addValue(50)
        maxHeap.addValue(40)
        maxHeap.addValue(20)
        maxHeap.addValue(10)
        maxHeap.addValue(30)

        val deletedRoot = maxHeap.deleteRoot()

        assertEquals(50, deletedRoot)
        assertEquals(listOf(40, 30, 20, 10), maxHeap.getHeap())
        assertEquals(40, maxHeap.peek())
    }

    @Test
    fun `deletes root from heap with single value`() {
        val maxHeap = MaxHeapRootDeletion()

        maxHeap.addValue(10)

        val deletedRoot = maxHeap.deleteRoot()

        assertEquals(10, deletedRoot)
        assertEquals(emptyList(), maxHeap.getHeap())
        assertEquals(null, maxHeap.peek())
    }

    @Test
    fun `returns null when deleting root from empty heap`() {
        val maxHeap = MaxHeapRootDeletion()

        val deletedRoot = maxHeap.deleteRoot()

        assertEquals(null, deletedRoot)
        assertEquals(emptyList(), maxHeap.getHeap())
        assertEquals(null, maxHeap.peek())
    }

    @Test
    fun `deletes root from heap with two values`() {
        val maxHeap = MaxHeapRootDeletion()

        maxHeap.addValue(50)
        maxHeap.addValue(30)

        val deletedRoot = maxHeap.deleteRoot()

        assertEquals(50, deletedRoot)
        assertEquals(listOf(30), maxHeap.getHeap())
        assertEquals(30, maxHeap.peek())
    }

    @Test
    fun `deletes root from heap with three values`() {
        val maxHeap = MaxHeapRootDeletion()

        maxHeap.addValue(50)
        maxHeap.addValue(40)
        maxHeap.addValue(30)

        val deletedRoot = maxHeap.deleteRoot()

        assertEquals(50, deletedRoot)
        assertEquals(listOf(40, 30), maxHeap.getHeap())
        assertEquals(40, maxHeap.peek())
    }

    @Test
    fun `keeps max heap property after deleting root`() {
        val maxHeap = MaxHeapRootDeletion()

        maxHeap.addValue(90)
        maxHeap.addValue(70)
        maxHeap.addValue(80)
        maxHeap.addValue(40)
        maxHeap.addValue(50)
        maxHeap.addValue(60)
        maxHeap.addValue(30)

        val deletedRoot = maxHeap.deleteRoot()

        assertEquals(90, deletedRoot)
        assertEquals(80, maxHeap.peek())
        assertTrue(isValidMaxHeap(maxHeap.getHeap()))
    }

    @Test
    fun `deletes root when left child is larger than right child`() {
        val maxHeap = MaxHeapRootDeletion()

        maxHeap.addValue(100)
        maxHeap.addValue(80)
        maxHeap.addValue(70)
        maxHeap.addValue(60)
        maxHeap.addValue(50)

        val deletedRoot = maxHeap.deleteRoot()

        assertEquals(100, deletedRoot)
        assertEquals(80, maxHeap.peek())
        assertTrue(isValidMaxHeap(maxHeap.getHeap()))
    }

    @Test
    fun `deletes root when right child is larger than left child`() {
        val maxHeap = MaxHeapRootDeletion()

        maxHeap.addValue(100)
        maxHeap.addValue(70)
        maxHeap.addValue(90)
        maxHeap.addValue(40)
        maxHeap.addValue(50)
        maxHeap.addValue(80)

        val deletedRoot = maxHeap.deleteRoot()

        assertEquals(100, deletedRoot)
        assertEquals(90, maxHeap.peek())
        assertTrue(isValidMaxHeap(maxHeap.getHeap()))
    }

    @Test
    fun `handles duplicate values while deleting root`() {
        val maxHeap = MaxHeapRootDeletion()

        maxHeap.addValue(50)
        maxHeap.addValue(50)
        maxHeap.addValue(50)
        maxHeap.addValue(50)

        val deletedRoot = maxHeap.deleteRoot()

        assertEquals(50, deletedRoot)
        assertEquals(listOf(50, 50, 50), maxHeap.getHeap())
        assertEquals(50, maxHeap.peek())
        assertTrue(isValidMaxHeap(maxHeap.getHeap()))
    }

    @Test
    fun `handles negative values while deleting root`() {
        val maxHeap = MaxHeapRootDeletion()

        maxHeap.addValue(-5)
        maxHeap.addValue(-10)
        maxHeap.addValue(-20)
        maxHeap.addValue(-30)

        val deletedRoot = maxHeap.deleteRoot()

        assertEquals(-5, deletedRoot)
        assertEquals(-10, maxHeap.peek())
        assertTrue(isValidMaxHeap(maxHeap.getHeap()))
    }

    @Test
    fun `handles mixed positive zero and negative values while deleting root`() {
        val maxHeap = MaxHeapRootDeletion()

        maxHeap.addValue(40)
        maxHeap.addValue(25)
        maxHeap.addValue(0)
        maxHeap.addValue(-10)
        maxHeap.addValue(-5)

        val deletedRoot = maxHeap.deleteRoot()

        assertEquals(40, deletedRoot)
        assertEquals(25, maxHeap.peek())
        assertTrue(isValidMaxHeap(maxHeap.getHeap()))
    }

    @Test
    fun `deletes root repeatedly until heap becomes empty`() {
        val maxHeap = MaxHeapRootDeletion()

        maxHeap.addValue(50)
        maxHeap.addValue(40)
        maxHeap.addValue(20)
        maxHeap.addValue(10)
        maxHeap.addValue(30)

        assertEquals(50, maxHeap.deleteRoot())
        assertEquals(40, maxHeap.deleteRoot())
        assertEquals(30, maxHeap.deleteRoot())
        assertEquals(20, maxHeap.deleteRoot())
        assertEquals(10, maxHeap.deleteRoot())

        assertEquals(emptyList(), maxHeap.getHeap())
        assertEquals(null, maxHeap.peek())
    }

    @Test
    fun `returns null after deleting all values`() {
        val maxHeap = MaxHeapRootDeletion()

        maxHeap.addValue(30)
        maxHeap.addValue(20)
        maxHeap.addValue(10)

        assertEquals(30, maxHeap.deleteRoot())
        assertEquals(20, maxHeap.deleteRoot())
        assertEquals(10, maxHeap.deleteRoot())
        assertEquals(null, maxHeap.deleteRoot())

        assertEquals(emptyList(), maxHeap.getHeap())
        assertEquals(null, maxHeap.peek())
    }

    @Test
    fun `maintains heap property after every root deletion`() {
        val maxHeap = MaxHeapRootDeletion()

        maxHeap.addValue(100)
        maxHeap.addValue(90)
        maxHeap.addValue(80)
        maxHeap.addValue(70)
        maxHeap.addValue(60)
        maxHeap.addValue(50)
        maxHeap.addValue(40)
        maxHeap.addValue(30)
        maxHeap.addValue(20)
        maxHeap.addValue(10)

        maxHeap.deleteRoot()
        assertTrue(isValidMaxHeap(maxHeap.getHeap()))

        maxHeap.deleteRoot()
        assertTrue(isValidMaxHeap(maxHeap.getHeap()))

        maxHeap.deleteRoot()
        assertTrue(isValidMaxHeap(maxHeap.getHeap()))

        maxHeap.deleteRoot()
        assertTrue(isValidMaxHeap(maxHeap.getHeap()))
    }

    @Test
    fun `deletes root from complete max heap with many values`() {
        val maxHeap = MaxHeapRootDeletion()

        maxHeap.addValue(120)
        maxHeap.addValue(100)
        maxHeap.addValue(110)
        maxHeap.addValue(90)
        maxHeap.addValue(80)
        maxHeap.addValue(70)
        maxHeap.addValue(60)
        maxHeap.addValue(50)
        maxHeap.addValue(40)
        maxHeap.addValue(30)
        maxHeap.addValue(20)
        maxHeap.addValue(10)

        val deletedRoot = maxHeap.deleteRoot()

        assertEquals(120, deletedRoot)
        assertEquals(110, maxHeap.peek())
        assertTrue(isValidMaxHeap(maxHeap.getHeap()))
    }

    @Test
    fun `deletes root when heap contains zero`() {
        val maxHeap = MaxHeapRootDeletion()

        maxHeap.addValue(0)
        maxHeap.addValue(-10)
        maxHeap.addValue(-20)

        val deletedRoot = maxHeap.deleteRoot()

        assertEquals(0, deletedRoot)
        assertEquals(-10, maxHeap.peek())
        assertTrue(isValidMaxHeap(maxHeap.getHeap()))
    }

    @Test
    fun `getHeap returns current heap after deletion`() {
        val maxHeap = MaxHeapRootDeletion()

        maxHeap.addValue(60)
        maxHeap.addValue(40)
        maxHeap.addValue(50)
        maxHeap.addValue(10)
        maxHeap.addValue(30)

        maxHeap.deleteRoot()

        assertEquals(listOf(50, 40, 30, 10), maxHeap.getHeap())
    }

    @Test
    fun `peek returns maximum value after root deletion`() {
        val maxHeap = MaxHeapRootDeletion()

        maxHeap.addValue(70)
        maxHeap.addValue(60)
        maxHeap.addValue(50)
        maxHeap.addValue(20)
        maxHeap.addValue(10)

        maxHeap.deleteRoot()

        assertEquals(60, maxHeap.peek())
    }

    @Test
    fun `does not break when deleting root from heap with only left child`() {
        val maxHeap = MaxHeapRootDeletion()

        maxHeap.addValue(30)
        maxHeap.addValue(20)

        val deletedRoot = maxHeap.deleteRoot()

        assertEquals(30, deletedRoot)
        assertEquals(listOf(20), maxHeap.getHeap())
        assertTrue(isValidMaxHeap(maxHeap.getHeap()))
    }

    @Test
    fun `deletes duplicate maximum values one by one`() {
        val maxHeap = MaxHeapRootDeletion()

        maxHeap.addValue(50)
        maxHeap.addValue(50)
        maxHeap.addValue(40)
        maxHeap.addValue(30)
        maxHeap.addValue(20)

        assertEquals(50, maxHeap.deleteRoot())
        assertEquals(50, maxHeap.peek())

        assertEquals(50, maxHeap.deleteRoot())
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
