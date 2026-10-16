# Proyecto Backend II

API REST para la gestión de estudiantes, cursos y matrículas.

**Stack:** Java 21, Spring Boot 4, Spring Data JPA, MySQL (XAMPP).

## Cómo ejecutarlo

1. Iniciar MySQL desde XAMPP y crear la base de datos `mi_base_de_datos`.
2. Revisar el usuario y la contraseña en `src/main/resources/application.yml`.
3. Ejecutar desde IntelliJ (`PbaApplication`) o con:

```
powershell -ExecutionPolicy Bypass -File run.ps1
```

La API queda en `http://localhost:8888`.

## Endpoints

| Método | Ruta | Descripción |
|--------|------|-------------|
| GET | `/students` | Listar estudiantes |
| GET | `/students/{id}` | Obtener estudiante |
| POST | `/students` | Crear estudiante |
| PUT | `/students/{id}` | Actualizar estudiante |
| DELETE | `/students/{id}` | Eliminar estudiante |
| GET | `/courses` | Listar cursos |
| GET | `/courses/{id}` | Obtener curso |
| POST | `/courses` | Crear curso |
| PUT | `/courses/{id}` | Actualizar curso |
| DELETE | `/courses/{id}` | Eliminar curso |
| GET | `/enrollments` | Listar matrículas |
| GET | `/enrollments/{id}` | Obtener matrícula |
| POST | `/enrollments` | Matricular estudiante |
| PUT | `/enrollments/{id}` | Cambiar estado de la matrícula |
| DELETE | `/enrollments/{id}` | Eliminar matrícula |

### Ejemplos

Crear estudiante:

```json
{
  "firstName": "Juan",
  "lastName": "Pérez",
  "email": "juan@example.com",
  "phone": "3001234567",
  "birthDate": "2000-01-15"
}
```

Crear curso:

```json
{
  "code": "BACK-II",
  "name": "Backend II",
  "description": "Spring Boot y JPA",
  "maxCapacity": 30
}
```

Matricular (la fecha es opcional, por defecto es hoy):

```json
{
  "studentId": 1,
  "courseId": 1,
  "enrollmentDate": "2026-10-15"
}
```

Cambiar estado (`ACTIVE`, `CANCELLED`, `COMPLETE`):

```json
{
  "status": "CANCELLED"
}
```

## Reglas de negocio

- El email del estudiante y el código del curso no se pueden repetir.
- Un estudiante no puede tener dos matrículas vigentes en el mismo curso (las canceladas no cuentan).
- No se puede matricular si el curso ya llegó a su cupo máximo (`maxCapacity`).
- No se puede bajar el cupo de un curso por debajo de las matrículas activas que tiene.
- Una matrícula completada no se puede modificar y una cancelada no se puede pasar a completada.

## Respuestas de error

| Código | Cuándo |
|--------|--------|
| 400 | Datos inválidos o JSON mal formado |
| 404 | El recurso no existe |
| 409 | Email o código duplicado, matrícula repetida o curso sin cupo |
