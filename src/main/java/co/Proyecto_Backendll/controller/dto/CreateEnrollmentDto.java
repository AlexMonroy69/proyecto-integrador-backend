package co.Proyecto_Backendll.controller.dto;

import co.Proyecto_Backendll.domain.Enrollment;

import java.time.LocalDate;

public record CreateEnrollmentDto(
        Long studentId,
        Long courseId,
        LocalDate enrollmentDate,
        String status
) {

    public Enrollment toEnrollment() {
        return new Enrollment(null, studentId, courseId, enrollmentDate, status);
    }
}
