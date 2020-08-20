import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    // write your code here
    val x1 = scanner.nextInt()
    val y1 = scanner.nextInt()
    val z1 = scanner.nextInt()
    val x2 = scanner.nextInt()
    val y2 = scanner.nextInt()
    val z2 = scanner.nextInt()

    val box1 = intArrayOf(x1, y1, z1)
    val box2 = intArrayOf(x2, y2, z2)
    box1.sort()
    box2.sort()

    println(
            if (box1 contentEquals box2) {
                "Box 1 = Box 2"
            } else if (box1[0] >= box2[0] && box1[1] >= box2[1] && box1[2] >= box2[2]) {
                "Box 1 > Box 2"
            } else if (box1[0] <= box2[0] && box1[1] <= box2[1] && box1[2] <= box2[2]) {
                "Box 1 < Box 2"
            } else {
                "Incomparable"
            }
    )
}
