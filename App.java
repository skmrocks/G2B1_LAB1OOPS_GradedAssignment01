package com.lab01.individualgradedassignments01;

import static java.lang.System.out;

import java.util.ArrayList;

/**
 * App class for running application.
 */
public final class App {
    private static final int DEPARTMENT_ID_1 = 1;
    private static final int DEPARTMENT_ID_2 = 2;
    private static final int DEPARTMENT_ID_3 = 3;
    private static final int DEPARTMENT_ID_4 = 4;

    /**
     * Says hello to the world.
     *
     * @param args The arguments of the program.
     */
    public static void main(final String[] args) {
        final ArrayList<Department> availableDepartments = new ArrayList<>();
        availableDepartments.add(new Department(DEPARTMENT_ID_1, "tech", "Technical"));
        availableDepartments.add(new Department(DEPARTMENT_ID_2, "admin", "Admin"));
        availableDepartments.add(new Department(DEPARTMENT_ID_3, "hr", "Human Resource"));
        availableDepartments.add(new Department(DEPARTMENT_ID_4, "legal", "Legal"));

        out.println("=========================================");
        out.println("Employee Credentials Generator");
        out.println("=========================================");
        out.println("Please enter the department from the following:");
        availableDepartments.forEach(n -> out.println(new StringBuilder().append(n.getDepartmentId())
                .append(". ").append(n.getDepartmentNameForDisplay()).toString()));
        Department selectedDepartment = availableDepartments
                .get(Integer.parseInt(System.console().readLine().trim()) - 1);
        String firstName = "Alex";
        String lastName = "Denver";
        Employee employee = new Employee(firstName, lastName);
        employee.setDepartment(selectedDepartment);
        employee.setPassword(CredentialService.generatePassword());
        employee.setEmailAddress(CredentialService.generateEmailAddress(employee));
        out.println("\n");
        out.println(CredentialService.showCredentials(employee));
    }

    /**
     *
     */
    public App() {
        System.out.println("Program Initialized...");
    }
}
