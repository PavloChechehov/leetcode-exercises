package com.paul.employee;

import java.util.*;

public class EmployeeHierarchy {

    private static Map<Integer, Employee> hierarchyMap = new HashMap<>();
    private static Map<Integer, List<Employee>> childrenMap = new HashMap<>();

    public static void main(String[] args) {
        String input = """
                id,superid,name
                0,2,Pavlo
                2,3,John
                6,3,Doda
                3,,Mary
                4,6,Kolia
                1,2,Asia
                10,6,Alex
                """;


        //1.create structure based on the input file
        List<Employee> employees = buildEmployees(input);
        //2. build the hierarchy <EmployeeId, Employee> to get the root
        buildHierarchy(employees);

        //3. print hierarchy by the Employee id
        printHierarchy(3);

        //4. print the breadth-search-tree based on the hierarchy
        //give a hint
        printBfsTree(3);


    }

    private static void printBfsTree(Integer rootId) {
        //3, Mary
        Employee root = hierarchyMap.get(rootId);
        if (root == null) {
            System.out.println("Employee not found");
            return;
        }


        Queue<Employee> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            Employee curr = queue.poll();
            System.out.println(curr.id() + " - " + curr.name());

            List<Employee> children = childrenMap.get(curr.id());

            if (children != null) {
                queue.addAll(children);
            }

        }



    }

    private static void printHierarchy(Integer id) {

        Employee curr = hierarchyMap.get(id);

        if (curr == null) {
            System.out.println("Employee not found");
            return;
        }


        while (curr != null) {
            System.out.println("SuperId = " + curr.id() + ", name = " + curr.name());
            curr = hierarchyMap.get(curr.superId());
        }
    }

    private static void buildHierarchy(List<Employee> employees) {

        for (Employee e : employees) {
            hierarchyMap.put(e.id(), e);

            if (e.superId() != null) {
                childrenMap.computeIfAbsent(e.superId(), k -> new ArrayList<>())
                        .add(e);
            }
        }

        System.out.println();
    }

    private static List<Employee> buildEmployees(String input) {
        String[] lines = input.split("\n");
        List<Employee> employees = new ArrayList<>();

        for (int i = 1; i < lines.length; i++) {
           String line = lines[i];
           String[] columns = line.split(",");

            if (Objects.equals(columns[1], "")) {
                employees.add(new Employee(Integer.valueOf(columns[0]), null, columns[2]));
            } else {
                employees.add(new Employee(Integer.valueOf(columns[0]), Integer.valueOf(columns[1]), columns[2]));
            }

       }
        return employees;
    }

}


record Employee(Integer id, Integer superId, String name) {

}
