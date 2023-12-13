package course.hashing.counting

/**
 * https://leetcode.com/problems/permutation-in-string/
 */

class PermutationInString {
    class Solution {
        fun checkInclusion(mask: String, string: String): Boolean {
            if (mask.length > string.length) {
                return false
            }

            val etalon = HashMap<Char, Int>()
            val windowSize = mask.length
            mask.forEach {
                etalon[it] = etalon.getOrDefault(it, 0) + 1
            }


            val check = HashMap<Char, Int>()
            for (i in 0 until windowSize) {
                check[string[i]] = check.getOrDefault(string[i], 0) + 1
            }

            if (isSame(etalon, check)) {
                return true
            }

            for (right in windowSize..string.lastIndex) {
                val curr = string[right]
                val prev = string[right - windowSize]
                check[curr] = check.getOrDefault(curr, 0) + 1
                if (check[prev] == null || check[prev] == 1) {
                    check.remove(prev)
                } else {
                    check[prev] = check[prev]!! - 1
                }
                if (isSame(check, etalon)){
                    return true
                }
            }

            return false
        }

        private fun isSame(first: HashMap<Char, Int>, second: HashMap<Char, Int>): Boolean {
            first.keys.forEach {
                if (second[it] == null || second[it] != first[it]) {
                    return false
                }
            }
            return true
        }
    }
}

fun main() {
    val res = PermutationInString.Solution().checkInclusion("ab", "eidbaooo")
    println(res)
}