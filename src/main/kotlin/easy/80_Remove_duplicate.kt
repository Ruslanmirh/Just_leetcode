package easy

import utils.asString

/**
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
 *
 * Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
 *
 * Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
 * Return k.
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/?envType=study-plan-v2&envId=top-interview-150
 */
class ReomveElement {
    fun removeDuplicates(nums: IntArray): Int {

        var current = 0
        var actual = 0

        var num = nums[0]
        var repeat = 0

        while (actual <= nums.lastIndex) {
            if (num == nums[current]) {
                repeat++
                if (repeat > 2) {
                    while (actual < nums.lastIndex && nums[actual] == num) {
                        actual++
                    }
                }
            } else {
                num = nums[current]
                repeat = 1
            }
            nums[current] = nums[actual]
            actual++
            current++
        }

        return current
    }
}

fun main() {
//    val array = intArrayOf(0, 0, 1, 1, 1, 1, 2, 3, 3)
    val array = intArrayOf(1, 1, 0, 0, 0, 2, 2, 2, 1)
    val count = ReomveElement().removeDuplicates(array)
    println("count = $count")
    println("new array = ${array.asString()}")
}
