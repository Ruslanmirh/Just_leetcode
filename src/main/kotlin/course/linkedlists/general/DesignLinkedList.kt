package course.linkedlists.general

import course.linkedlists.ListNode
import course.linkedlists.asString

/**
 * https://leetcode.com/problems/design-linked-list/
 */
class DesignLinkedList {

    class MyLinkedList() {

        private var head: ListNode? = null
        private var tail: ListNode? = null
        private var count = 0
        private var dummy: ListNode? = null
        private var prev: ListNode? = null

        fun get(index: Int): Int {
            clearTemps()

            while (dummy != null) {
                if (count == index) {
                    return dummy!!.`val`
                }
                dummy = dummy!!.next
                count++
            }
            return -1
        }

        fun addAtHead(`val`: Int) {
            val new = ListNode(`val`)
            if (isEmpty()) {
                tail = new
                head = new
            } else {
                new.next = head
                head = new
            }
        }

        fun addAtTail(`val`: Int) {
            val new = ListNode(`val`)
            if (isEmpty()) {
                tail = new
                head = new
            } else {
                tail?.next = new
                tail = new
            }
        }

        fun addAtIndex(index: Int, `val`: Int) {
            clearTemps()

            if (index == 0) {
                addAtHead(`val`)
            }

            while (dummy != null) {
                if (count == index) {
                    val new = ListNode(`val`)
                    prev?.next = new
                    new.next = dummy
                    return
                }
                prev = dummy
                dummy = dummy?.next
                count++
            }
            if (count == index) {
                addAtTail(`val`)
            }
        }

        fun deleteAtIndex(index: Int) {
            clearTemps()

            if (index == 0) {
                head = head?.next
                if (isEmpty()) {
                    tail = null
                }
            }

            while (dummy != null) {
                if (count == index) {
                    prev?.next = dummy?.next
                    return
                }
                prev = dummy
                dummy = dummy?.next
                count++
            }
        }

        private fun clearTemps() {
            dummy = head
            count = 0
            prev = null
        }

        private fun isEmpty(): Boolean {
            return head == null
        }

        fun getHead() = head
    }
}

fun main() {
    val list = DesignLinkedList.MyLinkedList()
    list.addAtHead(7)
    list.addAtHead(2)
    list.addAtHead(1)
    println(list.getHead().asString())

    list.addAtIndex(3, 0)
    println(list.getHead().asString())

    list.deleteAtIndex(2)
    println(list.getHead().asString())

    list.addAtHead(6)
    list.addAtTail(4)
    println(list.getHead().asString())

    println(list.get(4))
    println(list.getHead().asString())

    list.addAtIndex(5, 0)
    println(list.getHead().asString())

    list.addAtHead(6)
    println(list.getHead().asString())

}