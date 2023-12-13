package course.hashing.chekingexistance

/**
 * https://leetcode.com/problems/destination-city/
 */
class DestinationCity {
    class Solution {
        fun destCity(paths: List<List<String>>): String {
            val departuresAmount = hashMapOf<String, Int>()

            paths.forEach {
                departuresAmount[it.first()] = departuresAmount.getOrDefault(it.first(), 0) + 1
                departuresAmount.putIfAbsent(it.last(), 0)
            }

            departuresAmount.entries.forEach {
                if (it.value == 0) {
                    return it.key
                }
            }
            return "NOT FOUND"
        }
    }

}