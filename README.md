# tempah-hotel
Pet codes for Hotel Reservation

# How to run
Navigate to the root of the project via command line and execute the command: ```mvn spring-boot:run```

# How to open api documentation
After website run open webpage ```http://localhost:8080/swagger-ui.html```
  
# How to create a reservation
* Get list of available hotels and rooms from ```http://localhost:8080/v1/hotels```, take a note on ```hotelId``` and ```roomNumber```, this two fields are required to make a reservation
* Make a reservation to ```http://localhost:8080/v1/reservations```
```json
{
  "guestEmail": "andika@gmail.com",
  "guestName": "Andika",
  "guestPhone": "0123345",
  "hotelId": "HiltonKL",
  "roomNumber": 111,
  "checkInDate": "2020-11-29",
  "checkOutDate": "2020-11-30"
}
```
* All parameters are available in ```http://localhost:8080/swagger-ui.html```

# Tech Stack
* Spring Boot
* JPA + H2 Database
* Lombok
* Maven
* Swagger


