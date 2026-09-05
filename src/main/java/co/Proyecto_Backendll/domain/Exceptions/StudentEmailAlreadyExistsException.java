package co.Proyecto_Backendll.domain.Exceptions;

public class StudentEmailAlreadyExistsException extends BusinessException {

    public StudentEmailAlreadyExistsException(String email) {
        super("Student with email: " + email + " already exists");
    }

    public StudentEmailAlreadyExistsException(String email, Throwable cause) {
        super("Student with email: " + email + " already exists", cause);
    }
}

