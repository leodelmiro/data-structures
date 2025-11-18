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