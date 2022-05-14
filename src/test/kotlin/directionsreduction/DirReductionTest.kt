package solution

import org.junit.Test
import kotlin.test.assertEquals

class DirReductionTest {

    private fun testing(arr: Array<String>, expect: Array<String>) {
        val actual: Array<String> = DirReduction.dirReduc(arr)
        assertEquals(expect.contentDeepToString(), actual.contentDeepToString())
    }

    @Test
    fun basicTests() {
        var a = arrayOf("NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST")
        testing(a, arrayOf("WEST"))
        a = arrayOf("NORTH", "WEST", "SOUTH", "EAST")
        testing(a, arrayOf("NORTH", "WEST", "SOUTH", "EAST"))
        a = arrayOf("NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "NORTH")
        testing(a, arrayOf("NORTH"))
        a = arrayOf("NORTH", "EAST", "NORTH", "EAST", "WEST", "WEST", "EAST", "EAST", "WEST", "SOUTH")
        testing(a, arrayOf("NORTH", "EAST"))
        a = arrayOf("")
        testing(a, arrayOf(""))

    }
}
