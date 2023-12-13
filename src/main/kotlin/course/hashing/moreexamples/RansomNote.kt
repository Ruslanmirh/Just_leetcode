package course.hashing.moreexamples

/**
 * https://leetcode.com/problems/ransom-note/description/
 */

class RansomNote {

    class Solution {
        fun canConstruct(ransomNote: String, magazine: String): Boolean {
            if (magazine.length < ransomNote.length) {
                return false
            }
            val map = hashMapOf<Char, Int>()
            ransomNote.forEach {
                map[it] = map.getOrDefault(it, 0) + 1
            }

            magazine.forEach {
                if (map.containsKey(it)) {
                    map[it] = map[it]!! - 1
                }
            }

            map.values.forEach {
                if (it > 0) {
                    return false
                }
            }

            return true
        }
    }
}