# **Required Tools** 

- Java 17
- Docker 29.9.2
- Gradle
- Gradle Springboot
- Gradle Spotless (Optional - Formatter)

# **How to Run Mouseion API**

Switch to the develop branch to run the current production

**Run the Database**

- Open a terminal
- Navigate to the db directory, which contains the `init.sql` and `docker-compose.yml`, files using `cd`.
- Run `sudo docker compose up -d`. This command starts the database docker image defined in the `docker-compose.yml` in detached mode.

**Run the Service**

- Open Mouseion in your code editer in the outer most directory
- Run `./gradlew bootRun` or, alternatively,  right click `MouseionServiceApplication.java` and click `run java`.

**Bruno**

- Open Bruno and connect to Mouseion.
- Open the Mouseion bruno collection. This is the `bruno` directory.

# **How to Test** 

[API definition document](https://github.com/OfficeCoffee/mouseion-api/blob/develop/API-definition-document.md)

- All premade bru tests should be valid and should cover everything within the API definition document.
- When updating a record, If the request URL contains a word id or deck id that does not exist in the database, it will return a 404 not found.

