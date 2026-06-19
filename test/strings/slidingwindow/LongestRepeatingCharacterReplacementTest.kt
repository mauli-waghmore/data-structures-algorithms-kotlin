package strings.slidingwindow

import kotlin.test.Test
import kotlin.test.assertEquals

class LongestRepeatingCharacterReplacementTest {

    @Test
    fun `returns four for AABABBA with one replacement`() {
        assertEquals(4, characterReplacement("AABABBA", 1))
    }

    @Test
    fun `returns six for BAABAABBBAAA with two replacements`() {
        assertEquals(6, characterReplacement("BAABAABBBAAA", 2))
    }

    @Test
    fun `returns length of string when all characters are already same`() {
        assertEquals(5, characterReplacement("AAAAA", 2))
    }

    @Test
    fun `returns length of string when k is large enough to replace all other characters`() {
        assertEquals(6, characterReplacement("ABCDEF", 5))
    }

    @Test
    fun `returns one when k is zero and no adjacent characters repeat`() {
        assertEquals(1, characterReplacement("ABCDE", 0))
    }

    @Test
    fun `returns longest existing repeating substring when k is zero`() {
        assertEquals(4, characterReplacement("AABBBBAA", 0))
    }

    @Test
    fun `handles empty string`() {
        assertEquals(0, characterReplacement("", 2))
    }

    @Test
    fun `handles single character with zero replacement`() {
        assertEquals(1, characterReplacement("A", 0))
    }

    @Test
    fun `handles single character with multiple replacements`() {
        assertEquals(1, characterReplacement("A", 5))
    }

    @Test
    fun `handles two different characters with zero replacement`() {
        assertEquals(1, characterReplacement("AB", 0))
    }

    @Test
    fun `handles two different characters with one replacement`() {
        assertEquals(2, characterReplacement("AB", 1))
    }

    @Test
    fun `handles alternating characters with one replacement`() {
        assertEquals(3, characterReplacement("ABAB", 1))
    }

    @Test
    fun `handles alternating characters with two replacements`() {
        assertEquals(5, characterReplacement("ABABA", 2))
    }

    @Test
    fun `handles repeated block in the middle`() {
        assertEquals(6, characterReplacement("ABBBBBAC", 1))
    }

    @Test
    fun `handles replacement at the beginning of window`() {
        assertEquals(5, characterReplacement("BAAAA", 1))
    }

    @Test
    fun `handles replacement at the end of window`() {
        assertEquals(5, characterReplacement("AAAAB", 1))
    }

    @Test
    fun `handles multiple character types in window`() {
        assertEquals(4, characterReplacement("ABCDDD", 1))
    }

    @Test
    fun `handles case where best window is at the beginning`() {
        assertEquals(5, characterReplacement("AAAABBC", 1))
    }

    @Test
    fun `handles case where best window is at the end`() {
        assertEquals(5, characterReplacement("CBAAAAA", 0))
    }

    @Test
    fun `handles long repeating section with two replacements`() {
        assertEquals(9, characterReplacement("AABAAAAABB", 2))
    }

    @Test
    fun `handles string with many same letters separated by few others`() {
        assertEquals(7, characterReplacement("AABBAAA", 2))
    }

    @Test
    fun `handles all unique characters with two replacements`() {
        assertEquals(3, characterReplacement("ABCDEFG", 2))
    }

    @Test
    fun `handles all unique characters with zero replacements`() {
        assertEquals(1, characterReplacement("ABCDEFG", 0))
    }

    @Test
    fun `handles full replacement into one repeated character`() {
        assertEquals(4, characterReplacement("ABCD", 3))
    }

    @Test
    fun `handles mixed uppercase letters`() {
        assertEquals(3, characterReplacement("XYZXXY", 1))
    }

    @Test
    fun `handles larger mixed example`() {
        assertEquals(7, characterReplacement("AAABBCDDDDDA", 2))
    }

    @Test
    fun `handles when k equals zero and entire string is same`() {
        assertEquals(6, characterReplacement("BBBBBB", 0))
    }

    @Test
    fun `handles when k equals string length`() {
        assertEquals(5, characterReplacement("ABCDE", 5))
    }

    @Test
    fun `handles frequent character not at edges`() {
        assertEquals(5, characterReplacement("BAAAB", 2))
    }

    @Test
    fun `handles shrinking window many times`() {
        assertEquals(4, characterReplacement("ABCDEFFFAAA", 1))
    }
}
