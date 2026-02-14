input = [
    {
        "n": 6,
        "connections": [
            [0, 1, 1],
            [0, 2, 2],
            [0, 3, 3],
            [1, 4, 3],
            [2, 4, 2],
            [3, 4, 3],
            [4, 5, 4]
        ],
        "locations": [1, 2, 3, 4, 5]
    },
    {
        "n": 6,
        "connections": [
            [0, 1, 1],
            [0, 2, 2],
            [0, 3, 3],
            [1, 4, 3],
            [2, 4, 2],
            [3, 4, 3],
            [4, 5, 4]
        ],
        "locations": [2, 4, 5, 5]
    }
]

class Graph {
    constructor(numVertices) {
        this.numVertices = numVertices
        this.adjacencyList = []
        for (let i = 0; i < numVertices; i++) {
            this.adjacencyList[i] = []
        }
    }

    addEdge(u, v, weight) {
        this.adjacencyList[u].push([v, weight])
        this.adjacencyList[v].push([u, weight])
    }

    dijkstra(start) {
        const distances = Array(this.numVertices).fill(Infinity)
        const visited = Array(this.numVertices).fill(false)
        const previous = new Array(this.numVertices).fill(-1)

        distances[start] = 0
        previous[start] = start

        for (let i = 0; i < this.numVertices; i++) {
            let current = -1

            for (let j = 0; j < this.numVertices; j++) {
                if (visited[j]) continue

                if (current === -1 || distances[j] < distances[current]) current = j
            }

            visited[current] = true

            for (const [neighbour, w] of this.adjacencyList[current]) {
                if (distances[current] + w < distances[neighbour]) {
                    distances[neighbour] = distances[current] + w
                    previous[neighbour] = current
                }
            }
        }

        return { distances, previous }
    }
}


function totalDeliveryCost(n, connections, locations) {
    const graph = new Graph(n)
    for (const [u, v, w] of connections) {
        graph.addEdge(u, v, w)
    }

    const { distances } = graph.dijkstra(0)
    let totalCost = 0

    for (const location of locations) {
        totalCost += distances[location]
    }

    return totalCost
}

for (i in input) {
    const { n, connections, locations } = input[i]
    console.log(totalDeliveryCost(n, connections, locations))
}
