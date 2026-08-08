package co.Proyecto_Backendll.domain.repository;

import co.Proyecto_Backendll.domain.Course;

import java.util.List;
import java.util.Optional;

public interface CourseRepository {

    List<Course> findAll();
    Optional<Course> findByName(String name);
    Course save(Course course);
    void deleteById(Long id);
    Optional<Course> update(Course course);
    boolean existsByCourseId(Long courseId);
    Optional<Course> findById(Long id);
}
