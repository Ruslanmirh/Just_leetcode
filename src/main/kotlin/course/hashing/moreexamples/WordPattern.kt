package course.hashing.moreexamples

/**
 * https://leetcode.com/problems/word-pattern/
 */
class WordPattern {
    class Solution {
        fun wordPattern(pattern: String, s: String): Boolean {
            val mapPattern = hashMapOf<Char, String>()
            val mapWords = hashMapOf<String, Char>()

            val words = s.split(' ')
            if (words.size != pattern.length) {
                return false
            }
            words.forEachIndexed { index, word ->
                val char = pattern[index]
                if (
                    mapPattern.containsKey(char) && mapPattern[char] != word ||
                    mapWords.containsKey(word) && char != mapWords[word]
                ) {
                    return false
                }

                mapPattern[pattern[index]] = word
                mapWords[word] = pattern[index]
            }
            return true
        }
    }
}