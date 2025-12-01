fun main() {
    fun part1(input: List<String>): Int {

        //The start is 50
        // L is left
        // R is right
        // if at 0 and L5 == 95    and R10 == 5
        // everytime its at zero (count)

        var currentPosition = 50
        var count = 0

        input.forEach {
            text -> val dir = text[0]
            val move = text.substring(1).toInt()
            val res = rotate(dir, move, currentPosition)
            currentPosition = res
            if (res == 0) {
                count++
            }
        }
        return count
    }


    fun part2(input: List<String>): List<String> {
        return input
    }

    val inputTest = readInput("Day01")

    part1(inputTest).println()
//    part2(inputTest).println()
}

fun rotate(dir: Char, move : Int, curPosition: Int) : Int {
    var newPos = 0
    if (dir == 'L') {
        newPos = curPosition - move // 50 - 60
        if (newPos < 0)
            newPos += 100
    }else if (dir == 'R') {
        newPos = curPosition + move // 50 + 60
        if (newPos > 99)
            newPos -= 100
    }
//    newPos.println()
    return newPos
}
