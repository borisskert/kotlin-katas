package solution

import kotlin.math.sqrt

/**
 * https://www.codewars.com/kata/5536a85b6ed4ee5a78000035/train/kotlin
 */
object Tour {

    fun tour(arrFriends: Array<String>, ftwns: Array<Array<String>>, h: Map<String, Double>): Int {
        val friendTowns = ftwns.associate { arr -> Pair(arr[0], arr[1]) }

        val distances = arrFriends
            .mapNotNull { friend -> friendTowns[friend] }
            .mapNotNull { town -> h[town] }

        val distance = distances.zipWithNext()
            .sumOf { (a, c) -> oppositeLeg(a, c) } +
                distances.first() +
                distances.last()

        return distance.toInt()
    }
}

/**
 * Calculates the opposite leg by Pythagoras' theorem
 * @param a the adjacent leg
 * @param c the hypotenuse
 * @return the opposite leg (alias b)
 */
fun oppositeLeg(a: Double, c: Double): Double {
    return sqrt(c * c - a * a)
}
