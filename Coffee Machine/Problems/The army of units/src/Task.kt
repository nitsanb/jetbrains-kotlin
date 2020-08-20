import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    // write your code here
    val a = scanner.nextInt()
    println(
            when {
                a < 1 -> "no army"
                a in 1..4 -> "few"
                a in 5..9 -> "several"
                a in 10..19 -> "pack"
                a in 20..49 -> "lots"
                a in 50..99 -> "horde"
                a in 100..249 -> "throng"
                a in 250..499 -> "swarm"
                a in 500..999 -> "zounds"
                else -> "legion"
            }
    )
}