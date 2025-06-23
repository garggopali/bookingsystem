The project is a Java-based Booking System implemented using Spring Boot. It includes RESTful controllers, models for booking and coworking entities, H2 memory database with memory and/or file(based on active profile), and email notifications.

**Booking System**
A simple coworking slot booking system built with Spring Boot/Gradle offering various endpoints as API cataglogue. It allows users to manage coworking availability, schedule bookings, and send notifications.

**Features**
REST APIs to:
  Create and view coworkers
  Manage available slots
  Book available time slots
In-memory H2 database integration
Email notification component
Modular architecture with MVC pattern

**Project Structure**
bookingsystem-main/
├── src/main/java/com/gopali/bookingsystem/
│   ├── controller/          # REST API controllers
│   ├── model/               # Entity models
│   ├── repository/          # Spring Data JPA repositories
│   ├── component/           # Utility components (e.g., email)
│   └── BookingsystemApplication.java  # Main app entry point
├── h2/                      # Embedded H2 database files
├── build.gradle             # Gradle build file
├── settings.gradle

**Prerequisites**
Java 17+
Gradle (or use the included wrapper ./gradlew)

**Running the Application**
./gradlew bootRun
Once started, the app will be available at http://localhost:8080.

**API Endpoints**
Method	Endpoint	Description
POST	/api/coworker	Add a new coworker
GET	/api/coworker	List all coworkers
GET	/api/coworker/{id}/availability	Get availability of a specific coworker
POST	/api/coworker/{id}/availability	add availability of a specific coworker
POST	/api/bookings	Book a slot
GET	/api/bookings	List all bookings

**Database**
The app uses an H2 embedded database. Data is stored in:

JDBC URL: jdbc:h2:file:./h2/bookingdb
Username: gopali
Password: gopali

**Email Notifications**
EmailNotifier.java is a component stubbed to handle notification sending when bookings are created to integrate with real email services (e.g., JavaMailSender).

**Build**
./gradlew build

**License**
This project is licensed under the MIT License.
