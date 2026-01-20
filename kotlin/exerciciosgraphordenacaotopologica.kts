import java.util.*

// Grafo direcionado e aciclico
data class Graph(val numVertices: Int) {
    private val list: Array<LinkedList<Int>> = Array(numVertices) { LinkedList() }

    fun addEdge(vertice1: Int, vertice2: Int) {
        list[vertice1].add(vertice2)
    }

    fun neighbours(vertice: Int): List<Int> {
        return this.list[vertice]
    }

    fun toposort(): MutableList<Int> {
        val alreadyVisited = mutableSetOf<Int>()
        val orderedList = mutableListOf<Int>()

        for (i in 0 until numVertices) {
            if (i !in alreadyVisited) {
                this.dfsUtil(i, alreadyVisited, orderedList)
            }
        }

        return orderedList
    }

    private fun dfsUtil(vertice: Int, alreadyVisited: MutableSet<Int>, orderedList: MutableList<Int>) {
        alreadyVisited.add(vertice)
        println("visited: $vertice")

        for (v in neighbours(vertice)) {
            if (v !in alreadyVisited) {
                this.dfsUtil(v, alreadyVisited, orderedList)
            }
        }

        orderedList.addFirst(vertice)
    }
}

val graph = Graph(10)
graph.addEdge(0, 1)
graph.addEdge(0, 2)
graph.addEdge(0, 3)
graph.addEdge(0, 5)
graph.addEdge(1, 2)
graph.addEdge(2, 3)
graph.addEdge(2, 4)
graph.addEdge(4, 6)
graph.addEdge(5, 6)
graph.addEdge(5, 4)
graph.addEdge(9, 6)
graph.addEdge(6, 8)
graph.addEdge(6, 7)
graph.addEdge(7, 8)
println("--------")
println(graph.toposort())
