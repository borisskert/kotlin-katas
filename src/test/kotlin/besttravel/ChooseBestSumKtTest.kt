package besttravel

import org.junit.Assert.assertEquals
import org.junit.Ignore
import org.junit.Test

class SumOfKTest {

    @Test
    fun basicTests1() {
        println("****** Basic Tests small numbers******")
        var ts = listOf(50, 55, 56, 57, 58)
        val n = chooseBestSum(163, 3, ts)
        assertEquals(163, n.toLong())
        ts = listOf(50)
        val m = chooseBestSum(163, 3, ts)
        assertEquals(-1, m)
    }

    @Test
    @Ignore("Performance test (~ 4 seconds on M3 Pro)")
    fun hardPerformanceTest() {
        val ts: List<Int> = listOf(
            931, 744, 763, 825, 713, 851, 867, 435, 726, 112, 847, 697, 547, 384, 897, 455, 242, 564, 873, 586, 336,
            934, 208, 557, 876, 644, 934, 753, 664, 725, 941, 754, 563, 972, 683, 636, 428, 943, 653, 862, 929, 645,
            251, 665, 120, 750, 420, 340, 931, 744, 763, 825, 713, 851, 867, 435, 726, 112, 847, 697, 547, 384, 897,
            455, 242, 564, 873, 586, 336, 934, 208, 557, 876, 644
        )

        val start = System.currentTimeMillis()
        val n: Int = chooseBestSum(3198, 5, ts)
        val end = System.currentTimeMillis()
        println("Time: " + (end - start) + " ms")
        assertEquals(3198, n.toLong())
    }

    @Test
    @Ignore("Performance test (~ 10 seconds on M3 Pro)")
    fun harderPerformanceTest() {
        val ts: List<Int> = listOf(
            931, 744, 763, 825, 713, 851, 867, 435, 726, 112, 847, 697, 547, 384, 897, 455, 242, 564, 873, 586, 336,
            934, 208, 557, 876, 644, 934, 753, 664, 725, 941, 754, 563, 972, 683, 636, 428, 943, 653, 862, 929, 645,
            251, 665, 120, 750, 420, 340, 931, 744, 763, 825, 713, 851, 867, 435, 726, 112, 847, 697, 547, 384, 897,
            455, 242, 564, 873, 586, 336, 934, 208, 557, 876, 644, 934, 753, 664, 725, 941, 754, 563, 972, 683, 636
        )

        val start = System.currentTimeMillis()
        val n: Int = chooseBestSum(3198, 5, ts)
        val end = System.currentTimeMillis()
        println("Time: " + (end - start) + " ms")
        assertEquals(3198, n.toLong())
    }

    @Test
    @Ignore("Performance test (~ 20 seconds on M3 Pro)")
    fun evenHarderPerformanceTest() {
        val ts: List<Int> = listOf(
            931, 744, 763, 825, 713, 851, 867, 435, 726, 112, 847, 697, 547, 384, 897, 455, 242, 564, 873, 586, 336,
            934, 208, 557, 876, 644, 934, 753, 664, 725, 941, 754, 563, 972, 683, 636, 428, 943, 653, 862, 929, 645,
            251, 665, 120, 750, 420, 340, 931, 744, 763, 825, 713, 851, 867, 435, 726, 112, 847, 697, 547, 384, 897,
            455, 242, 564, 873, 586, 336, 934, 208, 557, 876, 644, 934, 753, 664, 725, 941, 754, 563, 972, 683, 636,
            428, 943, 653, 862, 929, 645, 251, 665, 120, 750
        )

        val start = System.currentTimeMillis()
        val n: Int = chooseBestSum(3198, 5, ts)
        val end = System.currentTimeMillis()
        println("Time: " + (end - start) + " ms")
        assertEquals(3198, n.toLong())
    }
    
    @Test
    @Ignore("Performance test")
    fun evenHardestPerformanceTest() {
        val ts: List<Int> = listOf(
            931, 744, 763, 825, 713, 851, 867, 435, 726, 112, 847, 697, 547, 384, 897, 455, 242, 564, 873, 586, 336,
            934, 208, 557, 876, 644, 934, 753, 664, 725, 941, 754, 563, 972, 683, 636, 428, 943, 653, 862, 929, 645,
            251, 665, 120, 750, 420, 340, 931, 744, 763, 825, 713, 851, 867, 435, 726, 112, 847, 697, 547, 384, 897,
            455, 242, 564, 873, 586, 336, 934, 208, 557, 876, 644, 934, 753, 664, 725, 941, 754, 563, 972, 683, 636,
            428, 943, 653, 862, 929, 645, 251, 665, 120, 750, 420, 340, 931, 744, 763, 825, 713, 851, 867, 435, 726,
            112, 847, 697, 547, 384, 897, 455, 242, 564, 873, 586, 336, 934, 208, 557, 876, 644, 934, 753, 664, 725,
            941, 754, 563, 972, 683, 636, 428, 943, 653, 862, 929, 645, 251, 665, 120, 750, 420, 340, 931, 744, 763,
        )

        val start = System.currentTimeMillis()
        val n: Int = chooseBestSum(3198, 5, ts)
        val end = System.currentTimeMillis()
        println("Time: " + (end - start) + " ms")
        assertEquals(3198, n.toLong())
    }
}
