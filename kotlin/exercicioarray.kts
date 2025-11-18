fun findMaxConsecutiveOnes(nums: IntArray): Int {
    var maxCounter = 0
    var currentCounter = 0
    for(num in nums) {
        if(num == 1) {
            currentCounter++
            if(currentCounter > maxCounter) maxCounter = currentCounter
            continue
        }

        currentCounter = 0
    }

    return maxCounter
}

println(findMaxConsecutiveOnes(intArrayOf(1,1,0,1,1,1)))
println(findMaxConsecutiveOnes(intArrayOf(1,0,1,1,0,1)))
println("----------------------------")

fun dotProductTwoArrays(nums1: IntArray, nums2: IntArray): Int {
    var total = 0
    for(i in nums1.indices) {
        total += nums1[i] * nums2[i]
    }

    return total
}

println(dotProductTwoArrays(intArrayOf(1,0,0,2,3), intArrayOf(0,3,0,4,0)))
println(dotProductTwoArrays(intArrayOf(0,1,0,0,0), intArrayOf(0,0,0,0,0)))
println(dotProductTwoArrays(intArrayOf(0,1,0,0,2,0,0), intArrayOf(1,0,0,0,3,0,4)))
println("----------------------------")

fun findNumbers(nums: IntArray): Int {
    var result = 0

    for (num in nums) {
        val numLength = num.toString().length
        if(numLength % 2 == 0) result++
    }

    return result
}

println(findNumbers(intArrayOf(12,345,2,6,7896)))
println(findNumbers(intArrayOf(555,901,482,1771)))
println("----------------------------")

fun sortedSquares(nums: IntArray): IntArray {
    val result = nums.copyOf()
    for(i in nums.indices) {
        result[i] = nums[i] * nums[i]
    }

    result.sort()

    return result
}

println(sortedSquares(intArrayOf(-4,-1,0,3,10)))
println(sortedSquares(intArrayOf(-7,-3,2,3,11)))
println("----------------------------")