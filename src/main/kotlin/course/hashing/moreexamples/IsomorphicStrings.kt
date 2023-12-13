package course.hashing.moreexamples

/**
 * https://leetcode.com/problems/isomorphic-strings/
 */

class IsomorphicStrings {
    class Solution {
        fun isIsomorphic(s: String, t: String): Boolean {
            val mapS = hashMapOf<Char, Char>()
            val mapT = hashMapOf<Char, Char>()

            for (i in 0..s.lastIndex) {
                if (mapS.containsKey(s[i]) && mapS[s[i]] != t[i]
                    || mapT.containsKey(t[i]) && mapT[t[i]] != s[i]
                ) {
                    return false
                }
                mapS[s[i]] = t[i]
                mapT[t[i]] = s[i]
            }
            return true
        }
    }
}
