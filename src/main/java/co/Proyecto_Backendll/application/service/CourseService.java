package co.Proyecto_Backendll.application.service;

import co.Proyecto_Backendll.domain.Course;
import co.Proyecto_Backendll.domain.model.CourseModel;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    Course create(Course course);

    CourseModel create(CourseModel course);

    void deleteById(Long id);
    boolean existsById(Long id);
    List<Course> findAll();
    Optional<Course> findById(Long id);
    Optional<Course> update(Course course);

    Optional<CourseModel> update(CourseModel course);
}
