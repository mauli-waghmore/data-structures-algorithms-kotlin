package arrays.heap

import kotlin.test.Test
import kotlin.test.assertEquals

class HeapSortAlgorithmTest {

    @Test
    fun `sorts single value`() {
        val heapSortAlgorithm = HeapSortAlgorithm()

        heapSortAlgorithm.addValue(10)
        heapSortAlgorithm.heapSort()

        assertEquals(listOf(10), heapSortAlgorithm.getSortedArray())
    }

    @Test
    fun `sorts two values with larger value second`() {
        val heapSortAlgorithm = HeapSortAlgorithm()

        heapSortAlgorithm.addValue(10)
        heapSortAlgorithm.addValue(30)
        heapSortAlgorithm.heapSort()

        assertEquals(listOf(10, 30), heapSortAlgorithm.getSortedArray())
    }

    @Test
    fun `sorts two values with larger value first`() {
        val heapSortAlgorithm = HeapSortAlgorithm()

        heapSortAlgorithm.addValue(30)
        heapSortAlgorithm.addValue(10)
        heapSortAlgorithm.heapSort()

        assertEquals(listOf(10, 30), heapSortAlgorithm.getSortedArray())
    }

    @Test
    fun `sorts multiple values in ascending order`() {
        val heapSortAlgorithm = HeapSortAlgorithm()

        heapSortAlgorithm.addValue(10)
        heapSortAlgorithm.addValue(30)
        heapSortAlgorithm.addValue(20)
        heapSortAlgorithm.addValue(50)
        heapSortAlgorithm.addValue(40)

        heapSortAlgorithm.heapSort()

        assertEquals(listOf(10, 20, 30, 40, 50), heapSortAlgorithm.getSortedArray())
    }

    @Test
    fun `sorts values already in ascending order`() {
        val heapSortAlgorithm = HeapSortAlgorithm()

        heapSortAlgorithm.addValue(10)
        heapSortAlgorithm.addValue(20)
        heapSortAlgorithm.addValue(30)
        heapSortAlgorithm.addValue(40)
        heapSortAlgorithm.addValue(50)

        heapSortAlgorithm.heapSort()

        assertEquals(listOf(10, 20, 30, 40, 50), heapSortAlgorithm.getSortedArray())
    }

    @Test
    fun `sorts values in descending order`() {
        val heapSortAlgorithm = HeapSortAlgorithm()

        heapSortAlgorithm.addValue(50)
        heapSortAlgorithm.addValue(40)
        heapSortAlgorithm.addValue(30)
        heapSortAlgorithm.addValue(20)
        heapSortAlgorithm.addValue(10)

        heapSortAlgorithm.heapSort()

        assertEquals(listOf(10, 20, 30, 40, 50), heapSortAlgorithm.getSortedArray())
    }

    @Test
    fun `handles duplicate values`() {
        val heapSortAlgorithm = HeapSortAlgorithm()

        heapSortAlgorithm.addValue(10)
        heapSortAlgorithm.addValue(10)
        heapSortAlgorithm.addValue(10)

        heapSortAlgorithm.heapSort()

        assertEquals(listOf(10, 10, 10), heapSortAlgorithm.getSortedArray())
    }

    @Test
    fun `sorts values with duplicates`() {
        val heapSortAlgorithm = HeapSortAlgorithm()

        heapSortAlgorithm.addValue(40)
        heapSortAlgorithm.addValue(10)
        heapSortAlgorithm.addValue(30)
        heapSortAlgorithm.addValue(10)
        heapSortAlgorithm.addValue(20)
        heapSortAlgorithm.addValue(40)

        heapSortAlgorithm.heapSort()

        assertEquals(listOf(10, 10, 20, 30, 40, 40), heapSortAlgorithm.getSortedArray())
    }

    @Test
    fun `handles negative values`() {
        val heapSortAlgorithm = HeapSortAlgorithm()

        heapSortAlgorithm.addValue(-10)
        heapSortAlgorithm.addValue(-30)
        heapSortAlgorithm.addValue(-5)
        heapSortAlgorithm.addValue(-20)

        heapSortAlgorithm.heapSort()

        assertEquals(listOf(-30, -20, -10, -5), heapSortAlgorithm.getSortedArray())
    }

    @Test
    fun `handles mixed positive and negative values`() {
        val heapSortAlgorithm = HeapSortAlgorithm()

        heapSortAlgorithm.addValue(-10)
        heapSortAlgorithm.addValue(40)
        heapSortAlgorithm.addValue(0)
        heapSortAlgorithm.addValue(25)
        heapSortAlgorithm.addValue(-5)

        heapSortAlgorithm.heapSort()

        assertEquals(listOf(-10, -5, 0, 25, 40), heapSortAlgorithm.getSortedArray())
    }

    @Test
    fun `returns empty list for empty heap`() {
        val heapSortAlgorithm = HeapSortAlgorithm()

        heapSortAlgorithm.heapSort()

        assertEquals(emptyList(), heapSortAlgorithm.getSortedArray())
    }

    @Test
    fun `sorts many values`() {
        val heapSortAlgorithm = HeapSortAlgorithm()

        val values = listOf(15, 10, 20, 17, 8, 25, 30, 5, 40, 1)

        for (value in values) {
            heapSortAlgorithm.addValue(value)
        }

        heapSortAlgorithm.heapSort()

        assertEquals(
            listOf(1, 5, 8, 10, 15, 17, 20, 25, 30, 40),
            heapSortAlgorithm.getSortedArray()
        )
    }
}
