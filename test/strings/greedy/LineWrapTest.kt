package strings.greedy

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class LineWrapTest {

    @Test
    fun `wraps at breakable characters and keeps short words intact`() {
        val expected = """
            the quick
            brown
            fox
        """.trimIndent()

        assertEquals(expected, wrapText("the quick brown fox", 10))
    }

    @Test
    fun `splits a word that is longer than the width at the boundary`() {
        val expected = """
            Java is a
            Popular
            Programmin
            g-
            language
        """.trimIndent()

        assertEquals(expected, wrapText("Java is a Popular Programming-language", 10))
    }

    @Test
    fun `returns text unchanged when shorter than width`() {
        assertEquals("hello", wrapText("hello", 10))
    }

    @Test
    fun `returns text unchanged when exactly equal to width`() {
        assertEquals("hello", wrapText("hello", 5))
    }

    @Test
    fun `breaks a single long word into width sized chunks`() {
        val expected = """
            abcde
            fghij
            k
        """.trimIndent()

        assertEquals(expected, wrapText("abcdefghijk", 5))
    }

    @Test
    fun `does not start a wrapped line with leading whitespace`() {
        val result = wrapText("one two three four", 4)

        assertFalse(result.lines().any { it.startsWith(" ") })
    }

    @Test
    fun `does not end a wrapped line with trailing whitespace`() {
        val result = wrapText("one two three four", 4)

        assertFalse(result.lines().any { it.endsWith(" ") })
    }

    @Test
    fun `handles empty input`() {
        assertEquals("", wrapText("", 10))
    }

    @Test
    fun `handles only whitespace input`() {
        assertEquals("", wrapText("     ", 10))
    }

    @Test
    fun `rejects zero width`() {
        assertFailsWith<IllegalArgumentException> {
            wrapText("anything", 0)
        }
    }

    @Test
    fun `rejects negative width`() {
        assertFailsWith<IllegalArgumentException> {
            wrapText("anything", -5)
        }
    }

    @Test
    fun `wraps using comma semicolon colon dot and hyphen`() {
        val expected = """
            Kotlin-is
            fast, safe;
            and fun:
            language.
        """.trimIndent()

        assertEquals(
            expected,
            wrapText("Kotlin-is fast, safe; and fun: language.", 12)
        )
    }

    @Test
    fun `breaks after hyphen when needed`() {
        val expected = """
            state-of-
            the-
            art
        """.trimIndent()

        assertEquals(expected, wrapText("state-of-the-art", 9))
    }

    @Test
    fun `breaks after comma when needed`() {
        val expected = """
            apples,
            bananas
        """.trimIndent()

        assertEquals(expected, wrapText("apples, bananas", 8))
    }

    @Test
    fun `breaks after semicolon when needed`() {
        val expected = """
            first;
            second
        """.trimIndent()

        assertEquals(expected, wrapText("first; second", 7))
    }

    @Test
    fun `breaks after colon when needed`() {
        val expected = """
            note:
            read
            docs
        """.trimIndent()

        assertEquals(expected, wrapText("note: read docs", 6))
    }

    @Test
    fun `uses the last breakable character inside the width`() {
        val expected = """
            Dr. Smith
            went home.
        """.trimIndent()

        assertEquals(expected, wrapText("Dr. Smith went home.", 10))
    }

    @Test
    fun `handles multiple spaces between words`() {
        val expected = """
            one
            two
            three
        """.trimIndent()

        assertEquals(expected, wrapText("one     two     three", 6))
    }

    @Test
    fun `handles leading and trailing spaces`() {
        val expected = """
            hello
            world
        """.trimIndent()

        assertEquals(expected, wrapText("   hello world   ", 7))
    }

    @Test
    fun `handles width of one`() {
        val expected = """
            a
            b
            c
        """.trimIndent()

        assertEquals(expected, wrapText("abc", 1))
    }

    @Test
    fun `does not add extra newline at the end`() {
        val result = wrapText("hello world", 5)

        assertFalse(result.endsWith("\n"))
    }

    @Test
    fun `all non empty output lines are within width`() {
        val width = 10
        val result = wrapText("Kotlin-is fast, safe; and fun: ProgrammingLanguage", width)

        assertTrue(result.lines().all { it.length <= width })
    }

    @Test
    fun `complex sentence covers spaces punctuation hyphen and long word`() {
        val expected = """
            Kotlin-is
            fast, safe;
            and fun:
            SuperLongPro
            grammingWord
            .
        """.trimIndent()

        assertEquals(
            expected,
            wrapText("Kotlin-is fast, safe; and fun: SuperLongProgrammingWord.", 12)
        )
    }
}
