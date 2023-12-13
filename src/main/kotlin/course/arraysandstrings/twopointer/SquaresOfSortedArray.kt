package course.arraysandstrings.twopointer

import utils.asString
import kotlin.math.absoluteValue

class SquaresOfSortedArray {
    class Solution {
        fun sortedSquares(nums: IntArray): IntArray {
            val res = IntArray(nums.size)


            var left = 0
            var right = nums.lastIndex
            var i = nums.lastIndex


            while (left <= right) {
                if (nums[left].absoluteValue > nums[right].absoluteValue) {
                    res[i] = nums[left].sqr()
                    left++
                } else {
                    res[i] = nums[right].sqr()
                    right--
                }
                i--
            }
            return res
        }

        private fun Int.sqr() = this * this
    }
}

fun main() {
    val res = SquaresOfSortedArray.Solution().sortedSquares(intArrayOf(-5,-3,-2,-1))
    print(res.asString())
}