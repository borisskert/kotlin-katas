package simpleassemblerinterpreter

import org.junit.Test
import kotlin.test.assertEquals

class SolutionTest {

    @Test
    fun varySimple1() {
        assertEquals(
            mapOf("a" to 6),
            interpret(arrayOf("mov a 5", "inc a"))
        )
    }

    @Test
    fun varySimple2() {
        assertEquals(
            mapOf("a" to 5),
            interpret(arrayOf("mov a 5", "inc a", "dec a"))
        )
    }

    @Test
    fun varySimple3() {
        assertEquals(
            mapOf("a" to 3, "b" to 3),
            interpret(arrayOf("mov a 5", "mov b 3", "mov a b",  "inc a", "dec a"))
        )
    }

    @Test
    fun simple1() {
        assertEquals(
            mapOf("a" to 1),
            interpret(arrayOf("mov a 5", "inc a", "dec a", "dec a", "jnz a -1", "inc a"))
        )
    }

    @Test
    fun simple2() {
        assertEquals(
            mapOf("a" to 0, "b" to -20),
            interpret(arrayOf("mov a -10", "mov b a", "inc a", "dec b", "jnz a -2"))
        )
    }
}
