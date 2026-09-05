package co.Proyecto_Backendll.controller;


import co.Proyecto_Backendll.domain.Student;
import co.Proyecto_Backendll.domain.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @DeleteMapping
    public void deleteStudent(@RequestParam Student student) {
        studentRepository.delete(student);
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @PutMapping
    public Student updateStudent(@RequestParam Student student) {
        return studentRepository.save(student);
    }

    @PatchMapping
    public Student patchStudent(@RequestParam Student student) {
        return studentRepository.save(student);
    }
}
