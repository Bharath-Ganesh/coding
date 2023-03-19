package com.leetcode.trees.heaps.collections;

public class StudentRunner {

    public static void main(String[] args) {
        Student student = new Student();
        Student.HUMAN_ID = 0;
        student.studentId = 1;
        student.showHumandId();
        /**
         * studentId is the instance variable of student class
         * similarly the class SpecialStudent will also be instance of student class, so to access "specialStudentId" of SpecialStudent class
         * we need to access using the object of student class
         *
         * Member innerclass
         */
        Student.SpecialStudent specialStudent = student.new SpecialStudent();
        specialStudent.specialStudentId = 11;

        Student.DisableStudent disableStudent = new Student.DisableStudent();
        disableStudent.disableStudent = 111;


        /**
         * Anonymous inner class
         */
        Student annoynousStudent = new Student() {
            public void showHumandId() {
                System.out.println("HumanId " + HUMAN_ID);
            }
        };
        annoynousStudent.showHumandId();

        /**
         * Lambda expression target always needs to be an interface
         */
        InterfaceStudent lambda = () -> {
            System.out.println("Hello");
        };
        lambda.show();

    }
}
