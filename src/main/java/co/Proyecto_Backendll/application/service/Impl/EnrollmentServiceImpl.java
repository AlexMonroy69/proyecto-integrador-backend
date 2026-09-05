package co.Proyecto_Backendll.application.service.Impl;

import co.Proyecto_Backendll.domain.repository.EnrollmentRepository;
import co.Proyecto_Backendll.application.service.EnrollmentService;

public class EnrollmentServiceImpl extends EnrollmentService {

    public EnrollmentServiceImpl(EnrollmentRepository enrollmentRepository) {
        super(enrollmentRepository);
    }

}
