package co.Proyecto_Backendll.application.service;

import co.Proyecto_Backendll.domain.Student;
import co.Proyecto_Backendll.domain.repository.StudentRepository;

import java.util.List;
import java.util.Optional;




public class StudentService implements StudentRepository {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return List.of();
    }

    @Override
    public Optional<Student> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public boolean existsByStudentId(Long studentId) {
        return studentRepository.existsByStudentId(studentId);
    }

    @Override
    public boolean existsByEmail(String email) {
        return studentRepository.existsByEmail(email);
    }

    @Override
    public void deleteStudentById(Long id) {
        if (studentRepository.existsByStudentId(id)) {
            studentRepository.deleteById(id);
        }
    }

    @Override
    public Optional<Student> update(Student student) {
        if (studentRepository.existsByStudentId(student.getId())) {
            return Optional.of(studentRepository.save(student));
        }
        return Optional.empty();
    }
}