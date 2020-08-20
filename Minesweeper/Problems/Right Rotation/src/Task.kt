import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    // write your code here
    val size = scanner.nextInt()
    val nums = IntArray(size) { scanner.nextInt() }
    val rotation = scanner.nextInt() % size
    for (i in nums.indices) {
        print("${nums[(size - rotation + i) % size]} ")
    }
}