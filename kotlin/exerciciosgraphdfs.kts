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

    fun dfsRecursive(vertice: Int) {
        val alreadyVisited = mutableSetOf<Int>()
        this.dfsUtil(vertice, alreadyVisited)
    }

    private fun dfsUtil(vertice: Int, alreadyVisited: MutableSet<Int>) {
        alreadyVisited.add(vertice)
        println("visited: $vertice")

        for (v in neighbours(vertice)) {
            if (v !in alreadyVisited) {
                this.dfsUtil(v, alreadyVisited)
            }
        }
    }

    fun dfsIterativa(vertice: Int) {
        val stack = Stack<Int>()
        val alreadyVisited = mutableSetOf<Int>()

        stack.push(vertice)
        alreadyVisited.add(vertice)
        while (stack.isNotEmpty()) {
            val currentVertice = stack.pop()
            println("visited: $currentVertice")
            for (v in neighbours(currentVertice)) {
                if (v !in alreadyVisited) {
                    alreadyVisited.add(v)
                    stack.push(v)
                }
            }
        }
    }

}

val graph = Graph(5)
graph.addEdge(0, 1)
graph.addEdge(0, 2)
graph.addEdge(0, 3)
graph.addEdge(2, 3)
graph.addEdge(2, 4)
graph.addEdge(3, 4)
graph.dfsIterativa(0)
println("--------")
graph.dfsRecursive(0)
println("--------")
