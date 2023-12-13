package course.arraysandstrings.prefixsum

/**
 * https://leetcode.com/problems/find-pivot-index/
 */

class FindPivotIndex {
    class Solution {
        fun pivotIndex(nums: IntArray): Int {
            val prefix = IntArray(nums.size + 1)

            prefix[0] = 0
            prefix[1] = nums[0]

            for (i in 1..nums.lastIndex) {
                prefix[i + 1] = prefix[i] + nums[i]
            }


            // n = 1 2 3 4
            // p = 0 1 3 6 10
            var index = -1
            for (i in nums.indices) {
                if (prefix[i] == prefix.last() - prefix[i + 1]) {
                    index = i
                    break
                }
            }

            return index
        }
    }
}

fun main() {
    val res = FindPivotIndex.Solution().pivotIndex(intArrayOf(1,7,3,6,5,6))
    println(res)
}