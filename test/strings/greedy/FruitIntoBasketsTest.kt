package strings.greedy

import kotlin.test.Test
import kotlin.test.assertEquals

class FruitIntoBasketsTest {

    @Test
    fun `returns zero for empty array`() {
        assertEquals(0, fruitsIntoBaskets(intArrayOf()))
    }

    @Test
    fun `returns one for single fruit`() {
        assertEquals(1, fruitsIntoBaskets(intArrayOf(1)))
    }

    @Test
    fun `returns full length when only one fruit type exists`() {
        assertEquals(5, fruitsIntoBaskets(intArrayOf(2, 2, 2, 2, 2)))
    }

    @Test
    fun `returns full length when exactly two fruit types exist`() {
        assertEquals(6, fruitsIntoBaskets(intArrayOf(1, 2, 1, 2, 1, 2)))
    }

    @Test
    fun `handles basic case with three fruit types`() {
        assertEquals(4, fruitsIntoBaskets(intArrayOf(1, 2, 1, 2, 3)))
    }

    @Test
    fun `handles leetcode example with answer three`() {
        assertEquals(3, fruitsIntoBaskets(intArrayOf(1, 2, 1)))
    }

    @Test
    fun `handles leetcode example with answer four`() {
        assertEquals(4, fruitsIntoBaskets(intArrayOf(1, 2, 3, 2, 2)))
    }

    @Test
    fun `handles longer mixed sequence`() {
        assertEquals(5, fruitsIntoBaskets(intArrayOf(3, 3, 3, 1, 2, 1, 1, 1, 3, 4)))
    }

    @Test
    fun `best window appears at the beginning`() {
        assertEquals(4, fruitsIntoBaskets(intArrayOf(1, 1, 2, 2, 3, 4, 5)))
    }

    @Test
    fun `best window appears in the middle`() {
        assertEquals(6, fruitsIntoBaskets(intArrayOf(5, 1, 2, 2, 2, 1, 1, 3)))
    }

    @Test
    fun `best window appears at the end`() {
        assertEquals(6, fruitsIntoBaskets(intArrayOf(1, 2, 3, 3, 4, 4, 4, 4)))
    }

    @Test
    fun `shrinks window when third fruit type appears`() {
        assertEquals(4, fruitsIntoBaskets(intArrayOf(1, 2, 3, 2, 3)))
    }

    @Test
    fun `handles frequent fruit type changes`() {
        assertEquals(2, fruitsIntoBaskets(intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun `handles alternating two fruit types followed by third type`() {
        assertEquals(6, fruitsIntoBaskets(intArrayOf(1, 2, 1, 2, 1, 2, 3)))
    }

    @Test
    fun `handles third type then returns to previous type`() {
        assertEquals(4, fruitsIntoBaskets(intArrayOf(1, 2, 3, 2, 2, 1)))
    }

    @Test
    fun `handles repeated blocks of fruit types`() {
        assertEquals(6, fruitsIntoBaskets(intArrayOf(1, 1, 1, 2, 2, 2, 3, 3)))
    }

    @Test
    fun `handles zeros as fruit types`() {
        assertEquals(5, fruitsIntoBaskets(intArrayOf(0, 0, 1, 1, 0, 2)))
    }

    @Test
    fun `handles negative fruit type values`() {
        assertEquals(4, fruitsIntoBaskets(intArrayOf(-1, -1, -2, -2, -3)))
    }

    @Test
    fun `handles large fruit type values`() {
        assertEquals(4, fruitsIntoBaskets(intArrayOf(100000, 200000, 100000, 200000, 300000)))
    }

    @Test
    fun `handles two adjacent same fruits after shrinking`() {
        assertEquals(5, fruitsIntoBaskets(intArrayOf(1, 2, 3, 3, 3, 2)))
    }

    @Test
    fun `handles all same except one different fruit`() {
        assertEquals(6, fruitsIntoBaskets(intArrayOf(7, 7, 7, 8, 7, 7)))
    }

    @Test
    fun `handles pattern requiring multiple left moves`() {
        assertEquals(6, fruitsIntoBaskets(intArrayOf(1, 1, 2, 3, 3, 3, 2, 2)))
    }

    @Test
    fun `handles minimum array with two different fruits`() {
        assertEquals(2, fruitsIntoBaskets(intArrayOf(1, 2)))
    }

    @Test
    fun `handles minimum array with two same fruits`() {
        assertEquals(2, fruitsIntoBaskets(intArrayOf(1, 1)))
    }

    @Test
    fun `does not count non contiguous fruits`() {
        assertEquals(3, fruitsIntoBaskets(intArrayOf(1, 2, 1, 3, 4, 3, 5, 1, 2)))
    }

    @Test
    fun `handles long valid window after early invalid window`() {
        assertEquals(7, fruitsIntoBaskets(intArrayOf(1, 2, 3, 4, 4, 4, 5, 5, 5, 5)))
    }

    @Test
    fun `handles long valid window before late invalid window`() {
        assertEquals(8, fruitsIntoBaskets(intArrayOf(6, 6, 7, 7, 6, 7, 6, 7, 8)))
    }

    @Test
    fun `handles repeating three fruit cycle`() {
        assertEquals(2, fruitsIntoBaskets(intArrayOf(1, 2, 3, 1, 2, 3, 1, 2, 3)))
    }

    @Test
    fun `handles fruit type removed completely from basket`() {
        assertEquals(4, fruitsIntoBaskets(intArrayOf(1, 1, 2, 3, 3, 3)))
    }

    @Test
    fun `handles large input with one fruit type`() {
        val fruits = IntArray(1000) { 5 }

        assertEquals(1000, fruitsIntoBaskets(fruits))
    }

    @Test
    fun `handles large input with two fruit types`() {
        val fruits = IntArray(1000) { index ->
            if (index % 2 == 0) 1 else 2
        }

        assertEquals(1000, fruitsIntoBaskets(fruits))
    }

    @Test
    fun `handles large input with three repeating fruit types`() {
        val fruits = IntArray(1000) { index ->
            index % 3
        }

        assertEquals(2, fruitsIntoBaskets(fruits))
    }
}
