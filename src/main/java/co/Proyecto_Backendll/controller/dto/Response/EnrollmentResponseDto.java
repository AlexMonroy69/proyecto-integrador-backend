package co.Proyecto_Backendll.controller.dto.Response;

import co.Proyecto_Backendll.domain.Enrollment;

import java.time.LocalDate;

public record EnrollmentResponseDto(
        Long id,
        co.Proyecto_Backendll.domain.Student studentId,
        co.Proyecto_Backendll.domain.Course courseId,
        LocalDate enrollmentDate,
        co.Proyecto_Backendll.domain.EnrollmentStatus status
) {
    public static EnrollmentResponseDto from(Enrollment enrollment) {
        return new EnrollmentResponseDto(
                enrollment.getId(),
                enrollment.getStudent(),
                enrollment.getCourse(),
                enrollment.getEnrollmentDate(),
                enrollment.getStatus()
        );
    }
}
