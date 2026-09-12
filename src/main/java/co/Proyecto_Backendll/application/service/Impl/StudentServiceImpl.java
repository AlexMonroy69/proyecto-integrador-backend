package co.Proyecto_Backendll.application.service.Impl;

import co.Proyecto_Backendll.application.service.StudentService;
import co.Proyecto_Backendll.domain.Course;
import co.Proyecto_Backendll.domain.Student;
import co.Proyecto_Backendll.domain.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public  class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    // Inyección correcta del repositorio de estudiantes
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student create(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Course create(Course course) {
        return null;
    }

    @Override
    public Optional<Student> update(Student student) {
        if (studentRepository.existsById(student.getId())) {
            return Optional.of(studentRepository.save(student));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Course> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Course> update(Course course) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }

    @Override
    public boolean existsByEmail(String email) {
        return false;
    }

    @Override
    public List<Course> findAll() {
        return List.of();
    }

    @Override
    public Optional<Student> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public boolean existsByStudentId(Long studentId) {
        return false;
    }
}
