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

    fun part2(input: List<String>): Long {

        val ranges = input.flatMap { block ->
            block.split(',')
                .filter { it.isNotBlank() }
                .map { part ->
                    val (start, end) = part.split('-').map { it.toLong() }
                    start..end
                }
        }

        fun isInvalid(id: Long): Boolean {
            val s = id.toString()
            val n = s.length

            for (len in 1..n / 2) {
                if (n % len != 0) continue // must divide evenly
                val pattern = s.take(len)
                val repeated = pattern.repeat(n / len)
                if (repeated == s) return true
            }
            return false
        }


        val invalidIds = ranges.flatMap { longs ->
            longs.filter { isInvalid(it) }
        }

        return invalidIds.sum()
    }

    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}
