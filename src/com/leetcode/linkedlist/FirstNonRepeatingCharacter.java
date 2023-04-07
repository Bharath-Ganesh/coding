package com.leetcode.linkedlist;


import java.util.ArrayList;
import java.util.List;

class Solution {

    static class LinkedList {

        static class Node {
            char val;
            Node next;
            Node prev;

            Node(char data) {
                this.val = data;
                this.next = null;
                this.prev = null;
            }
        }

        static Node head;
        static Node tail;

        public static Node addNode(char data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
            } else {
                newNode.prev = tail;
                tail.next = newNode;
            }
            tail = newNode;
            return newNode;
        }

        public static void removeElement(char ch) {

            if (head.val == ch) {
                head = head.next;
                //one element
                if (head != null) {
                    head.prev = null;
                }
            } else if (tail.val == ch) {
                tail = tail.prev;
                tail.next = null;
            } else {
                Node curr = head;
                while (curr != null) {
                    if (curr.val == ch) {
                        curr.prev.next = curr.next;
                        break;
                    } else {
                        curr = curr.next;
                    }
                }
            }
        }
    }

    public String FirstNonRepeatingList(String A) {
        List<Character> dl = new ArrayList<Character>();
        boolean[] repeated = new boolean[26];
        StringBuilder s = new StringBuilder();
        int x;
        for (char ch : A.toCharArray()) {
            x = ch - 'a';
            // repeated[x] is true if x is repeated two or more
            // times. If x is not seen so far or x is seen only
            // once. then repeated[x] is false
            if (!repeated[x]) {
                //if dl does not contains ch,add it else remove it from dl and make it true in repeated
                //denoting ch has appeared more than 1 time
                if (!dl.contains(ch))
                    dl.add(ch);
                else {
                    dl.remove((Character) ch);
                    repeated[x] = true;
                }
            }
            if (dl.size() != 0)
                s.append(dl.get(0));
            else
                s.append('#');
        }
        return s.toString();
    }

    public String FirstNonRepeating(String word) {
        // code here
        //hrqcvsvszpsjammdrw
        //hhhhhhhhhhhhhhhhhh
        StringBuffer result = new StringBuffer();
        LinkedList.Node arr[] = new LinkedList.Node[26];

        LinkedList.head = null;
        LinkedList.tail = null;
        boolean visited[] = new boolean[26];

        for (int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            //True implies the character has more than 2 occurrence
            int index = ch - 'a';
            if (visited[index]) {
                printResult(result);
            } else if (arr[index] != null) {
                visited[index] = true;
                LinkedList.removeElement(ch);
                printResult(result);
            } else {
                arr[index] = LinkedList.addNode(ch);
                printResult(result);

            }
        }
        return result.toString();
    }

    private void printResult(StringBuffer result) {
        if (LinkedList.head == null) {
            result.append("#");
        } else {
            result.append(LinkedList.head.val);
        }

    }
}

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        FirstNonRepeatingCharacter ob = new FirstNonRepeatingCharacter();
        ob.newMethod();
    }

    private void newMethod() {
        String word = "ftvbwnimpvvbfvtot";
        Solution solution = new Solution();
        System.out.println(solution.FirstNonRepeating(word));
    }
}
