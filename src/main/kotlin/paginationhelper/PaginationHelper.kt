package paginationhelper

/**
 * https://www.codewars.com/kata/515bb423de843ea99400000a/train/kotlin
 */
class PaginationHelper<T>(private val collection: List<T>, private val itemsPerPage: Int) {

    /**
     * returns the number of items within the entire collection
     */
    val itemCount: Int
        get() {
            return collection.size
        }

    /**
     * returns the number of pages
     */
    val pageCount: Int
        get() {
            if (itemCount % itemsPerPage == 0) {
                return itemCount / itemsPerPage
            }

            return itemCount / itemsPerPage + 1
        }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    fun pageItemCount(pageIndex: Int): Int {
        if (pageIndex < 0 || pageIndex >= pageCount) {
            return -1
        }

        val rest = itemCount % itemsPerPage
        if (rest == 0) {
            return itemsPerPage
        }

        if (pageIndex == pageCount - 1) {
            return rest
        }

        return itemsPerPage
    }


    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    fun pageIndex(itemIndex: Int): Int {
        if (itemIndex < 0 || itemIndex >= itemCount) {
            return -1
        }

        return itemIndex / itemsPerPage
    }
}
