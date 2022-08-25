package com.bipin.student.controller;

import com.bipin.student.entity.Student;
import com.bipin.student.model.StudentDto;
import com.bipin.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService ;

    @PostMapping("/create")
    private StudentDto createStudent(@RequestBody  StudentDto obj ){
        return covertEntityToDto(studentService.createStudent(obj));
    }

    @PostMapping("/update")
    private StudentDto updateStudent(@RequestBody  StudentDto obj ){
        return covertEntityToDto(studentService.updateStudent(obj));
    }

    @GetMapping("/all")
    private List<StudentDto> getAllStudent( ){
        List<StudentDto> studentDtos=new ArrayList<>();
        studentService.getAllStudent().forEach(
                Student -> {
                    studentDtos.add(covertEntityToDto(Student));
                }
        );
        return studentDtos ;
    }

    @GetMapping("/all/{username}")
    private StudentDto getStudent(@PathVariable String username)
    {
        return covertEntityToDto(studentService.getStudent(username));
    }

    @GetMapping("/deleteAll/{username}")
    private String deleteByusername(@PathVariable String username)
    {
        return studentService.DeleteStudent(username);
    }

    @GetMapping("/deleteAll")
    private String deleteAll( ){
        return studentService.deleteAll();
    }

    private StudentDto covertEntityToDto(Student obj){
        StudentDto dto = new StudentDto();
        dto.setId(obj.getId());
        dto.setName(obj.getName());
        dto.setAge(obj.getAge());
        dto.setUsername(obj.getUsername());
        return dto ;
    }

//    request mappings

}
