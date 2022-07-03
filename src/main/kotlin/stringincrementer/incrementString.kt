package stringincrementer

/**
 * https://www.codewars.com/kata/54a91a4883a7de5d7800009c/train/kotlin
 */
fun incrementString(str: String): String {
    val (text, counter) = parse(str)
    return "$text${counter + 1}"
}

fun parse(str: String, counter: String = ""): Pair<String, Int> {
    if (str.isEmpty()) {
        return Pair("", Integer.parseInt("0$counter"))
    }

    val potentialDigit = str.last()

    if (!potentialDigit.isDigit()) {
        return Pair(str, Integer.parseInt("0$counter"))
    }

    val init = str.take(str.length - 1)

    if (potentialDigit != '9') {
        return Pair(init, Integer.parseInt("$potentialDigit$counter"));
    }

    return parse(init, "$potentialDigit$counter")
}
