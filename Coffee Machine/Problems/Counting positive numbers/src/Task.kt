import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    // put your code here
    var amount = 0
    repeat(scanner.nextInt()) {
        if (scanner.nextInt() > 0) {
            amount++
        }
    }
    println(amount)
}