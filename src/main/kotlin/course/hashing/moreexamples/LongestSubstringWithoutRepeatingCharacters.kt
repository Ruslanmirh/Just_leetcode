package course.hashing.moreexamples

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */

class LongestSubstringWithoutRepeatingCharacters {

    class Solution {
        fun lengthOfLongestSubstring(s: String): Int {

            val map = hashMapOf<Char, Int>()

            var left = 0
            var maxLength = 0
            for (right in 0..s.lastIndex) {
                if (map.containsKey(s[right])) {
                    while (left <= map[s[right]]!!) {
                        left++
                    }
                }
                map[s[right]] = right
                maxLength = maxOf(maxLength, right - left + 1)
            }
            return maxLength
        }
    }
}
