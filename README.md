# Azeroth AI

**AI-powered fantasy character generator built with Java and Large Language Models.**

Azeroth AI is a full-stack learning project focused on building a real application around a locally hosted Large Language Model (LLM).

The application allows users to define a character's:

* Race
* Class
* Personality

The application then generates a complete fantasy character using AI and returns the result as structured data.

---

## Features

* AI-powered character generation
* Custom race, class and personality
* Local LLM using Ollama and Llama 3.2
* Java backend
* JSON serialization and deserialization
* Separation between application logic and LLM integration
* Planned cloud deployment
* Planned Docker support

---

## Current Architecture

```text
User
  |
  v
Main
  |
  v
PromptService
  |
  v
LlmService
  |
  v
Ollama
  |
  v
Llama 3.2
  |
  v
JSON
  |
  v
JsonService
  |
  v
Personaje
```

The LLM integration is isolated inside `LlmService`, making it possible to change the LLM provider in the future without rewriting the rest of the application.

---

## Technologies

| Technology | Purpose                         |
| ---------- | ------------------------------- |
| Java 25    | Backend development             |
| Maven      | Dependency management and build |
| Jackson    | JSON processing                 |
| Ollama     | Local LLM runtime               |
| Llama 3.2  | Local language model            |
| Git        | Version control                 |
| GitHub     | Source code and project history |

### Planned technologies

* Spring Boot
* REST API
* PostgreSQL
* Docker
* Frontend framework
* Cloud deployment
* CI/CD

---

## How it works

The user provides three characteristics:

```text
Race: Orc
Class: Warrior
Personality: Fierce and honorable
```

Azeroth AI converts this information into a structured prompt and sends it to the local Llama 3.2 model through Ollama.

The model returns JSON containing the generated character:

```json
{
  "nombre": "Gorthok Bloodfist",
  "raza": "Orco",
  "clase": "Guerrero",
  "nivel": 80,
  "especializacion": "Armas de Guerra",
  "personalidad": "Feroz y honorable",
  "historia": "..."
}
```

The JSON response is then converted into a Java `Personaje` object.

---

## Running the project locally

### Requirements

* Java 25
* Maven
* Ollama
* Llama 3.2

Make sure Ollama is running and the model is available:

```bash
ollama list
```

The project expects the `llama3.2` model.

Then compile the project with Maven:

```bash
mvn clean compile
```

Run the application from your IDE or using Maven.

---

## Roadmap

### Completed

* [x] Java project structure
* [x] Character model
* [x] JSON serialization and deserialization
* [x] Prompt generation
* [x] LLM service
* [x] Ollama integration
* [x] Llama 3.2 integration
* [x] Git repository
* [x] GitHub repository

### In progress

* [ ] Improve error handling
* [ ] Improve project configuration
* [ ] Add automated tests
* [ ] Clean up unused code
* [ ] Improve documentation

### Planned

* [ ] Migrate to Spring Boot
* [ ] Create REST API
* [ ] Add PostgreSQL persistence
* [ ] Build a web frontend
* [ ] Dockerize the application
* [ ] Add CI/CD
* [ ] Deploy the application to the cloud
* [ ] Make the application publicly accessible

---

## Project Goals

This project is being developed as a practical portfolio project to learn and demonstrate:

* Java development
* Object-oriented programming
* Software architecture
* REST APIs
* LLM integration
* JSON processing
* Testing
* Databases
* Docker
* Git and GitHub
* Cloud deployment
* CI/CD

The project is intentionally being developed incrementally, with the goal of turning a simple Java application into a complete cloud-accessible AI application.

---

## Screenshots

Screenshots will be added as the application evolves.

---

## Author

Developed as a personal learning and portfolio project.

More features and improvements are coming soon.
