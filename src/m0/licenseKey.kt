fun generateKey(): String {
    val characters = ('A'..'Z') + ('1'..'9') + ('Æ') + ('Ø') + ('Å')
    val key = (1..4).joinToString("-") { (1..4).map { characters.random() }.joinToString("") }
    return key
}

fun main() {
    val keys = mutableListOf<String>()
    print("Amount of keys: ")
    val amt = readlnOrNull()!!.toInt()
    while (keys.size < amt) {
        val key = generateKey()
        if (key in keys) {
            continue
        }
        keys.add(key)
    }
    for (key in keys) {
        println(key)
    }
}