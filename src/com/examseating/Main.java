package com.examseating;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Main class
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = loginAdmin(scanner);
        admin.printRegisteredUsers();


        System.out.println("Admin logged in successfully!");

        // Input total number of students
        System.out.println("Enter total number of students:");
        int totalStudents = scanner.nextInt();
        admin.inputTotalStudents(totalStudents);

        // Input available classes and their seats
        Map<String, Integer> classes = inputAvailableClasses(scanner);
        admin.inputAvailableClasses(classes);

        // Input student details
        inputStudentDetails(scanner, admin, totalStudents);

        // Generate seating arrangement
        admin.generateSeatingArrangement();

        scanner.close();
    }

    // Method to login admin
    private static Admin loginAdmin(Scanner scanner) {
        System.out.println("Enter Admin Username:");
        String adminUsername = scanner.next();
        System.out.println("Enter Admin Password:");
        String adminPassword = scanner.next();
    
        System.out.println("Entered Username: " + adminUsername);
        System.out.println("Entered Password: " + adminPassword);
    
        Admin admin = new Admin(adminUsername, adminPassword);
        if (admin.login(adminUsername, adminPassword)) {
            return admin;
        } else {
            System.out.println("Login failed. Exiting program.");
            return null;
        }
    }
    
    // Method to input available classes and their seats
    private static Map<String, Integer> inputAvailableClasses(Scanner scanner) {
        Map<String, Integer> classes = new HashMap<>();
        System.out.println("Enter available classes and their seats (e.g., ClassA 50):");
        scanner.nextLine(); // Consume newline
        while (true) {
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                break;
            }

            String[] parts = input.split(" ");
            String className = parts[0];
            int seats = Integer.parseInt(parts[1]);
            classes.put(className, seats);
        }
        return classes;
    }

    // Method to input student details
    private static void inputStudentDetails(Scanner scanner, Admin admin, int totalStudents) {
        for (int i = 1; i <= totalStudents; i++) {
            System.out.println("Enter details for Student " + i + ":");
            System.out.println("Enter Student Name:");
            String studentName = scanner.next();
            System.out.println("Enter Branch:");
            String branch = scanner.next();
            System.out.println("Enter Semester:");
            int semester = scanner.nextInt();
            System.out.println("Enter Year:");
            int year = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.println("Enter Subject:");
            String subject = scanner.nextLine();

            admin.inputStudentDetails(new Student(studentName, branch, semester, year, subject));
        }
    }
}
