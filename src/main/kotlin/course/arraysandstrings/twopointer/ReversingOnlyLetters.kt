package course.arraysandstrings.twopointer

class ReversingOnlyLetters {
    class Solution {
        fun reverseOnlyLetters(s: String): String {
            var left = 0
            var right = s.lastIndex

            val res = s.toCharArray()

            var temp: Char
            while (left < right) {
                if (res[left].isLetter() && res[right].isLetter()) {
                    temp = res[left]
                    res[left] = res[right]
                    res[right] = temp
                    left++
                    right--
                }

                if (res[left].isLetter().not()) {
                    left++
                }

                if (res[right].isLetter().not()) {
                    right--
                }

            }

            return res.concatToString()
        }
    }
}

fun main() {
    val res = ReversingOnlyLetters.Solution().reverseOnlyLetters("Test1ng-Leet=code-Q!")
    println(res)
}