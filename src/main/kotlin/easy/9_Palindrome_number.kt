package easy

/**
 *  Given an integer x, return true if x is a
 * palindrome
 * , and false otherwise.
 *
 * https://leetcode.com/problems/palindrome-number/description/
 */
class `9_Palindrome_number` {
    class Solution {
        fun isPalindrome(x: Int): Boolean {
            if (x < 0 || x != 0 && x.rem(10) == 0) {
                return false
            }

            var half = 0
            var original = x
            while (original > half) {
                half = half.times(10) + original.rem(10)
                original = original.div(10)
            }

            return original == half || original == half / 10
        }
    }
}