package solution

/**
 * https://www.codewars.com/kata/54dc6f5a224c26032800005c/train/kotlin
 */
object StockList {
    fun stockSummary(lstOfArt: Array<String>, lstOfCat: Array<String>): String {
        if (lstOfArt.isEmpty()) {
            return ""
        }

        val stock = lstOfArt
            .map(::readOne)
            .groupBy { it.category }
            .map { (key, value) ->
                StockItem(key, value.sumOf { it.quantity })
            }
            .associateBy { it.category }

        return lstOfCat
            .map {
                stock[it] ?: StockItem(it, 0)
            }
            .joinToString(" - ") {
                "(${it.category} : ${it.quantity})"
            }
    }
}

data class StockItem(val category: String, val quantity: Int) {
}

val stockItemPattern = """([A-Z][A-Z0-9]+) ([0-9]+)""".toRegex()

fun readOne(input: String): StockItem {
    val match = stockItemPattern.matchEntire(input)
    val groups = match!!.groups

    val category = groups[1]!!.value
    val quantity = groups[2]!!.value

    return StockItem(category.take(1), quantity.toInt())
}
