package co.Proyecto_Backendll.application.service;



import co.Proyecto_Backendll.domain.Course;
import co.Proyecto_Backendll.domain.Student;

import java.util.List;
import java.util.Optional;
public interface StudentService {

    Student create(Student student);
    Course create(Course course);
    void deleteById(Long id);
    boolean existsById(Long id);
    boolean existsByEmail(String email);
    List<Course> findAll();
    Optional<Student> findByName(String name);

    boolean existsByStudentId(Long studentId);

    List<Student> getAllStudents();
    Optional<Student> getStudentById(Long id);
    Optional<Student> update(Student student);
    Optional<Course> findById(Long id);
    Optional<Course> update(Course course);
}

