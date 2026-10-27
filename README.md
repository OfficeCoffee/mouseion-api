# **Required Tools** 

- Java 17
- Docker 29.9.2
- Gradle

# **How to Run Mouseion API**

- Switch to the main branch to run the current production

**Run the Database**

- Open a terminal
- Navigate to the directory containing the init.sql and docker-compose.yml files using cd. These files need to be in the same directory.
- Run sudo docker compose up -d. This command starts the database docker image defined in the docker-compose.yml in detached mode.

**Run the Service**

- Open Mouseion in your code editer in the outer most directory
- Run `./gradlew bootRun` (or right click MouseionServiceApplication and click `run java`)

**Bruno**

- Open Bruno and connect to Mouseion
- Run any of the premade Bruno files

# **How to Test** 

[API definition document](https://github.com/OfficeCoffee/mouseion-api/blob/underwood-homework-5/API-definition-document.md)

- All premade Bruno tests should be valid and should cover everything within the API definition document.
- If the request URL contains a word id or deck id that does not exist in the database, it will return a 404 not found.

