# VAMM

A simple Spring Boot application that provides a REST API for managing contracts and assets backed by MongoDB.

## Requirements

- Java 17+
- Maven 3+
- Docker & Docker Compose (optional)
- A running MongoDB instance (default connection URL `mongodb://localhost:27017/vamm`)

## Setup & Run

```bash
mvn spring-boot:run
```

### Docker Compose

To start both MongoDB and the application run:

```bash
docker-compose up --build
```

The API exposes endpoints for contracts and assets:

### Contracts
- `GET /contracts` – list contracts sorted by end date
- `POST /contracts` – create a contract
- `GET /contracts/{id}` – read a contract
- `PUT /contracts/{id}` – update a contract
- `DELETE /contracts/{id}` – delete a contract

### Assets
- `GET /assets` – list assets sorted by EOL, optional filter with `?upcoming=<days>`
- `POST /assets` – create an asset
- `GET /assets/{id}` – read an asset
- `PUT /assets/{id}` – update an asset
- `DELETE /assets/{id}` – delete an asset

Contracts and assets reference each other by ID. Sorting and filtering occur server-side.
