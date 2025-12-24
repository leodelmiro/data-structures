data class Node<K>(
    var key: K?,
    var parent: Node<K>?,
    var left: Node<K>? = null,
    var right: Node<K>? = null
) {
    fun isSentinel() = this.key == null
}

class BinarySearchTreeSet<K : Comparable<K>>(
    var size: Int = 0,
    private var root: Node<K> = Node(key = null, parent = null)
) {
    constructor(collection: Collection<K> = emptyList()) : this(0, Node(key = null, parent = null)) {
        this.addAll(collection)
    }

    fun isEmpty() = this.size == 0

    fun addAll(collection: Collection<K>) {
        collection.forEach { this.add(it) }
    }

    fun add(key: K?) {
        if (key == null) throw IllegalArgumentException("Key não pode ser null")

        if (this.isEmpty()) {
            root = Node(key, null)
            root.left = Node(null, root)
            root.right = Node(null, root)
            size++
            return
        }

        val node = this.findKeyLocation(this.root, key)

        if (node.isSentinel()) {

            val parent = node.parent
            val newNode = Node(key, parent)
            newNode.left = Node(null, newNode)
            newNode.right = Node(null, newNode)

            if (node === parent?.left) {
                parent.left = newNode
            } else if (node === parent?.right) {
                parent.right = newNode
            }

            size++
        }
    }

    private fun findKeyLocation(node: Node<K> = root, key: K): Node<K> {
        var current: Node<K>? = node
        while (!current!!.isSentinel()) {
            val cmp = key.compareTo(current.key!!)
            current = if (cmp == 0) {
                return current
            } else if (cmp < 0) {
                current.left
            } else {
                current.right
            }
        }
        return current
    }

    fun keys(): List<K> {
        val keysList = mutableListOf<K>()

        this.collectKeys(this.root, keysList)

        return keysList
    }

    private fun collectKeys(node: Node<K>?, keysList: MutableList<K>) {
        if (!node!!.isSentinel()) {
            this.collectKeys(node.left, keysList)
            keysList.add(node.key!!)
            this.collectKeys(node.right, keysList)
        }
    }

    fun contains(key: K): Boolean {
        return !this.findKeyLocation(key = key).isSentinel()
    }

    private fun toStringFormatHelper(node: Node<K>?, depth: Int, sb: StringBuilder) {
        if (!node!!.isSentinel()) {
            this.toStringFormatHelper(node.right, depth + 1, sb)
            val spaces = "        ".repeat(depth)
            val parent = if (depth > 0) node.parent!!.key else ""
            sb.append("$spaces(${node.key!!})${parent}\n")
            this.toStringFormatHelper(node.left, depth + 1, sb)
        }
    }

    fun remove(key: K?): Boolean {
        if (key == null) throw IllegalArgumentException("Key não pode ser null")

        var nodeToRemove = findKeyLocation(key = key)
        if (nodeToRemove.isSentinel()) return false

        if (!nodeToRemove.left!!.isSentinel() && !nodeToRemove.right!!.isSentinel()) {
            val sucessor = findMin(nodeToRemove.right!!)
            nodeToRemove.key = sucessor?.key
            nodeToRemove = sucessor!!
        }

        val child: Node<K>? = if (!nodeToRemove.left!!.isSentinel()) {
            nodeToRemove.left
        } else {
            nodeToRemove.right
        }

        child?.parent = nodeToRemove.parent

        if (nodeToRemove.parent == null) {
            this.root = child!!
            return true
        } else if (nodeToRemove === nodeToRemove.parent?.left) {
            nodeToRemove.parent?.left = child
        } else {
            nodeToRemove.parent?.right = child
        }

        this.size--
        return true
    }

    private fun findMin(node: Node<K>): Node<K>? {
        var current: Node<K>? = node
        while (!current?.left!!.isSentinel()) {
            current = current?.left
        }

        return current
    }

    fun union(other: BinarySearchTreeSet<K>): BinarySearchTreeSet<K> {
        val result = BinarySearchTreeSet<K>()
        this.keys().forEach { result.add(it) }
        other.keys().forEach { result.add(it) }
        return result
    }

    fun intersection(other: BinarySearchTreeSet<K>): BinarySearchTreeSet<K> {
        val result = BinarySearchTreeSet<K>()
        this.keys().filter { other.contains(it) }.forEach { result.add(it) }
        return result
    }

    fun difference(other: BinarySearchTreeSet<K>): BinarySearchTreeSet<K> {
        val result = BinarySearchTreeSet<K>()
        this.keys().filter { !other.contains(it) }.forEach { result.add(it) }
        return result
    }

    override fun toString(): String {
        return this.keys().toString()
    }

    fun toStringFormat(): String {
        val sb = StringBuilder()
        this.toStringFormatHelper(this.root, 0, sb)
        return sb.toString()
    }

}

val A = BinarySearchTreeSet<Int>(
    listOf(52, 17, 67, 11, 33, 55, 83, 14, 31, 46, 23, 26)
)
val B = BinarySearchTreeSet<Int>(
    listOf(11, 14, 17, 23, 26, 31, 33, 46, 52, 55, 67, 83)
)
val C = BinarySearchTreeSet<Int>(
    listOf(52, 67, 17, 11, 33, 55, 83, 14, 31, 46, 23, 26)
)
val D = BinarySearchTreeSet<Int>(
    listOf(1, 2, 3, 4, 5)
)
val E = BinarySearchTreeSet<Int>(
    listOf(4, 5, 6, 7, 8)
)
val F = D.union(E)
val G = D.intersection(E)
val H = D.difference(E)
println("size = ${A.size}")
println("isEmpty = ${A.isEmpty()}")
println("KEYS A: ${A.keys()}")
println("A Contains 83: ${A.contains(83)}")
println("A Contains 58: ${A.contains(58)}")
println("A String: ${A.toString()}")
println("C Árvore Original: \n${C.toStringFormat()}")
C.remove(17)
println("C Árvore Remove Test: \n${C.toStringFormat()}")

println("\nD: $D")
println("\nE: $E")
println("\nUNION: $F")
println("\nINTERSECTION: $G")
println("\nDIFFERENCE: $H")

