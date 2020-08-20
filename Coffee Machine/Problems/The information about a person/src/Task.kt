import java.util.Scanner

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    // put your code here
    val first = scanner.next()
    val last = scanner.next()
    val age = scanner.nextInt()
    println("${first.first()}. $last, $age years old")
}