package course.stacks.queues

/**
 * https://leetcode.com/problems/moving-average-from-data-stream/description/
 */

class MovingAverageFromDataStream {

    class MovingAverage(
        private val size: Int
    ) {
        private val deque = ArrayDeque<Int>()
        private var sum = 0.0

        fun next(`val`: Int): Double {
            deque.addLast(`val`)
            sum += `val`
            if (deque.size > size) {
                sum -= deque.removeFirst()
            }
            return sum / deque.size
        }

    }

}