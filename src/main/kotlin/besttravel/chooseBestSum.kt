package besttravel

/**
 * https://www.codewars.com/kata/55e7280b40e1c4a06d0000aa/train/kotlin
 */
fun chooseBestSum(t: Int, k: Int, ls: List<Int>): Int {
    return ls.combinations(k)
        .map { it.sum() }
        .filter { it <= t }
        .maxOrNull() ?: -1
}

fun <T> List<T>.combinations(k: Int, acc: List<T> = emptyList()): List<List<T>> {
    if (k == 0) return listOf(acc)
    if (isEmpty()) return emptyList()

    return drop(1)
        .combinations(k - 1, acc + first()) + drop(1).combinations(k, acc)
}

// best practice (a lot of faster)

//fun chooseBestSum(t: Int, k: Int, ls: List<Int>): Int {
//    return ls.findBestCombination(k, { it.sum() }, t)?.sum() ?: -1
//}
//
//fun <T, R : Comparable<R>> List<T>.findBestCombination(
//    k: Int,
//    f: (List<T>) -> R?,
//    max: R,
//    found: List<T> = emptyList(),
//    n: Int = 0
//): (List<T>)? {
//    val result = f(found)
//    if (k == 0 && (result == null || result <= max)) return found
//    if (result != null && result > max || n >= size) return null
//
//    val a = findBestCombination(k - 1, f, max, found + get(n), n + 1)
//    val b = findBestCombination(k, f, max, found, n + 1)
//
//    return if (a == null) b else if (b == null) a else if (f(a)!! > f(b)!!) a else b
//}
