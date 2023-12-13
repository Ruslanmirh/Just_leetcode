package daily

/** You are given an integer array pref of size n. Find and return the array arr of size n that satisfies:
 *
 * pref[i] = arr[0] ^ arr[1] ^ ... ^ arr[i].
 * Note that ^ denotes the bitwise-xor operation.
 *
 * It can be proven that the answer is unique.
 *
 * https://leetcode.com/problems/find-the-original-array-of-prefix-xor/
 */
class Solution {
    fun findArray(pref: IntArray): IntArray {
        if (pref.size > 1) {
            for (i in pref.lastIndex downTo 1) {
                pref[i] = pref[i - 1] xor pref[i]
            }
        }
        return pref
    }
}

// 5 - 1 0 1
// 7 - 1 1 1
// 2 - 0 1 0
// 0 - 0 0 0
//
fun main(args: Array<String>) {
    Solution().findArray(intArrayOf(5, 2, 0, 3, 1)).forEach {
        print("$it ")
    }
//    print(1 xor 3)
}