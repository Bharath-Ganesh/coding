package com.practice.pepcoding.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Given an employee-employer hierarchy, find the number of employees reporting to an employer
 * EMPLOYEE -> EMPLOYER
 * A -> C
 * B -> C
 * C -> F
 * D -> E
 * E -> F
 * F -> F
 * <p>
 * A,B -> C
 * D   -> E
 * C,E -> F
 * <p>
 * OUTPUT
 * A -> 0
 * B -> 0
 * C -> 2
 * D -> 0
 * E -> 1
 * F -> 5
 */

public class FindEmployer_02 {

    public static void main(String args[]) {
        Map<String, String> employeeManager = new HashMap<>();
        employeeManager.put("A", "C");
        employeeManager.put("B", "C");
        employeeManager.put("C", "F");
        employeeManager.put("D", "E");
        employeeManager.put("E", "F");
        employeeManager.put("F", "F");
        findCount(employeeManager);

    }

    private static void findCount(Map<String, String> employeeManager) {

        Map<String, HashSet<String>> managerEmployee = new HashMap<>();
        String CEO = "";
        for (String employee : employeeManager.keySet()) {
            String manager = employeeManager.get(employee);
            if (manager == employee) {
                CEO = manager;
                continue;
            }
            HashSet<String> employeeList = managerEmployee.getOrDefault(manager, new HashSet<>());
            employeeList.add(employee);
            managerEmployee.put(manager, employeeList);
        }

        Map<String, Integer> employeeReporting = new HashMap<>();
        getSizeOfEmployee(managerEmployee, CEO, employeeReporting);

        for (String emp : employeeReporting.keySet()) {
            System.out.println(emp + " -> " + employeeReporting.get(emp));
        }
    }

    private static int getSizeOfEmployee(Map<String, HashSet<String>> managerEmployee, String manager,
                                         Map<String, Integer> employeeCount) {

        // F : CEO
        // C -> A, B
        // F -> C, E
        // E -> D
        if (!managerEmployee.containsKey(manager)) {
            employeeCount.put(manager, 0);
            return 1;
        }

        int size = 0;
        //C,E               F
        //A,B               C
        //D                 E
        for (String employee : managerEmployee.get(manager)) {
            int countOfEmployee = getSizeOfEmployee(managerEmployee, employee, employeeCount);
            size += countOfEmployee;
        }

        employeeCount.put(manager, size);
        return size += 1;

    }

}
