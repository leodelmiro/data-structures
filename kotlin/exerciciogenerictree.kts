import java.util.LinkedList
import java.util.Queue

interface Position<T> {
    val element: T
}

data class Node<T>(
    override var element: T,
    var parent: Node<T>? = null,
    var children: MutableList<Node<T>> = mutableListOf()
) : Position<T> {

    fun isLeaf(): Boolean {
        return children.isEmpty()
    }

    fun addChild(child: Node<T>) {
        children.add(child)
        child.parent = this
    }

    fun removeChild(child: Node<T>) {
        children = children.filter { c -> c != child }.toMutableList()
        child.parent = null
    }
}

data class GenericTree<T>(var root: Node<T>? = null, var size: Int = 0) {
    fun isEmpty() = this.size == 0

    private fun validate(position: Position<T>): Node<T> {
        if (position !is Node<T>) throw IllegalArgumentException("Invalid position type")

        if (position.parent === position) throw IllegalStateException("Removed node")

        return position
    }

    fun add(element: T, parent: Position<T>?): Position<T> {
        if (!this.isEmpty() && parent == null) throw IllegalArgumentException("Parent position can't be null for a non-empty tree")
        val parentNode = parent?.let { this.validate(it) }

        val newNode = Node(element = element, parent = parentNode)
        if (parentNode == null) {
            this.root = newNode
        } else {
            parentNode.addChild(newNode)
        }

        this.size++
        return newNode
    }

    fun children(position: Position<T>): List<Position<T>> {
        val node = this.validate(position)
        return node.children.toList()
    }

    fun elements(): MutableList<T> {
        val elements = mutableListOf<T>()
        this.collectElements(elements, this.root)
        return elements
    }

    private fun collectElements(elements: MutableList<T>, node: Node<T>?) {
        if (node == null) return

        elements.add(node.element)
        for (child in node.children) {
            this.collectElements(elements, child)
        }
    }

    fun positions(): MutableList<Position<T>> {
        val positions = mutableListOf<Position<T>>()
        this.collectPositions(positions, this.root)
        return positions
    }

    private fun collectPositions(positions: MutableList<Position<T>>, node: Node<T>?) {
        if (node == null) return

        positions.add(node)
        for (child in node.children) {
            this.collectPositions(positions, child)
        }
    }

    fun find(target: T): Position<T>? {
        return findElement(target, this.root)
    }

    private fun findElement(target: T, node: Node<T>?): Position<T>? {
        if (node == null) return null

        if (node.element == target) return node
        for (child in node.children) {
            val found = this.findElement(target, child)
            if (found != null) return found
        }
        return null
    }

    fun isExternal(position: Position<T>): Boolean {
        val node = this.validate(position)

        return node.isLeaf()
    }

    fun isRoot(position: Position<T>): Boolean {
        val node = this.validate(position)

        return node == this.root
    }

    fun getParent(position: Position<T>): Position<T>? {
        val node = this.validate(position)

        return node.parent
    }

    fun replace(position: Position<T>, newValue: T) {
        val node = this.validate(position)

        node.element = newValue
    }

    fun remove(position: Position<T>) {
        val node = this.validate(position)
        if (node == this.root) {
            this.root == null
            return
        }

        val parent = node.parent
        parent?.removeChild(node)

        this.markAsRemoved(node)
    }

    private fun markAsRemoved(node: Node<T>) {
        node.parent = node
        this.size--
        for (child in node.children) {
            this.markAsRemoved(child)
        }
    }
}


val myTree = GenericTree<String>()

val root = myTree.add("Livro Azul", null)
val intro = myTree.add("Introdução", root)

myTree.add("Para quem é este livro", intro)
myTree.add("Agradecimento", intro)

val cap1 = myTree.add("Capítulo 1", root)
val cap2 = myTree.add("Capítulo 2", root)

myTree.add("Conceitos", cap1)
myTree.add("Aplicações", cap1)

val cap2Sec1 = myTree.add("Métodos", cap2)
myTree.add("Problema terreno", cap2)
myTree.add("Problema carros", cap2)

myTree.add("Método recursivo", cap2Sec1)
myTree.add("Método imperativo", cap2Sec1)

println("size: ${myTree.size}")
println("isEmpty: ${myTree.isEmpty()}")
println()

val pos1 = myTree.find("Livro Azul")
val pos2 = myTree.find("Capítulo 1")
val pos3 = myTree.find("Aplicações")
val pos4 = myTree.find("Conceitos")
pos4?.let { myTree.replace(pos4, "Conceitos básicos") }

if (pos1 != null) {
    println("Livro azul encontrado")
    println("isExternal: ${myTree.isExternal(pos1)}")
    println("isRoot: ${myTree.isRoot(pos1)}")
    myTree.getParent(pos1)?.let {
        println("parent: ${it.element}")
    }
} else println("Livro azul não encontrado")
if (pos2 != null) {
    println("Capítulo 1 encontrado")
    println("isExternal: ${myTree.isExternal(pos2)}")
    println("isRoot: ${myTree.isRoot(pos2)}")
    println("parent: ${myTree.getParent(pos2)?.element}")
} else println("Capítulo 1 não encontrado")
if (pos3 != null) {
    println("Aplicações encontrado")
    println("isExternal: ${myTree.isExternal(pos3)}")
    println("isRoot: ${myTree.isRoot(pos3)}")
    println("parent: ${myTree.getParent(pos3)?.element}")
} else println("Aplicações não encontrado")
println()

println("PRINT DFS PRE ORDER:")
print<String>(myTree)
println()

println("PRINT DFS PRE ORDER:")
print<String>(myTree)
println()

println("PRINT elements():")
for (element in myTree.elements()) {
    println(element)
}
println()

println("PRINT positions():")
for (position in myTree.positions()) {
    println(position.element)
}
println()

println("PRINT BFS:")
printBfs(myTree)
println()

val pos5 = myTree.find("Métodos")
if (pos5 != null) {
    myTree.remove(pos5)
    println("PRINT remove:")
    println("SIZE = ${myTree.size}")
    print(myTree)
}

fun <T> print(tree: GenericTree<T>) {
    printRecursive(tree.root, tree, 0)
}

// DFS
fun <T> printRecursive(node: Position<T>?, tree: GenericTree<T>, depth: Int) {
    val spaces = "   ".repeat(depth)
    if (node == null) return
    println(spaces + node.element)
    for (child in tree.children(node)) {
        printRecursive(child, tree, depth + 1)
    }
}

fun <T> printBfs(tree: GenericTree<T>) {
    if (tree.isEmpty()) return

    val queue: Queue<Position<T>> = LinkedList()
    queue.add(tree.root)
    while(!queue.isEmpty()) {
        val position = queue.remove()
        println(position.element)
        queue.addAll(tree.children(position))
    }
}



