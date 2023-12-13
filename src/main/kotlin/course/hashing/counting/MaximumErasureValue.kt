package course.hashing.counting

import kotlin.math.max

/**
 * https://leetcode.com/problems/maximum-erasure-value/
 */

class MaximumErasureValue {
    class Solution {
        fun maximumUniqueSubarray(nums: IntArray): Int {
            val set = hashSetOf<Int>()
            var left = 0
            var right = 0

            var sum = 0
            var res = 0

            while (right <= nums.lastIndex) {
                if (set.contains(nums[right])) {
                    sum -= nums[left]
                    set.remove(nums[left])
                    left++
                } else {
                    sum += nums[right]
                    res = max(res, sum)
                    set.add(nums[right])
                    right++
                }
            }

            return res
        }
    }
}

fun main() {
    val res = MaximumErasureValue.Solution().maximumUniqueSubarray(intArrayOf(4, 2, 4, 5, 6))
    println(res)
}