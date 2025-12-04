/*
A transaction is possibly invalid if:

- the amount exceeds $1000, or;
- if it occurs within (and including) 60 minutes of another transaction with the same name in a different city.

You are given an array of strings transaction where transactions[i] consists of comma-separated values representing the name,
time (in minutes), amount, and city of the transaction.

Return a list of transactions that are possibly invalid. You may return the answer in any order.*/


data class Tx(
    val name: String,
    val time: Int,
    val amount: Int,
    val city: String,
    val raw: String
)

class Solution {
    fun invalidTransactions(transactions: Array<String>): List<String> {
        val n = transactions.size
        val invalid = BooleanArray(n)

        val map = mutableMapOf<String, MutableList<Pair<Int, Tx>>>()

        val txs = Array(n) { i ->
            val parts = transactions[i].split(",")
            Tx(
                name = parts[0],
                time = parts[1].toInt(),
                amount = parts[2].toInt(),
                city = parts[3],
                raw = transactions[i]
            )
        }

        for (i in 0 until n) {
            val tx = txs[i]

            if (tx.amount > 1000) invalid[i] = true

            val list = map.getOrPut(tx.name) { mutableListOf() }
            for ((oldIndex, oldTx) in list) {
                val within60 = kotlin.math.abs(oldTx.time - tx.time) <= 60
                val differentCity = oldTx.city != tx.city

                if (within60 && differentCity) {
                    invalid[i] = true
                    invalid[oldIndex] = true
                }
            }

            list.add(i to tx)
        }

        val result = mutableListOf<String>()
        for (i in 0 until n) {
            if (invalid[i]) result.add(txs[i].raw)
        }

        return result
    }
}


println(Solution().invalidTransactions(arrayOf("alice,20,800,mtv", "alice,50,100,beijing")))
println(Solution().invalidTransactions(arrayOf("alice,20,800,mtv", "alice,50,1200,mtv")))
println(Solution().invalidTransactions(arrayOf("alice,20,800,mtv", "bob,50,1200,mtv")))
println("----------------------------")