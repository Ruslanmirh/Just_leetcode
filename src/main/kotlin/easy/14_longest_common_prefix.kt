package easy

import java.lang.StringBuilder
import java.util.*

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 *  If there is no common prefix, return an empty string "".
 *
 *  https://leetcode.com/problems/longest-common-prefix/
 */

class `14_longest_common_prefix` {
    class Solution {
        fun longestCommonPrefix(strs: Array<String>): String {
            Arrays.sort(strs)
            val first = strs.first()
            val last = strs.last()
            var index = 0
            var prefixLength = 0

            while (index <= first.lastIndex) {
                if (first.get(index) == last.get(index)) {
                    prefixLength++
                } else {
                    break
                }
                index++
            }

            return first.substring(0, prefixLength)
        }
    }

}


fun main() {
    val res = `14_longest_common_prefix`.Solution().longestCommonPrefix(arrayOf("aaa", "aa", "aaa"))
    print(res)
}