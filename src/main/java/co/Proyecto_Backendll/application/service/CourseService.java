package co.Proyecto_Backendll.application.service;

import co.Proyecto_Backendll.domain.Course;
import co.Proyecto_Backendll.domain.repository.CourseRepository;

import java.util.List;
import java.util.Optional;

public class CourseService {

    protected final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseByName(String name) {
        return courseRepository.findByName(name);
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public Optional<Course> updateCourse(Course course) {
        if (course.getId() != null && courseRepository.existsById(course.getId())) {
            return Optional.of(courseRepository.save(course));
        }
        return Optional.empty();
    }

    public void deleteCourseById(Long id) {
        if (courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
        }
    }

    public Course existsByCourseId(Course course) {
        if (course.getId() != null && courseRepository.existsById(course.getId())) {
            return courseRepository.findById(course.getId()).get();
        }
        return courseRepository.save(course);
    }

    public Course save(Course course) {
        return createCourse(course);
    }

}
