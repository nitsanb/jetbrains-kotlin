import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    // write your code here
    val num = scanner.nextInt()
    println(
            if (num == 0) {
                "zero"
            } else if (num > 0) {
                "positive"
            } else {
                "negative"
            }
    )
}