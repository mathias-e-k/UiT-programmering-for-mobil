package m0

import kotlin.random.Random

fun main() {
    print("Number of throws: ")
    val numOfThrows = readlnOrNull()?.toIntOrNull() ?: 0
    val randomValuesDice1 = List(numOfThrows) { Random.nextInt(1, 7) + Random.nextInt(1, 7) }
    val sums = IntArray(13) { 0 }
    for (i in randomValuesDice1){
        sums[i] += 1
    }
    for (i in sums.indices) {
        if (sums[i] != 0) {
            println("The number of times $i shows up: ${sums[i]}")
        }
    }
    val minimum = sums.toList().drop(2).min()
    val maximum = sums.max()
    println("Minimum: ${sums.indexOf(minimum)} shows up $minimum times")
    println("Maximum: ${sums.indexOf(maximum)} shows up $maximum times")
}