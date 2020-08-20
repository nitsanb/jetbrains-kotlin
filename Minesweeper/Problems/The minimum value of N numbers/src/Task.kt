import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val size = scanner.nextInt()
    var min = scanner.nextInt()
    // write your code here
    for (i in 2..size) {
        val next = scanner.nextInt()
        min = if (min < next) min else next
    }
    println(min)
}