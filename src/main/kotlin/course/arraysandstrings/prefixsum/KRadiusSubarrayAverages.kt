package course.arraysandstrings.prefixsum

import utils.asString

class KRadiusSubarrayAverages {
    class Solution {
        fun getAverages(nums: IntArray, k: Int): IntArray {
            if (k == 0) {
                return nums
            }

            val avg = IntArray(nums.size) { -1 }

            if (k >= nums.size.toDouble() / 2) {
                return avg
            }

            val prefix = LongArray(nums.size)
            prefix[0] = nums[0].toLong()

            for (i in 1..nums.lastIndex) {
                prefix[i] = nums[i] + prefix[i - 1]
            }

            avg[k] = (prefix[k + k] / (k * 2 + 1)).toInt()
            for (i in k + 1..nums.lastIndex - k) {
                avg[i] = ((prefix[i + k] - prefix[i - k - 1]) / (k * 2 + 1)).toInt()
            }

            return avg
        }
    }

    class SolutionWindow {
        fun getAverages(nums: IntArray, k: Int): IntArray {
            if (k == 0) {
                return nums
            }
            val avg = IntArray(nums.size) { -1 }

            if (k >= nums.size.toDouble() / 2) {
                return avg
            }

            var currSum: Long = 0

            for (i in 0..2 * k) {
                currSum += nums[i].toLong()
            }
            avg[k] = (currSum / (2 * k + 1)).toInt()

            var left = 0
            for (i in 2 * k + 1..nums.lastIndex) {
                currSum = currSum - nums[left].toLong() + nums[i].toLong()
                left++
                avg[i - k] = (currSum / (2 * k + 1)).toInt()
            }
            return avg
        }
    }
}

fun main() {
    val res = KRadiusSubarrayAverages.SolutionWindow().getAverages(intArrayOf(7, 4, 3, 9, 1, 8, 5, 2, 6), 3)
    print(res.asString())
}