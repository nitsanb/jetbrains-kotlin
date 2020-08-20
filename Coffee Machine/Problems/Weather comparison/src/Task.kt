class City(val name: String, val average: Int) {
    var degrees: Int = average
        set(value) {
            field = if (value < -92 || value > 57) average else value
        }

    fun colderCity(city: City): City {
        return if (degrees < city.degrees) this else city
    }

    fun colderName(city: City): String {
        return when {
            degrees < city.degrees -> "$name"
            degrees > city.degrees -> "${city.name}"
            else -> "neither"
        }
    }
}        

fun main() {
    val first = readLine()!!.toInt()
    val second = readLine()!!.toInt()
    val third = readLine()!!.toInt()
    val firstCity = City("Dubai", 30)
    firstCity.degrees = first
    val secondCity = City("Moscow", 5)
    secondCity.degrees = second
    val thirdCity = City("Hanoi", 20)
    thirdCity.degrees = third
    print(firstCity.colderName(secondCity.colderCity(thirdCity)))
}
