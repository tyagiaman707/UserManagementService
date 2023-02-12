package com.example.universityeventmanagement.service;

import com.example.universityeventmanagement.model.Student;

import java.util.List;

public interface IStudentService {
    public List<Student> findAllStudents();

    public Student findById(int id);

    public void addStudent(Student student);

    public void deleteStudent(int id);

    public void updateStudent(int id, Student student);

}
