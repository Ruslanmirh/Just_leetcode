package course.hashing.counting

import java.lang.StringBuilder

/**
 * https://leetcode.com/problems/sort-characters-by-frequency/
 */

class SortCharactersByFrequency {
    class Solution {
        fun frequencySort(s: String): String {
            val map = hashMapOf<Char, Int>()
            s.forEach { char ->
                map[char] = map.getOrDefault(char, 0) + 1
            }

            val builder = StringBuilder()
            map.keys.sortedByDescending { map[it] }.forEach { char ->
                for (i in 0 until map[char]!!) {
                    builder.append(char)
                }
            }
            return builder.toString()
        }
    }
}