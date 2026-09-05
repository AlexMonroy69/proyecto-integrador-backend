package co.Proyecto_Backendll.application.service;

import co.Proyecto_Backendll.domain.Enrollment;
import co.Proyecto_Backendll.domain.repository.EnrollmentRepository;

import java.util.List;
import java.util.Optional;

public class EnrollmentService {

    protected final EnrollmentRepository enrollmentRepository;

    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    public List<Enrollment> findAll() {
        return enrollmentRepository.findAll();
    }

    public Optional<Enrollment> findById(Long id) {
        return enrollmentRepository.findById(id);
    }

    public Enrollment save(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    public void deleteById(Long id) {
        enrollmentRepository.deleteById(id);
    }

    public Optional<Enrollment> update(Enrollment enrollment) {
        if (enrollment.getId() != null && enrollmentRepository.existsById(enrollment.getId())) {
            return Optional.of(enrollmentRepository.save(enrollment));
        }
        return Optional.empty();
    }

    public boolean existsByEnrollmentId(Long enrollmentId) {
        return enrollmentRepository.existsById(enrollmentId);
    }

}


