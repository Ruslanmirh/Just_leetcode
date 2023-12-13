package course.arraysandstrings.slidingwindow

/**
 *
 *  https://leetcode.com/explore/interview/card/leetcodes-interview-crash-course-data-structures-and-algorithms/703/arraystrings/4594/
 */
class MaximumAverageSubArray {
    // 0   1  2  3   4     k = 3
    // 0, 21, 3, 4, -4
    class Solution {
        fun findMaxAverage(nums: IntArray, k: Int): Double {
            var sum = 0
            var avg: Double
            for (i in 0 until k) {
                sum += nums[i]
            }

            avg = sum.toDouble() / k

            for (i in k..nums.lastIndex) {
                sum = sum - nums[i - k] + nums[i]
                if (sum.toDouble() / k > avg) {
                    avg = sum.toDouble() / k
                }
            }

            return avg
        }
    }

}

fun main() {
    val res = MaximumAverageSubArray.Solution().findMaxAverage(intArrayOf(0,4,0,3,2), 1)
    print(res)
}