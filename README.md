# 🌦 Weather Data API

## 📌 Project Overview
Weather Data API is a Spring Boot application that processes weather data from a CSV file, stores it in a relational database, and exposes RESTful endpoints to retrieve, filter, and sort the data.

This project was developed as part of an internship assessment in February 2026.



## 🚀 Tech Stack
- Java
- Spring Boot
- Spring Data JPA
- Maven
- MySQL / Oracle
- REST API


## 📂 Features
- Read and process weather data from CSV file
- Store structured data into database
- Retrieve all weather records
- Filter by Month
- Filter by Year
- Sort results (ascending/descending)
- Exception handling
- Layered architecture (Controller, Service, Repository)



## 📡 API Endpoints

### 🔹 Get All Weather Month
http://localhost:8081/weather/month/5

### 🔹 Filter by year
http://localhost:8081/weather/year/1999/summary


## ⚙️ How to Run the Project

1. Clone the repository  
   git clone https://github.com/your-username/weather-data-api.git

2. Configure database in `application.properties`

3. Build the project  
   mvn clean install

4. Run the application  
   mvn spring-boot:run

Application runs at:  
http://localhost:8081

