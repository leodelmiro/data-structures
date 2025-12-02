import java.util.*

/*
There are n people in a line queuing to buy tickets, where the 0th person is at the front of the line and the (n - 1)th person is at the back of the line.

You are given a 0-indexed integer array tickets of length n where the number of tickets that the ith person would like to buy is tickets[i].

Each person takes exactly 1 second to buy a ticket. A person can only buy 1 ticket at a time and has to go back to the end of the line (which happens instantaneously) in order to buy more tickets. If a person does not have any tickets left to buy, the person will leave the line.

Return the time taken for the person initially at position k (0-indexed) to finish buying tickets.
*/
data class Customer(val personId: Int, val ticketsLeft: Int)

class Solution {
    fun timeRequiredToBuy(tickets: IntArray, k: Int): Int {
        val queue: Queue<Customer> = LinkedList()
        var counter = 0

        for (i in tickets.indices) {
            queue.add(Customer(i, tickets[i]))
        }

        while (!queue.isEmpty()) {
            val element = queue.remove()

            if(element.ticketsLeft > 0) {
                queue.add(Customer(element.personId, element.ticketsLeft - 1))
                counter++
            }

            if(element.personId == k && element.ticketsLeft - 1 == 0) return counter
        }

        return counter
    }
}

println(Solution().timeRequiredToBuy(intArrayOf(84,49,5,24,70,77,87,8), 3))


class Solution2 {
    fun timeRequiredToBuy(tickets: IntArray, k: Int): Int {
        val queue: Queue<Int> = LinkedList()
        var counter = 0

        for (i in tickets.indices) {
            queue.add(i)
        }

        while (!queue.isEmpty()) {
            val i = queue.remove()
            counter++
            tickets[i]--

            if(tickets[i] > 0) {
                queue.add(i)
            } else if(i == k) return counter
        }

        return counter
    }
}