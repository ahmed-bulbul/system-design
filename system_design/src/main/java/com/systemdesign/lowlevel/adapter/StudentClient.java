package com.systemdesign.lowlevel.adapter;

import java.util.ArrayList;
import java.util.List;

public class StudentClient {

    public List<Student>  getStudents() {
        List<Student> studentList = new ArrayList<>();

        CollegeStudent student = new CollegeStudent("Gokul", "Kumar", "gokul.kumar@in");

        SchoolStudent student1 = new SchoolStudent("Gokul", "Kumar", "gokul.kumar@in");

        studentList.add(student);
        studentList.add(new SchoolStudentAdapter(student1));

        return studentList;
    }





}
