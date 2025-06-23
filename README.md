The project is a Java-based Booking System implemented using Spring Boot. It includes RESTful controllers, models for booking and coworking entities, database integration (via H2), and email notifications.

**Here’s a draft README.md for my project:**

**Booking System**
A simple coworking space booking system built with Spring Boot. It allows users to manage coworking availability, schedule bookings, and send notifications.

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
POST	/api/slot	Add availability slot
GET	/api/slot	List all availability slots
POST	/api/booking	Book a slot
GET	/api/booking	List all bookings

**Database**
The app uses an H2 embedded database. Data is stored in:

h2/bookingdb.mv.db
You can view the H2 console at:

http://localhost:8080/h2-console
JDBC URL: jdbc:h2:file:./h2/bookingdb

User: sa
Password: (leave blank)

**Email Notifications**
EmailNotifier.java is a component stubbed to handle notification sending when bookings are created to integrate with real email services (e.g., JavaMailSender).

**Build**
./gradlew build

**License**
This project is licensed under the MIT License.
