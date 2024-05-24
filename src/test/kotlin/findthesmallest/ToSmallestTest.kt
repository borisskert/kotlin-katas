package findthesmallest

import org.junit.Test
import kotlin.test.assertEquals

class ToSmallestTest {
    private fun testing(n: Long, expect: String) {
        val actual = ToSmallest.smallest(n).contentToString()
        assertEquals(expect, actual)
    }

    @Test
    fun fixedTest() {
        testing(261235, "[126235, 2, 0]")
        testing(209917, "[29917, 0, 1]")
        testing(285365, "[238565, 3, 1]")
    }
}
