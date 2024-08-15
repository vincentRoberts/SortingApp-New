package utilities

fun <T : Comparable<T>> selectionSort(array: Array<T>) {

    val n = array.size

    for (i in 0 until n - 1) {
        var minIndex = i

        // Find the index of the smallest element in the unsorted part of the array
        for (j in i + 1 until n) {
            if (array[j] < array[minIndex]) {
                minIndex = j
            }
        }

        // Swap the smallest element with the current element, if necessary
        if (minIndex != i) {
            val temp = array[i]
            array[i] = array[minIndex]
            array[minIndex] = temp
        }
    }
}