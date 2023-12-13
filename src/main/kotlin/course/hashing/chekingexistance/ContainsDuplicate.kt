package course.hashing.chekingexistance

/**
 * https://leetcode.com/problems/contains-duplicate/
 */

class ContainsDuplicate {
    class Solution {
        fun containsDuplicate(nums: IntArray): Boolean {
            val map = hashMapOf<Int, Boolean>()

            nums.forEach {
                if (map[it] == true) {
                    return true
                }
                map[it] = true
            }
            return false
        }
    }
}