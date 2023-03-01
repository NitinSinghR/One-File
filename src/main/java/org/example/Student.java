package org.example;

import java.util.logging.Logger;

public class Student {
    private final String stuName;
    private int gpa;
    private final char grade;

    public Student(String stuName, int gpa, char grade) {
        this.stuName = stuName;
        this.gpa = gpa;
        this.grade = grade;
    }

    public void updateGPA(int update) {
        Logger l=Logger.getLogger("com.api.jar");
        gpa = update;
        String det="The Student " + stuName + " GPA has been updated to " + gpa + "\n";
        l.info(det);
    }

    public String getDetails() {
        String details;
        details = stuName + " has GPA of " + gpa + " and grade of " + grade +"\n";
        return details;
    }
}