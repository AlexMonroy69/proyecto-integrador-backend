package co.Proyecto_Backendll.domain.repository;

import co.Proyecto_Backendll.domain.Enrollment;

import java.util.List;
import java.util.Optional;

public interface EnrollmentRepository {

    List<Enrollment> findAll();
    Optional<Enrollment> findByName(String name);
    Enrollment save(Enrollment enrollment);
    void deleteById(Long id);
    Optional<Enrollment> update(Enrollment enrollment);
    boolean existsByEnrollmentId(Long enrollmentId);
}
