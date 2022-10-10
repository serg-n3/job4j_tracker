package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student stud = new Student();
        stud.setFio("Ivanov Ivan");
        stud.setGroup(1234);
        stud.setDor(new Date());
        System.out.println("Student: " + stud.getFio()
                + " Group: " + stud.getGroup()
                + " Date of receipt: " + stud.getDor());
    }
}
