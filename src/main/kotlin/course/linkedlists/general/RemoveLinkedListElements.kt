package course.linkedlists.general

import course.linkedlists.ListNode

/**
 * https://leetcode.com/problems/remove-linked-list-elements/
 */

class RemoveLinkedListElements {

    class Solution {
        fun removeElements(head: ListNode?, value: Int): ListNode? {
            var dummy = head
            var prev: ListNode? = null

            var newHead: ListNode? = null
            while (dummy != null) {
                if (dummy.`val` == value) {
                    prev?.next = dummy.next
                } else {
                    prev = dummy
                    if (newHead == null) {
                        newHead = dummy
                    }
                }
                dummy = dummy.next
            }

            return newHead
        }
    }
}