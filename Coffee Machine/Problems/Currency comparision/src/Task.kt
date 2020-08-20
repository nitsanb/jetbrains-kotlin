import java.util.Scanner

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    // put your code here
    val country1 = Country.findByCountry(input.next())
    val country2 = Country.findByCountry(input.next())
    println(country1.sameCurrency(country2))
}

enum class Country(val country: String, val currency: String) {
    GERMANY("Germany", "Euro"),
    MALI("Mali", "CFA franc"),
    DOMINICA("Dominica", "Eastern Caribbean dollar"),
    CANADA("Canada", "Canadian dollar"),
    SPAIN("Spain", "Euro"),
    AUSTRALIA("Australia", "Australian dollar"),
    BRAZIL("Brazil", "Brazilian Real"),
    SENEGAL("Senegal", "CFA franc"),
    FRANCE("France", "Euro"),
    GRENADA("Grenada", "Eastern Caribbean dollar"),
    KIRIBATI("Kiribati", "Australian dollar"),
    NULL("", "");

    fun sameCurrency(otherCountry: Country): Boolean {
        return currency.contentEquals(otherCountry.currency)
    }

    companion object {
        fun findByCountry(country: String): Country {
            for (enum in values()) {
                if (country == enum.country) return enum
            }
            return NULL
        }
    }
}