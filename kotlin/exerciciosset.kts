val A = hashSetOf(1, 2, 3, 4, 5)
val B = hashSetOf(4, 5, 6, 7, 8)

println("Conjunto A: $A")
println("Conjunto B: $B")

A.add(9)
println("Conjunto A após adicionar o 9: $A")

A.remove(9)
println("Conjunto A após remover o 9: $A")

println("5 pertence ao Conjunto A: ${A.contains(5)}")

println("Conjunto A está vazio? ${A.isEmpty()}")

println("Tamanho do Conjunto A ${A.size}")

// União
val C1 = A.union(B)
println("União dos conjuntos A e B (Conjunto C) $C1")

// Intersecção
val C2 = A.intersect(B)
println("Intersecção dos conjuntos A e B (Conjunto C) $C2")

// Diferença
val C3 = A.subtract(B)
println("Diferença dos conjuntos A e B (Conjunto C) $C3")