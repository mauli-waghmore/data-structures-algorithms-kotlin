package strings.twopointers

import kotlin.test.Test
import kotlin.test.assertEquals

class MinimumWindowSubsequenceTest {

    @Test
    fun `returns empty string for empty s1`() {
        assertEquals(
            "",
            minWindow("", "abc")
        )
    }

    @Test
    fun `returns empty string for empty s2`() {
        assertEquals(
            "",
            minWindow("abc", "")
        )
    }

    @Test
    fun `returns empty string when both strings are empty`() {
        assertEquals(
            "",
            minWindow("", "")
        )
    }

    @Test
    fun `returns single character when both strings are same single character`() {
        assertEquals(
            "a",
            minWindow("a", "a")
        )
    }

    @Test
    fun `returns empty string when single character does not match`() {
        assertEquals(
            "",
            minWindow("a", "b")
        )
    }

    @Test
    fun `handles standard example`() {
        assertEquals(
            "bcde",
            minWindow("abcdebdde", "bde")
        )
    }

    @Test
    fun `handles larger standard example`() {
        assertEquals(
            "kzxwqegknd",
            minWindow("fgrqsqsnodwmxzkzxwqegkndaa", "kzed")
        )
    }

    @Test
    fun `returns exact match when s1 equals s2`() {
        assertEquals(
            "abc",
            minWindow("abc", "abc")
        )
    }

    @Test
    fun `returns empty string when s2 is longer than s1`() {
        assertEquals(
            "",
            minWindow("abc", "abcd")
        )
    }

    @Test
    fun `returns empty string when subsequence does not exist`() {
        assertEquals(
            "",
            minWindow("abcde", "aec")
        )
    }

    @Test
    fun `returns entire string when whole s1 is needed`() {
        assertEquals(
            "abcde",
            minWindow("abcde", "ace")
        )
    }

    @Test
    fun `returns smallest window at beginning`() {
        assertEquals(
            "abc",
            minWindow("abcxxxxabc", "abc")
        )
    }

    @Test
    fun `returns smallest window in middle`() {
        assertEquals(
            "abc",
            minWindow("xxxxabcxxxx", "abc")
        )
    }

    @Test
    fun `returns smallest window at end`() {
        assertEquals(
            "abc",
            minWindow("xxxxabc", "abc")
        )
    }

    @Test
    fun `returns earliest window when multiple windows have same length`() {
        assertEquals(
            "abc",
            minWindow("abcxxabc", "abc")
        )
    }

    @Test
    fun `handles repeated characters in s1`() {
        assertEquals(
            "aaa",
            minWindow("aaaaa", "aaa")
        )
    }

    @Test
    fun `handles repeated characters in s2`() {
        assertEquals(
            "aab",
            minWindow("aaab", "aab")
        )
    }

    @Test
    fun `returns empty string when repeated subsequence cannot be formed`() {
        assertEquals(
            "",
            minWindow("abc", "aa")
        )
    }

    @Test
    fun `handles subsequence with gaps`() {
        assertEquals(
            "axbxc",
            minWindow("axbxcxd", "abc")
        )
    }

    @Test
    fun `handles smaller later window`() {
        assertEquals(
            "bdd",
            minWindow("abcdebdde", "bdd")
        )
    }

    @Test
    fun `handles window with duplicate target characters`() {
        assertEquals(
            "abbbbc",
            minWindow("abbbbc", "abbc")
        )
    }

    @Test
    fun `handles all characters same and target smaller`() {
        assertEquals(
            "aaa",
            minWindow("aaaaaa", "aaa")
        )
    }

    @Test
    fun `handles all characters same and target equal length`() {
        assertEquals(
            "aaaaaa",
            minWindow("aaaaaa", "aaaaaa")
        )
    }

    @Test
    fun `handles all characters same and target longer`() {
        assertEquals(
            "",
            minWindow("aaa", "aaaa")
        )
    }

    @Test
    fun `handles single character target`() {
        assertEquals(
            "b",
            minWindow("abcde", "b")
        )
    }

    @Test
    fun `handles single character target appearing multiple times`() {
        assertEquals(
            "a",
            minWindow("baaaac", "a")
        )
    }

    @Test
    fun `returns empty string for missing single character target`() {
        assertEquals(
            "",
            minWindow("abcde", "z")
        )
    }

    @Test
    fun `handles uppercase and lowercase as distinct`() {
        assertEquals(
            "Aa",
            minWindow("aAaA", "Aa")
        )
    }

    @Test
    fun `handles case sensitive mismatch`() {
        assertEquals(
            "",
            minWindow("abc", "A")
        )
    }

    @Test
    fun `handles spaces as characters`() {
        assertEquals(
            "a b",
            minWindow("xxa bxx", "ab")
        )
    }

    @Test
    fun `handles target containing spaces`() {
        assertEquals(
            "a b",
            minWindow("xxa bxx", "a b")
        )
    }

    @Test
    fun `handles string containing only spaces`() {
        assertEquals(
            "  ",
            minWindow("     ", "  ")
        )
    }

    @Test
    fun `handles numeric characters`() {
        assertEquals(
            "123",
            minWindow("0012300123", "123")
        )
    }

    @Test
    fun `handles punctuation characters`() {
        assertEquals(
            "!@#",
            minWindow("xx!@#yy", "!@#")
        )
    }

    @Test
    fun `handles unicode characters`() {
        assertEquals(
            "åβγ",
            minWindow("xxåβγyy", "åγ")
        )
    }

    @Test
    fun `handles subsequence with unicode gaps`() {
        assertEquals(
            "åxβyγ",
            minWindow("zzåxβyγzz", "åβγ")
        )
    }

    @Test
    fun `handles target at very beginning with extra trailing characters`() {
        assertEquals(
            "abc",
            minWindow("abcdddddd", "abc")
        )
    }

    @Test
    fun `handles target at very end with extra leading characters`() {
        assertEquals(
            "abc",
            minWindow("ddddddabc", "abc")
        )
    }

    @Test
    fun `handles multiple possible starts and chooses shortest`() {
        assertEquals(
            "abdc",
            minWindow("abdecfabdc", "abc")
        )
    }

    @Test
    fun `handles overlapping possible windows`() {
        assertEquals(
            "abc",
            minWindow("ababc", "abc")
        )
    }

    @Test
    fun `handles repeated pattern and target`() {
        assertEquals(
            "abc",
            minWindow("abcabcabc", "abc")
        )
    }

    @Test
    fun `handles repeated pattern with longer target`() {
        assertEquals(
            "abca",
            minWindow("abcabcabc", "abca")
        )
    }

    @Test
    fun `handles target requiring characters across repeated pattern`() {
        assertEquals(
            "cab",
            minWindow("abcabcabc", "cab")
        )
    }

    @Test
    fun `handles long gap between target characters`() {
        assertEquals(
            "axxxxxxxxxb",
            minWindow("zzaxxxxxxxxxbyy", "ab")
        )
    }

    @Test
    fun `handles shorter later window after long first window`() {
        assertEquals(
            "ab",
            minWindow("axxxxxxxxxbab", "ab")
        )
    }

    @Test
    fun `handles target with same start and end character`() {
        assertEquals(
            "abca",
            minWindow("xxabcaxx", "aba")
        )
    }

    @Test
    fun `handles target with repeated end character`() {
        assertEquals(
            "abc",
            minWindow("xxabccxx", "abc")
        )
    }

    @Test
    fun `handles target with repeated middle character`() {
        assertEquals(
            "abbc",
            minWindow("xxabbcxx", "abbc")
        )
    }

    @Test
    fun `handles no valid ordering`() {
        assertEquals(
            "",
            minWindow("cba", "abc")
        )
    }

    @Test
    fun `handles valid characters but wrong order first then correct order later`() {
        assertEquals(
            "abc",
            minWindow("cbaabc", "abc")
        )
    }

    @Test
    fun `handles large input with repeated character`() {
        val input = "a".repeat(1000)

        assertEquals(
            "a".repeat(500),
            minWindow(input, "a".repeat(500))
        )
    }

    @Test
    fun `handles large input with target at end`() {
        val input = "x".repeat(1000) + "abc"

        assertEquals(
            "abc",
            minWindow(input, "abc")
        )
    }

    @Test
    fun `handles large input with target at beginning`() {
        val input = "abc" + "x".repeat(1000)

        assertEquals(
            "abc",
            minWindow(input, "abc")
        )
    }

    @Test
    fun `handles large input where subsequence spans full string`() {
        val input = "a" + "x".repeat(1000) + "b" + "y".repeat(1000) + "c"

        assertEquals(
            input,
            minWindow(input, "abc")
        )
    }
}
