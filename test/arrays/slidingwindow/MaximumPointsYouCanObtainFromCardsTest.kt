package arrays.slidingwindow

import kotlin.test.Test
import kotlin.test.assertEquals

class MaximumPointsYouCanObtainFromCardsTest {

    @Test
    fun `returns zero when no cards are selected`() {
        assertEquals(0, maxScore(intArrayOf(), 0))
    }

    @Test
    fun `returns zero when k is zero for non empty array`() {
        assertEquals(0, maxScore(intArrayOf(1, 2, 3), 0))
    }

    @Test
    fun `returns the card value for a single card`() {
        assertEquals(9, maxScore(intArrayOf(9), 1))
    }

    @Test
    fun `returns sum of all cards when k equals array size`() {
        assertEquals(21, maxScore(intArrayOf(1, 2, 3, 4, 5, 6), 6))
    }

    @Test
    fun `handles basic example`() {
        assertEquals(
            12,
            maxScore(intArrayOf(1, 2, 3, 4, 5, 6, 1), 3)
        )
    }

    @Test
    fun `selects all cards from the right side`() {
        assertEquals(
            15,
            maxScore(intArrayOf(1, 2, 3, 4, 5, 6), 3)
        )
    }

    @Test
    fun `selects cards from both ends`() {
        assertEquals(
            12,
            maxScore(intArrayOf(5, 4, 1, 8, 7, 1, 3), 3)
        )
    }

    @Test
    fun `selects all cards from the left side`() {
        assertEquals(
            24,
            maxScore(intArrayOf(9, 8, 7, 1, 1, 1), 3)
        )
    }

    @Test
    fun `selects one card from the left`() {
        assertEquals(
            10,
            maxScore(intArrayOf(10, 2, 3, 4, 9), 1)
        )
    }

    @Test
    fun `selects one card from the right`() {
        assertEquals(
            10,
            maxScore(intArrayOf(9, 2, 3, 4, 10), 1)
        )
    }

    @Test
    fun `returns same value when both end cards are equal`() {
        assertEquals(
            1,
            maxScore(intArrayOf(1, 1000, 1), 1)
        )
    }

    @Test
    fun `cannot directly select a large middle card`() {
        assertEquals(
            1,
            maxScore(intArrayOf(1, 1000, 1), 1)
        )
    }

    @Test
    fun `can reach middle card after removing an end card`() {
        assertEquals(
            1001,
            maxScore(intArrayOf(1, 1000, 1), 2)
        )
    }

    @Test
    fun `selects one card from each end`() {
        assertEquals(
            200,
            maxScore(intArrayOf(100, 1, 1, 1, 100), 2)
        )
    }

    @Test
    fun `handles different values at both ends`() {
        assertEquals(
            19,
            maxScore(intArrayOf(10, 1, 1, 1, 9), 2)
        )
    }

    @Test
    fun `ignores large middle value when k is too small`() {
        assertEquals(
            7,
            maxScore(intArrayOf(1, 2, 100, 3, 4), 2)
        )
    }

    @Test
    fun `handles all equal card values`() {
        assertEquals(
            6,
            maxScore(intArrayOf(2, 2, 2, 2, 2), 3)
        )
    }

    @Test
    fun `handles two equal cards`() {
        assertEquals(
            4,
            maxScore(intArrayOf(2, 2), 2)
        )
    }

    @Test
    fun `handles increasing card values`() {
        assertEquals(
            18,
            maxScore(intArrayOf(1, 2, 3, 4, 5, 6, 7), 3)
        )
    }

    @Test
    fun `handles decreasing card values`() {
        assertEquals(
            18,
            maxScore(intArrayOf(7, 6, 5, 4, 3, 2, 1), 3)
        )
    }

    @Test
    fun `handles alternating high and low values`() {
        assertEquals(
            21,
            maxScore(intArrayOf(10, 1, 10, 1, 10), 3)
        )
    }

    @Test
    fun `handles zeros`() {
        assertEquals(
            0,
            maxScore(intArrayOf(0, 0, 0, 0), 3)
        )
    }

    @Test
    fun `handles zeros mixed with positive values`() {
        assertEquals(
            5,
            maxScore(intArrayOf(0, 5, 0, 5, 0), 3)
        )
    }

    @Test
    fun `handles negative card values`() {
        assertEquals(
            -3,
            maxScore(intArrayOf(-1, -2, -3, -4), 2)
        )
    }

    @Test
    fun `handles positive and negative card values`() {
        assertEquals(
            5,
            maxScore(intArrayOf(-5, 10, -5), 2)
        )
    }

    @Test
    fun `selects two high values from opposite ends`() {
        assertEquals(
            16,
            maxScore(intArrayOf(8, -1, -1, 8), 2)
        )
    }

    @Test
    fun `best combination uses two left cards and one right card`() {
        assertEquals(
            14,
            maxScore(intArrayOf(3, 1, 2, 10, 1), 3)
        )
    }

    @Test
    fun `best combination uses one left card and two right cards`() {
        assertEquals(
            202,
            maxScore(intArrayOf(1, 79, 80, 1, 1, 1, 200, 1), 3)
        )
    }

    @Test
    fun `handles larger mixed example`() {
        assertEquals(
            232,
            maxScore(intArrayOf(11, 49, 100, 20, 86, 29, 72), 4)
        )
    }

    @Test
    fun `handles k equal to one with negative values`() {
        assertEquals(
            -1,
            maxScore(intArrayOf(-1, -5, -3), 1)
        )
    }

    @Test
    fun `handles all cards selected with negative values`() {
        assertEquals(
            -10,
            maxScore(intArrayOf(-1, -2, -3, -4), 4)
        )
    }

    @Test
    fun `handles integer values near maximum range without overflow`() {
        assertEquals(
            2_000_000,
            maxScore(
                intArrayOf(1_000_000, 1, 1, 1, 1_000_000),
                2
            )
        )
    }

    @Test
    fun `handles large input with all same values`() {
        val cards = IntArray(1000) { 5 }

        assertEquals(2500, maxScore(cards, 500))
    }

    @Test
    fun `handles large input where left side is better`() {
        val cards = IntArray(1000) { index ->
            if (index < 500) 10 else 1
        }

        assertEquals(5000, maxScore(cards, 500))
    }

    @Test
    fun `handles large input where right side is better`() {
        val cards = IntArray(1000) { index ->
            if (index >= 500) 10 else 1
        }

        assertEquals(5000, maxScore(cards, 500))
    }

    @Test
    fun `handles large input with alternating values`() {
        val cards = IntArray(1000) { index ->
            if (index % 2 == 0) 10 else 1
        }

        assertEquals(2750, maxScore(cards, 500))
    }

    @Test
    fun `handles k one less than array size`() {
        assertEquals(
            20,
            maxScore(intArrayOf(1, 2, 3, 4, 5, 6), 5)
        )
    }

    @Test
    fun `excludes the smallest card when k is one less than size`() {
        assertEquals(
            29,
            maxScore(intArrayOf(10, 1, 8, 7, 4), 4)
        )
    }

    @Test
    fun `handles best score found in initial left selection`() {
        assertEquals(
            27,
            maxScore(intArrayOf(10, 9, 8, 1, 1, 1, 1), 3)
        )
    }

    @Test
    fun `handles best score found in final right selection`() {
        assertEquals(
            27,
            maxScore(intArrayOf(1, 1, 1, 1, 8, 9, 10), 3)
        )
    }

    @Test
    fun `handles best score found during middle replacement`() {
        assertEquals(
            22,
            maxScore(intArrayOf(10, 9, 1, 1, 1, 3), 3)
        )
    }
}
