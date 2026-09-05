package co.Proyecto_Backendll.application.service.Impl;

import co.Proyecto_Backendll.application.service.CourseService;
import co.Proyecto_Backendll.domain.repository.CourseRepository;

public class CourseServiceImpl extends CourseService {

    public CourseServiceImpl(CourseRepository courseRepository) {
        super(courseRepository);
    }

}