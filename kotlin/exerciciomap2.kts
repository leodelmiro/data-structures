fun normalize(text: String): String {
    val pattern = Regex("[^\\p{L}\\p{N}\\s]")
    val words = pattern.replace(text, " ")
    return words.replace("\\s+".toRegex(), " ").trim().lowercase()
}

data class Rank(val word: String, val count: Int)

val text =
    "O vento sussurra sons entre as árvores, sons que fazem animais correrem. A floresta e a natureza vibram com segredos e sons."

fun wordCount(text: String): List<Rank> {
    val textNormalized = normalize(text).split(" ")
    val counter = hashMapOf<String, Int>()
    val ranks = mutableListOf<Rank>()

    println(textNormalized)

    for (c in textNormalized) {
        counter[c] = (counter.getOrDefault(c, 0)) + 1
    }

    counter.forEach { (key, value) ->
        ranks.add(Rank(key, value))
    }
    return ranks.sortedWith(
        compareByDescending<Rank> { it.count }
            .thenBy { it.word }
    )
}

println(wordCount(text))