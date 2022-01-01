package com.leetcode.trees.heaps.collections;

/**
 * Anonymous inner class
 */
public class Student {

    public static int HUMAN_ID;
    int studentId;

    public void showHumandId() {
        System.out.println("StudentId " + studentId);
    }

    class SpecialStudent {

        int specialStudentId;
    }


    /**
     * Students with most important privilege
     */
    static class DisableStudent {
        int disableStudent;

    }
}
