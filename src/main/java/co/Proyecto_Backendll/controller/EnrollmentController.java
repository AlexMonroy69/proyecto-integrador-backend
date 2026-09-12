package co.Proyecto_Backendll.controller;

import co.Proyecto_Backendll.controller.dto.CreateEnrollmentDto;
import co.Proyecto_Backendll.controller.dto.Response.EnrollmentResponseDto;
import co.Proyecto_Backendll.domain.Enrollment;
import co.Proyecto_Backendll.application.service.EnrollmentService;
import co.Proyecto_Backendll.domain.Exceptions.EnrollmentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @GetMapping
    public ResponseEntity<List<EnrollmentResponseDto>> list() {
        List<EnrollmentResponseDto> enrollments = enrollmentService.findAll()
                .stream()
                .map(EnrollmentResponseDto::from)
                .toList();
        return ResponseEntity.ok(enrollments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentResponseDto> getById(@PathVariable Long id) {
        Enrollment enrollment = enrollmentService.findById(id)
                .orElseThrow(() -> new EnrollmentNotFoundException(id));
        return ResponseEntity.ok(EnrollmentResponseDto.from(enrollment));
    }

    @PostMapping
    public ResponseEntity<EnrollmentResponseDto> create(@RequestBody CreateEnrollmentDto createEnrollmentDto) {
        Enrollment enrollment = enrollmentService.create(createEnrollmentDto.toEnrollment());
        return ResponseEntity.status(HttpStatus.CREATED).body(EnrollmentResponseDto.from(enrollment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        enrollmentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}