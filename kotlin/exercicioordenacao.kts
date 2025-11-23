// Bubble Sort
// Complexidade O (n²)

fun bubbleSort(nums: IntArray): IntArray {
    for (i in nums.indices) {
        for (j in 0 until nums.size - 1) {
            if (nums[j] > nums[j + 1]) {
                val aux = nums[j]
                nums[j] = nums[j + 1]
                nums[j + 1] = aux
            }
        }
    }

    return nums
}

println(bubbleSort(intArrayOf(20, 9, 86, -2, 16)).map { it.toString() }.reduce { acc, it -> "$acc, $it"})
println(bubbleSort(intArrayOf(5, 4, 3, 2, 1)).map { it.toString() }.reduce { acc, it -> "$acc, $it"})

// Bubble Sort Otimizado
// Complexidade O (n²)

fun bubbleSortOtimizado(nums: IntArray): IntArray {
    for (i in nums.indices) {
        var swapped = false
        for (j in 0 until nums.size - 1) {
            if (nums[j] > nums[j + 1]) {
                val aux = nums[j]
                nums[j] = nums[j + 1]
                nums[j + 1] = aux
                swapped = true
            }
        }
        if (!swapped) break
    }

    return nums
}

println(bubbleSortOtimizado(intArrayOf(20, 9, 86, -2, 16)).map { it.toString() }.reduce { acc, it -> "$acc, $it"})
println(bubbleSortOtimizado(intArrayOf(5, 4, 3, 2, 1)).map { it.toString() }.reduce { acc, it -> "$acc, $it"})