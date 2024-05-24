package findthesmallest

/**
 * https://www.codewars.com/kata/573992c724fc289553000e95/train/kotlin
 */
object ToSmallest {

    fun smallest(n: Long): LongArray {
        return Result.possibleResults(n)
            .minOrNull()
            ?.toLongArray()
            ?: longArrayOf(n, 0, 0)
    }
}

class Result(
    private val n: Long,
    private val i: Long,
    private val j: Long
) : Comparable<Result> {

    fun toLongArray(): LongArray = longArrayOf(n, i, j)

    companion object Factory {
        fun possibleResults(n: Long): List<Result> {
            val size = n.length()

            return cartesianProduct(size)
                .map { (i, j) ->
                    Result(n.moveDigit(i, j), i.toLong(), j.toLong())
                }
        }
    }

    override fun compareTo(other: Result): Int {
        return this.n.compareTo(other.n)
    }
}

fun cartesianProduct(a: Int, b: Int = a): List<Pair<Int, Int>> {
    return (0 until a)
        .flatMap { i ->
            (0 until b)
                .map { j -> Pair(i, j) }
        }
}

typealias Digits = List<Int>

fun Long.digits(): Digits {
    var digits: List<Int> = emptyList()
    var value = this

    while (value > 0) {
        digits = listOf((value % 10).toInt()) + digits
        value /= 10
    }

    return digits
}

fun Long.moveDigit(from: Int, to: Int): Long {
    if (from == to) return this

    val digits: Digits = this.digits()
    val digit: Int = digits[from]

    return digits.toMutableList().apply {
        removeAt(from)
        add(to, digit)
    }.let { Long.fromDigits(it) }
}

fun Long.length(): Int = this.toString().length

fun Long.Companion.fromDigits(digits: Digits): Long = digits
    .fold(0L) { acc, digit -> acc * 10 + digit }
