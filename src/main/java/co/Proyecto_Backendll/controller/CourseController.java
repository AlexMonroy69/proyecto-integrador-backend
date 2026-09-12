package co.Proyecto_Backendll.controller;

import co.Proyecto_Backendll.controller.dto.CreateCourseDto;
import co.Proyecto_Backendll.controller.dto.Response.CourseResponseDto;
import co.Proyecto_Backendll.domain.Course;
import co.Proyecto_Backendll.application.service.CourseService;
import co.Proyecto_Backendll.domain.Exceptions.CourseNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<CourseResponseDto>> list() {
        List<CourseResponseDto> courses = courseService.findAll()
                .stream()
                .map(CourseResponseDto::from)
                .toList();
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseResponseDto> getById(@PathVariable Long id) {
        Course course = courseService.findById(id)
                .orElseThrow(() -> new CourseNotFoundException(id));
        return ResponseEntity.ok(CourseResponseDto.from(course));
    }

    @PostMapping
    public ResponseEntity<CourseResponseDto> create(@RequestBody CreateCourseDto createCourseDto) {
        Course course = courseService.create(createCourseDto.toCourse());
        return ResponseEntity.status(HttpStatus.CREATED).body(CourseResponseDto.from(course));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        courseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}