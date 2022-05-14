package maximumsubarraysum

import kotlin.math.max

/**
 * https://www.codewars.com/kata/54521e9ec8e60bc4de000d6c/train/kotlin
 */
fun maxSequence(arr: List<Int>): Int {
    return arr.fold(Pair(0, 0)) { (current, max), x ->
        val nextCurrent = max(0, current + x)
        val nextMax = max(nextCurrent, max)

        Pair(nextCurrent, nextMax)
    }.second
}
