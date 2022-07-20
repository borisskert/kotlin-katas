package paginationhelper

import kotlin.test.assertEquals
import org.junit.Test

class PaginationHelperTest {

    @Test
    fun testItemCount() {
        val helper = PaginationHelper(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11), 3)
        assertEquals(11, helper.itemCount, "itemCount is returning incorrect value")
    }

    @Test
    fun testPageCount() {
        val helper = PaginationHelper(listOf('a', 'b', 'c', 'd', 'e', 'f'), 4)
        assertEquals(2, helper.pageCount, "pageCount is returning incorrect value")
    }

    @Test
    fun shouldProvidePageItemCount() {
        assertEquals(5, PaginationHelper(listOf(1, 2, 3, 4, 5), 5).pageItemCount(0))
        assertEquals(-1, PaginationHelper(listOf(1, 2, 3, 4, 5), 5).pageItemCount(1))
        assertEquals(3, PaginationHelper(listOf(1, 2, 3, 4, 5), 3).pageItemCount(0))
        assertEquals(2, PaginationHelper(listOf(1, 2, 3, 4, 5), 3).pageItemCount(1))
        assertEquals(-1, PaginationHelper(listOf(1, 2, 3, 4, 5), 3).pageItemCount(-1))
        assertEquals(-1, PaginationHelper(emptyList<Int>(), 3).pageItemCount(0))
    }

    @Test
    fun shouldProvidePageIndex() {
        assertEquals(0, PaginationHelper(listOf(1, 2, 3, 4, 5), 5).pageIndex(0))
        assertEquals(0, PaginationHelper(listOf(1, 2, 3, 4, 5), 3).pageIndex(0))
        assertEquals(1, PaginationHelper(listOf(1, 2, 3, 4, 5), 2).pageIndex(3))
        assertEquals(-1, PaginationHelper(listOf(1, 2, 3, 4, 5), 2).pageIndex(8))
        assertEquals(-1, PaginationHelper(emptyList<Int>(), 5).pageIndex(8))
        assertEquals(-1, PaginationHelper(listOf('a'), 1).pageIndex(1))
    }

    @Test
    fun shouldProvidePageIndicesForNegativeIndices() {
        assertEquals(-1, PaginationHelper(listOf(0), 1).pageIndex(-1))
        assertEquals(-1, PaginationHelper(listOf(0), 1).pageIndex(-2))
        assertEquals(-1, PaginationHelper(listOf(0), 2).pageIndex(-1))
        assertEquals(-1, PaginationHelper(listOf(0, 1), 1).pageIndex(-1))
        assertEquals(-1, PaginationHelper(listOf(0, 1), 2).pageIndex(-1))
        assertEquals(-1, PaginationHelper(listOf(0, 1, 2, 3, 4), 2).pageIndex(-1))
        assertEquals(-1, PaginationHelper(emptyList<Int>(), 1).pageIndex(-1))
        assertEquals(-1, PaginationHelper(emptyList<Int>(), 2).pageIndex(-1))
        assertEquals(-1, PaginationHelper(emptyList<Int>(), 3).pageIndex(-1))
        assertEquals(-1, PaginationHelper(emptyList<Int>(), 4).pageIndex(-1))

    }


}
