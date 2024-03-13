package com.examseating;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Admin {
    private String username;
    private String password;
    private Map<String, String> registeredUsers; // Map to store username-password pairs
    private int totalStudents;
    private Map<String, Integer> availableClasses; // Map to store class name and number of seats
    private Map<String, Student> studentDetails; // Map to store student details

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
        this.registeredUsers = new HashMap<>();
        // Add the default user for testing
        this.registeredUsers.put("fahad", "123");
        this.studentDetails = new HashMap<>();
    }

    // Method to register a new user
    public void register(String username, String password) {
        registeredUsers.put(username, password);
        System.out.println("User registered successfully!");
    }

    // Method to check if the provided username and password match
    public boolean login(String username, String password) {
        return registeredUsers.containsKey(username) && registeredUsers.get(username).equals(password);
    }

    // Method to print registered users
    public void printRegisteredUsers() {
        System.out.println("Registered Users:");
        for (Map.Entry<String, String> entry : registeredUsers.entrySet()) {
            System.out.println("Username: " + entry.getKey() + ", Password: " + entry.getValue());
        }
    }

    // Method to input total number of students
    public void inputTotalStudents(int totalStudents) {
        this.totalStudents = totalStudents;
    }

    // Method to input available classes and their respective seats
    public void inputAvailableClasses(Map<String, Integer> classes) {
        availableClasses = new HashMap<>(classes);
        System.out.println("Available classes and seats input successful!");
    }

    // Method to input student details like branch, semester, year, etc.
    public void inputStudentDetails(Student student) {
        studentDetails.put(student.getName(), student); // Storing student details
        System.out.println("Student details input successful:");
        System.out.println("Name: " + student.getName());
        System.out.println("Branch: " + student.getBranch());
        System.out.println("Semester: " + student.getSemester());
        System.out.println("Year: " + student.getYear());
        System.out.println("Subject: " + student.getSubject());
    }

// Method to generate seating arrangement
public void generateSeatingArrangement() {
    int totalSeats = availableClasses.values().stream().mapToInt(Integer::intValue).sum();
    if (totalStudents > totalSeats) {
        System.out.println("Error: Not enough seats available for all students.");
        return;
    }

    System.out.println("Generating seating arrangement...");
    int remainingStudents = totalStudents;
    for (Map.Entry<String, Integer> entry : availableClasses.entrySet()) {
        String className = entry.getKey();
        int classSeats = entry.getValue();

        int studentsForClass = Math.min(classSeats, remainingStudents);
        List<String> seatingArrangement = new ArrayList<>();

        for (int i = 1; i <= studentsForClass; i++) {
            seatingArrangement.add("Student " + i);
        }

        int rows = studentsForClass / 10;
        int remainingSeats = studentsForClass % 10;

        for (int i = 0; i < rows; i++) {
            System.out.println("Seating arrangement for " + className + ", Row " + (i + 1) + ": " + seatingArrangement.subList(i * 10, (i + 1) * 10));
        }

        if (remainingSeats > 0) {
            System.out.println("Seating arrangement for " + className + ", Row " + (rows + 1) + ": " + seatingArrangement.subList(rows * 10, rows * 10 + remainingSeats));
        }

        remainingStudents -= studentsForClass;
        if (remainingStudents == 0) {
            break;
        }
    }
    System.out.println("Seating arrangement generated successfully!");
}

}
