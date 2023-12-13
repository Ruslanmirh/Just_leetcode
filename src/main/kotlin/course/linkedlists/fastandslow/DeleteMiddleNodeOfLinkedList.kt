package course.linkedlists.fastandslow

import course.linkedlists.ListNode

/**
 * https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
 */

class DeleteMiddleNodeOfLinkedList {
    class Solution {
        fun deleteMiddle(head: ListNode?): ListNode? {
            if (head == null) {
                return head
            }
            if (head.next == null) {
                return null
            }

            var slow = head
            var fast = head
            var prev: ListNode? = null

            while (fast?.next != null) {
                if (fast.next?.next != null) {
                    fast = fast.next?.next
                } else {
                    fast = fast.next
                }
                prev = slow
                slow = slow?.next
            }
            prev?.next = slow?.next
            return head
        }
    }
}