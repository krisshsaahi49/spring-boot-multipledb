# Spring Boot Multi-DataSource Configuration

## Overview
This project demonstrates how to configure **multiple databases** in a Spring Boot application using **Spring Data JPA**. The application supports three databases:

1. **First Database** (MySQL)
2. **Second Database** (PostgreSQL)
3. **Third Database** (Configurable)

Each database has a separate **DataSource, EntityManagerFactory, and TransactionManager** configuration.

---

## Setup Instructions

### 1️⃣ Prerequisites
Before running the project, ensure you have the following installed:
- **Java 17+**
- **Maven 3.6+**
- **MySQL Server**
- **PostgreSQL Server**

---

### 2️⃣ Configure Database Properties

Modify the `application-dev.yaml` file to provide your **database credentials** (host, username, and password):

```yaml
spring:
  datasource:
    first:
      jdbcUrl: jdbc:mysql://<MYSQL_HOST>:<PORT>/<DB_NAME>
      username: <MYSQL_USER>
      password: <MYSQL_PASSWORD>
      driverClassName: com.mysql.cj.jdbc.Driver

    second:
      jdbcUrl: jdbc:postgresql://<POSTGRES_HOST>:<PORT>/<DB_NAME>
      username: <POSTGRES_USER>
      password: <POSTGRES_PASSWORD>
      driverClassName: org.postgresql.Driver

    third:
      jdbcUrl: jdbc:<DB_TYPE>://<HOST>:<PORT>/<DB_NAME>
      username: <USERNAME>
      password: <PASSWORD>

  jpa:
    hibernate:
      ddl-auto: update
```

🔹 **Replace placeholders** (`<MYSQL_HOST>`, `<POSTGRES_USER>`, etc.) with actual values.

---

### 3️⃣ Project Structure

📂 **Project Directory**
```
multiple-db/
│── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/multiple_db/multiple_db/
│   │   │   │   ├── config/
│   │   │   │   │   ├── FirstDatabaseConfig.java
│   │   │   │   │   ├── SecondDatabaseConfig.java
│   │   │   │   │   ├── ThirdDatabaseConfig.java
│   │   │   │   ├── repository/
│   │   │   │   │   ├── first/
│   │   │   │   │   ├── second/
│   │   │   │   │   ├── third/
│   │   │   │   ├── model/
│   │   │   │   │   ├── first/
│   │   │   │   │   ├── second/
│   │   │   │   │   ├── third/
│   │   │   ├── MultipleDbApplication.java
│   ├── resources/
│   │   ├── application.yaml
│   │   ├── application-dev.yaml
```

---

### 4️⃣ Running the Application

#### 🏃 Run Locally
Execute the following command:
```sh
mvn spring-boot:run
```

#### 🚀 Build and Run JAR
To package and run the application as a JAR file:
```sh
mvn clean package
java -jar target/multiple-db-0.0.1-SNAPSHOT.jar
```

---

### 5️⃣ Database Configurations
Each database is configured separately in `dbconfig` package:
- **FirstDatabaseConfig.java** → Configures MySQL database.
- **SecondDatabaseConfig.java** → Configures PostgreSQL database.
- **ThirdDatabaseConfig.java** → Configurable for another DB.

Each class defines:
✔️ **DataSource**
✔️ **EntityManagerFactory**
✔️ **TransactionManager**

---

### 6️⃣ API Endpoints (Optional)
You can create REST controllers that interact with different databases.

Example:
```java
@RestController
@RequestMapping("/api/first-db")
public class FirstDbController {

    @Autowired
    private FirstDbService firstDbService;
    
    @GetMapping("/data")
    public List<FirstEntity> getData() {
        return firstDbService.getAllData();
    }
}
```

---

### 7️⃣ Troubleshooting
- If `application.yaml` is committed by mistake, remove it from git tracking:
```sh
git rm --cached src/main/resources/application.yaml
```
- **Connection Issues:** Ensure your database is running and credentials are correct.

---

### 🎯 Conclusion
This Spring Boot project demonstrates how to work with multiple databases using **Spring Data JPA**. Modify the YAML file, define entities, and create repositories for different databases.

Happy coding! 🚀

