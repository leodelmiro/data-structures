import java.util.*

class Solution {
    fun findJudge(n: Int, trust: Array<IntArray>): Int {
        val trustsIn = mutableMapOf<Int, Int>()
        val trustedByQuantity = mutableMapOf<Int, Int>()
        if (trust.isEmpty() && n == 1) return 1

        for (i in trust.indices) {
            val personTrustsIn = trust[i][1]
            trustsIn[trust[i][0]] = personTrustsIn
            trustedByQuantity[trust[i][1]] = trustedByQuantity.getOrDefault(trust[i][1], 0) + 1
        }

        for (i in trustedByQuantity.keys) {
            val trustSomebody = trustsIn.getOrDefault(i, 0)
            if (trustedByQuantity[i] == n - 1 && trustSomebody == 0) return i
        }

        return -1
    }
}


// Solução otimizada com grau de entrada e saída
class Solution1_5 {
    fun findJudge(n: Int, trust: Array<IntArray>): Int {
        val inDegree = IntArray(n + 1)
        val outDegree = IntArray(n + 1)

        for (t in trust) {
            val a = t[0]
            val b = t[1]
            outDegree[a]++
            inDegree[b]++
        }

        for (i in 1..n) {
            if (inDegree[i] == n - 1 && outDegree[i] == 0) {
                return i
            }
        }

        return -1
    }
}

println(Solution().findJudge(2, arrayOf(intArrayOf(1, 2))))

class Solution {
    fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
        val adjList = mutableMapOf<Int, MutableList<Int>>()
        for (i in edges.indices) {
            val from = edges[i][0]
            val to = edges[i][1]

            adjList.putIfAbsent(from, mutableListOf())
            adjList.putIfAbsent(to, mutableListOf())

            adjList[from]!!.add(to)
            adjList[to]!!.add(from)
        }

        val visited = mutableSetOf<Int>()
        visited.add(source)
        val stack = Stack<Int>()
        stack.add(source)

        while (stack.isNotEmpty()) {
            val node = stack.pop()
            if (node == destination) return true

            for (neighbour in adjList.getOrDefault(node, mutableListOf())) {
                if (neighbour !in visited) {
                    visited.add(neighbour)
                    stack.push(neighbour)
                }
            }
        }

        return false
    }
}

class Solution {
    fun findCircleNum(isConnected: Array<IntArray>): Int {
        val n = isConnected.size
        val visited = BooleanArray(n)
        var provinces = 0

        fun dfs(city: Int) {
            for (i in 0 until n) {
                if (isConnected[city][i] == 1 && !visited[i]) {
                    visited[i] = true
                    dfs(i)
                }
            }
        }

        for (i in 0 until n) {
            if (!visited[i]) {
                provinces++
                visited[i] = true
                dfs(i)
            }
        }

        return provinces
    }
}

class Solution {
    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        val visited = mutableSetOf<Int>()
        val queue: Queue<Int> = LinkedList()

        for(i in rooms[0]) {
            queue.add(i)
        }
        visited.add(0)

        while(queue.isNotEmpty()) {
            val key = queue.poll()

            for(i in rooms[key]) {
                if (i !in visited) queue.add(i)
            }
            visited.add(key)
        }

        return visited.size == rooms.size
    }
}

class Solution2 {
    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        val visited = BooleanArray(rooms.size)
        val queue: ArrayDeque<Int> = ArrayDeque()

        visited[0] = true
        queue.addLast(0)

        while (queue.isNotEmpty()) {
            val room = queue.removeFirst()
            for (key in rooms[room]) {
                if (!visited[key]) {
                    visited[key] = true
                    queue.addLast(key)
                }
            }
        }

        return visited.all { it }
    }
}

class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val graph = Array(numCourses) { mutableListOf<Int>() }
        val visited = IntArray(numCourses) { 0 }
        // 0 = unvisited, 1 = visiting, 2 = visited

        // Construir lista de adjacência
        for (pair in prerequisites) {
            val course = pair[0]
            val prereq = pair[1]
            graph[prereq].add(course)
        }

        fun dfs(node: Int): Boolean {
            if (visited[node] == 1) return false   // ciclo detectado
            if (visited[node] == 2) return true    // já processado

            visited[node] = 1  // marcando como visitando

            for (neighbor in graph[node]) {
                if (!dfs(neighbor)) return false
            }

            visited[node] = 2  // processamento completo
            return true
        }

        // DFS em todos os cursos
        for (course in 0 until numCourses) {
            if (visited[course] == 0) {
                if (!dfs(course)) return false
            }
        }

        return true
    }
}

class Solution {

    private fun dijkstra(
        start: Int,
        numVertices: Int,
        adjList: Array<MutableList<Pair<Int, Int>>>
    ): Int {
        val dist = IntArray(numVertices) { Int.MAX_VALUE }
        val visited = BooleanArray(numVertices)

        // distância da origem
        dist[start] = 0

        // processar todos os vértices
        repeat(numVertices) {
            var current = -1

            // escolher o vértice não visitado com menor distância
            for (i in 0 until numVertices) {
                if (visited[i]) continue
                if (current == -1 || dist[i] < dist[current]) {
                    current = i
                }
            }

            if (current == -1) return@repeat
            visited[current] = true

            // relaxar vizinhos
            for ((neighbor, weight) in adjList[current]) {
                if (dist[current] != Int.MAX_VALUE &&
                    dist[current] + weight < dist[neighbor]
                ) {
                    dist[neighbor] = dist[current] + weight
                }
            }
        }

        // maior distância mínima
        var maxMinDist = 0
        for (d in dist) {
            if (d == Int.MAX_VALUE) return -1
            maxMinDist = maxOf(maxMinDist, d)
        }

        return maxMinDist
    }

    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        val adjList = Array(n) { mutableListOf<Pair<Int, Int>>() }

        for (edge in times) {
            val u = edge[0] - 1
            val v = edge[1] - 1
            val w = edge[2]
            adjList[u].add(v to w)
        }

        return dijkstra(k - 1, n, adjList)
    }
}


