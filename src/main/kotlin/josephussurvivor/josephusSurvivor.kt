package josephussurvivor

/**
 * https://www.codewars.com/kata/555624b601231dc7a400017a/train/kotlin
 */
fun josephusSurvivor(n: Int, k: Int): Int {
    return (1..n)
        .reduce { x, ni -> (x + k - 1) % ni + 1 }
}
