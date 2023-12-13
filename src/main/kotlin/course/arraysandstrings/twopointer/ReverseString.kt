package course.arraysandstrings.twopointer

//https://leetcode.com/explore/featured/card/leetcodes-interview-crash-course-data-structures-and-algorithms/703/arraystrings/4592/

class ReverseString {
    fun reverseString(s: CharArray): Unit {
        var i = 0
        var j = s.lastIndex

        var temp: Char

        while (i < j) {
            temp = s[i]
            s[i] = s[j]
            s[j] = temp

            i++
            j--
        }
    }
}