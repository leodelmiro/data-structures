class Solution {
    fun climbStairs(n: Int): Int {
        if(n <= 2) return n

        val memo = Array(n + 1) { 0 }
        memo[0] = 0
        memo[1] = 1
        memo[2] = 2

        for (i in 3..n) {
            memo[i] = memo[i - 1] + memo[i - 2]
        }

        return memo[n]
    }
}