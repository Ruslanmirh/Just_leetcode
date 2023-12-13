package course.arraysandstrings.slidingwindow

/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 */
class MinimumSizeSubarraySum {

    class Solution {
        fun minSubArrayLen(target: Int, nums: IntArray): Int {
            var left = 0
            var right = 0

            var currSum = 0
            var min = 0
            while (right <= nums.lastIndex) {
                currSum += nums[right]

                if (currSum >= target && (right - left + 1 < min || min == 0)) {
                    min = right - left + 1
                }

                while (currSum >= target && left <= right) {
                    currSum -= nums[left]
                    left++
                    if (currSum >= target && (right - left + 1 < min || min == 0)) {
                        min = right - left + 1
                    }
                }
                right++
            }

            return min
        }
    }
}

fun main() {
    val res = MinimumSizeSubarraySum.Solution().minSubArrayLen(11, intArrayOf(1,1,1,1,1,1,1,1))
    println(res)
}