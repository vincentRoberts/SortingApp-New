package ui

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test
import utilities.bubbleSort

class BubbleSortTest {

    @Test
    fun `test bubble sort with empty array`() {
        val array = arrayOf<Int>()
        bubbleSort(array)
        assertArrayEquals(arrayOf<Int>(), array)
    }

    @Test
    fun `test bubble sort with one element`() {
        val array = arrayOf(1)
        bubbleSort(array)
        assertArrayEquals(arrayOf(1), array)
    }

    @Test
    fun `test bubble sort with multiple integer elements`() {
        val array = arrayOf(3, 1, 4, 1, 5, 9, 2, 6)
        bubbleSort(array)
        assertArrayEquals(arrayOf(1, 1, 2, 3, 4, 5, 6, 9), array)
    }

    @Test
    fun `test bubble sort with multiple string elements`() {
        val array = arrayOf("banana", "apple", "cherry")
        bubbleSort(array)
        assertArrayEquals(arrayOf("apple", "banana", "cherry"), array)
    }

    @Test
    fun `test bubble sort with multiple double elements`() {
        val array = arrayOf(3.14, 2.71, 1.41, 1.73)
        bubbleSort(array)
        assertArrayEquals(arrayOf(1.41, 1.73, 2.71, 3.14), array)
    }

    @Test
    fun `test bubble sort with multiple char elements`() {
        val array = arrayOf('d', 'a', 'c', 'b')
        bubbleSort(array)
        assertArrayEquals(arrayOf('a', 'b', 'c', 'd'), array)
    }
}
