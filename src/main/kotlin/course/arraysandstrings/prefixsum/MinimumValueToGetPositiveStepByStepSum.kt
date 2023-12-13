package course.arraysandstrings.prefixsum

class MinimumValueToGetPositiveStepByStepSum {
    class Solution {
        fun minStartValue(nums: IntArray): Int {
            var currentSum = 0
            var min = 0

            for (i in 0..nums.lastIndex) {
                currentSum += nums[i]
                if (currentSum < min) {
                    min = currentSum
                }
            }

            return -min + 1
        }
    }
}

fun main() {
    val res = MinimumValueToGetPositiveStepByStepSum.Solution().minStartValue(intArrayOf(3, 3, 3))
    print(res)
}