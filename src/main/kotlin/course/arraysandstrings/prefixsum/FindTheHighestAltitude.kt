package course.arraysandstrings.prefixsum

import kotlin.math.max

/**
 * https://leetcode.com/problems/find-the-highest-altitude/
 */

class FindTheHighestAltitude {
    class Solution {
        fun largestAltitude(gain: IntArray): Int {
            if (gain.size == 1) {
                return max(gain[0], 0)
            }

            var current = gain[0]
            var highest = max(current, 0)

            for (i in 1..gain.lastIndex) {
                current += gain[i]
                highest = max(current, highest)
            }
            return highest
        }
    }
}