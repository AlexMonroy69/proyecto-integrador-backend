package co.Proyecto_Backendll.controller.dto;

import co.Proyecto_Backendll.domain.Student;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record UpdateStudentDto(
        String firstName,
        String lastName,
        String email,

        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate birthDate
) {
    public Student toStudent(Long id) {
        return new Student(id, firstName, lastName, email, birthDate);
    }
}