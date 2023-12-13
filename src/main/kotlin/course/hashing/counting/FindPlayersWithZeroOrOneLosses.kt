package course.hashing.counting

/**
 * https://leetcode.com/problems/find-players-with-zero-or-one-losses/description/
 */
class FindPlayersWithZeroOrOneLosses {

    class Solution {
        fun findWinners(matches: Array<IntArray>): List<List<Int>> {
            val map = HashMap<Int, Int>()

            for (i in 0..matches.lastIndex) {
                map.increment(matches[i][1])
                map.putIfAbsent(matches[i][0], 0)
            }

            val wonAll = mutableListOf<Int>()
            val lostOnlyOne = mutableListOf<Int>()

            map.keys.sorted().forEach { player ->
                if (map[player] == 0) {
                    wonAll.add(player)
                } else if (map[player] == 1) {
                    lostOnlyOne.add(player)
                }
            }

            return listOf(wonAll, lostOnlyOne)
        }

        private fun HashMap<Int, Int>.increment(key: Int) {
            if (get(key) != null) {
                put(key, get(key)!! + 1)
            } else {
                put(key, 1)
            }
        }
    }
}