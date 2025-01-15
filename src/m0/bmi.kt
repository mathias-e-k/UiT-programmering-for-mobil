
import kotlin.math.pow
import kotlin.math.round

fun main() {
    print("Enter weight (kg): ")
    val weightStr = readlnOrNull()
    print("Enter height (m): ")
    val heightStr = readlnOrNull()
    try {
        val height = heightStr?.toDouble() ?: 0.0
        val weight = weightStr?.toDouble() ?: 0.0
        var BMI = weight / (height.pow(2))
        BMI = round(BMI * 10) / 10
        println("Your BMI is $BMI")
        print(when (BMI) {
            in 0.0..18.5 -> "Underweight"
            in 18.5..24.9 -> "Normal weight"
            in 25.0..29.9 -> "Overweight"
            else -> "Obese"
        })
    } catch (e: Exception) {
        println("wrong format in input: ${e.message}")
    }

}