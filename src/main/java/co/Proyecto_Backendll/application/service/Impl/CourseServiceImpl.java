package co.Proyecto_Backendll.application.service.Impl;

import co.Proyecto_Backendll.application.service.CourseService;
import co.Proyecto_Backendll.domain.Course;
import co.Proyecto_Backendll.domain.model.CourseModel;
import co.Proyecto_Backendll.domain.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    // Inyección de dependencias a través del constructor
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course create(Course course) {
        // Aquí pasamos correctamente la entidad Course al repositorio
        return courseRepository.save(course);
    }

    @Override
    public CourseModel create(CourseModel course) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        // Verificamos si existe antes de intentar eliminarlo
        if (courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
        } else {
            // Opcional: Lanzar tu CourseNotFoundException aquí
            throw new RuntimeException("El curso con ID " + id + " no fue encontrado.");
        }
    }

    @Override
    public boolean existsById(Long id) {
        return courseRepository.existsById(id);
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> findById(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        if (course.isPresent()) {
            return course;
        }
        return Optional.empty();
    }

    @Override
    public Optional<Course> update(Course course) {
        if (course.getId() != null && courseRepository.existsById(course.getId())) {
            return Optional.of(courseRepository.save(course));
        }
        return Optional.empty();
    }

    @Override
    public Optional<CourseModel> update(CourseModel courseModel) {
        if (courseModel.getCourseId() != null && courseRepository.existsById(courseModel.getCourseId())) {
            Course entity = new Course();
            entity.setId(courseModel.getCourseId());
            courseRepository.save(entity);
            return Optional.of(courseModel);
        }
        return Optional.empty();
    }

}