package course.hashing.chekingexistance

/**
 * https://leetcode.com/problems/check-if-the-sentence-is-pangram/description/
 */

class CheckIfSentenceIsPangram {
    class Solution {
        fun checkIfPangram(sentence: String): Boolean {
            val set = HashSet<Char>()
            sentence.forEach { char ->
                set.add(char)
            }
            return set.size == 26
        }
    }
}