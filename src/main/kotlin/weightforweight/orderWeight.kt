package weight

/**
 * https://www.codewars.com/kata/55c6126177c9441a570000cc/train/kotlin
 */
fun orderWeight(string: String): String {
    return string.split(" ")
        .map { s -> Weight.from(s) }
        .sorted()
        .joinToString(" ")
        { w -> w.raw() }
}

class Weight private constructor(
    private val raw: String,
    private val crossSum: Int,
) : Comparable<Weight> {

    override fun compareTo(other: Weight): Int {
        return COMPARATOR.compare(this, other)
    }

    fun raw(): String {
        return raw
    }

    companion object {
        private val COMPARATOR = Comparator
            .comparingInt(Weight::crossSum)
            .thenComparing { o1, o2 -> o1.raw.compareTo(o2.raw) }

        fun from(weight: String): Weight {
            val crossSum = toCrossSum(weight)
            return Weight(weight, crossSum)
        }

        private fun toCrossSum(weight: String): Int {
            return weight.chars()
                .map { i -> i - '0'.code }
                .sum()
        }
    }
}
