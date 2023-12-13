package course.hashing.moreexamples

/**
 * https://leetcode.com/problems/jewels-and-stones/description/
 */

class JewelsAndStones {

    class Solution {
        fun numJewelsInStones(jewels: String, stones: String): Int {
            val set = HashSet<Char>()
            jewels.forEach {
                set.add(it)
            }

            var count = 0
            stones.forEach { char ->
                if (set.contains(char)) {
                    count++
                }
            }
            return count
        }
    }
}