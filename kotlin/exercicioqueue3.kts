import java.util.*

class Solution {
    fun countStudents(students: IntArray, sandwiches: IntArray): Int {
        val studentsQueue: Queue<Int> = LinkedList()
        val sandwichesStack = Stack<Int>()
        var cycleCounter = 0

        for (i in students.indices) studentsQueue.add(students[i])
        for (i in sandwiches.lastIndex downTo 0) sandwichesStack.push(sandwiches[i])

        while (studentsQueue.isNotEmpty() && cycleCounter < studentsQueue.size) {
            val student = studentsQueue.remove()

            if (student == sandwichesStack.peek()) {
                sandwichesStack.pop()
                cycleCounter = 0
                continue
            }

            studentsQueue.add(student)
            cycleCounter++
        }

        return studentsQueue.size
    }
}

println(Solution().countStudents(intArrayOf(1, 1, 0, 0), intArrayOf(0, 1, 0, 1)))
println(Solution().countStudents(intArrayOf(1, 1, 1, 0, 0, 1), intArrayOf(1, 0, 0, 0, 1, 1)))


// Otimizado
class Solution2 {
    fun countStudents(students: IntArray, sandwiches: IntArray): Int {
        // contagens de preferências
        var count0 = 0
        for (s in students) {
            if (s == 0) count0++
        }
        var count1 = students.size - count0

        var i = 0
        while (i < sandwiches.size) {
            val sand = sandwiches[i]
            if (sand == 0) {
                if (count0 > 0) {
                    count0--
                } else {
                    break
                }
            } else { // sand == 1
                if (count1 > 0) {
                    count1--
                } else {
                    break
                }
            }
            i++
        }

        // quantos não comeram = sanduíches restantes
        return sandwiches.size - i
    }
}
