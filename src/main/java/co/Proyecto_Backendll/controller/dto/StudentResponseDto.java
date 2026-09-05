package co.Proyecto_Backendll.controller.dto;

import co.Proyecto_Backendll.domain.Student;
import java.time.LocalDate;

public record StudentResponseDto(Long id, String firstName, String lastName, String email, LocalDate birthDate) {

    public static StudentResponseDto from(Student student) {
        return new StudentResponseDto(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getBirthDate()
        );
    }
}

