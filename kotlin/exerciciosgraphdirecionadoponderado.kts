data class Graph(val numVertices: Int) {
    val matrix = Array(numVertices) { Array(numVertices) { -1 } }

    fun addEdge(vertice1: Int, vertice2: Int, weight: Int) {
        matrix[vertice1][vertice2] = weight
    }

    fun removeEdge(vertice1: Int, vertice2: Int) {
        matrix[vertice1][vertice2] = -1
    }

    fun lowestWeight(): Array<Int>? {
        val lowestEdge = arrayOf(0, 0)
        var lowestValue = Int.MAX_VALUE

        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                if (matrix[i][j] != -1 && matrix[i][j] < lowestValue) {
                    lowestValue = matrix[i][j]
                    lowestEdge[0] = i
                    lowestEdge[1] = j
                }
            }
        }

        if (lowestValue == Int.MAX_VALUE) return null

        return lowestEdge
    }

    fun neighbours(vertice: Int): MutableList<Int> {
        val neighbors = mutableListOf<Int>()

        for(i in 0 until numVertices) {
           if (this.matrix[vertice][i] != -1) {
               neighbors.add(i)
           }
        }

        return neighbors
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
graph.addEdge(0,1, 1)
graph.addEdge(0, 2, 4)
graph.addEdge(1, 3, 5)
graph.addEdge(2, 3, 3)
graph.addEdge(3, 3, 7)
graph.addEdge(3, 1, 1)
graph.removeEdge(0, 1)
graph.printGraph()
println(graph.lowestWeight()?.joinToString { "$it" })
println(graph.neighbours(1))