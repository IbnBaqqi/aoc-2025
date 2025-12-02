fun main() {

    fun part1(input: List<String>): Int {

        var currPos = 50
        var count = 0

        input.forEach {
            val dir = it[0]
            val move = it.substring(1).toInt()
            val res = rotate(dir, move, currPos)
            currPos = res
            if (res == 0) {
                count++
            }
        }
        return count
    }


    fun part2(input: List<String>): Int {
        var currPos = 50
        var count = 0
        input.forEach {
            val move = if (it[0] == 'L') -1 else 1

            repeat(it.drop(1).toInt()) {
                currPos = (currPos + move) % 100
                if (currPos == 0) count++
            }
        }
        return count
    }

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}

fun rotate(dir: Char, move: Int, currPos: Int) : Int {
    val newPos = if (dir == 'L') {
        (currPos - move) % 100
    } else{
        (currPos + move) % 100
    }
    newPos.println()
    return newPos
}
