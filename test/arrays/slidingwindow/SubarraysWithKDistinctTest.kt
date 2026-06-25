package arrays.slidingwindow

import kotlin.test.Test
import kotlin.test.assertEquals

class SubarraysWithKDistinctTest {

    @Test
    fun `returns zero for empty array`() {
        assertEquals(
            0,
            subarraysWithKDistinct(intArrayOf(), 1)
        )
    }

    @Test
    fun `returns zero when k is zero`() {
        assertEquals(
            0,
            subarraysWithKDistinct(intArrayOf(1, 2, 3), 0)
        )
    }

    @Test
    fun `returns zero when k is negative`() {
        assertEquals(
            0,
            subarraysWithKDistinct(intArrayOf(1, 2, 3), -1)
        )
    }

    @Test
    fun `returns zero when k is greater than array size`() {
        assertEquals(
            0,
            subarraysWithKDistinct(intArrayOf(1, 2, 3), 4)
        )
    }

    @Test
    fun `handles first example`() {
        assertEquals(
            7,
            subarraysWithKDistinct(
                intArrayOf(1, 2, 1, 2, 3),
                2
            )
        )
    }

    @Test
    fun `handles second example`() {
        assertEquals(
            3,
            subarraysWithKDistinct(
                intArrayOf(1, 2, 1, 3, 4),
                3
            )
        )
    }

    @Test
    fun `handles single element with k one`() {
        assertEquals(
            1,
            subarraysWithKDistinct(intArrayOf(5), 1)
        )
    }

    @Test
    fun `returns zero for single element with k two`() {
        assertEquals(
            0,
            subarraysWithKDistinct(intArrayOf(5), 2)
        )
    }

    @Test
    fun `counts every subarray when all values are equal and k one`() {
        assertEquals(
            10,
            subarraysWithKDistinct(
                intArrayOf(2, 2, 2, 2),
                1
            )
        )
    }

    @Test
    fun `returns zero when all values are equal and k two`() {
        assertEquals(
            0,
            subarraysWithKDistinct(
                intArrayOf(2, 2, 2, 2),
                2
            )
        )
    }

    @Test
    fun `counts single element subarrays when all values are distinct and k one`() {
        assertEquals(
            4,
            subarraysWithKDistinct(
                intArrayOf(1, 2, 3, 4),
                1
            )
        )
    }

    @Test
    fun `counts adjacent pairs when all values are distinct and k two`() {
        assertEquals(
            3,
            subarraysWithKDistinct(
                intArrayOf(1, 2, 3, 4),
                2
            )
        )
    }

    @Test
    fun `counts length three subarrays when all values are distinct`() {
        assertEquals(
            2,
            subarraysWithKDistinct(
                intArrayOf(1, 2, 3, 4),
                3
            )
        )
    }

    @Test
    fun `counts entire array when k equals number of distinct values`() {
        assertEquals(
            1,
            subarraysWithKDistinct(
                intArrayOf(1, 2, 3, 4),
                4
            )
        )
    }

    @Test
    fun `handles two equal elements`() {
        assertEquals(
            3,
            subarraysWithKDistinct(
                intArrayOf(1, 1),
                1
            )
        )
    }

    @Test
    fun `handles two different elements`() {
        assertEquals(
            1,
            subarraysWithKDistinct(
                intArrayOf(1, 2),
                2
            )
        )
    }

    @Test
    fun `handles alternating two values`() {
        assertEquals(
            10,
            subarraysWithKDistinct(
                intArrayOf(1, 2, 1, 2, 1),
                2
            )
        )
    }

    @Test
    fun `handles repeated blocks`() {
        assertEquals(
            4,
            subarraysWithKDistinct(
                intArrayOf(1, 1, 2, 2),
                2
            )
        )
    }

    @Test
    fun `handles three distinct values with repetition`() {
        assertEquals(
            5,
            subarraysWithKDistinct(
                intArrayOf(1, 2, 1, 3, 2),
                3
            )
        )
    }

    @Test
    fun `handles zeros`() {
        assertEquals(
            10,
            subarraysWithKDistinct(
                intArrayOf(0, 0, 0, 0),
                1
            )
        )
    }

    @Test
    fun `handles zeros with other values`() {
        assertEquals(
            7,
            subarraysWithKDistinct(
                intArrayOf(0, 1, 0, 1, 2),
                2
            )
        )
    }

    @Test
    fun `handles negative values`() {
        assertEquals(
            7,
            subarraysWithKDistinct(
                intArrayOf(-1, -2, -1, -2, -3),
                2
            )
        )
    }

    @Test
    fun `handles positive and negative values`() {
        assertEquals(
            7,
            subarraysWithKDistinct(
                intArrayOf(-1, 1, -1, 1, 2),
                2
            )
        )
    }

    @Test
    fun `handles repeated negative values`() {
        assertEquals(
            4,
            subarraysWithKDistinct(
                intArrayOf(-1, -1, -2, -2),
                2
            )
        )
    }

    @Test
    fun `handles large and small integer values`() {
        assertEquals(
            3,
            subarraysWithKDistinct(
                intArrayOf(
                    Int.MIN_VALUE,
                    Int.MAX_VALUE,
                    Int.MIN_VALUE
                ),
                2
            )
        )
    }

    @Test
    fun `handles k equal to one with mixed repetitions`() {
        assertEquals(
            9,
            subarraysWithKDistinct(
                intArrayOf(1, 1, 2, 2, 2),
                1
            )
        )
    }

    @Test
    fun `handles several repeated groups`() {
        assertEquals(
            8,
            subarraysWithKDistinct(
                intArrayOf(1, 1, 2, 2, 3, 3),
                2
            )
        )
    }

    @Test
    fun `handles all distinct values with k equal to array size`() {
        assertEquals(
            1,
            subarraysWithKDistinct(
                intArrayOf(10, 20, 30, 40, 50),
                5
            )
        )
    }

    @Test
    fun `handles repeated values surrounding one different value`() {
        assertEquals(
            8,
            subarraysWithKDistinct(
                intArrayOf(1, 1, 2, 1, 1),
                2
            )
        )
    }

    @Test
    fun `handles one distinct value appearing between another value`() {
        assertEquals(
            3,
            subarraysWithKDistinct(
                intArrayOf(1, 2, 1),
                2
            )
        )
    }

    @Test
    fun `handles three values appearing alternately`() {
        assertEquals(
            6,
            subarraysWithKDistinct(
                intArrayOf(1, 2, 3, 1, 2),
                3
            )
        )
    }

    @Test
    fun `handles large input with all equal values`() {
        val nums = IntArray(1000) { 5 }

        assertEquals(
            500_500,
            subarraysWithKDistinct(nums, 1)
        )
    }

    @Test
    fun `returns zero for large equal input when k is two`() {
        val nums = IntArray(1000) { 5 }

        assertEquals(
            0,
            subarraysWithKDistinct(nums, 2)
        )
    }

    @Test
    fun `handles large input with alternating values`() {
        val nums = IntArray(1000) { index ->
            if (index % 2 == 0) 1 else 2
        }

        assertEquals(
            499_500,
            subarraysWithKDistinct(nums, 2)
        )
    }

    @Test
    fun `handles large input with all distinct values and k one`() {
        val nums = IntArray(1000) { it }

        assertEquals(
            1000,
            subarraysWithKDistinct(nums, 1)
        )
    }

    @Test
    fun `handles large input with all distinct values and k two`() {
        val nums = IntArray(1000) { it }

        assertEquals(
            999,
            subarraysWithKDistinct(nums, 2)
        )
    }
}
