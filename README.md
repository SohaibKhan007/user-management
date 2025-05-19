# 🚀 User Management System

<div align="center">

![Java](https://img.shields.io/badge/Java-17+-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![H2 Database](https://img.shields.io/badge/H2-004088?style=for-the-badge&logo=h2&logoColor=white)

*A modern RESTful API for user management built with Spring Boot*

</div>

---

## 📋 Table of Contents
- [✨ Features](#-features)
- [🛠️ Technologies](#️-technologies)
- [🚀 Getting Started](#-getting-started)
- [📡 API Endpoints](#-api-endpoints)
- [✅ Validation Rules](#-validation-rules)
- [🔧 Error Handling](#-error-handling)
- [🤝 Contributing](#-contributing)

---

## ✨ Features

> **Clean RESTful APIs for seamless user management**

- 📋 **List Users**: Retrieve all users with a single GET request
- 👤 **Create Users**: Add new users with comprehensive validation
- 🛡️ **Data Validation**: Robust input validation with detailed error messages
- 🔄 **Exception Handling**: Graceful error handling with meaningful responses

---

## 🛠️ Technologies

<table>
<tr>
<td><strong>Backend</strong></td>
<td>
  <img src="https://img.shields.io/badge/Java-17-ED8B00?style=flat-square&logo=openjdk&logoColor=white" alt="Java">
  <img src="https://img.shields.io/badge/Spring%20Boot-3.x-6DB33F?style=flat-square&logo=springboot&logoColor=white" alt="Spring Boot">
</td>
</tr>
<tr>
<td><strong>Data Layer</strong></td>
<td>
  <img src="https://img.shields.io/badge/Spring%20JDBC-6DB33F?style=flat-square&logo=spring&logoColor=white" alt="Spring JDBC">
  <img src="https://img.shields.io/badge/H2%20Database-004088?style=flat-square&logo=h2&logoColor=white" alt="H2">
</td>
</tr>
<tr>
<td><strong>Build Tool</strong></td>
<td>
  <img src="https://img.shields.io/badge/Maven-C71A36?style=flat-square&logo=apache-maven&logoColor=white" alt="Maven">
</td>
</tr>
</table>

---

## 🚀 Getting Started

### 📋 Prerequisites

Ensure you have the following installed:

| Requirement | Version | Download |
|-------------|---------|----------|
| ☕ Java | 17+ | [Oracle JDK](https://www.oracle.com/java/technologies/downloads/) / [OpenJDK](https://openjdk.org/) |
| 🔧 Maven | 3.6+ | [Apache Maven](https://maven.apache.org/download.cgi) |
| 💻 IDE | Latest | [IntelliJ IDEA](https://www.jetbrains.com/idea/) / [VS Code](https://code.visualstudio.com/) |

### 📦 Installation

<details>
<summary><strong>🔽 Click to expand installation steps</strong></summary>

#### 1️⃣ Clone the Repository
```bash
git clone https://github.com/khan-sk-dev/user-management.git
cd user-management
```

#### 2️⃣ Build the Project
```bash
mvn clean install
```

#### 3️⃣ Run the Application
```bash
mvn spring-boot:run
```

#### 4️⃣ Verify Installation
🌐 Open your browser and navigate to: **http://localhost:8080**

</details>

---

## 📡 API Endpoints

### 🔍 Overview

| Method | Endpoint | Description | Status |
|--------|----------|-------------|--------|
| `GET` | `/users` | Retrieve all users | ✅ Available |
| `POST` | `/users` | Create a new user | ✅ Available |

### 📝 Create User Example

<details>
<summary><strong>📤 POST /users</strong></summary>

**Request:**
```json
POST /users
Content-Type: application/json

{
  "id": 1,
  "name": "John Doe",
  "email": "john.doe@example.com"
}
```

**Response:**
```json
HTTP/1.1 201 Created
Content-Type: application/json

{
  "id": 1,
  "name": "John Doe",
  "email": "john.doe@example.com",
  "createdAt": "2025-05-19T10:30:00Z"
}
```

</details>

<details>
<summary><strong>📋 GET /users</strong></summary>

**Request:**
```bash
GET /users
```

**Response:**
```json
HTTP/1.1 200 OK
Content-Type: application/json

[
  {
    "id": 1,
    "name": "John Doe",
    "email": "john.doe@example.com",
    "createdAt": "2025-05-19T10:30:00Z"
  },
  {
    "id": 2,
    "name": "Jane Smith",
    "email": "jane.smith@example.com",
    "createdAt": "2025-05-19T11:15:00Z"
  }
]
```

</details>

---

## ✅ Validation Rules

<div align="center">

| Field | Rules | Example |
|-------|-------|---------|
| 🆔 **ID** | `≥ 0` (zero or positive) | `1`, `42`, `0` |
| 👤 **Name** | `2-255 characters` • `not blank` | `"John Doe"` |
| 📧 **Email** | `valid format` • `not empty` | `"user@domain.com"` |

</div>

### 🔍 Validation Examples

<details>
<summary><strong>✅ Valid User Data</strong></summary>

```json
{
  "id": 0,
  "name": "Al",
  "email": "al@example.com"
}
```

</details>

<details>
<summary><strong>❌ Invalid User Data</strong></summary>

```json
{
  "id": -1,           // ❌ Negative ID
  "name": "A",        // ❌ Too short (< 2 chars)
  "email": "invalid"  // ❌ Invalid email format
}
```

</details>

---

## 🔧 Error Handling

The API provides detailed error responses for better debugging:

### ❌ Validation Error Response

```json
HTTP/1.1 400 Bad Request
Content-Type: application/json

{
  "timestamp": "2025-05-19T10:30:00Z",
  "status": 400,
  "error": "Bad Request",
  "message": "Validation failed",
  "path": "/users",
  "fieldErrors": {
    "id": "ID must be zero or positive",
    "name": "Name must be between 2 and 255 characters",
    "email": "Email must be a valid email address"
  }
}
```

---

## 🤝 Contributing

<div align="center">

**We welcome contributions! 🎉**

[![GitHub Issues](https://img.shields.io/github/issues/khan-sk-dev/user-management?style=for-the-badge)](https://github.com/khan-sk-dev/user-management/issues)
[![GitHub Forks](https://img.shields.io/github/forks/khan-sk-dev/user-management?style=for-the-badge)](https://github.com/khan-sk-dev/user-management/network)
[![GitHub Stars](https://img.shields.io/github/stars/khan-sk-dev/user-management?style=for-the-badge)](https://github.com/khan-sk-dev/user-management/stargazers)

</div>

### 📝 How to Contribute

1. 🍴 **Fork** the repository
2. 🌿 **Create** a feature branch: `git checkout -b feature/amazing-feature`
3. 💾 **Commit** your changes: `git commit -m 'Add some amazing feature'`
4. 📤 **Push** to the branch: `git push origin feature/amazing-feature`
5. 🔄 **Open** a Pull Request

---

<div align="center">

**⭐ Found this project helpful? Give it a star!**

*Built with ❤️ using Spring Boot*

</div>
