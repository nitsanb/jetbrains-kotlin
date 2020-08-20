import java.util.*

fun triangle(scanner: Scanner): Double {
    val a = scanner.nextDouble()
    val b = scanner.nextDouble()
    val c = scanner.nextDouble()

    val s = (a + b + c) / 2
    return Math.sqrt(s * (s - a) * (s - b) * (s - c))
}

fun rectangle(scanner: Scanner): Double {
    val a = scanner.nextDouble()
    val b = scanner.nextDouble()
    return a * b
}

fun circle(scanner: Scanner): Double {
    val r = scanner.nextDouble()
    return 3.14 * r * r
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    // write your code here
    println(
            when (scanner.nextLine()) {
                "triangle" -> triangle(scanner)
                "rectangle" -> rectangle(scanner)
                "circle" -> circle(scanner)
                else -> "Unknown shape"
            }
    )
}
