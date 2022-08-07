package solution

import kotlin.math.abs
import kotlin.math.min
import kotlin.math.max

/**
 * https://www.codewars.com/kata/573992c724fc289553000e95/train/kotlin
 */
object ToSmallest {

    fun smallest(n: Long): LongArray {
//        val indexedDigits = n.digits().withIndex()
//        val min = indexedDigits.minByOrNull { x -> x.value }
//
//        if (min != null && min.index == 0) {
//            val (n, a, b) = smallest(n.digits().init().value())
//        }
//
//        val newNumber = (sequenceOf(min) + indexedDigits.filterNot { x -> x == min })
//            .map { x -> x!!.value }.toList()
//
//        val i = min!!.index.toLong()
//        val j = 0L
//
//        if (abs(i - j) == 1L) {
//            return longArrayOf(newNumber.value(), min(i, j), max(i, j))
//        }
//
//        return longArrayOf(newNumber.value(), min!!.index.toLong(), 0)

        val (digits, i, j) = find(n.digits())
        return longArrayOf(digits.value(), i, j)
    }
}

fun find(digits: List<Int>): Result {
    val indexedDigits = digits.withIndex()
    val min = indexedDigits.minByOrNull { x -> x.value }

    val newNumber = (sequenceOf(min) + indexedDigits.filterNot { x -> x == min })
        .map { x -> x!!.value }.toList()

    val i = min!!.index
    val j = 0

    if (abs(i - j) == 1) {
        return Result(newNumber, min(i, j), max(i, j))
    }

    return Result(newNumber, min.index, 0)
}

fun List<Int>.value(): Long {
    if (this.isEmpty()) {
        return 0L
    }

    return this.last() + 10 * this.init().value()
}

fun <T> List<T>.init(): List<T> {
    val n = this.size - 1
    return this.take(n)
}

fun Long.digits(digits: List<Int> = emptyList()): List<Int> {
    if (this == 0L) {
        return digits
    }

    val one: Int = (this % 10).toInt()
    val rest: Long = this / 10

    return rest.digits() + listOf(one)
}

fun Int.pow(exp: Int): Int {
    return (1..exp)
        .fold(this) { x, _ -> x * this }
}

class Result(val digits: List<Int>, val i: Int, val j: Int) {
    operator fun component1(): List<Int> {
        return digits
    }

    operator fun component2(): Int {
        return i
    }

    operator fun component3(): Int {
        return j
    }
}
