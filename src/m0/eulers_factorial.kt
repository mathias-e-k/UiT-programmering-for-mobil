fun factorial(n: Int): Int {
    if (n == 0) return 1
    return n * factorial(n - 1)
}

fun eulers(): Double {
    var e = 0.0
    for (i in 0..14) {
        e += 1.0 / factorial(i)
    }
    return e
}
fun main() {
    println(factorial(9))
    println(eulers())
}