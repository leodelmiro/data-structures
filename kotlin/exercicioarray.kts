fun findMaxConsecutiveOnes(nums: IntArray): Int {
    var maxCounter = 0
    var currentCounter = 0
    for (num in nums) {
        if (num == 1) {
            currentCounter++
            if (currentCounter > maxCounter) maxCounter = currentCounter
            continue
        }

        currentCounter = 0
    }

    return maxCounter
}

println(findMaxConsecutiveOnes(intArrayOf(1, 1, 0, 1, 1, 1)))
println(findMaxConsecutiveOnes(intArrayOf(1, 0, 1, 1, 0, 1)))
println("----------------------------")

fun dotProductTwoArrays(nums1: IntArray, nums2: IntArray): Int {
    var total = 0
    for (i in nums1.indices) {
        total += nums1[i] * nums2[i]
    }

    return total
}

println(dotProductTwoArrays(intArrayOf(1, 0, 0, 2, 3), intArrayOf(0, 3, 0, 4, 0)))
println(dotProductTwoArrays(intArrayOf(0, 1, 0, 0, 0), intArrayOf(0, 0, 0, 0, 0)))
println(dotProductTwoArrays(intArrayOf(0, 1, 0, 0, 2, 0, 0), intArrayOf(1, 0, 0, 0, 3, 0, 4)))
println("----------------------------")

fun findNumbers(nums: IntArray): Int {
    var result = 0

    for (num in nums) {
        val numLength = num.toString().length
        if (numLength % 2 == 0) result++
    }

    return result
}

println(findNumbers(intArrayOf(12, 345, 2, 6, 7896)))
println(findNumbers(intArrayOf(555, 901, 482, 1771)))
println("----------------------------")

fun sortedSquares(nums: IntArray): IntArray {
    val result = nums.copyOf()
    for (i in nums.indices) {
        result[i] = nums[i] * nums[i]
    }

    result.sort()

    return result
}

println(sortedSquares(intArrayOf(-4, -1, 0, 3, 10)))
println(sortedSquares(intArrayOf(-7, -3, 2, 3, 11)))
println("----------------------------")

fun duplicateZeros(arr: IntArray) {
    var i = 0

    while (i < arr.size - 1) {
        if (arr[i] == 0) {
            // shift de trás pra frente
            for (j in arr.size - 1 downTo i + 1) {
                arr[j] = arr[j - 1]
            }
            // duplicar zero
            arr[i + 1] = 0
            i += 2 // pula o zero duplicado
        } else {
            i++
        }
    }
}

val example1 = intArrayOf(1, 0, 2, 3, 0, 4, 5, 0)
val example2 = intArrayOf(1, 2, 3)
println(duplicateZeros(example1))
println(duplicateZeros(example2))
println("----------------------------")

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    var rightPointer = m - 1
    var leftPointer = n - 1
    var mergedPointer = m + n - 1
    while (leftPointer >= 0) {
        if (rightPointer >= 0 && nums1[rightPointer] >= nums2[leftPointer]) {
            nums1[mergedPointer] = nums1[rightPointer]
            mergedPointer--
            rightPointer--
            continue
        }
        nums1[mergedPointer] = nums2[leftPointer]
        mergedPointer--
        leftPointer--
    }
}


val example1Merge = intArrayOf(1, 2, 3, 0, 0, 0)
val example2Merge = intArrayOf(2, 5, 6)
println(merge(example1Merge, 3, example2Merge, 3))