package com.forbitbd.postdatatofirebase;

public class Student {

    String name,roll, course, duration;

    public Student() {
    }

    public Student(String name, String roll, String course, String duration) {
        this.name = name;
        this.roll = roll;
        this.course = course;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
