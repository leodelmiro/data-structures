import java.util.*

// Não direcionado e não poderado
data class Graph(val numVertices: Int) {
    private val list: Array<LinkedList<Int>> = Array(numVertices) { LinkedList() }

    fun addEdge(vertice1: Int, vertice2: Int) {
        list[vertice1].add(vertice2)
        list[vertice2].add(vertice1)
    }

    fun neighbours(vertice: Int): List<Int> {
        return this.list[vertice]
    }

    fun bfs(vertice: Int, alreadyVisited: MutableSet<Int> = mutableSetOf()) {
        val queue: Queue<Int> = LinkedList()

        queue.add(vertice)
        alreadyVisited.add(vertice)
        while (queue.isNotEmpty()) {
            val currentVertice = queue.poll()
            println("visited: $currentVertice")
            for (v in neighbours(currentVertice)) {
                if (v !in alreadyVisited) {
                    alreadyVisited.add(v)
                    queue.add(v)
                }
            }
        }
    }

    fun connectedComponents(): Int {
        val alreadyVisited = mutableSetOf<Int>()
        var counter = 0

        for (i in 0 until this.numVertices) {
            if (i !in alreadyVisited) {
                this.bfs(i, alreadyVisited)
                counter++
            }
        }
        return counter
    }
}

val graph = Graph(7)
graph.addEdge(0, 1)
graph.addEdge(0, 2)
graph.addEdge(1, 2)
graph.addEdge(3, 4)
graph.addEdge(2, 6)
graph.bfs(0)
println("--------")
println("Connected Components: ${graph.connectedComponents()}")