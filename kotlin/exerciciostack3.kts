import java.util.Stack

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.
*/

class Solution {
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()

        for (char in s) {
            when(char) {
                ')' -> {
                    if (isNotOpeningCharacterIn(stack, '(')) return false
                }
                '}' -> {
                    if (isNotOpeningCharacterIn(stack, '{')) return false
                }
                ']' -> {
                    if (isNotOpeningCharacterIn(stack, '[')) return false
                }
                else -> stack.push(char)
            }
        }

        return stack.isEmpty()
    }

    private fun isNotOpeningCharacterIn(stack: Stack<Char>, char: Char): Boolean {
        if(stack.isEmpty()) return true
        val element = stack.pop()
        return element != char
    }
}

assert(Solution().isValid("()"))
assert(Solution().isValid("()[]{}"))
assert(Solution().isValid("([])"))
assert(!Solution().isValid("(]"))
assert(!Solution().isValid("([)]"))
