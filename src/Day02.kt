fun main() {
    fun part1(input: List<String>): Long {
//         parse input
        val ranges = input.flatMap { block ->
            block.split(',')
                .filter { it.isNotBlank() }
                .map { part ->
                    val (start, end) = part.split('-').map { it.toLong() }
                    start..end
                }
        }

        fun isInValid(id: Long): Boolean {
            val s = id.toString()
            if (s.length % 2 != 0) return false
            val mid = s.length / 2
            return s.take(mid) == s.substring(mid)
        }

        val invalidIds = ranges.flatMap { longs ->
            longs.filter { isInValid(it) }
        }

        return invalidIds.sum()
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    val input = readInput("Day02")
    part1(input).println()

//    newInput.
//    val input = readInput("Day01")
//    part2(testInput).println()
//    part2(input).println()
}
