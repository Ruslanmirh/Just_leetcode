package course.linkedlists.reversing

import course.linkedlists.ListNode
import course.linkedlists.asString
import course.linkedlists.create

/**
 * https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
 */

class MaximumTwinSumOfLinkedList {

    class Solution {
        fun pairSum(head: ListNode?): Int {
            var slow = head
            var fast = head

            var preMiddle: ListNode? = null
            while (fast?.next != null) {
                fast = fast.next!!.next
                preMiddle = slow
                slow = slow?.next
            }
            val middle = slow

            var prev: ListNode? = null
            var current = middle

            println("preMiddle = ${preMiddle?.`val`}")
            println("middle = ${middle?.`val`}")
            // 5, 4, 2, 1
            while (current != null) {
                val nextNode = current.next
                current.next = prev
                prev = current
                current = nextNode
            }

            preMiddle?.next = prev
            println(head.asString())

            fast = prev
            slow = head

            println("fast = ${fast?.`val`}")
            println("slow = ${slow?.`val`}")
            var maxSum = 0
            var currSum = 0
            while (fast != null && slow != null) {
                currSum = slow.`val` + fast.`val`
                maxSum = maxOf(maxSum, currSum)
                slow = slow.next
                fast = fast.next
            }
            return maxSum
        }
    }
}

fun main() {
    val res = MaximumTwinSumOfLinkedList.Solution().pairSum(create(intArrayOf(5, 4, 2, 1)))
    println(res)
}