package course.linkedlists.general

import course.linkedlists.ListNode
import course.linkedlists.asString
import course.linkedlists.create

/**
 * https://leetcode.com/problems/odd-even-linked-list/
 */
class OddEvenLinkedList {
    class Solution {
        fun oddEvenList(head: ListNode?): ListNode? {

            if (head == null) {
                return head
            }

            var oddHead: ListNode? = null
            var evenHead: ListNode? = null
            var odd: ListNode? = oddHead
            var even: ListNode? = evenHead


            // 2, 4, 5, 7, 2
            var dummy = head
            var count = 1
            while (dummy != null) {
                if (count.isEven()) {
                    if (evenHead == null) {
                        evenHead = dummy
                        even = evenHead
                    } else {
                        even?.next = dummy
                        even = even?.next
                    }
                } else {
                    if (oddHead == null) {
                        oddHead = dummy
                        odd = oddHead
                    } else {
                        odd?.next = dummy
                        odd = odd?.next
                    }
                }
                dummy = dummy.next
                count++
            }
            odd?.next = evenHead
            even?.next = null
            return oddHead
        }

        private fun Int.isEven(): Boolean {
            return this.rem(2) == 0
        }
    }
}

fun main() {
    val res = OddEvenLinkedList.Solution().oddEvenList(create(intArrayOf(1, 2, 3, 4, 5)))
    println(res.asString())
}