package course.stacks.stringproblems

import java.lang.StringBuilder
import java.util.Stack

/**
 * https://leetcode.com/problems/make-the-string-great/description/
 */

class MakeStringGreat {
    class Solution {
        fun makeGood(s: String): String {
            val stack = Stack<Char>()
            s.forEach { char ->
                if (stack.isNotEmpty()) {
                    val prev = stack.last()
                    if (isBad(char, prev)) {
                        stack.pop()
                    } else {
                        stack.push(char)
                    }
                } else {
                    stack.push(char)
                }
            }
            return stack.asString()
        }

        private fun isBad(first: Char, second: Char): Boolean {
            return first.absoluteLetter() == second.absoluteLetter() && (
                    second.isLowerCase() && first.isUpperCase()
                            || second.isUpperCase() && first.isLowerCase())
        }

        private fun Char.absoluteLetter(): Int {
            return if (isLowerCase()) {
                this - 'a'
            } else {
                this - 'A'
            }
        }

        private fun Stack<Char>.asString(): String {
            val builder = StringBuilder()
            forEach {
                builder.append(it)
            }
            return builder.toString()
        }
    }
}

fun main() {
    val res = MakeStringGreat.Solution().makeGood("Pp")
    println(res)
}