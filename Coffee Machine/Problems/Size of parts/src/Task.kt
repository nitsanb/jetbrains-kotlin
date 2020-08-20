import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    // put your code here
    var perfect = 0
    var toFix = 0
    var toReject = 0
    repeat(scanner.nextInt()) {
        when (scanner.nextInt()) {
            0 -> perfect++
            1 -> toFix++
            -1 -> toReject++
            else -> println("unrecognized detector print")
        }
    }
    println("$perfect $toFix $toReject")
}
