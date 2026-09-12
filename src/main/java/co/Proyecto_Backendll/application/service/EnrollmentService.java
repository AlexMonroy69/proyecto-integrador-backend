package co.Proyecto_Backendll.application.service;

import co.Proyecto_Backendll.domain.Enrollment;

import java.util.List;
import java.util.Optional;

public interface EnrollmentService {
    Enrollment create(Enrollment enrollment);
    void deleteById(Long id);
    boolean existsById(Long id);
    List<Enrollment> findAll();
    Optional<Enrollment> findById(Long id);
    Optional<Enrollment> update(Enrollment enrollment);
}
