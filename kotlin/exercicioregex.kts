fun removeNonDigits(input: String): String {
    return input.replace(Regex("\\D"), "")
}

println(removeNonDigits("94923784799"))
println(removeNonDigits("213.445.034-82"))
println("----------------------------")

fun extractEmailInformation(email: String) {
    val emailSpllited = email.split("@")
    val userName = emailSpllited[0]
    val domain = emailSpllited[1]
    val isBrasilianEmail = if (email.contains(Regex(".[.]br\$"))) "sim" else "nao"

    println("Usuario $userName")
    println("Dominio $domain")
    println("Brasileiro $isBrasilianEmail")
}

extractEmailInformation("maria123@gmail.com")
extractEmailInformation("notbrazilian@gmail.com")
extractEmailInformation("notbrazilian@gmail.combr")
extractEmailInformation("joao.silva23@yahoo.com.br")
println("----------------------------")

fun validatePassword(password: String): Boolean {
    if (password.length < 8) return false
    if (!password.contains(Regex("[a-zA-Z]+"))) return false
    if (!password.contains(Regex("[0-9]+"))) return false
    if (!password.contains(Regex("[@#&]+"))) return false

    return true
}

println(validatePassword("amerca1@"))
println(validatePassword("amrca154682"))
println("----------------------------")

fun validAnagram(s: String, t: String): Boolean {
    val counter = mutableMapOf<Char ,Int >()
    if (s.isEmpty() || t.isEmpty() ) return false

    s.forEach {
        counter[it] = counter.getOrDefault(it, 0) + 1
    }

    t.forEach {
        counter[it] = counter.getOrDefault(it, 0) - 1
    }

    counter.values.forEach {
        if (it != 0) return false
    }

    return true
}
println(validAnagram("anagram", "nagaram"))
println(validAnagram("rat", "car"))
println("----------------------------")

