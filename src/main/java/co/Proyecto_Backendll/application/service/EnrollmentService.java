package co.Proyecto_Backendll.application.service;

import co.Proyecto_Backendll.domain.Enrollment;
import co.Proyecto_Backendll.domain.repository.EnrollmentRepository;

import java.util.List;
import java.util.Optional;

public class EnrollmentService implements EnrollmentRepository {

    EnrollmentRepository enrollmentRepository;
    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }


    @Override
    public List<Enrollment> findAll() {
        return List.of();
    }

    @Override
    public Optional<Enrollment> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public Enrollment save(Enrollment enrollment) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Optional<Enrollment> update(Enrollment enrollment) {
        return Optional.empty();
    }

    @Override
    public boolean existsByEnrollmentId(Long enrollmentId) {
        return false;
    }
}
