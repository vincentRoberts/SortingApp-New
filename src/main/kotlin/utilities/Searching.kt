package utilities

fun <T> linearSearch(array: Array<T>, target: T): Int {
    for (index in array.indices) {
        if (array[index] == target) {
            return index
        }
    }
    return -1
}