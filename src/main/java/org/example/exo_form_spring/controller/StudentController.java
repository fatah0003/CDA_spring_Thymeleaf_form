package org.example.exo_form_spring.controller;

import org.example.exo_form_spring.model.Student;
import org.example.exo_form_spring.servivce.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String home(){
        return "home";
    }

    @GetMapping("/list")
    public String getContacts(Model model){
        List<Student> students = studentService.getContacts();
        model.addAttribute("students", students);
        return "student/studentList";
    }

    @GetMapping("/detail/{id}")
    public String getContactDetails(@PathVariable("id") UUID id, Model model){
        Student student = studentService.getContact(id);
        model.addAttribute("student", student);
        return "student/studentDetails";
    }

    @GetMapping("/add")
    public String addContact(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "student/studentForm";
    }

    @PostMapping("/add")
    public String addContact(Student student){
        studentService.addContact(student);
        return "redirect:/student/list";
    }

}
