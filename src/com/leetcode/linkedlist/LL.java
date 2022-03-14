package com.leetcode.linkedlist;

public class LL {

    private Node head;
    private Node tail;
    private int size;

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public LL() {
        this.size = 0;
    }

    /**
     * To insert at the head of the linked list
     */
    public void insertFirst(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
        size += 1;
    }

    /**
     * Display all the elements in a linked list
     */
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.printf(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    /**
     * Inserting an element at the end of the list
     */
    public void insertLast(int val) {
        if (tail == null) {
            insertFirst(val);
            return;
        }
        Node newNode = new Node(val);
        tail.next = newNode;
        tail = newNode;
        size += 1;

    }

    /**
     * Insert at an index
     */
    public void insert(int val, int index) {
        if (index == 0) {
            insertFirst(val);
            return;
        } else if (index == size) {
            insertLast(val);
            return;
        } else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            Node node = new Node(val, temp.next);
            temp.next = node;
            size += 1;
        }
    }

    /**
     * Delete at the head of linked list
     *
     * @return
     */
    public int deleteFirst() {
        int val = -1;
        if (head != null) {
            val = head.value;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            size--;
        }
        return val;
    }

    /**
     * return a node at a particular index
     */
    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    /**
     * Delete at the end of the list
     */
    public int deleteLast() {
        if (size <= 1) {
            return deleteFirst();
        } else {
            Node secondLast = get(size - 2);
            int val = tail.value;
            secondLast.next = null;
            tail = secondLast;
            size--;
            return val;
        }
    }

    /**
     * Delete at a particular index
     *
     * @param index
     * @return
     */
    public int delete(int index) {
        if (index == 0) {
            return deleteFirst();
        } else if (size == index - 1) {
            return deleteLast();
        } else {
            Node prev = get(index - 1);
            int val = prev.next.value;
            prev.next = prev.next.next;
            return val;
        }
    }

    /**
     * Find an element at a based on a given value
     *
     * @param value
     * @return
     */
    public Node find(int value) {
        Node temp = head;
        while (temp != null) {
            if (temp.value == value) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }


    // insert using recursion

    /**
     * Insert using recursion
     */
    public void insertRec(int val, int index) {
        head = insertRec(val, index, head);
    }


    private Node insertRec(int val, int index, Node node) {
        if (index == 0) {
            Node newNode = new Node(val);
            size++;
            newNode.next = node;
            return newNode;
        }
        node.next = insertRec(val, index - 1, node.next);
        return node;
    }


    public void bubbleSort() {
        bubbleSort(size - 1, 0);
    }

    private void bubbleSort(int row, int col) {
        if (row == 0) {
            return;
        }

        if (col < row) {
            Node first = get(col);
            Node second = get(col + 1);

            if (first.value > second.value) {
                // swap
                if (first == head) {
                    head = second;
                    first.next = second.next;
                    second.next = first;
                } else if (second == tail) {
                    Node prev = get(col - 1);
                    prev.next = second;
                    tail = first;
                    first.next = null;
                    second.next = tail;
                } else {
                    Node prev = get(col - 1);
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }
            bubbleSort(row, col + 1);
        } else {
            bubbleSort(row - 1, 0);
        }
    }


    // https://leetcode.com/problems/remove-duplicates-from-sorted-list
    public void duplicates() {
        Node node = head;

        while (node.next != null) {
            if (node.value == node.next.value) {
                node.next = node.next.next;
                size--;
            } else {
                node = node.next;
            }
        }
        tail = node;
        tail.next = null;
    }

    // https://leetcode.com/problems/merge-two-sorted-lists/submissions/
    public static LL merge(LL first, LL second) {
        Node f = first.head;
        Node s = second.head;

        LL ans = new LL();

        while (f != null && s != null) {
            if (f.value < s.value) {
                ans.insertLast(f.value);
                f = f.next;
            } else {
                ans.insertLast(s.value);
                s = s.next;
            }
        }

        while (f != null) {
            ans.insertLast(f.value);
            f = f.next;
        }

        while (s != null) {
            ans.insertLast(s.value);
            s = s.next;
        }

        return ans;
    }


    // recursion reverse
    private void reverse(Node node) {
        if (node == tail) {
            head = tail;
            return;
        }
        reverse(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }

    // in place reversal of linked list
    // google, microsoft, apple, amazon: https://leetcode.com/problems/reverse-linked-list/
    public void reverse() {
        if (size < 2) {
            return;
        }

        Node prev = null;
        Node present = head;
        Node next = present.next;

        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }
        head = prev;
    }


    public static void main(String[] args) {
        LL first = new LL();
        LL second = new LL();

        first.insertLast(1);
        first.insertLast(3);
        first.insertLast(5);

        second.insertLast(1);
        second.insertLast(2);
        second.insertLast(9);
        second.insertLast(14);

        LL ans = LL.merge(first, second);
        ans.display();

        LL list = new LL();
        for (int i = 7; i > 0; i--) {
            list.insertLast(i);
        }
        list.display();
        list.bubbleSort();
        list.display();

    }


}
