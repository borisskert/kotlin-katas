package solution

import java.util.stream.LongStream
import java.util.stream.LongStream.range

/**
 * https://www.codewars.com/kata/55aa075506463dac6600010d/train/kotlin
 */
object SumSquaredDivisors {

    fun listSquared(m: Long, n: Long): String {
        return (m..n)
            .asSequence()
            .map { Pair(it, it.divisors()) }
            .map { pair -> pair.mapSecond(LongStream::squareSum) }
            .filter { it.second.isSquare() }
            .map { it.toList() }
            .toList()
            .toString()
    }
}

fun Long.divisors(): LongStream {
    return range(1, this + 1)
        .takeWhile { it * it <= this }
        .filter { this % it == 0L }
        .flatMap {
            if (it * it == this)
                LongStream.of(it)
            else
                LongStream.of(it, this / it)
        }
}

fun LongStream.squareSum(): Long {
    return this.map { it * it }.sum()
}

fun Long.sqrt(): Long {
    return kotlin.math.sqrt(this.toDouble()).toLong()
}

fun Long.isSquare(): Boolean {
    val sqrt = this.sqrt()
    return sqrt * sqrt == this
}

fun Pair<Long, Long>.toList(): List<Long> {
    return listOf(this.first, this.second)
}

fun <A, B, C> Pair<A, B>.mapSecond(f: (B) -> C): Pair<A, C> {
    return Pair(this.first, f(this.second))
}
