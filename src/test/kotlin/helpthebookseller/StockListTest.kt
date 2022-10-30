package solution

import org.junit.Test
import kotlin.test.assertEquals

class StockListTest {

    private fun testing(lstOfArt: Array<String>, lstOfCat: Array<String>, expect: String) {
        val actual: String = StockList.stockSummary(lstOfArt, lstOfCat)
        assertEquals(expect, actual)
    }

    @Test
    fun basicTest1() {
        val b = arrayOf("BBAR 150", "CDXE 515", "BKWR 250", "BTSQ 890", "DRTY 600")
        val c = arrayOf("A", "B", "C", "D")
        val res = "(A : 0) - (B : 1290) - (C : 515) - (D : 600)"
        testing(b, c, res)
    }

    @Test
    fun basicTest2() {
        val b = arrayOf("ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600")
        val c = arrayOf("A", "B")
        val res = "(A : 200) - (B : 1140)"
        testing(b, c, res)
    }

    @Test
    fun basicTest3() {
        val b = arrayOf(
            "ROXANNE 102",
            "RHODODE 123",
            "BKWRKAA 125",
            "BTSQZFG 239",
            "DRTYMKH 060",
            "RHIB 1230",
            "R0 530",
            "XILO 32"
        )
        val c = arrayOf("U", "V", "R")
        val res = "(U : 0) - (V : 0) - (R : 1985)"
        testing(b, c, res)
    }

    @Test
    fun emptyTest() {
        val b = emptyArray<String>()
        val c = arrayOf("A", "B", "C", "D")
        val res = ""
        testing(b, c, res)
    }
}
