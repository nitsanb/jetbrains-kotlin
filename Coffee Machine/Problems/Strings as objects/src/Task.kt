fun main() {
    val input = readLine()!!
    // write code here
    if (!input.isEmpty()) {
        println(when (input.first()) {
            'i' -> input.drop(1).toInt() + 1
            's' -> input.drop(1).reversed()
            else -> input
        })
    }
}