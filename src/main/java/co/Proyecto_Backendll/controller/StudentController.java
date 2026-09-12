package co.Proyecto_Backendll.controller;

import co.Proyecto_Backendll.application.service.StudentService;
import co.Proyecto_Backendll.controller.dto.CreateStudentDto;
import co.Proyecto_Backendll.controller.dto.Response.ErrorResponse;
import co.Proyecto_Backendll.controller.dto.Response.StudentResponseDto;
import co.Proyecto_Backendll.controller.dto.UpdateStudentDto;
import co.Proyecto_Backendll.domain.Exceptions.BusinessException;
import co.Proyecto_Backendll.domain.Exceptions.StudentEmailAlreadyExistsException;
import co.Proyecto_Backendll.domain.Exceptions.StudentNotFoundException;
import co.Proyecto_Backendll.domain.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<Object> list() {
        try {
            var students = studentService.getAllStudents().stream()
                    .map(StudentResponseDto::from)
                    .toList();
            return ResponseEntity.ok(students);
        } catch (BusinessException e) {
            return ResponseEntity.badRequest().body(ErrorResponse.of(e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id) {
        try {
            Student student = (Student) studentService.getStudentById(id)
                    .orElseThrow(() -> new StudentNotFoundException(id));
            return ResponseEntity.ok(StudentResponseDto.from(student));
        } catch (StudentNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse.of(e.getMessage()));
        }
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody CreateStudentDto createStudentDto) {
        try {
            if (studentService.existsByEmail(createStudentDto.email())) {
                throw new StudentEmailAlreadyExistsException(createStudentDto.email());
            }
            var created = studentService.create(createStudentDto.toStudent());
            return ResponseEntity.status(HttpStatus.CREATED).body(StudentResponseDto.from((Student) created));
        } catch (BusinessException e) {
            return ResponseEntity.badRequest().body(ErrorResponse.of(e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody UpdateStudentDto updateStudentDto) {
        try {
            Student student = updateStudentDto.toStudent(id);
            Student updated = (Student) studentService.update(student)
                    .orElseThrow(() -> new StudentNotFoundException(id));
            return ResponseEntity.ok(StudentResponseDto.from(updated));
        } catch (StudentNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse.of(e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        try {
            studentService.getStudentById(id);
            return ResponseEntity.noContent().build();
        } catch (StudentNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse.of(e.getMessage()));
        } catch (BusinessException e) {
            return ResponseEntity.badRequest().body(ErrorResponse.of(e.getMessage()));
        }
    }

}