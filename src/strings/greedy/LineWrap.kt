package strings.greedy

/**
 * Line Wrap (Word Wrap)
 * ---------------------
 * Greedily wrap a single line of text so that no output line exceeds `width`
 * characters where avoidable. A break is preferred right after a "breakable"
 * character (whitespace or common punctuation) so words stay intact.
 *
 * Example:
 *   "the quick brown fox", width = 10 ->
 *       the quick
 *       brown fox
 *
 * A word longer than `width` cannot fit on one line, so it is split at the
 * width boundary, e.g. "Programming" with width 10 becomes "Programmin" + "g".
 *
 * Approach:  greedy scan with backtracking to the last breakable character
 *            inside the current window.
 * Time:      O(n) — each character is visited a constant number of times.
 * Space:     O(n) — for the wrapped result.
 */

fun isBreakAble(char: Char): Boolean {
    return char.isWhitespace() ||
        char == '-' ||
        char == ':' ||
        char == ';' ||
        char == ',' ||
        char == '.'
}

fun wrapText(text: String, width: Int): String {
    require(width > 0) { "Width must be positive." }

    val normalizedText = text.trim()

    val result = StringBuilder()
    var start = 0

    while (start < normalizedText.length) {
        while (start < normalizedText.length && normalizedText[start].isWhitespace()) {
            start++
        }

        if (start >= normalizedText.length) {
            break
        }

        val end = minOf(start + width, normalizedText.length)
        var breakPosition = end

        while (breakPosition > start && !isBreakAble(normalizedText[breakPosition - 1])) {
            breakPosition--
        }

        if (breakPosition > start && breakPosition < normalizedText.length) {
            result.append(normalizedText.substring(start, breakPosition).trim())
            result.append("\n")
            start = breakPosition
        } else {
            result.append(normalizedText.substring(start, end).trim())

            if (end < normalizedText.length) {
                result.append("\n")
            }

            start = end
        }
    }

    return result.toString()
}

fun main() {
    val text = "Kotlin-is fast, safe; and fun: but SuperLongProgrammingWord is difficult."

    val width = 12

    println("Input Text:")
    println(text)

    println("\nWidth:")
    println(width)

    println("\nWrapped Output:")
    println("-".repeat(width))
    println(wrapText(text, width))
    println("-".repeat(width))
}
