package course.hashing.counting

import kotlin.math.max

/**
 * https://leetcode.com/problems/find-lucky-integer-in-an-array/
 */

class FindLuckyIntegerInArray {
    class Solution {
        fun findLucky(arr: IntArray): Int {
            val map = hashMapOf<Int, Int>()
            arr.forEach {
                map[it] = map.getOrDefault(it, 0) + 1
            }

            var largest = -1
            map.entries.forEach {
                if (it.value == it.key) {
                    largest = max(it.key, largest)
                }
            }
            return largest
        }
    }
}