package co.Proyecto_Backendll.domain.repository.impl;

import co.Proyecto_Backendll.domain.Student;
import co.Proyecto_Backendll.domain.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public  class StudentRepositoryimpl {

    private final StudentRepository studentRepository;

    public StudentRepositoryimpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public Optional<Student> findById(Long id) {

        return studentRepository.findById(id);
    }
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }


    public boolean existsByEmail(String email) {
        return studentRepository.existsByEmail(email);
    }


    public boolean existsById(Long id) {
        return studentRepository.existsById(id);
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

}
