package course.hashing.chekingexistance

/**
 * https://leetcode.com/problems/missing-number/description/
 */
class MissingNumber {
    class Solution {
        fun missingNumber(nums: IntArray): Int {
            val set = HashSet<Int>()
            nums.forEach { number ->
                set.add(number)
            }

            for (i in 0..nums.size) {
                if (set.contains(i).not()) {
                    return i
                }
            }
            return -1
        }
    }

}