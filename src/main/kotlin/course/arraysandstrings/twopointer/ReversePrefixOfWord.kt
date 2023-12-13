package course.arraysandstrings.twopointer

/**
 * https://leetcode.com/problems/reverse-prefix-of-word/
 */
class ReversePrefixOfWord {

    class Solution {
        fun reversePrefix(word: String, ch: Char): String {

            var right = word.indexOf(ch)

            if (right == -1) {
                return word
            }

            val res = word.toCharArray()
            var left = 0

            var temp: Char
            while (left < right) {
                temp = res[left]
                res[left] = res[right]
                res[right] = temp

                left++
                right--
            }
            return res.concatToString()
        }
    }
}