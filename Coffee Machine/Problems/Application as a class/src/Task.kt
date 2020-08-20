class Application(val name: String) {

    // write the run method here
    fun run(strings: Array<String>) {
        println("$name")
        for (i in strings) {
            println(i)
        }
    }
}