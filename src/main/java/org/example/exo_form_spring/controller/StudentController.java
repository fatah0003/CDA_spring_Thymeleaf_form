package org.example.exo_form_spring.controller;

import org.example.exo_form_spring.model.Student;
import org.example.exo_form_spring.servivce.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String getStudent(Model model){
        List<Student> students = studentService.getStudents();
        model.addAttribute("students", students);
        return "student/studentList";
    }

    @GetMapping("/detail/{id}")
    public String getStudentDetails(@PathVariable("id") UUID id, Model model){
        Student student = studentService.getStudent(id);
        model.addAttribute("student", student);
        return "student/studentDetails";
    }

    @GetMapping("/add")
    public String addStudent(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "student/studentForm";
    }

    @PostMapping("/add")
    public String addStudent(Student student){
        studentService.addStudent(student);
        return "redirect:/student/list";
    }

    @GetMapping("/search")
    public String searchStudent(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "student/studentSearch";
    }

    @PostMapping("/search")
    public String searchResult(@RequestParam String keyword, Model model) {
        List<Student> results = studentService.search(keyword);
        model.addAttribute("results", results);
        return "student/studentSearch";
    }


}
