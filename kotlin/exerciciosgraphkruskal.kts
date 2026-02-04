data class Edge(val from: Int, val to: Int, val weight: Int)

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

class Graph(private val numVertices: Int) {

    private val edges = mutableListOf<Edge>()

    fun addEdge(from: Int, to: Int, weight: Int) {
        edges.add(Edge(from, to, weight))
    }

    fun kruskal() {
        this.edges.sortBy { it.weight }

        val disjointSet = DisjointSet(this.numVertices)
        val mstEdges = mutableListOf<Edge>()
        var totalWeight = 0

        for(edge in edges) {
            val u = edge.from
            val v = edge.to

            if (disjointSet.find(u) != disjointSet.find(v)) {
                disjointSet.union(u, v)
                mstEdges.add(edge)
                totalWeight += edge.weight
            }
        }

        return println("MST Edges: $mstEdges with total weight: $totalWeight")
    }
}

val unionFind = Graph(7)
unionFind.addEdge(0, 1, 4)
unionFind.addEdge(0, 2, 8)
unionFind.addEdge(1, 2, 11)
unionFind.addEdge(1, 3, 2)
unionFind.addEdge(1, 4, 8)
unionFind.addEdge(2, 5, 1)
unionFind.addEdge(2, 3, 6)
unionFind.addEdge(3, 6, 10)
unionFind.addEdge(3,5, 5)
unionFind.addEdge(4, 6, 7)
unionFind.addEdge(5, 6, 6)
unionFind.kruskal()