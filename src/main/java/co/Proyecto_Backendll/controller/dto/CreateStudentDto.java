package co.Proyecto_Backendll.controller.dto;

import co.Proyecto_Backendll.domain.Student;
import java.time.LocalDate;

public record CreateStudentDto(String firstName, String lastName, String email, LocalDate birthDate) {

    public Student toStudent() {
        return new Student(null, this.firstName, this.lastName, this.email, this.birthDate);
    }
}

