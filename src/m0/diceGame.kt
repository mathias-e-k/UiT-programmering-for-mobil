import kotlin.random.Random

class Dice(var value: Int = 0) {
    init {
        var value = throwDice()
    }
    fun throwDice() {
        value = Random.nextInt(1, 7)
    }
}

fun main() {
    val diceList = List(5) { Dice() }
    for (i in 1..2) {
        diceList.forEach {
            if (it.value != 6) {
                it.throwDice()
            }
        }
    }
    val diceSum = diceList.count { it.value == 6 } * 6
    println("Sum of dice: $diceSum")
}
