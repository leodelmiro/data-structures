import java.util.*

data class Node(val value: Int, val weight: Int)

// Direcionado e poderado
data class Graph(val numVertices: Int) {
    private val list: Array<LinkedList<Node>> = Array(numVertices) { LinkedList() }

    fun addEdge(vertice1: Int, vertice2: Int, weight: Int) {
        list[vertice1].add(Node(vertice2, weight))
    }

    fun removeEdge(vertice1: Int, vertice2: Int) {
        list[vertice1].removeIf { it.value == vertice2 }
    }

    fun lowestWeight(): Node? {
        var lowestEdge = Node(0, 0)
        var lowestValue = Int.MAX_VALUE

        for (i in list.indices) {
            list[i].forEach {
                if (it.weight < lowestValue) {
                    lowestEdge = Node(it.value, it.weight)
                    lowestValue = it.value
                }
            }
        }

        if (lowestValue == Int.MAX_VALUE) return null

        return lowestEdge
    }

    fun neighbours(vertice: Int): List<Int> {
        return this.list[vertice].map { it.value }
    }


    fun printGraph() {
        this.list.forEachIndexed { index, _ ->
            println("$index -> {${this.list[index].joinToString { "$it" }}}")
        }
    }
}

val graph = Graph(5)
graph.addEdge(0, 1, 2)
graph.addEdge(0, 2, 5)
graph.addEdge(0, 3, 3)
graph.addEdge(4, 3, -5)
graph.removeEdge(0, 2)
graph.printGraph()
println(graph.lowestWeight())
println(graph.neighbours(0))