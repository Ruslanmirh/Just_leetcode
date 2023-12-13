package course.hashing.counting

import kotlin.math.max

/**
 * https://leetcode.com/problems/largest-unique-number/description/
 */

class LargestUniqueNumber {
    class Solution {
        fun largestUniqueNumber(nums: IntArray): Int {
            var maxNumber = -1

            val map = HashMap<Int, Int>()

            nums.forEach { map[it] = map.getOrDefault(it, 0) + 1 }

            map.keys.forEach { key ->
                if (map[key] == 1) {
                    maxNumber = max(maxNumber, key)
                }
            }
            return maxNumber
        }
    }

}