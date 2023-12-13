package course.hashing.counting

/**
 * https://leetcode.com/problems/number-of-good-pairs/
 */

class NumberOfGoodPairs {
    class Solution {
        fun numIdenticalPairs(nums: IntArray): Int {
            val map = hashMapOf<Int, Int>()
            nums.forEach { value ->
                map[value] = map.getOrDefault(value, 0) + 1
            }

            var count = 0
            map.entries.forEach {
                if (it.value > 1) {
                    count += countPairs(it.value)
                }
            }
            return count
        }

        private fun countPairs(n: Int) = n * (n - 1) / 2

    }

    class Solution2 {
        fun numIdenticalPairs(nums: IntArray): Int {
            val map = hashMapOf<Int, Int>()

            var count = 0
            nums.forEach { value ->
                val curr = map.getOrDefault(value, 0)
                count += curr
                map[value] = curr + 1

            }
            return count
        }
    }

}