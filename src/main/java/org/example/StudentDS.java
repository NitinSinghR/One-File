package org.example;

class StudentDS {
    private String id;
    private String name;
    private double gpa;

    public StudentDS(String id, String name, double gpa) {
        setId(id);
        setName(name);
        setGPA(gpa);
    }

    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public double getGPA() {
        return gpa;
    }

    private void setGPA(double gpa) {
        this.gpa = gpa;
    }

}
