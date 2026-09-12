package co.Proyecto_Backendll.controller.dto;

import co.Proyecto_Backendll.domain.Course;

public record CreateCourseDto(
        String code,
        String name,
        String description,
        Integer maxCapacity
)
{
    public Course toCourse() {
        return new Course(null, code, name, description, maxCapacity);
    }
}
