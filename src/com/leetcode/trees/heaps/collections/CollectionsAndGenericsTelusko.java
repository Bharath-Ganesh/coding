package com.leetcode.trees.heaps.collections;

import java.util.*;
import java.util.function.Consumer;


/**
 * Implementing the comparator class
 */
class ComparatorImpl implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1 % 10 > o2 % 10 ? 1 : -1;
    }
}


public class CollectionsAndGenericsTelusko {

    public static void main(String[] args) {
        CollectionsAndGenericsTelusko obj = new CollectionsAndGenericsTelusko();
        obj.compareTo();
        obj.workoutTwo();
      //  obj.workout();
      //  obj.workoutTwo();
      //  obj.workoutThree();
    }

    private void compareTo() {
        Integer val1=3;
        Integer val2=3;
        int i1 = val1.compareTo(val2);
        System.out.println(i1);
    }

    private void workoutThree() {
        List<List<List<Integer>>> res = Arrays.asList(Arrays.asList(Arrays.asList(6, 4, 3), Arrays.asList(1, 2, 3)), Arrays.asList(Arrays.asList(3, 4, 6), Arrays.asList(6, 7, 8)));
        Collections.sort(res, new Comparator<List<List<Integer>>>() {
            @Override
            public int compare(List<List<Integer>> o1, List<List<Integer>> o2) {
                return o1.get(0).get(0) - o2.get(0).get(0);
            }
        });
        System.out.println(res);
    }

    private void workoutTwo() {
        List<List<Integer>> res = Arrays.asList(Arrays.asList(3, 4, 6), Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 2), Arrays.asList(5, 2, 6));
        Comparator<List<Integer>> comparator = new Comparator<>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0) > o2.get(0)  ? 1 : -1;
            }
        };
//
//        Comparator<List<Integer>> comparator2 = (o1, o2) -> o1.get(0) - o2.get(0);
//
//        Comparator<List<Integer>> comparator3 = Comparator.comparingInt(o1 -> o1.get(0));

        Collections.sort(res, comparator);
        System.out.println(res);
    }

    private void workout() {
        List<Integer> values = new ArrayList();
        values.add(305);
        values.add(998);
        values.add(774);
        values.add(236);
        values.add(881);

        /**
         * Here we're using the object of the employee which has a method printEmpId
         * If it's a static method you can directly use the class name
         */
        values.forEach(new Employee()::printEmpId);

        /**
         * Annonymous inner class
         */
        Comparator<Integer> comparator = new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 % 10 > o2 % 10 ? 1 : -1;
            }
        };

        /**
         * lambda expression
         * It says that in the functional interface, Comparator, it has a single method compare which takes two arguments and return an int value
         */
        Comparator<Integer> comparator1 = (o1, o2) -> o1 % 10 > o2 % 10 ? 1 : -1;


        Comparator<Integer> comparator2 = new ComparatorImpl();

        Collections.sort(values, comparator1);
        System.out.println(values);
    }
}

class Employee {

    public void printEmpId(int empId) {
        System.out.println("EmpId " + empId);
    }
}