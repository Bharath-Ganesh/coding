package com.leetcode.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * https://www.geeksforgeeks.org/function-to-find-number-of-customers-who-could-not-get-a-computer/
 * Write a function “runCustomerSimulation” that takes following two inputs
 * a) An integer ‘n’: total number of computers in a cafe and a string:
 * b) A sequence of uppercase letters ‘seq’: Letters in the sequence occur in pairs.
 * The first occurrence indicates the arrival of a customer; the second indicates the departure of that same customer.
 * A customer will be serviced if there is an unoccupied computer. No letter will occur more than two times.
 * Customers who leave without using a computer always depart before customers who are currently using the computers.
 * There are at most 20 computers per cafe.
 * For each set of input the function should output a number telling how many customers, if any walked away without using a computer.
 * Return 0 if all the customers were able to use a computer.
 * <p>
 * runCustomerSimulation (2, “ABBAJJKZKZ”) should return 0
 * runCustomerSimulation (3, “GACCBDDBAGEE”) should return 1 as ‘D’ was not able to get any computer
 * runCustomerSimulation (3, “GACCBGDDBAEE”) should return 0
 * runCustomerSimulation (1, “ABCBCA”) should return 2 as ‘B’ and ‘C’ were not able to get any computer.
 * runCustomerSimulation(1, “ABCBCADEED”) should return 3 as ‘B’, ‘C’ and ‘E’ were not able to get any computer.
 */
public class _012_CustomersWhoCouldNotGetComputer {
    public static void main(String[] args) {
        String sequence = "ABCBCAIIJJKKLMML";
        Integer computers = 3;
        System.out.println(runCustomerSimulation(computers, sequence));
        System.out.println(runCustomerSimulationGFG(computers, sequence.toCharArray()));
    }

    private static int runCustomerSimulation(Integer computers, String sequence) {
        int peopleWithNoComp = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < sequence.length(); i++) {
            Character ch = sequence.charAt(i);
            if (set.contains(ch)) {
                set.remove(ch);
            } else {
                set.add(ch);
                if (set.size() > computers) {
                    peopleWithNoComp++;
                }
            }
        }
        return peopleWithNoComp;
    }

    // n is number of computers in cafe.
// 'seq' is given sequence of customer entry, exit events
    static int runCustomerSimulationGFG(int n, char[] seq) {
        // seen[i] = 0, indicates that customer 'i' is not in cafe
        // seen[1] = 1, indicates that customer 'i' is in cafe but
        //         computer is not assigned yet.
        // seen[2] = 2, indicates that customer 'i' is in cafe and
        //         has occupied a computer.
        int MAX_CHAR = 26;
        char[] seen = new char[MAX_CHAR];

        // Initialize result which is number of customers who could
        // not get any computer.
        int res = 0;

        int occupied = 0; // To keep track of occupied computers

        // Traverse the input sequence
        for (int i = 0; i < seq.length; i++) {
            // Find index of current character in seen[0...25]
            int ind = seq[i] - 'A';

            // If First occurrence of 'seq[i]'
            if (seen[ind] == 0) {
                // set the current character as seen
                seen[ind] = 1;

                // If number of occupied computers is less than
                // n, then assign a computer to new customer
                if (occupied < n) {
                    occupied++;

                    // Set the current character as occupying a computer
                    seen[ind] = 2;
                }

                // Else this customer cannot get a computer,
                // increment result
                else
                    res++;
            }

            // If this is second occurrence of 'seq[i]'
            else {

                // Decrement occupied only if this customer
                // was using a computer
                if (seen[ind] == 2)
                    occupied--;
                seen[ind] = 0;
            }
        }
        return res;
    }
}
