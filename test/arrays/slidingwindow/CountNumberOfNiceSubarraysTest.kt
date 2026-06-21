package arrays.slidingwindow

import kotlin.test.Test
import kotlin.test.assertEquals

class CountNumberOfNiceSubarraysTest {

    @Test
    fun `returns zero for empty array`() {
        assertEquals(0, countNumberOfNiceSubarrays(intArrayOf(), 1))
    }

    @Test
    fun `returns one for single odd number`() {
        assertEquals(1, countNumberOfNiceSubarrays(intArrayOf(1), 1))
    }

    @Test
    fun `returns zero for single even number`() {
        assertEquals(0, countNumberOfNiceSubarrays(intArrayOf(2), 1))
    }

    @Test
    fun `handles standard example`() {
        assertEquals(
            2,
            countNumberOfNiceSubarrays(intArrayOf(1, 1, 2, 1, 1), 3)
        )
    }

    @Test
    fun `returns zero when array contains no odd numbers`() {
        assertEquals(
            0,
            countNumberOfNiceSubarrays(intArrayOf(4, 8, 2), 1)
        )
    }

    @Test
    fun `counts every subarray when k is zero and all values are even`() {
        assertEquals(
            6,
            countNumberOfNiceSubarrays(intArrayOf(2, 4, 6), 0)
        )
    }

    @Test
    fun `counts subarrays with one odd number in all odd array`() {
        assertEquals(
            3,
            countNumberOfNiceSubarrays(intArrayOf(1, 3, 5), 1)
        )
    }

    @Test
    fun `counts subarrays with two odd numbers in all odd array`() {
        assertEquals(
            2,
            countNumberOfNiceSubarrays(intArrayOf(1, 3, 5), 2)
        )
    }

    @Test
    fun `counts full array when all elements are odd and k equals size`() {
        assertEquals(
            1,
            countNumberOfNiceSubarrays(intArrayOf(1, 3, 5), 3)
        )
    }

    @Test
    fun `returns zero when k is greater than number of odd values`() {
        assertEquals(
            0,
            countNumberOfNiceSubarrays(intArrayOf(1, 1, 1, 1), 5)
        )
    }

    @Test
    fun `handles one odd number surrounded by even numbers`() {
        assertEquals(
            9,
            countNumberOfNiceSubarrays(intArrayOf(2, 2, 1, 2, 2), 1)
        )
    }

    @Test
    fun `handles odd numbers at both ends with k one`() {
        assertEquals(
            8,
            countNumberOfNiceSubarrays(intArrayOf(1, 2, 2, 2, 1), 1)
        )
    }

    @Test
    fun `handles odd numbers at both ends with k two`() {
        assertEquals(
            1,
            countNumberOfNiceSubarrays(intArrayOf(1, 2, 2, 2, 1), 2)
        )
    }

    @Test
    fun `handles alternating odd and even values with k one`() {
        assertEquals(
            8,
            countNumberOfNiceSubarrays(intArrayOf(2, 1, 2, 1, 2), 1)
        )
    }

    @Test
    fun `handles alternating odd and even values with k two`() {
        assertEquals(
            4,
            countNumberOfNiceSubarrays(intArrayOf(2, 1, 2, 1, 2), 2)
        )
    }

    @Test
    fun `handles mixed values with multiple valid windows`() {
        assertEquals(
            4,
            countNumberOfNiceSubarrays(intArrayOf(1, 2, 3, 4, 5), 2)
        )
    }

    @Test
    fun `handles zeros as even numbers`() {
        assertEquals(
            8,
            countNumberOfNiceSubarrays(intArrayOf(0, 1, 0, 1, 0), 1)
        )
    }

    @Test
    fun `handles negative odd numbers`() {
        assertEquals(
            2,
            countNumberOfNiceSubarrays(intArrayOf(-1, 2, -3, 4), 2)
        )
    }

    @Test
    fun `handles negative even numbers`() {
        assertEquals(
            0,
            countNumberOfNiceSubarrays(intArrayOf(-2, -4, -6), 1)
        )
    }

    @Test
    fun `handles all odd values with k two`() {
        assertEquals(
            3,
            countNumberOfNiceSubarrays(intArrayOf(1, 1, 1, 1), 2)
        )
    }

    @Test
    fun `handles all odd values with k equal to array size`() {
        assertEquals(
            1,
            countNumberOfNiceSubarrays(intArrayOf(1, 1, 1, 1), 4)
        )
    }

    @Test
    fun `handles odd value at the end`() {
        assertEquals(
            4,
            countNumberOfNiceSubarrays(intArrayOf(2, 2, 2, 1), 1)
        )
    }

    @Test
    fun `handles odd value at the beginning`() {
        assertEquals(
            4,
            countNumberOfNiceSubarrays(intArrayOf(1, 2, 2, 2), 1)
        )
    }

    @Test
    fun `handles two odd values separated by multiple even values`() {
        assertEquals(
            4,
            countNumberOfNiceSubarrays(intArrayOf(2, 1, 2, 2, 1, 2), 2)
        )
    }

    @Test
    fun `handles repeated alternating sequence`() {
        assertEquals(
            6,
            countNumberOfNiceSubarrays(intArrayOf(1, 2, 1, 2, 1, 2), 2)
        )
    }

    @Test
    fun `handles large input containing only even values`() {
        val nums = IntArray(1000) { 2 }

        assertEquals(
            0,
            countNumberOfNiceSubarrays(nums, 1)
        )
    }

    @Test
    fun `handles large input containing only odd values`() {
        val nums = IntArray(1000) { 1 }

        assertEquals(
            999,
            countNumberOfNiceSubarrays(nums, 2)
        )
    }

    @Test
    fun `handles large alternating input`() {
        val nums = IntArray(1000) { index ->
            if (index % 2 == 0) 1 else 2
        }

        assertEquals(
            1994,
            countNumberOfNiceSubarrays(nums, 2)
        )
    }

    @Test
    fun `returns zero when k exceeds odd count in large array`() {
        val nums = IntArray(1000) { index ->
            if (index % 2 == 0) 1 else 2
        }

        assertEquals(
            0,
            countNumberOfNiceSubarrays(nums, 501)
        )
    }

    @Test
    fun `handles k equal to one for large all odd array`() {
        val nums = IntArray(1000) { 1 }

        assertEquals(
            1000,
            countNumberOfNiceSubarrays(nums, 1)
        )
    }
}
