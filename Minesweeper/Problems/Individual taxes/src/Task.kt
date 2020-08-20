import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    // write your code here
    var highestInd = 1
    var highestTax = 0
    val incomes = IntArray(scanner.nextInt()) { scanner.nextInt() }
    for (i in incomes.indices) {
        val tax = incomes[i] * scanner.nextInt()
        if (highestTax < tax) {
            highestTax = tax
            highestInd = i
        }
    }
    println(highestInd + 1)
}