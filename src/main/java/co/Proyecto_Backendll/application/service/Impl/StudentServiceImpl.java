package co.Proyecto_Backendll.application.service.Impl;

import co.Proyecto_Backendll.application.service.StudentService;
import co.Proyecto_Backendll.domain.repository.StudentRepository;
import org.springframework.stereotype.Service;


@Service
public class StudentServiceImpl extends StudentService {

    public StudentServiceImpl(StudentRepository studentRepository) {
        super(studentRepository);
    }

}
