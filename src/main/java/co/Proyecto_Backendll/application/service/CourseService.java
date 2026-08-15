package co.Proyecto_Backendll.application.service;

import co.Proyecto_Backendll.domain.Course;
import co.Proyecto_Backendll.domain.repository.CourseRepository;

import java.util.List;
import java.util.Optional;

public class CourseService {

    CourseRepository courseRepository;

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
        return courseRepository.update(course);
    }

    public void deleteCourseById(Long id) {
        if (courseRepository.findById(id).isPresent()) {
            courseRepository.deleteById(id);
        }
    }

    public boolean existsByCourseId(Course course) {
        if (courseRepository.findById(course.getId()).isPresent()) {
            return true;
        }
        return false;
    }
}