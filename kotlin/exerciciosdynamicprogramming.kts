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

class Solution4 {
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

// Recursiva (Top down)
class Solution5 {
    fun minPathSum(grid: Array<IntArray>): Int {
        val lastRow = grid.size - 1
        val dp = Array(grid.size) { IntArray(grid[lastRow].size) { -1 } }

        return recursion(0, 0, grid, dp)
    }

    private fun recursion(i: Int, j: Int, grid: Array<IntArray>, dp: Array<IntArray>): Int {
        if(i < 0 || j < 0 || i >= grid.size || j >= grid[0].size) return Int.MAX_VALUE
        if (i == grid.size - 1 && j == grid[0].size - 1) return grid[i][j]
        if(dp[i][j] != -1) return dp[i][j]

        dp[i][j] = minOf(recursion(i, j+1, grid, dp), recursion(i+1, j, grid, dp)) + grid[i][j]
        return dp[i][j]
    }
}

// Recursiva (Bottom Up)
class Solution6 {
    fun minPathSum(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size

        val dp = Array(m) { IntArray(n) }

        dp[0][0] = grid[0][0]

        // Preenchendo os bases que não tem de onde andar inicialmente que nao seja de cima
        for (i in 1 until m)
            dp[i][0] = dp[i - 1][0] + grid[i][0]

        // Preenchendo os bases que não tem de onde andar inicialmente que nao seja da direita
        for (j in 1 until n)
            dp[0][j] = dp[0][j - 1] + grid[0][j]

        // Preenchendo demais casos
        for (i in 1 until m) {
            for (j in 1 until n) {
                dp[i][j] = grid[i][j] + minOf(dp[i - 1][j], dp[i][j - 1])
            }
        }

        return dp[m - 1][n - 1]
    }
}

fun maxProfit(n: Int, values: IntArray): Int {
    val dp = IntArray(n + 1) { 0 }

    for(i in 1..n) {
        for (j in 1..n) {
            if (i - j >= 0) dp[i] = maxOf(dp[i], dp[i - j] + values[j - 1])
        }
    }

    return dp[n]
}

println("==================")
println(maxProfit(4, intArrayOf(2, 5, 7, 9)))
println(maxProfit(8, intArrayOf(1, 5, 8, 9, 10, 17, 17, 20)))
println(maxProfit(8, intArrayOf(3, 5, 8, 9, 10, 17, 17, 20)))
println("==================")