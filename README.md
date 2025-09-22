# Proyecto-Poo2025
Proyecto para la materia de Programación Orientada a Objetos 

# 📦 Sistema de Inventario — Spring Boot + MySQL

Este proyecto es una aplicación desarrollada en **Java** con **Spring Boot**, diseñada para gestionar inventarios mediante el control de productos, proveedores y movimientos de stock. Utiliza **MySQL** como base de datos y **Maven** para la gestión de dependencias.

## 🧩 Entidades Principales

- **Proveedor**: Información de los proveedores que suministran productos.
- **Producto**: Artículos disponibles en el inventario.
- **Movimiento**: Registro de entradas y salidas de productos.
- **Tipo**: Clasificación del movimiento (entrada, salida, ajuste, devolución).

## 🛠️ Tecnologías Utilizadas

| Componente           | Tecnología         |
|----------------------|--------------------|
| Lenguaje             | Java               |
| Framework            | Spring Boot        |
| Base de datos        | MySQL              |
| ORM                  | Spring Data JPA    |
| Build Tool           | Maven              |
| Control de versiones | Git                |

## 🚀 Cómo ejecutar el proyecto

1. **Clona el repositorio**:
   ```bash
   git clone https://github.com/RM24004/Proyecto-Poo2025.git
## Configura la base de datos MySQL:

Crea una base de datos llamada **inventario_db**.

Actualiza las credenciales en `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/inventario_db
spring.datasource.username=RM24004
spring.datasource.password=admin
```
```
2. **Clona el repositorio**:
src/
├── main/
│   ├── java/Poo_2025/Inventario/
│   │   ├── Controller/
│   │   ├── Modelo/
│   │   ├── Servicio/
│   │   └── InventarioAplication.java
│   └── resources/
│       ├── application.properties
│       └── templates/
└── test/
```

📈 Funcionalidades
- CRUD de productos y proveedores.
- Registro de movimientos con validación de stock.
- Filtrado por tipo de movimiento.
- Historial de operaciones por producto/proveedor.
- Reportes básicos de inventario.

🧪 Pruebas
Las pruebas se realizan utilizando Postman, permitiendo validar los endpoints REST de forma manual.
Se incluyen colecciones para:
- Crear, consultar, actualizar y eliminar productos y proveedores.
- Registrar movimientos de inventario (entradas, salidas, ajustes).
- Filtrar movimientos por tipo, fecha o producto.
- Verificar respuestas del backend y códigos de estado HTTP.
- Puedes importar la colección de Postman desde el archivo inventario.postman_collection.json incluido en el repositorio.

📌 Mejoras futuras
- API REST para integración con otros sistemas.
- Dashboard con gráficas.
