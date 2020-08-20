import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    // write your code here
    val nums = IntArray(scanner.nextInt())
    for (i in 0..nums.lastIndex) {
        nums[i] = scanner.nextInt()
    }
    if (nums.size == 1) {
        println(nums.first())
    } else {
        nums.sortDescending()
        println(nums[0] * nums[1])
    }
}