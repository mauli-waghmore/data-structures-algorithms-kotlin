package strings.slidingwindow

import kotlin.test.Test
import kotlin.test.assertEquals

class LongestSubstringKDistinctTest {

    @Test
    fun `returns zero for empty string`() {
        assertEquals(
            0,
            longestSubstringKDistinct("", 2)
        )
    }

    @Test
    fun `returns zero for empty string when k is zero`() {
        assertEquals(
            0,
            longestSubstringKDistinct("", 0)
        )
    }

    @Test
    fun `returns zero when k is zero`() {
        assertEquals(
            0,
            longestSubstringKDistinct("abc", 0)
        )
    }

    @Test
    fun `returns one for a single character`() {
        assertEquals(
            1,
            longestSubstringKDistinct("a", 1)
        )
    }

    @Test
    fun `returns entire string for a single character and large k`() {
        assertEquals(
            1,
            longestSubstringKDistinct("a", 10)
        )
    }

    @Test
    fun `handles standard example eceba`() {
        assertEquals(
            3,
            longestSubstringKDistinct("eceba", 2)
        )
    }

    @Test
    fun `handles example with longest substring at beginning`() {
        assertEquals(
            6,
            longestSubstringKDistinct("aababbcaacc", 2)
        )
    }

    @Test
    fun `handles example with repeated middle character`() {
        assertEquals(
            4,
            longestSubstringKDistinct("abcddefg", 3)
        )
    }

    @Test
    fun `returns entire string when all characters are same`() {
        assertEquals(
            6,
            longestSubstringKDistinct("aaaaaa", 1)
        )
    }

    @Test
    fun `returns entire string when k is greater than distinct count`() {
        assertEquals(
            5,
            longestSubstringKDistinct("abcba", 10)
        )
    }

    @Test
    fun `returns entire string when k equals distinct count`() {
        assertEquals(
            5,
            longestSubstringKDistinct("abcba", 3)
        )
    }

    @Test
    fun `returns one when all characters are distinct and k is one`() {
        assertEquals(
            1,
            longestSubstringKDistinct("abcdef", 1)
        )
    }

    @Test
    fun `returns two when all characters are distinct and k is two`() {
        assertEquals(
            2,
            longestSubstringKDistinct("abcdef", 2)
        )
    }

    @Test
    fun `returns three when all characters are distinct and k is three`() {
        assertEquals(
            3,
            longestSubstringKDistinct("abcdef", 3)
        )
    }

    @Test
    fun `handles two blocks with k one`() {
        assertEquals(
            3,
            longestSubstringKDistinct("aaabbb", 1)
        )
    }

    @Test
    fun `handles two blocks with k two`() {
        assertEquals(
            6,
            longestSubstringKDistinct("aaabbb", 2)
        )
    }

    @Test
    fun `handles longest substring at the end`() {
        assertEquals(
            4,
            longestSubstringKDistinct("abaccc", 2)
        )
    }

    @Test
    fun `handles longest repeated substring at the end`() {
        assertEquals(
            3,
            longestSubstringKDistinct("abaccc", 1)
        )
    }

    @Test
    fun `returns entire string when k covers all characters`() {
        assertEquals(
            6,
            longestSubstringKDistinct("abaccc", 3)
        )
    }

    @Test
    fun `handles repeating character after window shrink`() {
        assertEquals(
            4,
            longestSubstringKDistinct("araaci", 2)
        )
    }

    @Test
    fun `handles one distinct character in repeating input`() {
        assertEquals(
            2,
            longestSubstringKDistinct("araaci", 1)
        )
    }

    @Test
    fun `handles three distinct characters`() {
        assertEquals(
            5,
            longestSubstringKDistinct("cbbebi", 3)
        )
    }

    @Test
    fun `handles two distinct characters in mixed input`() {
        assertEquals(
            4,
            longestSubstringKDistinct("cbbebi", 2)
        )
    }

    @Test
    fun `handles alternating two characters`() {
        assertEquals(
            8,
            longestSubstringKDistinct("abababab", 2)
        )
    }

    @Test
    fun `handles alternating characters with k one`() {
        assertEquals(
            1,
            longestSubstringKDistinct("abababab", 1)
        )
    }

    @Test
    fun `handles repeating three character pattern with k two`() {
        assertEquals(
            2,
            longestSubstringKDistinct("abcabcabc", 2)
        )
    }

    @Test
    fun `handles repeating three character pattern with k three`() {
        assertEquals(
            9,
            longestSubstringKDistinct("abcabcabc", 3)
        )
    }

    @Test
    fun `handles long repeated middle section`() {
        assertEquals(
            7,
            longestSubstringKDistinct("abbbbbbc", 2)
        )
    }

    @Test
    fun `handles long repeated middle section with k one`() {
        assertEquals(
            6,
            longestSubstringKDistinct("abbbbbbc", 1)
        )
    }

    @Test
    fun `handles longest substring ending at final character`() {
        assertEquals(
            5,
            longestSubstringKDistinct("ccaabbb", 2)
        )
    }

    @Test
    fun `handles complex sliding window example`() {
        assertEquals(
            10,
            longestSubstringKDistinct("abcbbbbcccbdddadacb", 2)
        )
    }

    @Test
    fun `handles spaces as distinct characters`() {
        assertEquals(
            5,
            longestSubstringKDistinct("a a a", 2)
        )
    }

    @Test
    fun `handles string containing only spaces`() {
        assertEquals(
            5,
            longestSubstringKDistinct("     ", 1)
        )
    }

    @Test
    fun `treats uppercase and lowercase characters as distinct`() {
        assertEquals(
            1,
            longestSubstringKDistinct("aAaA", 1)
        )
    }

    @Test
    fun `handles uppercase and lowercase characters with k two`() {
        assertEquals(
            4,
            longestSubstringKDistinct("aAaA", 2)
        )
    }

    @Test
    fun `handles uppercase characters`() {
        assertEquals(
            5,
            longestSubstringKDistinct("AABBBCC", 2)
        )
    }

    @Test
    fun `handles numeric characters`() {
        assertEquals(
            6,
            longestSubstringKDistinct("1122332211", 2)
        )
    }

    @Test
    fun `handles one distinct numeric character`() {
        assertEquals(
            3,
            longestSubstringKDistinct("111222333", 1)
        )
    }

    @Test
    fun `handles punctuation characters`() {
        assertEquals(
            5,
            longestSubstringKDistinct("!!@@@##", 2)
        )
    }

    @Test
    fun `handles unicode characters`() {
        assertEquals(
            4,
            longestSubstringKDistinct("ååββγ", 2)
        )
    }

    @Test
    fun `handles k equal to string length`() {
        assertEquals(
            5,
            longestSubstringKDistinct("abcde", 5)
        )
    }

    @Test
    fun `handles k greater than string length`() {
        assertEquals(
            5,
            longestSubstringKDistinct("abcde", 100)
        )
    }

    @Test
    fun `handles longest valid substring at beginning`() {
        assertEquals(
            6,
            longestSubstringKDistinct("aaabbbcd", 2)
        )
    }

    @Test
    fun `handles longest valid substring in middle`() {
        assertEquals(
            6,
            longestSubstringKDistinct("zaabbbay", 2)
        )
    }

    @Test
    fun `handles longest valid substring at end`() {
        assertEquals(
            6,
            longestSubstringKDistinct("xyabbbaa", 2)
        )
    }

    @Test
    fun `handles frequent window shrinking`() {
        assertEquals(
            7,
            longestSubstringKDistinct("abcbdbdbbdcdabd", 2)
        )
    }

    @Test
    fun `handles characters becoming valid again after removal`() {
        assertEquals(
            4,
            longestSubstringKDistinct("abaccc", 2)
        )
    }

    @Test
    fun `handles two identical characters`() {
        assertEquals(
            2,
            longestSubstringKDistinct("aa", 1)
        )
    }

    @Test
    fun `handles two different characters with k one`() {
        assertEquals(
            1,
            longestSubstringKDistinct("ab", 1)
        )
    }

    @Test
    fun `handles two different characters with k two`() {
        assertEquals(
            2,
            longestSubstringKDistinct("ab", 2)
        )
    }

    @Test
    fun `handles large input with one repeated character`() {
        val input = "a".repeat(1000)

        assertEquals(
            1000,
            longestSubstringKDistinct(input, 1)
        )
    }

    @Test
    fun `handles large input containing two character blocks`() {
        val input = "a".repeat(500) + "b".repeat(500)

        assertEquals(
            1000,
            longestSubstringKDistinct(input, 2)
        )
    }

    @Test
    fun `handles large input containing two blocks with k one`() {
        val input = "a".repeat(500) + "b".repeat(500)

        assertEquals(
            500,
            longestSubstringKDistinct(input, 1)
        )
    }

    @Test
    fun `handles large repeating three character pattern with k three`() {
        val input = "abc".repeat(500)

        assertEquals(
            1500,
            longestSubstringKDistinct(input, 3)
        )
    }

    @Test
    fun `handles large repeating three character pattern with k two`() {
        val input = "abc".repeat(500)

        assertEquals(
            2,
            longestSubstringKDistinct(input, 2)
        )
    }
}
