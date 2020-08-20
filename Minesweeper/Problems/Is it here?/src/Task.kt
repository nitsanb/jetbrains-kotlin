import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    // write your code here
    val nums = IntArray(scanner.nextInt())
    for (i in nums.indices) {
        nums[i] = scanner.nextInt()
    }
    val m = scanner.nextInt()
    var msg = "NO"
    for (i in nums) {
        if (i == m) {
            msg = "YES"
            break
        }
    }
    println(msg)
}