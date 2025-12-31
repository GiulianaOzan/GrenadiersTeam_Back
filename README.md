# El Buen Sabor – Backend (API REST)
Proyecto grupal — **GRENADIERS_TEAM_BACK · Sprint 4**

Este proyecto fue desarrollado como trabajo integrador de la materia Desarrollo de Software (3to año) de la carrera Ingeniería en Sistemas de Información.

Para su desarrollo se realizó un análisis del sistema planteado, incluyendo requisitos e historias de usuario, y se complementó con el modelado del dominio mediante un diagrama de clases. En este repositorio se encuentra la implementación del **backend**, con las funcionalidades enumeradas a continuación.

## Funcionalidades principales 
- Autenticación y autorización mediante **JWT**
- Gestión de usuarios con roles
- API REST para el flujo completo del sistema
- Arquitectura en capas (controllers, services, repositories, DTOs)
- Base de datos en memoria **H2**
- Colecciones de Postman para pruebas de la API
- Dockerfile para ejecución en contenedores

## Tecnologías utilizadas
- Java
- Spring Boot
- Spring Security + JWT
- Gradle
- H2 Database
- Docker
- Postman

## Estructura del proyecto

```text
.
├── ArchivosPostman/              # Colecciones para probar la API
├── src/
│   ├── main/
│   │   ├── java/com/utn/sprint3/
│   │   │   ├── Auth/             # Autenticación y autorización
│   │   │   ├── Jwt/              # Manejo de tokens JWT
│   │   │   ├── config/           # Configuración de seguridad y beans
│   │   │   ├── controllers/      # Endpoints REST
│   │   │   ├── dtos/             # Objetos de transferencia de datos
│   │   │   ├── entidades/        # Entidades del dominio
│   │   │   ├── enums/            # Enumeraciones del sistema
│   │   │   ├── repositorios/     # Acceso a datos (JPA)
│   │   │   └── services/         # Lógica de negocio
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── Dockerfile
├── build.gradle
└── README.md
```

# Equipo
-  Murello, Facundo
-  Licciardi, Ignacio
-  Ozan, Giuliana
-  Sanz, Rodrigo
-  Rodriguez, Paula
-  Rodriguez, Facundo
