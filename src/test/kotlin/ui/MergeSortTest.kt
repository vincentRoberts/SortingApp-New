package ui

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test
import utilities.mergeSort

class MergeSortTest {

    @Test
    fun `test merge sort with empty array`() {
        val array = arrayOf<Int>()
        mergeSort(array)
        assertArrayEquals(arrayOf<Int>(), array)
    }

    @Test
    fun `test merge sort with one element`() {
        val array = arrayOf(1)
        mergeSort(array)
        assertArrayEquals(arrayOf(1), array)
    }

    @Test
    fun `test merge sort with multiple integer elements`() {
        val array = arrayOf(3, 1, 4, 1, 5, 9, 2, 6)
        mergeSort(array)
        assertArrayEquals(arrayOf(1, 1, 2, 3, 4, 5, 6, 9), array)
    }

    @Test
    fun `test merge sort with multiple string elements`() {
        val array = arrayOf("banana", "apple", "cherry")
        mergeSort(array)
        assertArrayEquals(arrayOf("apple", "banana", "cherry"), array)
    }

    @Test
    fun `test merge sort with multiple double elements`() {
        val array = arrayOf(3.14, 2.71, 1.41, 1.73)
        mergeSort(array)
        assertArrayEquals(arrayOf(1.41, 1.73, 2.71, 3.14), array)
    }

    @Test
    fun `test merge sort with multiple char elements`() {
        val array = arrayOf('d', 'a', 'c', 'b')
        mergeSort(array)
        assertArrayEquals(arrayOf('a', 'b', 'c', 'd'), array)
    }
}
