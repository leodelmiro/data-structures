import java.util.*

data class QueueWithList(val itens: LinkedList<String> = LinkedList<String>()) {
    fun add(item: String) {
        this.itens.push(item)
    }

    fun remove(): String {
        if (this.isEmpty()) throw IllegalStateException("Lista está vazia")
        return this.itens.removeLast()
    }

    fun peek(): String {
        if (this.isEmpty()) throw IllegalStateException("Lista está vazia")
        return this.itens.peekLast()
    }

    fun isEmpty() = this.itens.size == 0

    fun count() = this.itens.size
}

val queue = QueueWithList()
println(queue.isEmpty())
queue.add("Leo")
queue.add("Teste")
queue.add("Jorge")
println(queue.isEmpty())
println(queue.peek())
println(queue.remove())
println(queue.count())
println(queue.remove())
println(queue.remove())