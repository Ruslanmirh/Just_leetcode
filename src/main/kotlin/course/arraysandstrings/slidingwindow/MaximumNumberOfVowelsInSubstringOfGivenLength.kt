package course.arraysandstrings.slidingwindow

/**
 * https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
 */
class MaximumNumberOfVowelsInSubstringOfGivenLength {
    class Solution {
        fun maxVowels(s: String, k: Int): Int {

            var vowelNum = 0

            for (i in 0 until k) {
                if (s[i].isVowel()) {
                    vowelNum++
                }
            }
            var max = vowelNum

            for (i in k..s.lastIndex) {
                if (s[i].isVowel()) {
                    vowelNum++
                }
                if (s[i - k].isVowel()) {
                    vowelNum--
                }
                if (vowelNum > max) {
                    max = vowelNum
                }
            }

            return max
        }

        private fun Char.isVowel() =
            this == 'a' ||
                    this == 'e' ||
                    this == 'i' ||
                    this == 'o' ||
                    this == 'u'
    }
}