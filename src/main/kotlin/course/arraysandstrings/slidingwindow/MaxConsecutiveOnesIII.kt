package course.arraysandstrings.slidingwindow

/**
 * https://leetcode.com/explore/interview/card/leetcodes-interview-crash-course-data-structures-and-algorithms/703/arraystrings/4595/
 */
class MaxConsecutiveOnesIII {
    class Solution {
        fun longestOnes(nums: IntArray, k: Int): Int {
            var left = 0

            var numOfZeros = 0
            var length = 0
            var max = 0

            for (right in 0..nums.lastIndex) {
                if (nums[right] == 0) {
                    numOfZeros++
                }

                while (numOfZeros > k) {
                    if (nums[left] == 0) {
                        numOfZeros--
                    }
                    left++
                }

                length = right - left + 1
                if (length > max){
                    max = length
                }
            }

            return max
        }
    }
}

fun main() {
    val res = MaxConsecutiveOnesIII.Solution().longestOnes(intArrayOf(0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1), 3)
    print(res)
}