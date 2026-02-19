import kotlin.math.abs

class Solution1 {
    fun climbStairs(n: Int): Int {
        if (n <= 2) return n

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

// Solução fazendo o atual + memo do anterior ou do ante penultimo já que pode andar sempre 1 ou 2
class Solution2 {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val memo = IntArray(cost.size + 1) { 0 }
        memo[0] = 0
        memo[1] = cost[0]

        for (i in 2..cost.size) {
            memo[i] = minOf(memo[i - 1] + cost[i - 1], memo[i - 2] + cost[i - 1])
        }

        return minOf(memo[memo.size - 1], memo[memo.size - 2])
    }
}

// Solução fazendo o anterior + memo do anterior ou do ante penultimo + ante penultimo aqui basicamente conta quantos pra chegar no step atual ainda não contabilizando o atual
class Solution3 {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val memo = IntArray(cost.size + 1) { 0 }

        for (i in 2..cost.size) {
            memo[i] = minOf(memo[i - 1] + cost[i - 1], memo[i - 2] + cost[i - 2])
        }

        return memo[cost.size]
    }
}

fun minJumpsValue(values: IntArray): Int {
    val n = values.size
    val dp = IntArray(n) { 0 }

    for (i in 1 until n) {
        val jumpOne = dp[i - 1] + abs(values[i] - values[i - 1])

        val jumpTwo = if (i > 1)
            dp[i - 2] + abs(values[i] - values[i - 2])
        else
            Int.MAX_VALUE

        dp[i] = minOf(jumpOne, jumpTwo)
    }

    return dp[n - 1]
}

println(minJumpsValue(intArrayOf(10, 10)))
println(minJumpsValue(intArrayOf(10, 30, 40, 20)))
println(minJumpsValue(intArrayOf(30, 10, 60, 10, 60, 50)))

class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val dp = IntArray(amount + 1) { amount + 1 }

        dp[0] = 0
        for(i in 1..amount) {
            for(c in coins) {
                if(i - c >= 0) {
                    dp[i] = minOf(dp[i], dp[i - c] + 1)
                }
            }
        }

        return if (dp[amount] > amount) -1 else dp[amount]
    }
}