import kotlin.math.abs

fun minimumCoins(value: Int, coins: IntArray): Int {
    coins.sortDescending()
    var currentValue = value

    var count = 0
    for (i in coins.indices) {
        while (currentValue - coins[i] >= 0) {
            currentValue -= coins[i]
            count++
        }
    }

    return count
}

println(minimumCoins(37, intArrayOf(25, 10, 5, 1)))

data class Task(val start: Int, val end: Int)

fun minimumTime(tasks: Array<Task>): Int {
    tasks.sortedBy { it.end }

    var counter = 0
    var currentTime = 0
    for (i in tasks.indices) {
        if (tasks[i].start >= currentTime) {
            counter++
            currentTime = tasks[i].end
            continue
        }
    }

    return counter
}

println(
    minimumTime(
        arrayOf<Task>(
            Task(1, 4),
            Task(3, 5),
            Task(3, 8),
            Task(4, 7),
            Task(5, 9),
            Task(6, 10),
            Task(8, 11)
        )
    )
)

fun minimumImbalance(jailNumbers: Int, weight: IntArray): Int {
    var meanValue = 0
    var animals = weight
    for (i in weight.indices) {
        meanValue += weight[i]
    }
    meanValue /= jailNumbers

    if (weight.size < jailNumbers * 2) {
        val fictionalAnimalToADD = (jailNumbers * 2) - weight.size

        animals = weight.copyOf(weight.size + fictionalAnimalToADD)
    }

    animals.sort()

    val chambers = Array(jailNumbers) { IntArray(2) }
    for (i in 0 until jailNumbers) {
        chambers[i] = intArrayOf(animals[i], animals[animals.size - i - 1])
    }

    var imbalance = 0
    for (i in chambers.indices) {
        var totalWeight = 0
        for (j in chambers[i].indices) {
            totalWeight += chambers[i][j]
        }
        imbalance += abs(totalWeight - meanValue)
    }

    return imbalance
}

println(minimumImbalance(3, intArrayOf(5, 1, 2, 7)))