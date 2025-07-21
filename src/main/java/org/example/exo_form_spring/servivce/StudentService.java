package org.example.exo_form_spring.servivce;

import org.example.exo_form_spring.model.Student;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class StudentService {
    private final Map<UUID, Student> students;

    public StudentService() {
        students = new HashMap<>();
        Student student1 = new Student(UUID.randomUUID(), "Fatah", "Ainseri", 35, "fatah@gmail.com");
        Student student2 = new Student(UUID.randomUUID(), "Ophélie", "Ferrand", 32, "ophelie@gmail.com");
        Student student3 = new Student(UUID.randomUUID(), "Rose", "Fackson", 25, "rose@gmail.com");
        students.put(student1.getId(), student1);
        students.put(student2.getId(), student2);
        students.put(student3.getId(), student3);
    }

    public List<Student> getStudents() {
        return students.values().stream().toList();
    }

    public Student getStudent(UUID id) {
        return students.get(id);
    }

    public void addStudent(Student student) {
        UUID id = UUID.randomUUID();
        student.setId(id);
        students.put(id, student);
    }

    public void updateStudent(Student student) {
        students.put(student.getId(), student);
    }

    public void removeStudent(UUID id) {
        students.remove(id);
    }

    public List<Student> search() {
        return students.values().stream().toList();
    }
}

