package course.stacks.monotonic

import utils.asString
import java.util.Stack

/**
 * https://leetcode.com/problems/next-greater-element-i/description/
 */

class NextGreaterElement_I {
    class Solution {
        fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
            val deque = Stack<Int>()
            val map = HashMap<Int, Int>()

            for (i in 0..nums2.lastIndex) {

                // ind = 0, 1 ,2, 3
                // val = 1, 3, 4, 2
                // ans = 1, 2, H, H
                while (deque.isNotEmpty() && nums2[deque.last()] < nums2[i]) {
                    val j = deque.removeLast()
                    map[nums2[j]] = nums2[i]
                }

                deque.add(i)
            }

            val ans = IntArray(nums1.size)

            nums1.forEachIndexed { index, value ->
                ans[index] = map[value] ?: -1
            }

            return ans
        }
    }
}

fun main() {
    val res = NextGreaterElement_I.Solution().nextGreaterElement(intArrayOf(4, 1, 2), intArrayOf(1, 3, 4, 2))
    println(res.asString())
}