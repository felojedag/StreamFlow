## StreamFlow — Plataforma de Streaming

Sistema de microservicios para una plataforma de streaming desarrollado con **Spring Boot 3.3** y **Java 21**.  
Cada servicio es independiente, se comunica a través de un API Gateway y puede desplegarse en Railway.

---

## Servicios

| Servicio | Puerto (dev) | Base Path | Estado |
|---|---|---|---|
| streamflow-gateway | 8080 | — | ✅ Implementado |
| streamflow-servicio-usuarios | 8081 | `/api/usuarios` | ✅ Implementado |
| streamflow-servicio-auth | 8082 | `/api/auth` | ✅ Implementado |
| streamflow-servicio-catalogo | 8083 | `/api/catalogo` | ✅ Implementado |
| streamflow-servicio-favoritos | 8084 | `/api/favoritos` | ✅ Implementado |
| streamflow-servicio-historial | 8085 | `/api/historial` | ✅ Implementado |
| streamflow-servicio-notificaciones | 8086 | `/api/notificaciones` | ✅ Implementado |
| streamflow-servicio-pagos | 8087 | `/api/pagos` | ✅ Implementado |
| streamflow-servicio-reviews | 8088 | `/api/reviews` | ✅ Implementado |
| streamflow-servicio-suscripciones | 8089 | `/api/suscripciones` | ✅ Implementado |

---

## Descripción de cada servicio

### servicio-auth `:8082`
Autenticación de usuarios.
- `POST /api/auth/login` — Login y generación de token

### servicio-usuarios `:8081`
Gestión del registro y consulta de usuarios.
- `POST /api/usuarios` — Crear usuario
- `GET /api/usuarios` — Listar todos
- `GET /api/usuarios/{id}/existe` — Verificar si existe un usuario

### servicio-catalogo `:8083`
Catálogo de películas y series disponibles.
- `GET /api/catalogo/estado` — Estado del servicio
- *(CRUD de contenido)*

### servicio-pagos `:8087`
Procesamiento de pagos asociados a suscripciones.
- `POST /api/pagos` — Registrar pago
- `GET /api/pagos` — Listar pagos

### servicio-notificaciones `:8086`
Envío y consulta de notificaciones a usuarios.
- `GET /api/notificaciones/estado` — Estado del servicio

### servicio-suscripciones `:8089`
Gestión de planes y suscripciones activas.
- `POST /api/suscripciones` — Crear suscripción

### servicio-favoritos `:8084`
Lista personalizada de contenido favorito por usuario.
- `POST /api/favoritos` — Agregar a favoritos *(detecta duplicados)*
- `GET /api/favoritos` — Listar todos
- `GET /api/favoritos/usuario/{id}` — Favoritos de un usuario
- `DELETE /api/favoritos/{id}` — Eliminar de favoritos

### servicio-historial `:8085`
Registro del historial de reproducción con progreso.
- `POST /api/historial` — Registrar reproducción
- `GET /api/historial` — Listar todos
- `GET /api/historial/usuario/{id}` — Historial de un usuario *(ordenado por fecha desc)*
- `DELETE /api/historial/{id}` — Eliminar registro

### servicio-reviews `:8088`
Reseñas y calificaciones (1–5 estrellas) de contenido.
- `POST /api/reviews` — Crear reseña
- `GET /api/reviews` — Listar todas
- `GET /api/reviews/usuario/{id}` — Reviews de un usuario
- `GET /api/reviews/contenido/{id}` — Reviews de un contenido
- `DELETE /api/reviews/{id}` — Eliminar reseña

---

## Stack tecnológico

| Tecnología | Uso |
|---|---|
| Java 21 | Lenguaje principal |
| Spring Boot 3.3 | Framework base |
| Spring Data JPA | Persistencia |
| Spring Cloud Gateway | API Gateway |
| H2 Database | Base de datos in-memory |
| SpringDoc OpenAPI | Documentación Swagger |
| Maven | Gestión de dependencias |
| Railway | Deploy en producción |

---

## Cómo ejecutar localmente

### Prerrequisitos
- Java 21+
- Maven 3.9+

### Levantar un servicio individual

```bash
cd streamflow-servicio-reviews
mvn spring-boot:run
```

Swagger disponible en: `http://localhost:8088/swagger-ui/index.html`

### Levantar todos los servicios

Abre una terminal por servicio (o usa IntelliJ con múltiples Run Configurations):

```bash
# Terminal 1 — Gateway
cd streamflow-gateway && mvn spring-boot:run

# Terminal 2 — Usuarios
cd streamflow-servicio-usuarios && mvn spring-boot:run

# Terminal 3 — Auth
cd streamflow-servicio-auth && mvn spring-boot:run

# ... (repetir para cada servicio)
```


---

## Deploy en Railway

Cada servicio se despliega como un **Railway Service** independiente dentro del mismo proyecto.

### Variables de entorno requeridas

| Variable | Valor |
|---|---|
| `SPRING_PROFILES_ACTIVE` | `prod` |
| `PORT` | *(Railway lo inyecta automáticamente)* |

### Dockerfile (raíz de cada servicio)

```dockerfile
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn package -DskipTests -B

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
```

### Pasos resumidos
1. Subir cada servicio a GitHub (repo o subdirectorio)
2. Crear nuevo Service en Railway → conectar GitHub
3. Configurar *Root Directory* si es mono-repo
4. Agregar variables de entorno
5. Generar dominio público en *Settings → Networking*
6. Actualizar el `application-prod.yml` del gateway con las URLs de Railway

---

## Equipo

Sebastian Pérez - Desarrollador

Felipe Ojeda - Desarrollador
