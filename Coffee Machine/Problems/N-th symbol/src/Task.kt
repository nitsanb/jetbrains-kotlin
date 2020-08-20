import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    // write your code here
    val str = scanner.nextLine()
    val num = scanner.nextInt()
    println("Symbol # $num of the string \"$str\" is \'${str[num - 1]}\'")
}