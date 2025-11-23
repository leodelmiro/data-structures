// Bubble Sort
// Complexidade O (n²)
// Complexidade espaço O(1)

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

println(bubbleSort(intArrayOf(20, 9, 86, -2, 16)).map { it.toString() }.reduce { acc, it -> "$acc, $it" })
println(bubbleSort(intArrayOf(5, 4, 3, 2, 1)).map { it.toString() }.reduce { acc, it -> "$acc, $it" })

// Bubble Sort Otimizado
// Complexidade O (n²)
// Complexidade espaço O(1)

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

println(bubbleSortOtimizado(intArrayOf(20, 9, 86, -2, 16)).map { it.toString() }.reduce { acc, it -> "$acc, $it" })
println(bubbleSortOtimizado(intArrayOf(5, 4, 3, 2, 1)).map { it.toString() }.reduce { acc, it -> "$acc, $it" })


// Selection Sort
// Complexidade tempo O(n²)
// Complexidade espaço O(1)

fun selectionSort(nums: IntArray): IntArray {
    for (i in nums.indices) {
        var minIndex = i

        for (j in i + 1 until nums.size) {
            if (nums[j] < nums[minIndex]) {
                minIndex = j
            }
        }

        if (minIndex != i) {
            val aux = nums[i]
            nums[i] = nums[minIndex]
            nums[minIndex] = aux
        }
    }

    return nums
}

println(selectionSort(intArrayOf(20, 9, 86, -2, 16)).map { it.toString() }.reduce { acc, it -> "$acc, $it" })
println(selectionSort(intArrayOf(5, 4, 3, 2, 1)).map { it.toString() }.reduce { acc, it -> "$acc, $it" })

// Insertion Sort
// Complexidade tempo O(n²)
// Complexidade espaço O(1)
// Ideal para poucos elementos

fun insertionSort(nums: IntArray): IntArray {
    for (i in 1 until nums.size) {
        val aux = nums[i]
        var j = i - 1

        while (j >= 0 && nums[j] > aux) {
            nums[j + 1] = nums[j]
            j--
        }

        nums[j + 1] = aux
    }

    return nums
}

println(insertionSort(intArrayOf(20, 9, 86, -2, 16)).map { it.toString() }.reduce { acc, it -> "$acc, $it" })
println(insertionSort(intArrayOf(5, 4, 3, 2, 1)).map { it.toString() }.reduce { acc, it -> "$acc, $it" })