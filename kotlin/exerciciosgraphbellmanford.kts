// Não direcionado e não poderado
data class Edge(val from: Int, val to: Int, val weight: Int)

class Graph(val numVertices: Int) {

    private val edges = mutableListOf<Edge>()

    fun addEdge(from: Int, to: Int, weight: Int) {
        edges.add(Edge(from, to, weight))
    }


    fun bellmanFord(start: Int): Pair<IntArray, IntArray> {
        val dist = IntArray(numVertices) { Int.MAX_VALUE }
        val parent = IntArray(numVertices) { -1 }

        dist[start] = 0

        // Relaxamento das arestas (V - 1 vezes)
        repeat(numVertices - 1) {
            var updated = false

            for (edge in edges) {
                val u = edge.from
                val v = edge.to
                val w = edge.weight

                if (dist[u] != Int.MAX_VALUE && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w
                    parent[v] = u
                    updated = true
                }
            }

            // Otimização: se não houve atualização, pode parar
            if (!updated) return@repeat
        }

        // Verificação de ciclos negativos
        for (edge in edges) {
            val u = edge.from
            val v = edge.to
            val w = edge.weight

            if (dist[u] != Int.MAX_VALUE && dist[u] + w < dist[v]) {
                throw IllegalStateException("Graph contains negative weight cycle")
            }
        }

        return Pair(dist, parent)
    }
}

val graph = Graph(6)
graph.addEdge(0, 1, 8)
graph.addEdge(0, 2, 3)
graph.addEdge(1, 4, 6)
graph.addEdge(2, 5, -1)
graph.addEdge(3, 1, -4)
graph.addEdge(3, 4, -1)
graph.addEdge(4, 5, 4)
graph.addEdge(5, 3, -3)
val start = 0
val (distances, previous) = graph.bellmanFord(start)

for (i in distances.indices) {
    println("dist[$start, $i] = ${distances[i]}")
}