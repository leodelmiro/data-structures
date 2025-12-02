class StackWithArray(
    var size: Int = 100,
    val itens: Array<String> = Array(size) { "" },
    var top: Int = -1
) {

    fun push(value: String) {
        if (this.isFull()) throw IllegalStateException("A Pilha está cheia")
        itens[++top] = value
    }

    fun pop(): String {
        if (this.isEmpty()) throw IllegalStateException("A Pilha está vazia")
        val element = itens[top]
        itens[top--] = ""
        return element
    }

    fun isEmpty() = top == -1

    fun isFull() = top == (size - 1)

    fun count() = top + 1

    fun peek() = itens[top]
}

val stackWithArray = StackWithArray()
stackWithArray.push("Leo")
println(stackWithArray.itens[0])
println(stackWithArray.isEmpty())
stackWithArray.pop()
println(stackWithArray.isEmpty())
println(stackWithArray.count())
stackWithArray.push("Teste")
stackWithArray.push("Saul")
stackWithArray.push("Goodman")
println(stackWithArray.count())
println(stackWithArray.peek())
