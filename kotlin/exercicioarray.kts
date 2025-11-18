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