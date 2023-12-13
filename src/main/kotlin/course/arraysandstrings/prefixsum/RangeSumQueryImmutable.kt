package course.arraysandstrings.prefixsum

/**
 * https://leetcode.com/problems/range-sum-query-immutable/
 */

class RangeSumQueryImmutable {
    class NumArray(nums: IntArray) {

        private val prefix: IntArray = IntArray(nums.size)

        init {
            prefix[0] = nums[0]
            if (nums.size > 1) {
                for (i in 1..nums.lastIndex) {
                    prefix[i] = prefix[i - 1] + nums[i]
                }
            }
        }

        fun sumRange(left: Int, right: Int): Int {
            return prefix[right] - if (left > 0) prefix[left - 1] else 0
        }

    }

    /**
     * Your NumArray object will be instantiated and called as such:
     * var obj = NumArray(nums)
     * var param_1 = obj.sumRange(left,right)
     */
}