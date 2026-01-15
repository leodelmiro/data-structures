data class Graph(val numVertices: Int) {
    val matrix = Array(numVertices) { Array(numVertices) { 0 } }

    fun addEdge(vertice1: Int, vertice2: Int) {
        matrix[vertice1][vertice2] = 1
        matrix[vertice2][vertice1] = 1
    }

    fun removeEdge(vertice1: Int, vertice2: Int) {
        matrix[vertice1][vertice2] = 0
        matrix[vertice2][vertice1] = 0
    }

    fun degree(vertice: Int): Int {
        return matrix[vertice].reduce { acc, number -> acc + number }
    }

    fun listByDegree(): MutableMap<Int, MutableList<Int>> {
        val degrees = mutableMapOf<Int, MutableList<Int>>()

        for(i in 0 until numVertices) {
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
        this.matrix.forEach {
            print("|")
            it.forEach { el -> print(" $el ") }
            print("|\n")
        }
    }
}

val graph = Graph(4)
graph.addEdge(0, 1)
graph.addEdge(0, 2)
graph.addEdge(1, 3)
graph.addEdge(2, 3)
graph.addEdge(3, 3)
//graph.removeEdge(0, 2)
graph.printGraph()
println("Degree: " + graph.degree(3))
println(graph.listByDegree())