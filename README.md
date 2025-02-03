# r1-Ortega Miguel Ortega

# API Rest de Cuentas Bancarias

API de gestión de cuentas bancarias desarrollada con Spring Boot (Java), Maven y MySQL.  
Este proyecto fue desarrollado como parte del Reto 1 de Backend, el cual consistía en construir una API Rest que permitiera consultar, crear, modificar y eliminar cuentas bancarias.

---

## 🛠️ Tecnologías Utilizadas

- **Lenguaje**: Java 21
- **Framework**: Spring Boot 3.4.2
- **Gestor de Dependencias**: Maven
- **Base de Datos**: MySQL
- **Dependencias**:
  - Lombok (simplificación de código)
  - Spring Data JPA (persistencia de datos)
  - Spring Web (construcción de APIs REST)
  - Spring Boot DevTools (desarrollo ágil)

---

## 📋 Requisitos de Instalación

---

### 1. **MySQL Server**

- **Descargar**: [MySQL Installer](https://dev.mysql.com/downloads/file/?id=536788)
- **Configurar `MYSQL_HOME`**:
  - **Windows**:
    1.  Instala MySQL.
    2.  Ve a **Panel de Control > Sistema > Configuración avanzada del sistema > Variables de entorno**.
    3.  Crea una nueva variable de entorno:
        - **Nombre**: `MYSQL_HOME`
        - **Valor**: Ruta donde instalaste MySQL, por ejemplo `C:\Program Files\MySQL\MySQL Server 8.0`.
  4. **Actualizar `PATH`**:
     - Agrega `C:\\MySQL\MySQL Server 8.0\bin` a la variable `Path`.
  - **macOS/Linux**:
    1.  Instala MySQL.
    2.  Abre tu archivo `.bashrc` o `.zshrc` y agrega:
        ```bash
        export MYSQL_HOME=/path/to/mysql
        ```

---

### 2. **Java Development Kit (JDK) 21**

- **Descargar**: [JDK 21](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)
- **Configurar `JAVA_HOME`**:
  - **Windows**:
    1.  Instala el JDK.
    2.  Ve a **Panel de Control > Sistema > Configuración avanzada del sistema > Variables de entorno**.
    3.  Crea una nueva variable de entorno:
        - **Nombre**: `JAVA_HOME`
        - **Valor**: Ruta donde instalaste el JDK, por ejemplo `C:\Program Files\Java\jdk-21`.
  - **macOS/Linux**:
    1.  Instala el JDK.
    2.  Abre tu archivo `.bashrc` o `.zshrc` y agrega:
        ```bash
        export JAVA_HOME=/path/to/jdk
        ```

### 3. **Maven**

- **Descargar**: [Maven Binary ZIP](https://maven.apache.org/download.cgi)
- **Instalar**:
  1.  Extrae el archivo ZIP en una carpeta, por ejemplo `C:\apache-maven-3.9.9`.
  2.  **Configurar `MAVEN_HOME`**:
      - **Windows**:
        1. Ve a **Panel de Control > Sistema > Configuración avanzada del sistema > Variables de entorno**.
        2. Crea una nueva variable de entorno:
           - **Nombre**: `MAVEN_HOME`
           - **Valor**: Ruta donde descomprimiste Maven, por ejemplo `C:\apache-maven-3.9.9`.
      3. **Actualizar `PATH`**:
         - Agrega `C:\apache-maven-3.9.9\bin` a la variable `Path`.
  - **macOS/Linux**:
    1.  Abre tu archivo `.bashrc` o `.zshrc` y agrega:
        ```bash
        export MAVEN_HOME=/path/to/maven
        export PATH=$MAVEN_HOME/bin:$PATH
        ```
- **Verificación**:
  - Ejecuta `mvn -v` en la terminal para verificar la instalación.

## Instalacion

---

## 🚀 Instalación y Configuración

### 1. Clonar el Repositorio

```bash
git clone https://github.com/Migueltester/r1-Ortega.git

```

### 2. Acceder a al directorio desde su linea de comandos

`cd r1-Ortega/Api-Cuentas`

### 2. Configurar la base de datos

- _1. Crear la base de datos_

```Mysql
CREATE DATABASE bancodb;
```

- _2. Configurar credenciales en **src/main/resources/application.properties** :_

```
spring.datasource.url=jdbc:mysql://localhost:3306/bancodb
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
```

### 3. Ejecutar Aplicacion

Una vez estas en el directorio
`cd r1-Ortega/Api-Cuentas`

Debes instalar las dependencias del proyecto
`mvn clean install`

y luego para iniciarlo

### 🛑IMPORTANTE🛑; Recuerda que antes de iniciarlo, verifica que el puerto 8080 no este en uso, en caso de estar en uso puedes realizar lo siguiente;

1. Verificar si esta en uso

```bash
netstat -ano | findstr :8080
```

2. Ver que proceso se esta realizando con ese puerto, copiar el PID y remplazarlo
   ejemplo

```bash
tasklist /FI "PID eq 5220"
```

3. Terminar el proceso

```bash
taskkill /F /PID 5220

```

### Ejecutar proyecto

Recuerde ejecutarlo desde el directorio donde lo guardo desde el cmd
ejemplo

`C:\Users\us\Proyecto\r1-Ortega\Api-Cuentas`

```bash
mvn spring-boot:run
```

La aplicación se iniciará en [http://localhost:8080](http://localhost:8080).
_nota: Desde esa direeción, no contiene nada ya que es una API, puedes omitirla_

---

## 📚 Estructura de la Base de Datos

La tabla `cuenta` se crea automáticamente al iniciar la aplicación usando `data.sql` en /resourse:

```sql
-- data.sql
Create table if not exists cuenta (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre_Cliente VARCHAR(100) NOT NULL,
    numero_Cuenta VARCHAR(13) NOT NULL UNIQUE,
    saldo DECIMAL(10,2) NOT NULL,
    estado boolean NOT NULL
);
```

```sql
-- data.sql
INSERT INTO cuenta (nombre_Cliente, numero_Cuenta, saldo, estado)
VALUES
    ('Miguel Ortega', '040434565403', 1000.0, true),
    ('Cristal Almanza', '030434565403', 2000.0, true);

```

---

## 📡 Endpoints de la API

| Método | Endpoint                                   | Descripción                             |
| ------ | ------------------------------------------ | --------------------------------------- |
| GET    | http://localhost:8080/api/v1/accounts      | Lista todas las cuentas.                |
| GET    | http://localhost:8080/api/v1/accounts/{id} | Obtiene una cuenta por ID.              |
| POST   | http://localhost:8080/api/v1/accounts      | Crea una nueva cuenta.                  |
| PUT    | http://localhost:8080/api/v1/accounts/{id} | Actualiza nombre o saldo de una cuenta. |
| DELETE | http://localhost:8080/api/v1/accounts/{id} | Desactiva una cuenta (no la elimina).   |

## 📝 Ejemplos de Uso Utilizando Postman, Insomnia, el de su gusto

### Obtener una cuenta (Get)

GET http://localhost:8080/api/v1/accounts

### Crear una Cuenta por su id (Get) remplazar el id

GET http://localhost:8080/api/v1/accounts/id

### Crear una Cuenta (POST)

POST http://localhost:8080/api/v1/accounts

```json
{
  "nombreCliente": "Fernando Castillo",
  "numeroCuenta": "040934569403",
  "saldo": 10000.0
}
```

**Respuesta:**

```json
{
  "id": 3,
  "nombreCliente": "Fernando Castillo",
  "numeroCuenta": "040934569403",
  "saldo": 10000.0,
  "estado": true
}
```

### Actualizar Saldo (PUT)

PUT http://localhost:8080/api/v1/accounts/{id}

**Ejemplo de uso:**

```json
{
  "saldo": 2500.0
}
```

**Respuesta:**

```json
{
  "id": 3,
  "nombreCliente": "Fernando Castillo",
  "numeroCuenta": "040934569403",
  "saldo": 2500.0,
  "estado": true
}
```

### Desactivar una Cuenta (DELETE) remplazar el id

DELETE http://localhost:8080/api/v1/accounts/id

## 🛑 Reglas de Negocio

- El número de cuenta no se puede modificar.
- Al "eliminar" una cuenta (DELETE), se marca como inactiva (`estado: false`).
- El saldo no puede ser negativo.

Desarrollado por Miguel Ortega - 2024
Reto 1 Backend Creacion de API Rest con Spring boot (Java), Maven, Mysql

```

Este archivo incluye:
- Instrucciones claras de instalación y configuración.
- Descripción detallada de los endpoints.
- Ejemplos prácticos de solicitudes y respuestas.
- Reglas de negocio clave.
- Estructura de la base de datos.








```
