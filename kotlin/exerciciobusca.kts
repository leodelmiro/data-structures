// Busca Sequencial
// Big O O(n)

fun buscaSequencial(nums: IntArray, key: Int): Int {
    for (i in nums.indices) {
        if (nums[i] == key) return i
    }

    return -1
}

println(buscaSequencial(intArrayOf(28, 6, -2, 9, 16, 20, 23, 8), 20))
println(buscaSequencial(intArrayOf(4, 6, -3, 21, 55, 91, 2), 11))

// Busca Binária
// Necessita de dados ordenados
// Big O O(log n)

fun buscaBinaria(nums: IntArray, key: Int): Int {
    var leftPointer = 0
    var rightPointer = nums.lastIndex

    while (leftPointer <= rightPointer) {
        val currentPointer = (leftPointer + rightPointer) / 2
        val midValue = nums[currentPointer]

        if (midValue == key) return currentPointer

        if (key > midValue) {
            leftPointer = currentPointer + 1
        } else {
            rightPointer = currentPointer - 1
        }
    }

    return -1
}

println(buscaBinaria(intArrayOf(1, 6, 9, 16, 20), 20))
println(buscaBinaria(intArrayOf(4, 6, 21, 55, 91), 11))

fun binarySearch(nums: IntArray, key: Int): Int {
    return binarySearchTailRecursive(nums, key, 0, nums.lastIndex)
}

tailrec fun binarySearchTailRecursive(nums: IntArray, key: Int, low: Int, high: Int): Int {

    if (low > high) {
        return -1
    }

    val middle = (low + high) / 2

    return when {
        key == nums[middle] -> middle
        key < nums[middle] -> binarySearchTailRecursive(nums, key, low, middle - 1)
        else -> binarySearchTailRecursive(nums, key, middle + 1, high)
    }
}

val nums1 = intArrayOf(-5, 0, 2, 8, 13, 16, 19, 23, 29, 34, 38)
val nums2 = intArrayOf(-10, -3, 4, 11, 13, 18, 44, 64, 91, 225, 431)

println(binarySearch(nums1, 34)) // 9
println(binarySearch(nums1, 10)) // -1
println(binarySearch(nums2, 11)) // 3