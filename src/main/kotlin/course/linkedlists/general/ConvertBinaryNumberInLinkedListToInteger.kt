package course.linkedlists.general

import course.linkedlists.ListNode
import kotlin.math.pow

/**
 * https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 */

class ConvertBinaryNumberInLinkedListToInteger {
    class Solution {
        fun getDecimalValue(head: ListNode?): Int {
            var prev: ListNode? = null

            var dummy = head
            while (dummy != null) {
                val nextNode = dummy.next
                dummy.next = prev
                prev = dummy
                dummy = nextNode
            }

            var sum = 0.0
            var pos = 0
            while (prev != null) {
                sum += 2.0.pow(pos) * prev.`val`
                pos++
                prev = prev.next
            }
            return sum.toInt()
        }
    }
}