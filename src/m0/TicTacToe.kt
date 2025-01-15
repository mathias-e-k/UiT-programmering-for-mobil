abstract class Game() {
    abstract fun start()
    abstract fun getPlayerInput(): Int
}
interface board {
    fun printGameBoard()
}
interface moves {
    fun checkRows(): Int
    fun checkColumns(): Int
    fun checkDiagonals(): Int
}

class GameBoard(val height: Int=3, val width: Int=3) {
    private val board = MutableList(height * width) { ' ' }
    fun getBoard() = board
    fun printBoard() {
        for (i in 0..<height -1) {
            println(board.subList(i*width, i*width + 3).joinToString("|"))
            println("-----")
        }
        println(board.subList((height - 1) * width, height * width).joinToString("|"))
    }
    fun play(position: Int, player: Char) {
        board[position] = player
    }
}

class TicTacToe: Game(), board, moves {
    private val board = GameBoard()
    override fun checkRows(): Int {
        val boardList = board.getBoard()
        for (i in 0..2) {
            if (boardList[i * 3] != ' ' && boardList[i * 3] == boardList[i * 3 + 1] && boardList[i * 3] == boardList[i * 3 + 2]) {
                return i
            }
        }
        return -1
    }
    override fun checkColumns(): Int {
        val boardList = board.getBoard()
        for (i in 0..2) {
            if (boardList[i] != ' ' && boardList[i] == boardList[i + 3] && boardList[i] == boardList[i + 6]) {
                return i
            }
        }
        return -1
    }
    override fun checkDiagonals(): Int {
        val boardList = board.getBoard()
        if (boardList[0] != ' ' && boardList[0] == boardList[4] && boardList[0] == boardList[8]) {
            return 0
        }
        if (boardList[2] != ' ' && boardList[2] == boardList[4] && boardList[2] == boardList[6]) {
            return 1
        }
        return -1
    }
    fun check(): Boolean {
        var winPosition = checkRows()
        if (winPosition != -1) {
            println("Player won on row ${winPosition + 1}")
            return true
        }
        winPosition = checkColumns()
        if (winPosition != -1) {
            println("Player won on column ${winPosition + 1}")
            return true
        }
        winPosition = checkDiagonals()
        if (winPosition != -1) {
            println("Player won on diagonal ${winPosition + 1}")
            return true
        }
        return false
    }
    override fun printGameBoard() {
        board.printBoard()
    }
    override fun start() {
        var currentPlayer = 1
        val playerSymbols = "XO"
        var gameOver = false
        board.printBoard()
        while (!gameOver) {
            currentPlayer = (currentPlayer+1) % 2
            println("Player ${playerSymbols[currentPlayer]}")
            var playerInput = getPlayerInput()
            while (!isValidMove(playerInput)) {
                println("Invalid input")
                playerInput = getPlayerInput()
            }
            board.play(playerInput, playerSymbols[currentPlayer])
            gameOver = check()
            board.printBoard()
        }
    }
    private fun isValidMove(i: Int): Boolean {
        if (i !in 0..8) { // might be unnecessary since getPlayerInput() checks that the input is in the correct range
            return false
        }
        if (board.getBoard()[i] == ' ') {
            return true
        }
        return false
    }

    override fun getPlayerInput(): Int {
        print("Choose column(1-3): ")
        var col = readlnOrNull()?.toIntOrNull() ?: -1
        print("Choose row(1-3): ")
        var row = readlnOrNull()?.toIntOrNull() ?: -1
        while ((col !in 1..3) or (row !in 1..3)) {
            print("Invalid input")
            print("Choose column(1-3): ")
            col = readlnOrNull()?.toIntOrNull() ?: -1
            print("Choose row(1-3): ")
            row = readlnOrNull()?.toIntOrNull() ?: -1
        }
        return (row - 1) * 3 + col - 1
    }
}

fun main() {
    val game1 = TicTacToe()
    game1.start()
}