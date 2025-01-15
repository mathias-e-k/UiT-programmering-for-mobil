class TallMengde(val numbers: MutableList<Int> = mutableListOf()) {
    fun leggTil(tall: Int) {
        numbers.add(tall)
    }
    fun antall() = numbers.size
    fun gjennomsnitt() = numbers.average()
    fun skrivUtUnion(mengde1: TallMengde): Set<Int> {
        return mengde1.numbers.union(this.numbers)
    }
    fun skrivUtSnitt(mengde1: TallMengde): Set<Int> {
        return mengde1.numbers.intersect(this.numbers)
    }
}

fun main() {
    val mengde1 = TallMengde()
    mengde1.leggTil(2)
    mengde1.leggTil(3)
    mengde1.leggTil(8)
    mengde1.leggTil(12)
    println(mengde1.gjennomsnitt())
    println(mengde1.antall())
    val mengde2 = TallMengde()
    mengde2.leggTil(3)
    mengde2.leggTil(12)
    mengde2.leggTil(9)
    println(mengde2.gjennomsnitt())
    println(mengde1.skrivUtUnion(mengde2))
    println(mengde1.skrivUtSnitt(mengde2))
}