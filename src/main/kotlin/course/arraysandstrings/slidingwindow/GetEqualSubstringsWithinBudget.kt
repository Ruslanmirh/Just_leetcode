package course.arraysandstrings.slidingwindow

import kotlin.math.absoluteValue

class GetEqualSubstringsWithinBudget {

    class Solution {
        fun equalSubstring(s: String, t: String, maxCost: Int): Int {
            var left = 0
            var max = 0
            var currentCost = 0

            for (right in 0..s.lastIndex) {
                currentCost += cost(s[right], t[right])

                while (currentCost > maxCost) {
                    currentCost -= cost(s[left], t[left])
                    left++
                }

                if (right - left + 1 > max) {
                    max = right - left + 1
                }

            }

            return max
        }

        private fun cost(charA: Char, charB: Char): Int {
            return (charA - charB).absoluteValue
        }
    }
}

fun main() {
    val res = GetEqualSubstringsWithinBudget.Solution().equalSubstring("abcd", "acde", 0)
    println(res)
}