// Não direcionado e não poderado
data class Edge(val from: Int, val to: Int, val weight: Int)

class Graph(val numVertices: Int) {

    private val edges = mutableListOf<Edge>()

    fun addEdge(from: Int, to: Int, weight: Int) {
        edges.add(Edge(from, to, weight))
    }


    fun floydWarshall(): Array<IntArray> {
        val dist = Array<IntArray>(numVertices) { IntArray(numVertices) { Int.MAX_VALUE } }

        for (i in 0 until numVertices) {
            for (j in 0 until numVertices) {
                if (i == j) {
                    dist[i][j] = 0
                }
            }
        }

        for (edge in edges) {
            dist[edge.from][edge.to] = edge.weight
        }

        for (k in 0 until numVertices) {
            for (i in 0 until numVertices) {
                for (j in 0 until numVertices) {
                    if (dist[i][k] != Int.MAX_VALUE && dist[k][j] != Int.MAX_VALUE) {
                        val newDist = dist[i][k] + dist[k][j]
                        if (newDist < dist[i][j]) {
                            dist[i][j] = newDist
                        }
                    }
                }
            }
        }
        return dist
    }
}

val graph = Graph(3)
graph.addEdge(0, 1, 8)
graph.addEdge(1, 0, 3)
graph.addEdge(0, 2, 5)
graph.addEdge(2, 1, 2)
val start = 0
val distances = graph.floydWarshall()

for (i in distances.indices) {
    println("Distâncias a partir do vértice $i:")
    for (j in distances[i].indices) {
        val dist = if (distances[i][j] == Int.MAX_VALUE) "∞" else distances[i][j].toString()
        println("  Até o vértice $j: $dist")
    }
}