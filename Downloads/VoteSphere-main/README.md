# VoteSphere 🗳️

A modern online voting application built using **Spring Boot**, **Thymeleaf**, **Spring Security**, and **MySQL**.

VoteSphere allows users to securely register, log in, and vote for candidates while providing an admin dashboard to monitor voting statistics.

---

# 🚀 Features

## User Features

* User Registration
* Secure Login Authentication
* Vote for Candidates
* One User = One Vote
* User Dashboard
* Vote Status Tracking
* Responsive UI

## Admin Features

* Admin Login
* Dashboard Analytics
* View Candidate Vote Counts
* Real-Time Vote Monitoring

---

# 🛠️ Tech Stack

| Technology      | Usage                          |
| --------------- | ------------------------------ |
| Java            | Backend Logic                  |
| Spring Boot     | Application Framework          |
| Spring Security | Authentication & Authorization |
| Thymeleaf       | Frontend Templating            |
| HTML/CSS        | UI Design                      |
| Bootstrap 5     | Responsive Design              |
| MySQL           | Database                       |
| Hibernate / JPA | ORM                            |
| Maven           | Dependency Management          |

---

# 🎨 UI Highlights

* Modern Glassmorphism UI
* Responsive Design
* Bootstrap Integrated Layout
* Clean Admin Dashboard
* Professional Login & Registration Pages
* Interactive Voting Interface

---

# 📂 Project Structure

```text
VoteSphere
 ├── .mvn
 ├── src
 │   ├── main
 │   │   ├── java
 │   │   ├── resources
 │   │   │   ├── static
 │   │   │   └── templates
 │   └── test
 ├── pom.xml
 ├── mvnw
 └── mvnw.cmd
```

---

# ⚙️ Requirements

* Java 11+
* IntelliJ IDEA / Eclipse / STS
* MySQL Server
* Maven

---

# 🗄️ Database Setup

Create a MySQL database:

```sql
CREATE DATABASE springbootnew;
```

Update your database credentials inside:

```text
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/springbootnew
spring.datasource.username=root
spring.datasource.password=yourpassword
```

---

# ▶️ Run The Project

## Clone Repository

```bash
git clone https://github.com/Nishuk2005/VoteSphere.git
```

## Open Project

Open the project in IntelliJ IDEA or Spring Tool Suite.

## Run Application

Run:

```text
VoteSphereApplication.java
```

## Open Browser

```text
http://localhost:9002
```

(Port may vary based on your application.properties)

---

# 🔐 Admin Credentials

```text
Username: admin
Password: admin
```

---

# 📸 Application Modules

* Home Page
* Register Page
* Login Page
* User Dashboard
* Voting Page
* Admin Dashboard
* About Page

---

# 🌟 Future Improvements

* Email Verification
* Forgot Password
* JWT Authentication
* Live Voting Charts
* Candidate Images
* Result Graphs
* Deployment Support
* Role-Based Access

---

# 👩‍💻 Developed By

**Nishu Kumari**

GitHub Repository:
[https://github.com/Nishuk2005/VoteSphere](https://github.com/Nishuk2005/VoteSphere)
