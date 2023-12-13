package course.hashing.chekingexistance

/**
 * https://leetcode.com/problems/counting-elements/description/
 */

class CountingElements {

    class Solution {
        fun countElements(arr: IntArray): Int {
            val set = HashSet<Int>()

            arr.forEach { set.add(it) }

            var count = 0
            arr.forEach {
                if (set.contains(it + 1)) {
                    count++
                }
            }

            return count
        }
    }

    // if sorted
    class Solution2 {
        fun countElements(arr: IntArray): Int {

            if (arr.size <= 1) {
                return 0
            }

            var count = 0
            for (i in 1..arr.lastIndex) {
                if (arr[i] == arr[i - 1] + 1) {
                    count++
                }
            }

            return count
        }
    }
}