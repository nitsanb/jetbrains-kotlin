import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    // put your code here
    val n = scanner.nextInt()
    var i = 1
    var sq = 1
    while (sq <= n) {
        println(sq)
        i++
        sq = i * i
    }
}
