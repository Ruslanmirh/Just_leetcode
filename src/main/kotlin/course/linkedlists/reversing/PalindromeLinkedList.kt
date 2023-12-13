package course.linkedlists.reversing

import course.linkedlists.ListNode
import course.linkedlists.asString
import course.linkedlists.create

/**
 * https://leetcode.com/problems/palindrome-linked-list/
 */
class PalindromeLinkedList {
    class Solution {
        fun isPalindrome(head: ListNode?): Boolean {
            var slow = head
            var fast = head

            while (fast?.next != null) {
                slow = slow?.next
                fast = fast.next?.next
            }
            var dummy = slow
//            println("slow = ${slow?.`val`}")

            var prev: ListNode? = null
            while (dummy != null) {
                val nextNode = dummy.next
                dummy.next = prev
                prev = dummy
                dummy = nextNode
            }
//            println(head.asString())
//            println(prev.asString())

            dummy = head
            while (prev != null) {
                if (prev.`val` != dummy?.`val`) {
                    return false
                }
                prev = prev.next
                dummy = dummy.next
            }

            return true
        }
    }
}

fun main() {
    val res = PalindromeLinkedList.Solution().isPalindrome(create(intArrayOf(1, 2, 3, 2, 1)))
    println(res)
}