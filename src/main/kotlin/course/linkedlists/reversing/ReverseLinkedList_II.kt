package course.linkedlists.reversing

import course.linkedlists.ListNode
import course.linkedlists.asString
import course.linkedlists.create

/**
 * https://leetcode.com/problems/reverse-linked-list-ii/description/
 */

class ReverseLinkedList_II {
    class Solution {
        fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
            if (left == right) {
                return head
            }

            var i = 1

            var dummy = head

            var revHead: ListNode? = null
            var startNode: ListNode? = null
            var endNode: ListNode? = null
            var tail: ListNode? = null

            while (dummy != null) {
                when (i) {
                    left -> startNode = dummy
                    right -> endNode = dummy
                    right + 1 -> tail = dummy
                    left - 1 -> revHead = dummy
                }
                i++
                dummy = dummy.next
            }

            dummy = startNode
            var prev: ListNode? = null
            while (dummy != null && dummy != tail) {
                val nextNode = dummy.next
                dummy.next = prev
                prev = dummy
                dummy = nextNode
            }

            revHead?.next = endNode

            if (tail != null) {
                startNode?.next = tail
            }
            if (revHead == null) {
                return endNode
            } else {
                return head
            }

        }
    }
}

fun main() {
    val res = ReverseLinkedList_II.Solution().reverseBetween(create(intArrayOf(3, 5)), 1, 2)
    println(res.asString())
}