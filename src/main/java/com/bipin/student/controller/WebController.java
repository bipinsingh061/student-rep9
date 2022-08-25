package com.bipin.student.controller;

import com.bipin.student.entity.Student;
import com.bipin.student.model.StudentDto;
import com.bipin.student.repository.StudentRepository;
import com.bipin.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {

    @Autowired
    private StudentService studentService ;

    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

    @GetMapping("/AllStudents")
    public String viewHomePage(Model model) {
        model.addAttribute("allstudlist", studentService.getAllStudent());
        return "index";
    }

    @GetMapping("/addnew")
    public String addNewEmployee(Model model) {
        StudentDto studentDto = new StudentDto();
        model.addAttribute("studentDto", studentDto);
        return "newStudent";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("studentDto") StudentDto studentDto) {
        studentService.createStudent(studentDto);
        return "redirect:/AllStudents";
    }

    @PostMapping("/update2")
    private String updateStudent(@ModelAttribute("studentDto")  StudentDto studentDto ){
        studentService.updateStudent(studentDto);
        return "redirect:/AllStudents";
    }


    @GetMapping("/showFormForUpdate/{username}")
    public String updateForm(@PathVariable(value = "username") String username, Model model) {
        StudentDto studentDto = covertEntityToDto(studentService.getStudent(username));
        model.addAttribute("studentDto", studentDto);
        return "update";
    }

    @GetMapping("/deleteEmployee/{username}")
    public String deleteThroughId(@PathVariable(value = "username") String username) {
//        employeeServiceImpl.deleteViaId(id);
        studentService.DeleteStudent(username);
        return "redirect:/AllStudents";

    }

    private StudentDto covertEntityToDto(Student obj){
        StudentDto dto = new StudentDto();
        dto.setId(obj.getId());
        dto.setName(obj.getName());
        dto.setAge(obj.getAge());
        dto.setUsername(obj.getUsername());
        return dto ;
    }
}
