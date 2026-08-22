package co.Proyecto_Backendll.application.service;

import co.Proyecto_Backendll.domain.Student;
import co.Proyecto_Backendll.domain.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Optional<Student> updateStudent(Student student) {
        if (student == null || student.getId() == null) {
            return Optional.empty();
        }

        return studentRepository.findById(student.getId())
                .map(existingStudent -> studentRepository.save(student));
    }

    public void deleteStudentById(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
        }
    }

    public boolean existsByEmail(String email) {
        return studentRepository.existsByEmail(email);
    }
}
