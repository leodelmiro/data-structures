// Bubble Sort
// Complexidade O (n²)
// Complexidade espaço O(1)

fun bubbleSort(nums: IntArray): IntArray {
    for (i in nums.indices) {
        for (j in 0 until nums.size - 1 - i) {
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
        for (j in 0 until nums.size - 1 - i) {
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

// Merge Sort
// Um dos mais usados
// Complexidade tempo O(n log n)
// Complexidade espaço O(n)
// Separa os algoritmos em arrays menores e depois faz o merge, em cada merge é feito a ordenação

fun mergeSort(nums: IntArray, left: Int = 0, right: Int = nums.lastIndex): IntArray {
    if (left >= right) return nums

    val middle = (left + right) / 2
    mergeSort(nums, left, middle)
    mergeSort(nums, middle + 1, right)
    merge(nums, left, middle, right)

    return nums
}

fun merge(nums: IntArray, left: Int, middle: Int, right: Int) {
    val length = right - left + 1
    val result = IntArray(length)

    var i = left        // ponteiro da metade esquerda
    var j = middle + 1  // ponteiro da metade direita
    var k = 0           // ponteiro do array auxiliar

    // merge das duas metades
    while (i <= middle && j <= right) {
        if (nums[i] <= nums[j]) {
            result[k++] = nums[i++]
        } else {
            result[k++] = nums[j++]
        }
    }

    // copia o resto da esquerda (se sobrar)
    while (i <= middle) {
        result[k++] = nums[i++]
    }

    // copia o resto da direita (se sobrar)
    while (j <= right) {
        result[k++] = nums[j++]
    }

    // copia de volta para o array original
    for (indice in 0 until length) {
        nums[left + indice] = result[indice]
    }
}

println(mergeSort(intArrayOf(20, 9, 86, -2, 16)).map { it.toString() }.reduce { acc, it -> "$acc, $it" })
println(mergeSort(intArrayOf(5, 4, 3, 2, 1)).map { it.toString() }.reduce { acc, it -> "$acc, $it" })

// Quick Sort
// Muitas das linguagens o implementam por padrão
// Complexidade tempo médio e melhor O(n log n), Pior caso quando pivot não tão bom O(n²)
// Complexidade espaço O(n)
// Separa os algoritmos em arrays menores e depois faz o merge, em cada merge é feito a ordenação

fun quickSort(nums: IntArray, left: Int = 0, right: Int = nums.lastIndex): IntArray {
    // Se não menor é porque só tem um elemento
    if (left < right) {
        val pivot = partition(nums, left, right)
        quickSort(nums, left, pivot - 1)
        quickSort(nums, pivot + 1, right)
    }

    return nums
}

fun partition(nums: IntArray, left: Int, right: Int): Int {
    val pivot = nums[right]
    var i = left

    for (j in left until right) {
        // Coloca os menores sempre a esquerda e anda com o ponteiro da posição do pivot
        if (nums[j] <= pivot) {
            val aux = nums[j]
            nums[j] = nums[i]
            nums[i] = aux
            i++
        }
    }

    val aux = nums[right]
    nums[right] = nums[i]
    nums[i] = aux
    return i
}


println(quickSort(intArrayOf(20, 9, 86, -2, 16)).map { it.toString() }.reduce { acc, it -> "$acc, $it" })
println(quickSort(intArrayOf(5, 4, 3, 2, 1)).map { it.toString() }.reduce { acc, it -> "$acc, $it" })


