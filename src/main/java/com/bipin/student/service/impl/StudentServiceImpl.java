package com.bipin.student.service.impl;

import com.bipin.student.entity.Student;
import com.bipin.student.exception.NoSuchStudentExistsException;
import com.bipin.student.exception.StudentAlreadyExistsException;
import com.bipin.student.model.StudentDto;
import com.bipin.student.repository.StudentRepository;
import com.bipin.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository ;

    @Override
    public Student createStudent(StudentDto obj) {
        Student s=new Student();
        s.setName(obj.getName());
        s.setAge(obj.getAge());
        s.setUsername(obj.getUsername());

        Student existingStudent=studentRepository.findByusername(obj.getUsername()) ;
        if (existingStudent == null) {
            return studentRepository.save(s);
        }
        else{
            throw new StudentAlreadyExistsException(
                    "Student already exists!!");
        }
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public String deleteAll() {
        studentRepository.deleteAll();
        return "all deleted";
    }

    @Override
    public Student getStudent(String username) {
        Student s1= studentRepository.findByusername(username) ;
        if(s1 == null){
            throw new NoSuchStudentExistsException("NO STUDENT PRESENT WITH USERNAME = "+username);
        }else{
            return s1;
        }
    }

    @Override
    public String DeleteStudent(String username) {
        Student s=getStudent(username);
        studentRepository.delete(s);
        return "Student with username : "+username+" successfully deleted" ;
    }

    @Override
    public Student updateStudent(StudentDto obj) {
        String s2=DeleteStudent(obj.getUsername());
        return createStudent(obj);
    }


}
