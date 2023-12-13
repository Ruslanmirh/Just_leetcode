package course.linkedlists

import java.lang.StringBuilder

fun ListNode?.asString(): String {
    if (this == null) {
        return "[]"
    } else {
        val builder = StringBuilder()
        var dummy = this
        builder.append("[")
        while (dummy != null) {
            builder.append(dummy.`val`)
            if (dummy.next == null) {
                builder.append("]")
            } else {
                builder.append(", ")
            }
            dummy = dummy.next
        }
        return builder.toString()
    }
}

fun create(array: IntArray): ListNode? {
    if (array.isEmpty()) {
        return null
    }
    val head = ListNode(array[0])
    var dummy = head
    for (i in 1..array.lastIndex) {
        dummy.next = ListNode(array[i])
        dummy = dummy.next!!
    }
    return head
}