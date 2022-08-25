package com.bipin.student.service;

import com.bipin.student.entity.Student;
import com.bipin.student.model.StudentDto;
import org.springframework.stereotype.Service;

import java.util.List;
public interface StudentService {
    Student createStudent(StudentDto obj);
    List<Student> getAllStudent();

    String deleteAll();

    Student getStudent(String username);

    String DeleteStudent(String username);

    Student updateStudent(StudentDto obj);
}
