package arrays.slidingwindow

import kotlin.test.Test
import kotlin.test.assertEquals

class BinarySubarrayWithSumTest {

    @Test
    fun `returns seven for mixed binary array with goal two`() {
        assertEquals(7, numSubarraysWithSum(intArrayOf(1, 0, 0, 1, 1, 0), 2))
    }

    @Test
    fun `returns twenty one for all zeros with goal zero`() {
        assertEquals(21, numSubarraysWithSum(intArrayOf(0, 0, 0, 0, 0, 0), 0))
    }

    @Test
    fun `returns four for alternating binary array with goal two`() {
        assertEquals(4, numSubarraysWithSum(intArrayOf(1, 0, 1, 0, 1), 2))
    }

    @Test
    fun `returns one for single one with goal one`() {
        assertEquals(1, numSubarraysWithSum(intArrayOf(1), 1))
    }

    @Test
    fun `returns one for single zero with goal zero`() {
        assertEquals(1, numSubarraysWithSum(intArrayOf(0), 0))
    }

    @Test
    fun `returns zero for single zero with goal one`() {
        assertEquals(0, numSubarraysWithSum(intArrayOf(0), 1))
    }

    @Test
    fun `returns zero for single one with goal zero`() {
        assertEquals(0, numSubarraysWithSum(intArrayOf(1), 0))
    }

    @Test
    fun `returns zero when goal is greater than total sum`() {
        assertEquals(0, numSubarraysWithSum(intArrayOf(1, 0, 1), 5))
    }

    @Test
    fun `returns zero for empty array`() {
        assertEquals(0, numSubarraysWithSum(intArrayOf(), 0))
    }

    @Test
    fun `returns three for all ones with goal one`() {
        assertEquals(3, numSubarraysWithSum(intArrayOf(1, 1, 1), 1))
    }

    @Test
    fun `returns two for all ones with goal two`() {
        assertEquals(2, numSubarraysWithSum(intArrayOf(1, 1, 1), 2))
    }

    @Test
    fun `returns one for all ones with goal three`() {
        assertEquals(1, numSubarraysWithSum(intArrayOf(1, 1, 1), 3))
    }

    @Test
    fun `returns zero for all ones with goal zero`() {
        assertEquals(0, numSubarraysWithSum(intArrayOf(1, 1, 1), 0))
    }

    @Test
    fun `returns ten for four zeros with goal zero`() {
        assertEquals(10, numSubarraysWithSum(intArrayOf(0, 0, 0, 0), 0))
    }

    @Test
    fun `returns one when goal equals total number of ones`() {
        assertEquals(1, numSubarraysWithSum(intArrayOf(1, 0, 1, 0, 1), 3))
    }

    @Test
    fun `returns twelve for zeros around ones with goal one`() {
        assertEquals(12, numSubarraysWithSum(intArrayOf(0, 1, 0, 0, 1, 0), 1))
    }

    @Test
    fun `returns three for two groups of ones with goal two`() {
        assertEquals(3, numSubarraysWithSum(intArrayOf(1, 1, 0, 1), 2))
    }

    @Test
    fun `returns eight for leading zeros with goal one`() {
        assertEquals(8, numSubarraysWithSum(intArrayOf(0, 0, 1, 0, 1), 1))
    }

    @Test
    fun `returns three for trailing zeros with goal one`() {
        assertEquals(3, numSubarraysWithSum(intArrayOf(1, 0, 0), 1))
    }

    @Test
    fun `returns nine for mixed array with goal zero`() {
        assertEquals(9, numSubarraysWithSum(intArrayOf(0, 0, 1, 0, 0, 0), 0))
    }

    @Test
    fun `returns four for consecutive ones with goal two`() {
        assertEquals(4, numSubarraysWithSum(intArrayOf(1, 1, 1, 1, 1), 2))
    }

    @Test
    fun `returns five for consecutive ones with goal one`() {
        assertEquals(5, numSubarraysWithSum(intArrayOf(1, 1, 1, 1, 1), 1))
    }

    @Test
    fun `returns one for consecutive ones with goal five`() {
        assertEquals(1, numSubarraysWithSum(intArrayOf(1, 1, 1, 1, 1), 5))
    }

    @Test
    fun `returns zero for consecutive ones with goal six`() {
        assertEquals(0, numSubarraysWithSum(intArrayOf(1, 1, 1, 1, 1), 6))
    }

    @Test
    fun `returns twelve for many zeros around one with goal one`() {
        assertEquals(12, numSubarraysWithSum(intArrayOf(0, 0, 1, 0, 0, 0), 1))
    }

    @Test
    fun `returns four for alternating array with goal three`() {
        assertEquals(4, numSubarraysWithSum(intArrayOf(1, 0, 1, 0, 1, 0, 1), 3))
    }

    @Test
    fun `returns eight for alternating array with goal one`() {
        assertEquals(8, numSubarraysWithSum(intArrayOf(1, 0, 1, 0, 1), 1))
    }

    @Test
    fun `returns six for zeros between ones with goal two`() {
        assertEquals(6, numSubarraysWithSum(intArrayOf(1, 0, 0, 1, 0, 0, 1), 2))
    }

    @Test
    fun `returns one when whole array sums to goal`() {
        assertEquals(1, numSubarraysWithSum(intArrayOf(1, 1, 1, 1), 4))
    }

    @Test
    fun `returns fifteen for five zeros with goal zero`() {
        assertEquals(15, numSubarraysWithSum(intArrayOf(0, 0, 0, 0, 0), 0))
    }
}
