package com.examseating;

public class Student {
    private String name;
    private String branch;
    private int semester;
    private int year;
    private String subject;

    public Student(String name, String branch, int semester, int year, String subject) {
        this.name = name;
        this.branch = branch;
        this.semester = semester;
        this.year = year;
        this.subject = subject;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getBranch() {
        return branch;
    }

    public int getSemester() {
        return semester;
    }

    public int getYear() {
        return year;
    }

    public String getSubject() {
        return subject;
    }
}