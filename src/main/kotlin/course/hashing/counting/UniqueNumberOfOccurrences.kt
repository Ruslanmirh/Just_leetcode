package course.hashing.counting

/**
 * https://leetcode.com/problems/unique-number-of-occurrences/
 */

class UniqueNumberOfOccurrences {

    class Solution {
        fun uniqueOccurrences(arr: IntArray): Boolean {
            val map = hashMapOf<Int, Int>()
            arr.forEach {
                map[it] = map.getOrDefault(it, 0) + 1
            }
            return map.values.toSet().size == map.keys.size
        }
    }
}