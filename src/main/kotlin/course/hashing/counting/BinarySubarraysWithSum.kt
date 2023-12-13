package course.hashing.counting

/**
 * https://leetcode.com/problems/binary-subarrays-with-sum/
 */

class BinarySubarraysWithSum {

    class Solution {
        fun numSubarraysWithSum(nums: IntArray, goal: Int): Int {
            val prefix = IntArray(nums.size + 1)
            for (i in 0..nums.lastIndex) {
                prefix[i + 1] = prefix[i] + nums[i]
            }
            val map = hashMapOf<Int, Int>()
            var count = 0

            prefix.forEach {
                count += map.getOrDefault(it, 0)
                map[it + goal] = map.getOrDefault(it + goal, 0) + 1
            }
            return count
        }
    }
}