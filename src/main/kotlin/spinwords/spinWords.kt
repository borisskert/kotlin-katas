package spinwords

/**
 * https://www.codewars.com/kata/5264d2b162488dc400000001/train/kotlin
 */
fun spinWords(sentence: String): String {
    return sentence.split(" ")
        .joinToString(" ") { word ->
            if (word.length >= 5)
                word.reversed()
            else
                word
        }
}
