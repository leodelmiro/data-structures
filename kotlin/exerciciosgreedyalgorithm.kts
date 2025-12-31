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
println()

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
println()

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
println()

fun minimumBottle(lakeSize: Int, bottles: IntArray): Int {
    var currentWater = lakeSize
    bottles.sort()
    var counter = 0

    for (i in bottles.indices) {
        if (bottles[i] <= currentWater) {
            currentWater -= bottles[i]
            counter++
            continue
        }

        break
    }

    return counter
}

println(minimumBottle(10, intArrayOf(8, 5, 4, 3, 2)))
println(minimumBottle(10, intArrayOf(6, 3, 2)))
println()

fun minimumScarecrows(field: String): Int {
    var counter = 0

    var currentSpot = 0
    while (currentSpot in field.indices) {
        if (field[currentSpot] == '.') {
            currentSpot += 3
            counter++
            continue
        }

        currentSpot++
    }

    return counter
}

println(minimumScarecrows(".#."))
println(minimumScarecrows("...##....##"))
println(minimumScarecrows("##"))
println()

fun lemonadeChange(bills: IntArray): Boolean {
    val myBills = mutableMapOf(
        5 to 0,
        10 to 0,
        20 to 0
    )

    for (bill in bills) {
        // Adiciona a nota recebida ao nosso controle
        myBills[bill] = myBills[bill]!! + 1

        var change = bill - 5

        // Tentativas de dar o troco, começando com cédulas de maior valor
        val values = intArrayOf(20, 10, 5)
        for (value in values) {
            while (change >= value && myBills[value]!! > 0) {
                myBills[value] = myBills[value]!! - 1
                change -= value
            }
        }

        // Se após tentar dar o troco ainda resta valor, retorna false
        if (change > 0) {
            return false
        }
    }

    // Se foi possível dar o troco em todos os casos, retorna true
    return true
}
println(lemonadeChange(intArrayOf(5, 5, 5, 10, 20)))
println(lemonadeChange(intArrayOf(5, 5, 10, 10, 20)))
println()

fun minimumRooms(start: IntArray, end: IntArray, n: Int): Int {
    start.sort()
    end.sort()

    var i = 0
    var j = 0
    var ans = 0
    var rooms = 0

    // Aloca salas conforme necessário e mantém o máximo que precisamos
    while (i < n || j < n) {
        if (i < n && (j == n || start[i] <= end[j])) {
            i++
            rooms++
        } else {
            j++
            rooms--
        }

        ans = maxOf(ans, rooms)
    }

    return ans
}


println(minimumRooms(intArrayOf(900, 940, 950, 1100, 1500, 1800), intArrayOf(910, 1200, 1120, 1130, 1900, 2000), 6))
println(minimumRooms(intArrayOf(900, 1100, 1235), intArrayOf(1000, 1200, 1240), 3))
println()
