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

    public Optional<Enrollment> findByName(String name) {
        return enrollmentRepository.findByName(name);
    }

    public Enrollment save(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    public void deleteById(Long id) {
        enrollmentRepository.deleteById(id);
    }

    public Optional<Enrollment> update(Enrollment enrollment) {
        return enrollmentRepository.update(enrollment);
    }

    public boolean existsByEnrollmentId(Long enrollmentId) {
        return enrollmentRepository.existsByEnrollmentId(enrollmentId);
    }

}


