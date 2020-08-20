import java.lang.Integer.min
import java.util.*

/**
 * Print a number in repetition equal to itself, up to a set max.
 * if max is reached, return true.
 */
fun loopPrint(num: Int, max: Int): Boolean {
    repeat(min(num, max)) {
        print("$num ")
    }
    return max <= num
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    // put your code here
    var n = scanner.nextInt()
    var i = 1
    while (!loopPrint(i, n)) {
        n -= i++
    }
}
