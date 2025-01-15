class Cube(val height: Int = 1, val width: Int = 1, val depth: Int = 1) {
    fun volume() = height * width * depth
    fun surfaceArea() = 2 * width * depth + 2 * width * height + 2 * depth * height
}

fun main() {
    val cube1 = Cube()
    println(cube1.volume())
    println(cube1.surfaceArea())
    val cube2 = Cube(height = 3, width = 2, depth = 5)
    println(cube2.volume())
    println(cube2.surfaceArea())
    val cube3 = Cube(10, 17, 23)
    println(cube3.volume())
    println(cube3.surfaceArea())
}