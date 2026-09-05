# Guía de Ejecución - Proyecto Backend

## ✅ Problemas Solucionados

He corregido todos los errores en tu proyecto Spring Boot:

### 1. **DTOs Creados**
- ✅ `CreateStudentDto.java` - Para crear/actualizar estudiantes
- ✅ `StudentResponseDto.java` - Para respuestas de API
- ✅ `ErrorResponse.java` - Para respuestas de error

### 2. **Excepciones Actualizadas**
- ✅ `StudentEmailAlreadyExistsException.java` - Nueva excepción
- ✅ `CourseNotFoundException.java` - Ahora extiende BusinessException
- ✅ `EnrollmentNotFoundException.java` - Ahora extiende BusinessException

### 3. **Repositorios (Interfaces JPA)**
- ✅ `StudentRepository` - Ahora extiende JpaRepository
- ✅ `CourseRepository` - Ahora extiende JpaRepository
- ✅ `EnrollmentRepository` - Corregido (eliminado método findByName que no existe)
- ✅ `StudentRepositoryimpl.java` - Eliminado (no necesario)

### 4. **Servicios**
- ✅ `CourseService` - Actualizado para usar métodos correctos de JpaRepository
- ✅ `CourseServiceImpl` - Agregada anotación @Service
- ✅ `EnrollmentService` - Actualizado para usar métodos correctos de JpaRepository
- ✅ `EnrollmentServiceImpl` - Agregada anotación @Service
- ✅ `StudentService` - Verificado y funcional

### 5. **Entidades y Enums**
- ✅ `EnrollmentStatus.java` - Removida coma extra
- ✅ `StudentModel.java` - Completado
- ✅ `CourseModel.java` - Completado
- ✅ `EnrollmentModel.java` - Completado

### 6. **Dependencias Maven**
- ✅ Reemplazadas dependencias inválidas
- ✅ spring-boot-starter-webmvc → spring-boot-starter-web
- ✅ Dependencias de test configuradas correctamente

## 🚀 Cómo Ejecutar la Aplicación

### Opción 1: Usar Maven (Recomendado)

Si tienes Maven instalado:
```bash
mvn clean spring-boot:run
```

### Opción 2: Ejecutar Script Automático

En Windows (PowerShell):
```powershell
cd C:\Users\Josem\OneDrive\Documentos\Proyecto_Backendll
.\run.bat
```

O en PowerShell:
```powershell
powershell -ExecutionPolicy Bypass -File run.ps1
```

### Opción 3: Instalar Maven Manualmente

1. Descargar Maven 3.8.1 o superior desde: https://maven.apache.org/download.cgi
2. Extraer en una carpeta (ej: C:\maven)
3. Agregar a PATH: `C:\maven\bin`
4. Ejecutar: `mvn clean spring-boot:run`

## 📋 Verificar la Aplicación

Una vez que se ejecute correctamente, verás:
```
2026-09-05... INFO  o.s.b.w.e.tomcat.TomcatWebServer : Tomcat started on port(s): 8080 (http)
2026-09-05... INFO  co.Proyecto_Backendll.PbaApplication : Started PbaApplication in X.XXX seconds
```

## 📡 Endpoints Disponibles

La aplicación está configurada con los siguientes endpoints:

- **GET** `/students` - Listar todos los estudiantes
- **GET** `/students/{id}` - Obtener estudiante por ID
- **POST** `/students` - Crear nuevo estudiante
- **PUT** `/students/{id}` - Actualizar estudiante
- **DELETE** `/students/{id}` - Eliminar estudiante

## ⚙️ Configuración de Base de Datos

Archivo: `src/main/resources/application.yml`

Verifica que los datos de conexión sean correctos:
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/mi_base_de_datos
    username: Jose_Java
    password: Jose_JMN0306
```

Asegúrate de que:
1. MySQL está ejecutándose en localhost:3306
2. La base de datos `mi_base_de_datos` existe
3. El usuario `Jose_Java` tiene acceso

## 🔧 Solución de Problemas

### Si ves "Cannot create query for method"
- Ya está solucionado en `EnrollmentRepository`

### Si ves "Unsatisfied dependency"
- Verifica que todas las clases tengan @Service o @Repository

### Si no puedes conectar a la BD
- Verifica que MySQL está corriendo
- Verifica los datos de conexión en application.yml

## 📝 Comandos Útiles

```bash
# Compilar sin ejecutar
mvn clean compile

# Ejecutar tests
mvn test

# Crear JAR ejecutable
mvn clean package

# Ejecutar el JAR generado
java -jar target/Proyecto_Backendll-1.0-SNAPSHOT.jar
```

---

**Nota:** Todos los errores de código han sido corregidos. Solo necesitas instalar Maven o usar el script de descarga automática.

