package course.arraysandstrings.twopointer

class ReverseWordInAString {
    class Solution {
        fun reverseWords(s: String): String {
            val res = StringBuilder()

            s.split(" ").forEach { word ->
                for (i in word.lastIndex downTo 0) {
                    res.append(word.get(i))
                }
                res.append(" ")
            }

            return res.toString().trim()
        }
    }
}

fun main() {
    val res = ReverseWordInAString.Solution().reverseWords("Let's take LeetCode contest")
    println(res)
}