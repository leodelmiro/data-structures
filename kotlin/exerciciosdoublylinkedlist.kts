data class Node(var value: Int, var next: Node? = null, var previous: Node? = null)

data class DoublyLinkedList(var head: Node? = null, var size: Int = 0, var tail: Node? = null) {

    fun isEmpty() = this.head == null

    fun addAtStart(value: Int) {
        if (this.isEmpty()) {
            this.head = Node(value)
            this.tail = this.head
            this.size++
            return
        }

        this.head?.previous = Node(value)
        this.head?.previous?.next = this.head
        this.head = this.head?.previous
        this.size++
    }

    fun addAtEnd(value: Int) {
        if (this.isEmpty()) {
            this.head = Node(value)
            this.tail = this.head
            this.size++
            return
        }

        this.tail?.next = Node(value)
        this.tail?.next?.previous = this.tail
        this.tail = this.tail?.next
        this.size++
    }

    fun toArray(): Array<Int> {
        val arrayOfElements = Array(this.size) { 0 }
        var current = this.head
        var currentPosition = 0

        while (current != null) {
            arrayOfElements[currentPosition] = current.value
            current = current.next
            currentPosition++
        }

        return arrayOfElements
    }

    fun clear() {
        this.head = null
        this.tail = null
        this.size = 0
    }

    fun getNode(index: Int): Node? {
        if (this.isEmpty() || index >= size) {
            return null
        }

        var current = this.head
        var currentPosition = 0

        while (currentPosition < index) {
            current = current?.next
            currentPosition++
        }

        return current
    }

    fun get(index: Int) = this.getNode(index)?.value

    fun addAtPosition(index: Int, value: Int) {
        if (this.isEmpty() || index == 0) {
            this.addAtStart(value)
            return
        }

        if (index >= this.size) {
            this.addAtEnd(value)
            return
        }

        val current = getNode(index)
        val newNode = Node(value)
        current?.previous?.next = newNode
        newNode.previous = current?.previous
        current?.previous = newNode
        newNode.next = current
        this.size++
    }

    fun indexOf(value: Int): Int {
        if (this.isEmpty()) return -1

        var current = this.head
        var currentPosition = 0

        while (currentPosition < this.size) {
            if (current?.value == value) return currentPosition
            current = current?.next
            currentPosition++
        }

        return -1
    }

    fun contains(value: Int) = this.indexOf(value) != -1

    fun removeHead() {
        if (this.isEmpty() || this.size == 1) clear()

        this.head = this.head?.next
        this.head?.previous = null
        this.size--
    }

    fun removeTail() {
        if (this.isEmpty() || this.size == 1) clear()

        this.tail = this.tail?.previous
        this.tail?.next = null
        this.size--
    }

    fun removeAtPosition(index: Int) {
        if (this.isEmpty() || index == 0) this.removeHead().also { return }

        if (index >= this.size) removeTail().also { return }

        val elementToRemove = this.getNode(index) ?: return
        elementToRemove.previous?.next = elementToRemove.next
        elementToRemove.next?.previous = elementToRemove.previous
        this.size--
    }

    fun remove(value: Int): Boolean {
        val index = this.indexOf(value)
        if (this.isEmpty() || index == -1) return false

        this.removeAtPosition(index)
        return true
    }

    fun reverse() {
        if (this.isEmpty() || this.size == 1) {
            return
        }

        var current = this.head
        var currentPosition = 0

        while (currentPosition < this.size) {
            val oldCurrentNext = current?.next
            current?.next = current?.previous
            current?.previous = oldCurrentNext
            current = oldCurrentNext
            currentPosition++
        }

        val oldTail = this.tail
        this.tail = this.head
        this.head = oldTail
    }
}

val linkedList = DoublyLinkedList()
println(linkedList.toArray().joinToString { "$it" })
linkedList.addAtEnd(20)
linkedList.addAtEnd(9)
linkedList.addAtEnd(86)
linkedList.addAtEnd(-2)
linkedList.addAtEnd(16)
linkedList.addAtStart(3)
linkedList.addAtEnd(23)

println(linkedList.toArray().joinToString { "$it" })
println(linkedList.size)
linkedList.clear()
println(linkedList.size)
linkedList.addAtStart(3)
println(linkedList.toArray().joinToString { "$it" })
println(linkedList.getNode(0))
println(linkedList.getNode(3))
linkedList.addAtPosition(1, 10)
linkedList.addAtPosition(1, 86)
println(linkedList.toArray().joinToString { "$it" })
println(linkedList.indexOf(86))
println(linkedList.contains(86))
linkedList.removeHead()
println(linkedList.toArray().joinToString { "$it" })
linkedList.removeTail()
println(linkedList.toArray().joinToString { "$it" })
linkedList.addAtPosition(1, 10)
linkedList.addAtPosition(1, 86)
println(linkedList.toArray().joinToString { "$it" })
linkedList.removeAtPosition(1)
println(linkedList.toArray().joinToString { "$it" })
linkedList.addAtEnd(20)
linkedList.addAtEnd(9)
linkedList.addAtEnd(86)
linkedList.addAtEnd(-2)
linkedList.addAtEnd(16)
println(linkedList.toArray().joinToString { "$it" })
linkedList.reverse()
println(linkedList.toArray().joinToString { "$it" })
