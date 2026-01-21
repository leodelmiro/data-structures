// Não direcionado e não poderado
data class Graph(val numVertices: Int) {
    val matrix = Array(numVertices) { Array(numVertices) { -1 } }

    fun addEdge(vertice1: Int, vertice2: Int, weight: Int) {
        matrix[vertice1][vertice2] = weight
        matrix[vertice2][vertice1] = weight
    }

    fun dijkstra(start: Int): Pair<Array<Int>, Array<Int>> {
        val dist = Array(numVertices) { Int.MAX_VALUE }
        val alreadyVisited = mutableSetOf<Int>()
        val previous = Array(numVertices) { -1 }

        // inicializa distâncias até
        dist[start] = 0
        previous[start] = 0

        // loop para garantir que todos os vértices sejam processados
        for (k in 0 until this.numVertices) {
            var current = -1

            for (i in 0 until this.numVertices) {
                if (i in alreadyVisited) continue

                // seleciona o vértice mais próximo
                if (current == -1 || dist[i] < dist[current]) current = i
            }

            alreadyVisited.add(current)

            // percorrer vizinhos de current
            for (neighbor in 0 until this.numVertices) {
                val weight = this.matrix[current][neighbor]

                // tentar relaxar
                if (weight >= 0 && neighbor !in alreadyVisited) {
                    val newDist = dist[current] + weight
                    if (newDist < dist[neighbor]) {
                        dist[neighbor] = newDist
                        previous[neighbor] = current
                    }
                }
            }
        }
        return Pair(dist, previous)
    }

    fun recoverPath(previous: Array<Int>, target: Int): List<Int> {
        if (previous[target] == -1 && target != 0 && previous.all { it == -1 }) return emptyList()
        val path = mutableListOf<Int>()
        var at = target
        while (at != -1) {
            path.add(at)
            if (previous[at] == at) break
            at = previous[at]
        }
        return path.reversed()
    }
}

val graph = Graph(6)
graph.addEdge(0, 1, 9)
graph.addEdge(0, 2, 3)
graph.addEdge(1, 2, 1)
graph.addEdge(1, 3, 6)
graph.addEdge(2, 4, 2)
graph.addEdge(1, 4, 3)
graph.addEdge(3, 4, 5)
graph.addEdge(4, 5, 8)
graph.addEdge(3, 5, 2)
val start = 0
val (distances, previous) = graph.dijkstra(start)

for (i in distances.indices) {
    println("dist[$start, $i] = ${distances[i]}")
}

println(graph.recoverPath(previous, 5))
