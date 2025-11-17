import kotlin.math.abs

fun removeNonDigits(input: String): String {
    return input.replace(Regex("\\D"), "")
}

println(removeNonDigits("94923784799"))
println(removeNonDigits("213.445.034-82"))
println("----------------------------")

fun extractEmailInformation(email: String) {
    val emailSpllited = email.split("@")
    val userName = emailSpllited[0]
    val domain = emailSpllited[1]
    val isBrasilianEmail = if (email.contains(Regex(".[.]br\$"))) "sim" else "nao"

    println("Usuario $userName")
    println("Dominio $domain")
    println("Brasileiro $isBrasilianEmail")
}

extractEmailInformation("maria123@gmail.com")
extractEmailInformation("notbrazilian@gmail.com")
extractEmailInformation("notbrazilian@gmail.combr")
extractEmailInformation("joao.silva23@yahoo.com.br")
println("----------------------------")

fun validatePassword(password: String): Boolean {
    if (password.length < 8) return false
    if (!password.contains(Regex("[a-zA-Z]+"))) return false
    if (!password.contains(Regex("[0-9]+"))) return false
    if (!password.contains(Regex("[@#&]+"))) return false

    return true
}

println(validatePassword("amerca1@"))
println(validatePassword("amrca154682"))
println("----------------------------")

fun validAnagram(s: String, t: String): Boolean {
    val counter = mutableMapOf<Char, Int>()
    if (s.isEmpty() || t.isEmpty()) return false

    s.forEach {
        counter[it] = counter.getOrDefault(it, 0) + 1
    }

    t.forEach {
        counter[it] = counter.getOrDefault(it, 0) - 1
    }

    counter.values.forEach {
        if (it != 0) return false
    }

    return true
}
println(validAnagram("anagram", "nagaram"))
println(validAnagram("rat", "car"))
println("----------------------------")

// LongestPrefix Analisando todos os elementos, O (n * m)
fun longestCommonPrefixAnalisandoTodos(strs: Array<String>): String {
    if (strs.isEmpty()) return ""
    if (strs.size == 1) return strs[0]
    var longestPrefix = strs[0]
    for (i in 1 until strs.size) {
        if (longestPrefix.isEmpty()) return ""
        while (!strs[i].startsWith(longestPrefix)) {
            longestPrefix = longestPrefix.dropLast(1)
        }
    }
    return longestPrefix
}

// LongestPrefix e Ordenando Analisando primeiro e ultimo apenas e usando substring para nao criar toda hora uma nova string igual com dropLast, O(n log n + m)
fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.isEmpty()) return ""
    if (strs.size == 1) return strs[0]
    strs.sort()
    val longestPrefix = strs[0]
    val lastElement = strs[strs.size - 1]
    var i = 0

    while (i < longestPrefix.length && i < lastElement.length && longestPrefix[i] == lastElement[i]) {
        i++
    }

    return longestPrefix.substring(0, i)
}

println(longestCommonPrefix(arrayOf("flowers", "flow", "flight")))
println(longestCommonPrefix(arrayOf("dog", "racecar", "car")))
println("----------------------------")


// Usando Set O(n²)
fun invalidTransactionSet(transactions: Array<String>): List<String> {
    val invalidTransactions = mutableSetOf<String>()

    for (i in transactions.indices) {
        val (nameI, timeI, amountI, cityI) = transactions[i].split(",")
        val amountDigit = amountI.toInt()

        if (amountDigit > 1000) invalidTransactions.add(transactions[i])
        val timeDigitI = timeI.toInt()

        for (j in i+1 until transactions.size) {
            val (nameJ, timeJ, _, cityJ) = transactions[j].split(",")
            val timeDigitj = timeJ.toInt()
            if (nameI == nameJ && (abs(timeDigitI - timeDigitj) <= 60) && cityI != cityJ) {
                invalidTransactions.add(transactions[j])
                invalidTransactions.add(transactions[i])
            }
        }
    }

    return invalidTransactions.toList()
}

// Usando List O(n²)
fun invalidTransaction(transactions: Array<String>): List<String> {
    val result = mutableListOf<String>()
    val invalidTransactions = MutableList(transactions.size) { false }

    for (i in transactions.indices) {
        val (nameI, timeI, amountI, cityI) = transactions[i].split(",")
        val amountDigit = amountI.toInt()

        if (amountDigit > 1000) invalidTransactions[i] = true
        val timeDigitI = timeI.toInt()

        for (j in i+1 until transactions.size) {
            val (nameJ, timeJ, _, cityJ) = transactions[j].split(",")
            val timeDigitj = timeJ.toInt()
            if (nameI == nameJ && (abs(timeDigitI - timeDigitj) <= 60) && cityI != cityJ) {
                invalidTransactions[i] = true
                invalidTransactions[j] = true
            }
        }
    }

    for (i in transactions.indices) {
        if (invalidTransactions[i]) result.add(transactions[i])
    }

    return result
}

println(invalidTransaction(arrayOf("alice,20,800,mtv","alice,50,100,beijing")))
println(invalidTransaction(arrayOf("alice,20,800,mtv","alice,50,1200,mtv")))
println(invalidTransaction(arrayOf("alice,20,800,mtv","bob,50,1200,mtv")))
println("----------------------------")

