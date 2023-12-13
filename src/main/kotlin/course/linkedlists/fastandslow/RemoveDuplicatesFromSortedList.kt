package course.linkedlists.fastandslow

import course.linkedlists.ListNode
import course.linkedlists.asString
import course.linkedlists.create

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
 */

class RemoveDuplicatesFromSortedList {
    class Solution {
        fun deleteDuplicates(head: ListNode?): ListNode? {
            var slow = head
            var fast = head

            while (slow != null) {
                while (slow.`val` == fast?.`val`) {
                    fast = fast.next
                }
                slow.next = fast

                slow = slow.next
                fast = fast?.next
            }
            return head
        }
    }

    class Solution2 {
        fun deleteDuplicates(head: ListNode?): ListNode? {
            var dummy = head

            while (dummy?.next != null) {
                if (dummy.`val` == dummy.next!!.`val`) {
                    dummy.next = dummy.next!!.next
                } else {
                    dummy = dummy.next
                }
            }
            return head
        }
    }

}

fun main() {
    val res = RemoveDuplicatesFromSortedList.Solution().deleteDuplicates(create(intArrayOf(1, 1, 2, 3, 3)))
    println(res.asString())
}