data class DisjointSet(
    private val n: Int
) {
    val parent = IntArray(n) { it }
    private val rank = IntArray(n) { 0 }

    fun find(u: Int): Int {
        if (parent[u] != u) {
            parent[u] = find(parent[u]) // Path compression
        }
        return parent[u]
    }

    fun union(u: Int, v: Int) {
        val rootU = find(u)
        val rootV = find(v)

        if (rootU != rootV) {
            // Union by rank
            when {
                rank[rootU] < rank[rootV] -> parent[rootU] = rootV
                rank[rootU] > rank[rootV] -> parent[rootV] = rootU
                else -> {
                    parent[rootV] = rootU
                    rank[rootU]++
                }
            }
        }
    }
}

val unionFind = DisjointSet(7)
unionFind.union(0, 1)
unionFind.union(2, 3)
unionFind.union(3, 4)
unionFind.union(5, 6)
unionFind.union(3, 6)
unionFind.union(6, 1)

println(unionFind.parent.joinToString())
println("O representante de 6 é ${unionFind.find(6)}")