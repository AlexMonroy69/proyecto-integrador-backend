package co.Proyecto_Backendll.domain.repository;

import co.Proyecto_Backendll.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    List<Student> findAll();

    Optional<Student> findById(Long Id);

    Student save(Student student);

    void deleteById(Long id);

    boolean existsByEmail(String email);

}
