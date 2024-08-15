package ui

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import utilities.insertionSort
import utilities.selectionSort

class SortTests {

    @Test
    fun `selectionSort should handle an empty array`() {
        val array = arrayOf<Int>()
        selectionSort(array)
        assertArrayEquals(arrayOf<Int>(), array)
    }

    @Test
    fun `selectionSort should handle an array with one item`() {
        val array = arrayOf(5)
        selectionSort(array)
        assertArrayEquals(arrayOf(5), array)
    }

    @Test
    fun `selectionSort should handle an array with multiple items`() {
        val array = arrayOf(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5)
        selectionSort(array)
        assertArrayEquals(arrayOf(1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9), array)
    }

    @Test
    fun `selectionSort should handle an array of Strings`() {
        val array = arrayOf("banana", "apple", "cherry")
        selectionSort(array)
        assertArrayEquals(arrayOf("apple", "banana", "cherry"), array)
    }

    @Test
    fun `selectionSort should handle an array of Doubles`() {
        val array = arrayOf(2.5, 1.1, 3.3)
        selectionSort(array)
        assertArrayEquals(arrayOf(1.1, 2.5, 3.3), array)
    }

    @Test
    fun `selectionSort should handle an array of Chars`() {
        val array = arrayOf('d', 'a', 'c', 'b')
        selectionSort(array)
        assertArrayEquals(arrayOf('a', 'b', 'c', 'd'), array)
    }

    @Test
    fun `insertionSort should handle an empty array`() {
        val array = arrayOf<Int>()
        insertionSort(array)
        assertArrayEquals(arrayOf<Int>(), array)
    }

    @Test
    fun `insertionSort should handle an array with one item`() {
        val array = arrayOf(5)
        insertionSort(array)
        assertArrayEquals(arrayOf(5), array)
    }

    @Test
    fun `insertionSort should handle an array with multiple items`() {
        val array = arrayOf(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5)
        insertionSort(array)
        assertArrayEquals(arrayOf(1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9), array)
    }

    @Test
    fun `insertionSort should handle an array of Strings`() {
        val array = arrayOf("banana", "apple", "cherry")
        insertionSort(array)
        assertArrayEquals(arrayOf("apple", "banana", "cherry"), array)
    }

    @Test
    fun `insertionSort should handle an array of Doubles`() {
        val array = arrayOf(2.5, 1.1, 3.3)
        insertionSort(array)
        assertArrayEquals(arrayOf(1.1, 2.5, 3.3), array)
    }

    @Test
    fun `insertionSort should handle an array of Chars`() {
        val array = arrayOf('d', 'a', 'c', 'b')
        insertionSort(array)
        assertArrayEquals(arrayOf('a', 'b', 'c', 'd'), array)
    }
}
