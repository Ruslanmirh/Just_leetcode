package course.linkedlists.fastandslow

import course.linkedlists.ListNode
import course.linkedlists.asString
import course.linkedlists.create

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */

class RemoveDuplicatesFromSortedList_II {
    class Solution {
        fun deleteDuplicates(head: ListNode?): ListNode? {
            var current = head
            var prev: ListNode? = null

            var newHead: ListNode? = null

            while (current != null) {

                //1, 2, 3, 3, 4, 4, 5
                if (current?.`val` == current?.next?.`val`) {
                    current = current?.next
                } else {
                    if (prev == null && current != head && current.next != null) {
                        newHead = current?.next
                        prev = current
                    }
                    if (prev?.next != current && current != head) {
                        prev?.next = current?.next
                    } else {
                        prev = current
                    }

                    current = current?.next
                }
            }

            return if (prev == null) {
                null
            } else {
                newHead ?: head

            }
        }
    }
}

fun main() {
    val res =
        RemoveDuplicatesFromSortedList_II.Solution().deleteDuplicates(create(intArrayOf(1, 1, 2, 2)))
    println(res.asString())
}