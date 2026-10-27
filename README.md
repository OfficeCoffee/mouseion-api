# **Required Tools** 

- Java 17
- Docker 29.9.2
- Gradle (version)
- Any other dependencies

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

**API definition document**: (Link to API def document)

**Deck**

*Get:*
- Get all decks
- Get deck by ID
- Get deck by name

*Put:*

**Deck Words**

- Get all decks that contain words
- Get all words in deck
- Get words by deck ID

**Words**

- Get all words
- Get word by ID
- Get word by name
- Get recent words by date
