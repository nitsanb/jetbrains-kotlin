package machine

import java.util.*

val scanner = Scanner(System.`in`)
var state = State.ACTION
var water = 400
var milk = 540
var beans = 120
var cups = 9
var money = 550

fun main() {
    state = State.ACTION
    do {
        ExecuteCommand.execute(ExecuteCommand.promptUser())
    } while (state != State.EXIT)
}

enum class State {
    ACTION(),
    BUY(),
    FILL_WATER,
    FILL_MILK,
    FILL_BEANS,
    FILL_CUPS,
    EXIT
}

object ExecuteCommand {

    fun promptUser(): String {
        val userInput = prompt(when (state) {
            State.ACTION -> "Write action (buy, fill, take, remaining, exit):"
            State.BUY -> "What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:"
            State.FILL_CUPS -> "Write how many disposable cups of coffee do you want to add:"
            State.FILL_MILK -> "Write how many ml of milk do you want to add:"
            State.FILL_WATER -> "Write how many ml of water do you want to add:"
            State.FILL_BEANS -> "Write how many grams of coffee beans do you want to add:"
            State.EXIT -> "Done"
        })

        return userInput
    }

    fun execute(command: String) {
        when (state) {
            State.ACTION -> action(command)
            State.BUY -> buy(command)
            State.FILL_CUPS, State.FILL_MILK, State.FILL_WATER, State.FILL_BEANS -> fill(command)
            State.EXIT -> return
        }
    }

    private fun action(input: String) {
        state = when (input) {
            "buy" -> State.BUY
            "fill" -> State.FILL_WATER
            "take" -> {
                take()
                State.ACTION
            }
            "remaining" -> {
                report()
                State.ACTION
            }
            "exit" -> State.EXIT
            else -> {
                println("Error: unknown command \"$input\"")
                State.EXIT
            }
        }
    }

    private fun buy(input: String) {
        when (input) {
            "1" -> println(trade(250, 0, 16, 4))
            "2" -> println(trade(350, 75, 20, 7))
            "3" -> println(trade(200, 100, 12, 6))
            "back" -> print("")
            else -> println("Error: invalid option: $input")
        }
        state = State.ACTION
    }

    private fun trade(w: Int, mi: Int, b: Int, mo: Int): String {
        val missingResources = mutableListOf<String>()
        if (w > water) {
            missingResources.add("water")
        }
        if (mi > milk) {
            missingResources.add("milk")
        }
        if (b > beans) {
            missingResources.add("beans")
        }
        if (cups < 1) {
            missingResources.add("cups")
        }

        if (missingResources.size > 0) {
            return "Sorry, not enough ${missingResources.joinToString()}!"
        } else {
            water -= w
            milk -= mi
            beans -= b
            cups--
            money += mo
            return "I have enough resources, making you a coffee!"
        }
    }

    private fun fill(amount: String) {
        val toAdd = amount.toInt()
        state = when(state) {
            State.FILL_WATER -> {
                water += toAdd
                State.FILL_MILK
            }
            State.FILL_MILK -> {
                milk += toAdd
                State.FILL_BEANS
            }
            State.FILL_BEANS -> {
                beans += toAdd
                State.FILL_CUPS
            }
            State.FILL_CUPS -> {
                cups += toAdd
                State.ACTION
            }
            else -> {
                println("Error: unexpected state \"$state\"")
                State.EXIT
            }
        }
    }

    fun take() {
        println("I gave you \$$money")
        money = 0
    }

    private fun report() {
        println("The coffee machine has:\n" +
                "$water of water\n" +
                "$milk of milk\n" +
                "$beans of coffee beans\n" +
                "$cups of disposable cups\n" +
                "$money of money"
        )
    }

    fun prompt(message: String): String {
        println(message)
        return scanner.next()
    }
}


/* a strange */ // /* single-line comment */
b)

// this is
a multiple line
// comment
c)

/*
    another comment
*/*/
d)

/**
documentation comment?
 **/
e)

/*/*
    YAC = Yet Another Comment
*/
