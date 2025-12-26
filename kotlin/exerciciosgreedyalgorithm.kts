fun minimumCoins(value: Int, coinNumber: Int, coins: IntArray): Int {
    coins.sortDescending()
    var currentValue = value

    var count = 0
    for (i in 0 until coinNumber) {
        while (currentValue - coins[i] >= 0) {
            currentValue -= coins[i]
            count++
        }
    }

    return count
}

println(minimumCoins(37, 4, intArrayOf(25, 10, 5, 1)))