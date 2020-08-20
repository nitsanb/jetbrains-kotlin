package minesweeper

import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random

val scanner = Scanner(System.`in`)

fun main() {
    print("How many mines do you want on the field?")
    val gameField = MineField(9, 9, scanner.nextInt())
    gameField.startGame()
}

class MineField(w: Int, h: Int, m: Int) {
    private val width = if (w < 1) 1 else w
    private val height = if (h < 1) 1 else h
    private val mines = when {
        m < 1 -> 1
        m > width * height -> width * height
        else -> m
    }
    private val field = Array(height) { Array(width) { Cell(false) } }
    private var unexploredCells = width * height
    private var mineCells = ArrayList<Cell>()
    private var safeMarks = 0
    private var mineMarks = 0
    private var fail = false

    init {
        val random = Random.Default
        val cells = width * height
        while (mineCells.size < mines) {
            val randomCell = random.nextInt(cells)
            val x = randomCell / width
            val y = randomCell % width
            if (!field[x][y].isMine) {
                addMine(x, y)
            }
        }
        printField()
    }

    fun startGame() {
        while (!isSuccess() && !fail) {
            print("Set/unset mine marks or claim a cell as free:")
            runTurn()
        }
        print(
                if (fail) "You stepped on a mine and failed!"
                else "Congratulations! You found all the mines!"
        )
    }

    private fun isSuccess() = safeMarks == 0 &&
            (mineMarks == mineCells.size ||
            unexploredCells == mineCells.size)


    private fun failGame() {
        for (m in mineCells) m.explore()
        fail = true
    }

    private fun runTurn() {
        val userX = scanner.nextInt() - 1
        val userY = scanner.nextInt() - 1
        val command = scanner.next()
        val fieldChange: Boolean

        fieldChange = try {
            val cell = cell(userX, userY)
            if (!cell.isExplored()) {
                when (command) {
                    "m", "mine" -> {
                        toggleCellMark(cell)
                        true
                    }
                    "f", "free" -> {
                        exploreCell(userX, userY)
                        if (cell.isMine) failGame()
                        true
                    }
                    else -> {
                        println("Invalid command - try \"free\" or \"mine\"")
                        false
                    }
                }
            } else {
                println("This cell has already been explored, choose an unexplored cell")
                false
            }
        } catch (e: ArrayIndexOutOfBoundsException) {
            println("Invalid coordinates - Mine Field is $width by $height")
            false
        }
        if (fieldChange) printField()
    }

    private fun addMine(x: Int, y: Int) {
        field[x][y].layMine()
        mineCells.add(cell(x, y))
        increaseCellValue(x - 1, y - 1)
        increaseCellValue(x, y - 1)
        increaseCellValue(x + 1, y - 1)
        increaseCellValue(x - 1, y)
        increaseCellValue(x + 1 , y)
        increaseCellValue(x - 1, y + 1)
        increaseCellValue(x, y + 1)
        increaseCellValue(x + 1, y + 1)
    }

    private fun printField() {
        val xLine = printTop()
        for (line in 0 until height) {
            val lineNum = line + 1
            print("${lineNum}|")
            for (cell in 0 until width) {
                print(field[cell][line].toString())
            }
            println("|")
        }
        println("-|${xLine}|")
    }

    private fun printTop(): String {
        var xAxis = ""
        var xLine = ""
        for(i in 1..width) {
            xAxis += "$i"
            xLine += "-"
        }
        println(
            " |${xAxis}|\n" +
                    "-|${xLine}|"
        )

        return xLine
    }

    private fun exploreCell(x: Int, y: Int) {
        val cell: Cell
        try {
            cell = cell(x, y)
        } catch (e: ArrayIndexOutOfBoundsException) {
            return
        }
        if (cell.isExplored()) {
            return
        }
        if (cell.isMarked()) toggleCellMark(cell)
        cell.explore()
        unexploredCells--
        if (!cell.isMine && cell.mineValue() == 0) exploreAdjacentCells(x, y)
    }

    private fun exploreAdjacentCells(x: Int, y: Int) {
        exploreCell(x - 1, y - 1)
        exploreCell(x, y - 1)
        exploreCell(x + 1, y - 1)
        exploreCell(x - 1, y)
        exploreCell(x + 1 , y)
        exploreCell(x - 1, y + 1)
        exploreCell(x, y + 1)
        exploreCell(x + 1, y + 1)
    }
    
    private fun toggleCellMark(cell: Cell): Boolean {
        val isCellMarked = cell.toggleMark()
        if (!cell.isMine) {
            if (isCellMarked) safeMarks++ else safeMarks--
        } else {
            if (isCellMarked) mineMarks++ else mineMarks--
        }
        return isCellMarked
    }

    private fun increaseCellValue(x: Int, y: Int) {
        try {
            field[x][y].increaseVal()
        } catch (e: ArrayIndexOutOfBoundsException) {
            return
        }
    }

    private fun cell(x: Int, y: Int): Cell = field[x][y]

    private class Cell(var isMine: Boolean) {
        private var marked = false
        private var explored = false
        private var mineValue = 0
        private var char = "."

        fun mineValue() = mineValue
        fun isExplored() = explored
        fun isMarked() = marked

        fun layMine() {
            mineValue = 0
            isMine = true
        }

        fun toggleMark(): Boolean {
            marked = !marked
            char = if (marked) "*" else "."
            return marked
        }

        fun explore() {
            explored = true
            char = when {
                isMine -> "X"
                mineValue == 0 -> "/"
                else -> mineValue.toString()
            }
        }

        fun increaseVal() {
            if (!isMine) mineValue++
        }

        override fun toString(): String {
            return char
        }
    }
}
