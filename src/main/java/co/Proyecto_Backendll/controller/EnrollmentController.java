package co.Proyecto_Backendll.controller;

import co.Proyecto_Backendll.application.service.EnrollmentService;
import co.Proyecto_Backendll.controller.dto.Response.ErrorResponse;
import co.Proyecto_Backendll.domain.Enrollment;
import co.Proyecto_Backendll.domain.Exceptions.BusinessException;
import co.Proyecto_Backendll.domain.Exceptions.EnrollmentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @GetMapping
    public ResponseEntity<Object> list() {
        try {
            var enrollments = enrollmentService.findAll();
            return ResponseEntity.ok(enrollments);
        } catch (BusinessException e) {
            return ResponseEntity.badRequest().body(ErrorResponse.of(e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id) {
        try {
            Enrollment enrollment = enrollmentService.findById(id)
                    .orElseThrow(() -> new EnrollmentNotFoundException(id));
            return ResponseEntity.ok(enrollment);
        } catch (EnrollmentNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse.of(e.getMessage()));
        }
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Enrollment enrollment) {
        try {
            var created = enrollmentService.create(enrollment);
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } catch (BusinessException e) {
            return ResponseEntity.badRequest().body(ErrorResponse.of(e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Enrollment enrollment) {
        try {
            enrollment.setId(id);
            Enrollment updated = enrollmentService.update(enrollment)
                    .orElseThrow(() -> new EnrollmentNotFoundException(id));
            return ResponseEntity.ok(updated);
        } catch (EnrollmentNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse.of(e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        try {
            enrollmentService.findById(id).orElseThrow(() -> new EnrollmentNotFoundException(id));
            enrollmentService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (EnrollmentNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse.of(e.getMessage()));
        } catch (BusinessException e) {
            return ResponseEntity.badRequest().body(ErrorResponse.of(e.getMessage()));
        }
    }
}
