import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    var longest = 1
    var current = 1
    // write your code here
    val size = scanner.nextInt()
    var previous = scanner.nextInt()
    for (i in 2..size) {
        val next = scanner.nextInt()
        if (previous <= next) {
            current++
            if (current > longest) {
                longest = current
            }
        } else {
            current = 1
        }
        previous = next
    }

    println(longest)
}