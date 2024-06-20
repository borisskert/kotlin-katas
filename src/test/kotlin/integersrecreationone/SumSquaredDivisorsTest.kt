package solution

import org.junit.Test
import kotlin.test.assertEquals

class SumSquaredDivisorsTest {

    @Test
    fun basicTests() {
        assertEquals("[[1, 1], [42, 2500], [246, 84100]]", SumSquaredDivisors.listSquared(1, 250))
        assertEquals("[[42, 2500], [246, 84100]]", SumSquaredDivisors.listSquared(42, 250))
    }
}
