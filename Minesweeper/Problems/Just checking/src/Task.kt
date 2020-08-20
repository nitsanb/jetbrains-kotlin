import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    var res = "NO"
    // write your code here
    val arr = IntArray(scanner.nextInt()) { scanner.nextInt() }
    val m = scanner.nextInt()
    val n = scanner.nextInt()
    for (i in 0 until arr.lastIndex) {
        if (arr[i] == n && arr[i + 1] == m || arr[i] == m && arr[i + 1] == n) {
            res = "YES"
            break
        }
    }
    println(res)
}