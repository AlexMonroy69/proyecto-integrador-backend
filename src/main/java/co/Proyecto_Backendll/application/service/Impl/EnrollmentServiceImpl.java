package co.Proyecto_Backendll.application.service.Impl;

import co.Proyecto_Backendll.application.service.EnrollmentService;
import co.Proyecto_Backendll.domain.Enrollment;
import co.Proyecto_Backendll.domain.repository.EnrollmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {


    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentServiceImpl(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    @Override
    public Enrollment create(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public void deleteById(Long id) {
        // Validación con IF
        if (enrollmentRepository.existsById(id)) {
            enrollmentRepository.deleteById(id);
        }
    }

    @Override
    public boolean existsById(Long id) {
        return enrollmentRepository.existsById(id);
    }

    @Override
    public List<Enrollment> findAll() {
        return enrollmentRepository.findAll();
    }

    @Override
    public Optional<Enrollment> findById(Long id) {
        return enrollmentRepository.findById(id); // JPA maneja la existencia internamente aquí
    }

    @Override
    public Optional<Enrollment> update(Enrollment enrollment) {
        // Validación con IF
        if (enrollmentRepository.existsById(enrollment.getId())) {
            return Optional.of(enrollmentRepository.save(enrollment));
        }
        return Optional.empty();
    }
}
