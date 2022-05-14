package solution

/**
 * https://www.codewars.com/kata/550f22f4d758534c1100025a/train/kotlin
 */
object DirReduction {

    fun dirReduc(arr: Array<String>): Array<String> {
        return arr.fold(emptyList<String>()) { directions, direction ->
            if (directions.isEmpty())
                listOf(direction)
            else {
                val last = directions.last()

                if (last.isOppositeTo(direction))
                    directions.dropLast(1)
                else
                    directions.plus(direction)
            }
        }.toTypedArray()
    }
}

fun String.isOppositeTo(other: String): Boolean {
    return when (this) {
        "NORTH" -> other == "SOUTH"
        "SOUTH" -> other == "NORTH"
        "EAST" -> other == "WEST"
        "WEST" -> other == "EAST"
        else -> false
    }
}
