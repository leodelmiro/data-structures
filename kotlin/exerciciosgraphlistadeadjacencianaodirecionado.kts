import java.util.*

// Não direcionado e não poderado
data class Graph(val numVertices: Int) {
    private val list: Array<LinkedList<Int>> = Array(numVertices) { LinkedList() }

    fun addEdge(vertice1: Int, vertice2: Int) {
        list[vertice1].add(vertice2)
        list[vertice2].add(vertice1)
    }

    fun removeEdge(vertice1: Int, vertice2: Int) {
        list[vertice1].remove(vertice2)
        list[vertice2].remove(vertice1)
    }

    fun degree(vertice: Int): Int {
        return list[vertice].size
    }

    fun listByDegree(): MutableMap<Int, MutableList<Int>> {
        val degrees = mutableMapOf<Int, MutableList<Int>>()

        for (i in 0 until numVertices) {
            val degree = this.degree(i)

            if (degrees[degree]?.isNotEmpty() == true) {
                degrees[degree]!!.add(i)
                continue
            }

            degrees[degree] = mutableListOf(i)
        }

        return degrees
    }

    fun printGraph() {
        this.list.forEachIndexed { index, _ ->
            println("$index -> {${this.list[index].joinToString { "$it" }}}")
        }
    }
}

val graph = Graph(5)
graph.addEdge(0, 1)
graph.addEdge(0, 2)
graph.addEdge(0, 3)
graph.addEdge(4, 3)
graph.printGraph()
// println("Degree: " + graph.degree(3))
println(graph.listByDegree())
graph.removeEdge(4, 3)
graph.printGraph()