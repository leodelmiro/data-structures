import java.util.LinkedList

class StackWithList(
    val itens: LinkedList<String> = LinkedList()
) {

    fun push(value: String) {
        itens.push(value)
    }

    fun pop(): String {
        if (this.isEmpty()) throw IllegalStateException("A Pilha está vazia")
        return itens.pop()
    }

    fun isEmpty() = itens.size == 0
    
    fun count() = itens.size

    fun peek(): String = itens.peek()
}

val stackWithList = StackWithList()
stackWithList.push("Leo")
println(stackWithList.itens[0])
println(stackWithList.isEmpty())
stackWithList.pop()
println(stackWithList.isEmpty())
println(stackWithList.count())
stackWithList.push("Teste")
stackWithList.push("Saul")
stackWithList.push("Goodman")
println(stackWithList.count())
println(stackWithList.peek())
