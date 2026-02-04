class Solution {
    fun findJudge(n: Int, trust: Array<IntArray>): Int {
        val trustsIn = mutableMapOf<Int, Int>()
        val trustedByQuantity = mutableMapOf<Int, Int>()
        if(trust.isEmpty() && n == 1) return 1

        for (i in trust.indices) {
            val personTrustsIn = trust[i][1]
            trustsIn[trust[i][0]] = personTrustsIn
            trustedByQuantity[trust[i][1]] = trustedByQuantity.getOrDefault(trust[i][1], 0) + 1
        }

        for (i in trustedByQuantity.keys) {
            val trustSomebody = trustsIn.getOrDefault(i, 0)
            if(trustedByQuantity[i] == n - 1 && trustSomebody == 0) return i
        }

        return -1
    }
}


// Solução otimizada com grau de entrada e saída
class Solution1_5 {
    fun findJudge(n: Int, trust: Array<IntArray>): Int {
        val inDegree = IntArray(n + 1)
        val outDegree = IntArray(n + 1)

        for (t in trust) {
            val a = t[0]
            val b = t[1]
            outDegree[a]++
            inDegree[b]++
        }

        for (i in 1..n) {
            if (inDegree[i] == n - 1 && outDegree[i] == 0) {
                return i
            }
        }

        return -1
    }
}

println(Solution().findJudge(2, arrayOf(intArrayOf(1, 2))))