package strings.slidingwindow

import kotlin.test.Test
import kotlin.test.assertEquals

class MinimumWindowSubstringTest {

    @Test
    fun `returns empty string when source is empty`() {
        assertEquals(
            "",
            minimumWindowSubstring("", "A")
        )
    }

    @Test
    fun `returns empty string when target is longer than source`() {
        assertEquals(
            "",
            minimumWindowSubstring("a", "aa")
        )
    }

    @Test
    fun `returns single character when source and target are same`() {
        assertEquals(
            "a",
            minimumWindowSubstring("a", "a")
        )
    }

    @Test
    fun `handles standard example`() {
        assertEquals(
            "BANC",
            minimumWindowSubstring("ADOBECODEBANC", "ABC")
        )
    }

    @Test
    fun `returns entire source when entire source is required`() {
        assertEquals(
            "abc",
            minimumWindowSubstring("abc", "abc")
        )
    }

    @Test
    fun `returns empty string when target character is missing`() {
        assertEquals(
            "",
            minimumWindowSubstring("abc", "d")
        )
    }

    @Test
    fun `handles duplicate characters in target`() {
        assertEquals(
            "AABBC",
            minimumWindowSubstring("ZAABBCY", "AABC")
        )
    }

    @Test
    fun `returns empty string when duplicate requirement is not satisfied`() {
        assertEquals(
            "",
            minimumWindowSubstring("ABC", "AABC")
        )
    }

    @Test
    fun `handles minimum window at beginning`() {
        assertEquals(
            "ABC",
            minimumWindowSubstring("ABCXYZ", "ABC")
        )
    }

    @Test
    fun `handles minimum window at end`() {
        assertEquals(
            "ABC",
            minimumWindowSubstring("XYZABC", "ABC")
        )
    }

    @Test
    fun `handles minimum window in middle`() {
        assertEquals(
            "ABC",
            minimumWindowSubstring("XXABCYY", "ABC")
        )
    }

    @Test
    fun `handles target characters in different order`() {
        assertEquals(
            "BAC",
            minimumWindowSubstring("ZZBACYY", "ABC")
        )
    }

    @Test
    fun `handles repeated source characters`() {
        assertEquals(
            "ab",
            minimumWindowSubstring("aaabbb", "ab")
        )
    }

    @Test
    fun `handles all characters being the same`() {
        assertEquals(
            "aaa",
            minimumWindowSubstring("aaaaaa", "aaa")
        )
    }

    @Test
    fun `handles one required occurrence among repeated characters`() {
        assertEquals(
            "a",
            minimumWindowSubstring("aaaaaa", "a")
        )
    }

    @Test
    fun `handles uppercase characters`() {
        assertEquals(
            "AB",
            minimumWindowSubstring("ZZABYY", "AB")
        )
    }

    @Test
    fun `treats uppercase and lowercase as different characters`() {
        assertEquals(
            "aA",
            minimumWindowSubstring("zaAzz", "aA")
        )
    }

    @Test
    fun `returns empty string when character case does not match`() {
        assertEquals(
            "",
            minimumWindowSubstring("abc", "A")
        )
    }

    @Test
    fun `handles alternating characters`() {
        assertEquals(
            "ab",
            minimumWindowSubstring("abababab", "ab")
        )
    }

    @Test
    fun `handles duplicate alternating characters`() {
        assertEquals(
            "aba",
            minimumWindowSubstring("abababab", "aab")
        )
    }

    @Test
    fun `handles extra characters inside window`() {
        assertEquals(
            "AXBYC",
            minimumWindowSubstring("ZZAXBYCZZ", "ABC")
        )
    }

    @Test
    fun `ignores extra duplicate characters`() {
        assertEquals(
            "ABC",
            minimumWindowSubstring("AAABC", "ABC")
        )
    }

    @Test
    fun `shrinks unnecessary characters from left`() {
        assertEquals(
            "ABC",
            minimumWindowSubstring("AAAABC", "ABC")
        )
    }

    @Test
    fun `handles repeated required character after window shrink`() {
        assertEquals(
            "BAAC",
            minimumWindowSubstring("ABAACBAB", "AABC")
        )
    }

    @Test
    fun `handles target with two copies of one character`() {
        assertEquals(
            "AA",
            minimumWindowSubstring("BAAAC", "AA")
        )
    }

    @Test
    fun `handles source and target with mixed case duplicates`() {
        assertEquals(
            "AaA",
            minimumWindowSubstring("zAaAz", "AAa")
        )
    }

    @Test
    fun `handles minimum window of length two`() {
        assertEquals(
            "ba",
            minimumWindowSubstring("cba", "ab")
        )
    }

    @Test
    fun `handles source containing only target characters`() {
        assertEquals(
            "CAB",
            minimumWindowSubstring("CAB", "ABC")
        )
    }

    @Test
    fun `handles larger sliding window example`() {
        assertEquals(
            "CAB",
            minimumWindowSubstring(
                "AAAXYZCABBB",
                "ABC"
            )
        )
    }

    @Test
    fun `handles window requiring repeated character`() {
        assertEquals(
            "baca",
            minimumWindowSubstring("acbbaca", "aba")
        )
    }

    @Test
    fun `returns empty string when target contains unavailable duplicate`() {
        assertEquals(
            "",
            minimumWindowSubstring("ABCD", "AABC")
        )
    }

    @Test
    fun `handles one character target near end`() {
        assertEquals(
            "Z",
            minimumWindowSubstring("ABCDEZ", "Z")
        )
    }

    @Test
    fun `handles one character target near beginning`() {
        assertEquals(
            "A",
            minimumWindowSubstring("ABCDEZ", "A")
        )
    }

    @Test
    fun `handles long repeated prefix`() {
        val source = "A".repeat(1000) + "BC"

        assertEquals(
            "ABC",
            minimumWindowSubstring(source, "ABC")
        )
    }

    @Test
    fun `handles long repeated suffix`() {
        val source = "AB" + "C".repeat(1000)

        assertEquals(
            "ABC",
            minimumWindowSubstring(source, "ABC")
        )
    }

    @Test
    fun `handles large exact target`() {
        val source = "A".repeat(500) + "B".repeat(500)
        val target = "A".repeat(500) + "B".repeat(500)

        assertEquals(
            source,
            minimumWindowSubstring(source, target)
        )
    }

    @Test
    fun `handles large input with no valid window`() {
        val source = "A".repeat(1000)

        assertEquals(
            "",
            minimumWindowSubstring(source, "AB")
        )
    }

    @Test
    fun `handles repeated pattern`() {
        assertEquals(
            "ABC",
            minimumWindowSubstring("ABCABCABC", "ABC")
        )
    }

    @Test
    fun `handles target containing all lowercase letters`() {
        assertEquals(
            "abcdefghijklmnopqrstuvwxyz",
            minimumWindowSubstring(
                "ZZabcdefghijklmnopqrstuvwxyzYY",
                "abcdefghijklmnopqrstuvwxyz"
            )
        )
    }

    @Test
    fun `handles target containing all uppercase letters`() {
        assertEquals(
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
            minimumWindowSubstring(
                "zzABCDEFGHIJKLMNOPQRSTUVWXYZyy",
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            )
        )
    }
}
