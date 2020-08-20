import java.util.*
import kotlin.math.abs

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    // write your code here
    val x1 = scanner.nextInt()
    val y1 = scanner.nextInt()
    val x2 = scanner.nextInt()
    val y2 = scanner.nextInt()
    val xdiff = abs(x1 - x2)
    val ydiff = abs(y1 - y2)
    println(
            if (xdiff + ydiff == 3 && abs(xdiff - ydiff) == 1) {
                "YES"
            } else {
                "NO"
            }
    )
}
