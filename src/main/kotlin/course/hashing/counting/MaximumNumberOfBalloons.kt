package course.hashing.counting

import kotlin.math.min

/**
 * https://leetcode.com/problems/maximum-number-of-balloons/description/
 */

class MaximumNumberOfBalloons {
    class Solution {

        private val balloon = hashMapOf(
            'b' to 1,
            'a' to 1,
            'l' to 2,
            'o' to 2,
            'n' to 1
        )

        fun maxNumberOfBalloons(text: String): Int {
            val map = HashMap<Char, Int>()

            text.forEach { char ->
                if (balloon.contains(char)) {
                    map[char] = map.getOrDefault(char, 0) + 1
                }
            }

            if (map.keys.size != balloon.keys.size) {
                return 0
            }

            var count = Int.MAX_VALUE

            map.entries.forEach {
                count = min(it.value / balloon[it.key]!!, count)
            }
            return count
        }
    }
}

fun main() {
    val res = MaximumNumberOfBalloons.Solution().maxNumberOfBalloons("nlaebolko")
    println(res)
}