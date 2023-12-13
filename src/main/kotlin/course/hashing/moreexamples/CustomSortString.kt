package course.hashing.moreexamples

/**
 * https://leetcode.com/problems/custom-sort-string/
 */

class CustomSortString {
    class Solution {
        fun customSortString(order: String, s: String): String {
            val map = hashMapOf<Char, Int>()
            order.forEachIndexed { index, char -> map[char] = index }

            return s.toCharArray().sortedBy {
                if (map.keys.contains(it)) {
                    map[it]
                } else {
                    null
                }
            }.asString()
        }

        private fun List<Char>.asString(): String {
            val builder = StringBuilder()
            forEach {
                builder.append(it)
            }
            return builder.toString()
        }
    }
}