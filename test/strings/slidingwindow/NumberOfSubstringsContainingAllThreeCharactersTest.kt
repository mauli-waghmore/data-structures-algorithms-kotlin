package strings.slidingwindow

import kotlin.test.Test
import kotlin.test.assertEquals

class NumberOfSubstringsContainingAllThreeCharactersTest {

    @Test
    fun `returns five for abcba`() {
        assertEquals(5, numberOfSubStrings("abcba"))
    }

    @Test
    fun `returns eight for ccabcc`() {
        assertEquals(8, numberOfSubStrings("ccabcc"))
    }

    @Test
    fun `returns twenty five for abcabcacc`() {
        assertEquals(25, numberOfSubStrings("abcabcacc"))
    }

    @Test
    fun `returns ten for abcabc`() {
        assertEquals(10, numberOfSubStrings("abcabc"))
    }

    @Test
    fun `returns one for abc`() {
        assertEquals(1, numberOfSubStrings("abc"))
    }

    @Test
    fun `returns one for cba`() {
        assertEquals(1, numberOfSubStrings("cba"))
    }

    @Test
    fun `returns one for bac`() {
        assertEquals(1, numberOfSubStrings("bac"))
    }

    @Test
    fun `returns one for bca`() {
        assertEquals(1, numberOfSubStrings("bca"))
    }

    @Test
    fun `returns one for cab`() {
        assertEquals(1, numberOfSubStrings("cab"))
    }

    @Test
    fun `returns zero for empty string`() {
        assertEquals(0, numberOfSubStrings(""))
    }

    @Test
    fun `returns zero for single a`() {
        assertEquals(0, numberOfSubStrings("a"))
    }

    @Test
    fun `returns zero for single b`() {
        assertEquals(0, numberOfSubStrings("b"))
    }

    @Test
    fun `returns zero for single c`() {
        assertEquals(0, numberOfSubStrings("c"))
    }

    @Test
    fun `returns zero when string contains only a and b`() {
        assertEquals(0, numberOfSubStrings("ababab"))
    }

    @Test
    fun `returns zero when string contains only a and c`() {
        assertEquals(0, numberOfSubStrings("acacac"))
    }

    @Test
    fun `returns zero when string contains only b and c`() {
        assertEquals(0, numberOfSubStrings("bcbcbc"))
    }

    @Test
    fun `returns zero when string contains only a`() {
        assertEquals(0, numberOfSubStrings("aaaaaa"))
    }

    @Test
    fun `returns zero when string contains only b`() {
        assertEquals(0, numberOfSubStrings("bbbbbb"))
    }

    @Test
    fun `returns zero when string contains only c`() {
        assertEquals(0, numberOfSubStrings("cccccc"))
    }

    @Test
    fun `returns zero for two character string ab`() {
        assertEquals(0, numberOfSubStrings("ab"))
    }

    @Test
    fun `returns zero for two character string ac`() {
        assertEquals(0, numberOfSubStrings("ac"))
    }

    @Test
    fun `returns zero for two character string bc`() {
        assertEquals(0, numberOfSubStrings("bc"))
    }

    @Test
    fun `handles repeated characters before all three appear`() {
        assertEquals(4, numberOfSubStrings("aabbcc"))
    }

    @Test
    fun `handles large repeated groups`() {
        assertEquals(9, numberOfSubStrings("aaabbbccc"))
    }

    @Test
    fun `handles repeated a at beginning`() {
        assertEquals(5, numberOfSubStrings("aaaaabc"))
    }

    @Test
    fun `handles repeated a at end`() {
        assertEquals(9, numberOfSubStrings("abcaaaa"))
    }

    @Test
    fun `handles repeated c at beginning`() {
        assertEquals(4, numberOfSubStrings("ccccab"))
    }

    @Test
    fun `handles repeated c at end`() {
        assertEquals(4, numberOfSubStrings("abcccc"))
    }

    @Test
    fun `handles duplicate b before c`() {
        assertEquals(1, numberOfSubStrings("abbc"))
    }

    @Test
    fun `handles duplicate a before b and c`() {
        assertEquals(2, numberOfSubStrings("aabc"))
    }

    @Test
    fun `handles extra character after abc`() {
        assertEquals(3, numberOfSubStrings("abca"))
    }

    @Test
    fun `handles extra b after abc`() {
        assertEquals(2, numberOfSubStrings("abcb"))
    }

    @Test
    fun `handles c before abc`() {
        assertEquals(3, numberOfSubStrings("cabc"))
    }

    @Test
    fun `handles valid windows starting at different positions`() {
        assertEquals(6, numberOfSubStrings("bcabc"))
    }

    @Test
    fun `handles characters in different repeating order`() {
        assertEquals(10, numberOfSubStrings("acbacb"))
    }

    @Test
    fun `handles palindrome containing all characters`() {
        assertEquals(7, numberOfSubStrings("abccba"))
    }

    @Test
    fun `handles multiple valid windows in cababc`() {
        assertEquals(7, numberOfSubStrings("cababc"))
    }

    @Test
    fun `handles repeated characters around valid window`() {
        assertEquals(7, numberOfSubStrings("aaabca"))
    }

    @Test
    fun `handles three repetitions of abc`() {
        assertEquals(28, numberOfSubStrings("abcabcabc"))
    }

    @Test
    fun `handles three repetitions in reverse mixed order`() {
        assertEquals(28, numberOfSubStrings("cbacbacba"))
    }

    @Test
    fun `handles longer grouped and repeating string`() {
        assertEquals(34, numberOfSubStrings("aaabbbcccabc"))
    }

    @Test
    fun `handles a characters at both ends`() {
        assertEquals(8, numberOfSubStrings("acccbbbba"))
    }
}
