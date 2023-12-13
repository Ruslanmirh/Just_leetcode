package course.hashing.counting

/**
 * https://leetcode.com/problems/sum-of-unique-elements/
 */

class SumOfUniqueElements {
    class Solution {
        fun sumOfUnique(nums: IntArray): Int {
            val isUniqueMap = hashMapOf<Int, Boolean>()
            nums.forEach {
                if (isUniqueMap.containsKey(it)) {
                    isUniqueMap[it] = false
                }
                isUniqueMap.putIfAbsent(it, true)
            }

            var sum = 0
            isUniqueMap.entries.forEach {
                if (it.value) {
                    sum += it.key
                }
            }
            return sum
        }
    }
}

fun main() {
    val res = SumOfUniqueElements.Solution().sumOfUnique(intArrayOf(1, 2, 3, 2))
    println(res)
}