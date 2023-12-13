package course.linkedlists.fastandslow

import course.linkedlists.ListNode
import course.linkedlists.asString
import course.linkedlists.create

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */

class RemoveNthNodeFromEndOfList {
    class Solution {
        fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
            var slow = head
            var fast = head
            for (i in 1..n) {
                fast = fast?.next
            }

//            println("slow = ${slow?.`val`}")
//            println("fast = ${fast?.`val`}")
            if (fast == null) {
                return slow?.next
            }

            while (fast?.next != null) {
                slow = slow?.next
                fast = fast.next
            }

//            println("After")
//            println("slow = ${slow?.`val`}")
//            println("fast = ${fast?.`val`}")

            slow?.next = slow?.next?.next
            return head
        }
    }
}

fun main() {
    val res = RemoveNthNodeFromEndOfList.Solution().removeNthFromEnd(create(intArrayOf(1, 2)), 2)
    println(res.asString())
}