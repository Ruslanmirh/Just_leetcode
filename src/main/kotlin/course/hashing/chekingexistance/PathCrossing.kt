package course.hashing.chekingexistance

class PathCrossing {

    private data class Point(
        val x: Int,
        val y: Int
    ) {
        fun move(direction: Char): Point {
            return when (direction) {
                'N' -> Point(x, y + 1)
                'S' -> Point(x, y - 1)
                'W' -> Point(x - 1, y)
                'E' -> Point(x + 1, y)
                else -> this
            }
        }
    }

    class Solution {
        fun isPathCrossing(path: String): Boolean {
            val set = hashSetOf<Point>()

            val initPoint = Point(0, 0)
            var current = initPoint
            set.add(initPoint)
            path.forEach {
                current = current.move(it)
                if (set.contains(current)) {
                    return true
                }
                set.add(current)
            }
            return false
        }
    }
}

fun main() {
    val res = PathCrossing.Solution().isPathCrossing("SS")
    println(res)
}