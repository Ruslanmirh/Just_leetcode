package course.hashing.moreexamples

/**
 * https://leetcode.com/problems/determine-if-two-strings-are-close/
 */

class DetermineIfTwoStringsAreClose {
    class Solution {
        fun closeStrings(word1: String, word2: String): Boolean {
            if (word1.length != word2.length) {
                return false
            }
            val mapFirst = hashMapOf<Char, Int>()
            val mapSecond = hashMapOf<Char, Int>()

            word1.forEach { mapFirst[it] = mapFirst.getOrDefault(it, 0) + 1 }
            word2.forEach { mapSecond[it] = mapSecond.getOrDefault(it, 0) + 1 }

            if (mapFirst.keys != mapSecond.keys) {
                return false
            }
            val valsSecond = mapSecond.values.sorted()
            mapFirst.values.sorted().forEachIndexed { index, value ->
                if (value != valsSecond.get(index)) {
                    return false
                }
            }
            return true
        }
    }
}

fun main() {

}