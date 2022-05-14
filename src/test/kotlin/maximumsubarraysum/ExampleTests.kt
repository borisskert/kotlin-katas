package maximumsubarraysum

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class ExampleTests {

    @Test
    fun `it should work on an empty list`() {
        assertEquals(0, maxSequence(emptyList()))
    }

    @Test
    fun `it should work on the example`() {
        assertEquals(6, maxSequence(listOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
    }

}
