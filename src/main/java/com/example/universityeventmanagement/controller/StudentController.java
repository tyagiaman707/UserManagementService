package com.example.universityeventmanagement.controller;

import com.example.universityeventmanagement.model.Student;
import com.example.universityeventmanagement.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/university")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @PostMapping("/add-student")
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @PutMapping("/update-student/{id}")
    public void updateStudent(@PathVariable int id, @RequestBody Student student) {
        studentService.updateStudent(id, student);
    }

    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable int id) {
        return studentService.findById(id);
    }

    @GetMapping("/findAllStudents")
    public List<Student> findAllStudents() {
        return studentService.findAllStudents();
    }

    @DeleteMapping("/delete-student/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
    }
}