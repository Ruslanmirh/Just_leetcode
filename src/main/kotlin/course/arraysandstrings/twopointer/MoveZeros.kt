package course.arraysandstrings.twopointer

class MoveZeros {
    class Solution {
        fun moveZeroes(nums: IntArray): Unit {
            var left = 0

            for (right in 1..nums.lastIndex) {
                if (nums[right] != 0 && nums[left] == 0) {
                    nums[left] = nums[right]
                    nums[right] = 0
                    left++
                    println("swap")
                } else {
                    if (nums[left] != 0) {
                        left++
                    }
                }

            }
        }
    }
}

fun main() {
    MoveZeros.Solution().moveZeroes(intArrayOf(0,1,1,1,1,1))
}