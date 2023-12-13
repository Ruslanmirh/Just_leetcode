package course.arraysandstrings.prefixsum

/**
 * https://leetcode.com/explore/interview/card/leetcodes-interview-crash-course-data-structures-and-algorithms/703/arraystrings/4658/
 */

class RunningSumOfOneDimArray {

    class Solution {
        fun runningSum(nums: IntArray): IntArray {
            val prefix = IntArray(nums.size)
            prefix[0] = nums[0]

            for (i in 1..nums.lastIndex) {
                prefix[i] = nums[i] + prefix[i - 1]
            }
            return prefix
        }
    }
}