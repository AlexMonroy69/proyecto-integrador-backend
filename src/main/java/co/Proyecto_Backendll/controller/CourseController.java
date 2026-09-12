package co.Proyecto_Backendll.controller;

import co.Proyecto_Backendll.application.service.CourseService;
import co.Proyecto_Backendll.controller.dto.Response.ErrorResponse;
import co.Proyecto_Backendll.domain.Course;
import co.Proyecto_Backendll.domain.Exceptions.BusinessException;
import co.Proyecto_Backendll.domain.Exceptions.CourseNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<Object> list() {
        try {
            // Si en el futuro creas DTOs para Course, mapealos aquí como en StudentController
            var courses = courseService.findAll();
            return ResponseEntity.ok(courses);
        } catch (BusinessException e) {
            return ResponseEntity.badRequest().body(ErrorResponse.of(e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id) {
        try {
            Course course = courseService.findById(id)
                    .orElseThrow(() -> new CourseNotFoundException(id));
            return ResponseEntity.ok(course);
        } catch (CourseNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse.of(e.getMessage()));
        }
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Course course) {
        try {
            var created = courseService.create(course);
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } catch (BusinessException e) {
            return ResponseEntity.badRequest().body(ErrorResponse.of(e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Course course) {
        try {
            course.setId(id); // Aseguramos que el ID de la ruta se asigne al objeto
            Course updated = courseService.update(course)
                    .orElseThrow(() -> new CourseNotFoundException(id));
            return ResponseEntity.ok(updated);
        } catch (CourseNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse.of(e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        try {
            // Verificamos que exista antes de intentar eliminar
            courseService.findById(id).orElseThrow(() -> new CourseNotFoundException(id));
            courseService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (CourseNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse.of(e.getMessage()));
        } catch (BusinessException e) {
            return ResponseEntity.badRequest().body(ErrorResponse.of(e.getMessage()));
        }
    }
}

