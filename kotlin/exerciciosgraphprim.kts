import java.util.*

data class Graph(val numVertices: Int) {
    val matrix = Array(numVertices) { Array(numVertices) { 0 } }

    fun addEdge(vertice1: Int, vertice2: Int, weight: Int = 1) {
        matrix[vertice1][vertice2] = weight
        matrix[vertice2][vertice1] = weight
    }

    fun prim(start: Int): List<Pair<Int, Int>> {
        val visited = BooleanArray(numVertices) { false }
        val mstEdges = mutableListOf<Pair<Int, Int>>()
        val pq = PriorityQueue<Triple<Int, Int, Int>> { a, b -> a.first.compareTo(b.first) }
        var totalWeight = 0

        visited[start] = true

        for (v in 0 until numVertices) {
            if (matrix[start][v] > 0 && v != start) {
                pq.offer(Triple(matrix[start][v], start, v))
            }
        }

        while (pq.isNotEmpty()) {
            val (weight, u, v) = pq.poll()

            if (visited[v]) continue

            visited[v] = true
            totalWeight += weight
            mstEdges.add(Pair(v, weight))

            for (next in 0 until numVertices) {
                if (!visited[next] && matrix[v][next] > 0) {
                    pq.offer(Triple(matrix[v][next], v, next))
                }
            }
        }

        println("Total weight: $totalWeight")
        return mstEdges
    }
}


val graph = Graph(7)
graph.addEdge(0, 1, 4)
graph.addEdge(0, 2, 8)
graph.addEdge(1, 2, 11)
graph.addEdge(1, 3, 2)
graph.addEdge(1, 4, 8)
graph.addEdge(2, 5, 1)
graph.addEdge(2, 3, 6)
graph.addEdge(3, 6, 10)
graph.addEdge(3, 5, 5)
graph.addEdge(4, 6, 7)
graph.addEdge(5, 6, 6)
val mst = graph.prim(0)
println("MST Edges: $mst")
