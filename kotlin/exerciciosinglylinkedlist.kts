data class Node(var value: Int, var next: Node? = null)

val node1 = Node(1)
val node2 = Node(2)
val node3 = Node(3)

node1.next = node2
node2.next = node3

println(node1.value)
println(node1.next?.value)
println(node1.next?.next?.value)
println("========================")

data class LinkedList(var head: Node? = null, var size: Int = 0) {
    fun addAtEnd(value: Int) {
        if (this.isEmpty()) {
            head = Node(value)
            this.size++
            return
        }

        var currentNode = head
        while (currentNode?.next !== null) {
            currentNode = currentNode.next
        }

        currentNode?.next = Node(value)
        this.size++
    }

    fun addAtStart(value: Int) {
        if (this.isEmpty()) {
            head = Node(value)
            this.size++
            return
        }

        val newNode = Node(value)
        newNode.next = this.head
        this.head = newNode
        this.size++
    }

    fun printLinkedList() {
        var currentNode = this.head
        while (currentNode !== null) {
            println(currentNode?.value)
            currentNode = currentNode?.next
        }
    }

    fun isEmpty() = this.head == null

    fun clear() {
        this.head = null
        this.size = 0
    }

    fun get(index: Int): Int? = this.getNode(index)?.value

    fun getNode(index: Int): Node? {
        if (this.isEmpty()) return null

        var currentNode = this.head
        var currentNodeIndex = 0
        while (currentNodeIndex < index) {
            currentNode = currentNode?.next ?: return null
            currentNodeIndex++
        }

        return currentNode
    }

    fun addAt(index: Int, value: Int) {
        if (index == 0) {
            this.addAtStart(value)
            return
        }

        val previousNode = this.getNode(index - 1) ?: run {
            this.addAtEnd(value)
            return
        }

        val newNode = Node(value)
        newNode.next = previousNode.next
        previousNode.next = newNode
        this.size++
    }

    fun indexOf(value: Int): Int {
        if (this.isEmpty()) return -1

        var currentNode = this.head
        var currentNodeIndex = 0

        while (currentNode != null) {
            if (currentNode?.value == value) return currentNodeIndex
            currentNode = currentNode?.next
            currentNodeIndex++
        }

        return -1
    }

    fun contains(value: Int): Boolean = this.indexOf(value) != -1

    fun removeAt(index: Int): Node? {
        if (this.isEmpty() || index >= this.size) return null

        if (this.size == 1 || index == 0) {
            val oldhead = this.head
            this.head = head?.next
            this.size--
            return oldhead
        }

        val previousNode = this.getNode(index - 1) ?: return null

        val removedNode = previousNode.next ?: return null
        previousNode.next = previousNode.next?.next
        this.size--
        return removedNode
    }

    fun remove(value: Int): Boolean {
        val elementIndex = this.indexOf(value)

        if (elementIndex == -1) return false

        this.removeAt(elementIndex).also { return true }
    }
}

val linkedList = LinkedList()
linkedList.addAtEnd(20)
linkedList.addAtEnd(9)
linkedList.addAtEnd(86)
linkedList.addAtEnd(-2)
linkedList.addAtEnd(16)
linkedList.addAtEnd(23)

println(linkedList.head?.value)
println(linkedList.head?.next?.value)
println(linkedList.head?.next?.next?.value)
println(linkedList.head?.next?.next?.next?.value)
println(linkedList.head?.next?.next?.next?.next?.value)
println(linkedList.head?.next?.next?.next?.next?.next?.value)

linkedList.printLinkedList()
println(linkedList.size)
println(linkedList.isEmpty())
println("=====================")
linkedList.clear()
linkedList.printLinkedList()
linkedList.addAtEnd(23)
linkedList.addAtEnd(15)
linkedList.addAtStart(1)
linkedList.printLinkedList()
println(linkedList.getNode(0))
println(linkedList.getNode(1))
println(linkedList.getNode(2))
println(linkedList.getNode(3))
println(linkedList.get(0))
println(linkedList.get(1))
println(linkedList.get(2))
println(linkedList.get(3))

println("=====================")
linkedList.addAt(2, 10)
linkedList.printLinkedList()

println("=====================")
println(linkedList.indexOf(23))
println(linkedList.indexOf(15))
println(linkedList.indexOf(1))
println(linkedList.indexOf(10))
println(linkedList.indexOf(3))
println(linkedList.contains(23))
println(linkedList.contains(3))
println("=====================")
linkedList.removeAt(2)
linkedList.removeAt(5)
linkedList.removeAt(0)
linkedList.removeAt(1)
linkedList.printLinkedList()
println("=====================")
println(linkedList.remove(23))
linkedList.printLinkedList()