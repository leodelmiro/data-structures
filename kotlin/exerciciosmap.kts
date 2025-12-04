val cookies = hashMapOf<String, String>()


cookies["user"] = "leo13"
cookies["email"] = "leo@gmail.com"
cookies["last-login"] = "2024-07-04T21:42:40.353283800Z"

println("user: ${cookies["user"]}")
println("Is empty: ${cookies.isEmpty()}")
println("Count: ${cookies.size}")

println("Value")
for(value in cookies.values) {
    println(value)
}

println("Keys")
for(value in cookies.keys) {
    println(value)
}

cookies.forEach { (key, value) ->
    println("$key : $value")
}

println("Constains email ${cookies.contains("email")}")
println("Removed: ${cookies.remove("email")}")

println("Constains email ${cookies.contains("email")}")
println("Removed: ${cookies.remove("email")}")