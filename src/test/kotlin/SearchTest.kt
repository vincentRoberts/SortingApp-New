package utilities

import ui.SearchScreen
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SearchTest {

    private val emptyArray = arrayOf<Int>()
    private val singleItemArray = arrayOf(5)
    private val multipleItemsArray = arrayOf(1, 3, 5, 7, 9).sortedArray()

    @Test
    fun `binarySearch - empty array returns -1`() {
        assertEquals(-1, binarySearch(emptyArray, 1))
    }

    @Test
    fun `binarySearch - single item found`() {
        assertEquals(0, binarySearch(singleItemArray, 5))
    }

    @Test
    fun `binarySearch - single item not found`() {
        assertEquals(-1, binarySearch(singleItemArray, 3))
    }

    @Test
    fun `binarySearch - multiple items found`() {
        assertEquals(2, binarySearch(multipleItemsArray, 5))
    }

    @Test
    fun `binarySearch - multiple items not found`() {
        assertEquals(-1, binarySearch(multipleItemsArray, 4))
    }

    @Test
    fun `linearSearch - empty array returns -1`() {
        assertEquals(-1, linearSearch(emptyArray, 1))
    }

    @Test
    fun `linearSearch - single item found`() {
        assertEquals(0, linearSearch(singleItemArray, 5))
    }

    @Test
    fun `linearSearch - single item not found`() {
        assertEquals(-1, linearSearch(singleItemArray, 3))
    }

    @Test
    fun `linearSearch - multiple items found`() {
        assertEquals(2, linearSearch(multipleItemsArray, 5))
    }

    @Test
    fun `linearSearch - multiple items not found`() {
        assertEquals(-1, linearSearch(multipleItemsArray, 4))
    }
}
