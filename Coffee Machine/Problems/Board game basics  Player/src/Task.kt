class Player(val id: Int, val name: String, val hp: Int) {
    companion object {
        var serial = 0
        fun create(name: String): Player {
            return Player(serial++, name, 100)
        }
    }
}
