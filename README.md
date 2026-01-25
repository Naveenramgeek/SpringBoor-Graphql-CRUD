# Spring Boot GraphQL Movies CRUD

A REST alternative API built with **Spring Boot**, **GraphQL**, and **MongoDB** for managing movie data. Expose a single GraphQL endpoint for queries and mutations instead of multiple REST routes.

## Tech Stack

- **Java 17**
- **Spring Boot 3.3.4**
- **Spring Boot GraphQL** – GraphQL API
- **Spring Data MongoDB** – persistence
- **MongoDB** – document store
- **Lombok** – boilerplate reduction
- **GraphiQL** – built-in GraphQL UI

## Project Structure

```
src/main/java/com/example/Assignment1/Movies/
├── MoviesApplication.java      # Entry point
├── model/
│   └── Movie.java              # Movie entity (MongoDB document)
├── repository/
│   └── MovieRepository.java    # MongoDB repository
├── service/
│   └── MovieService.java       # Business logic
└── resolver/
    └── MovieResolver.java      # GraphQL queries & mutations

src/main/resources/
├── application.properties      # App & MongoDB config
└── graphql/
    └── movie.graphqls         # GraphQL schema
```

## Prerequisites

- **JDK 17**
- **Maven 3.6+**
- **MongoDB** (local or remote)

## Configuration

1. Clone the repo and open the project.

2. Configure MongoDB in `src/main/resources/application.properties`:

   ```properties
   spring.data.mongodb.uri=mongodb://localhost:27017
   spring.data.mongodb.database=movies
   ```

   Adjust `uri` and `database` for your environment.

3. The app runs on **port 8080** by default. GraphiQL is enabled at `/api`.

## Running the Application

```bash
./mvnw spring-boot:run
```

Or build and run the JAR:

```bash
./mvnw clean package
java -jar target/Movies-0.0.1-SNAPSHOT.jar
```

## GraphQL API

- **GraphQL endpoint:** `http://localhost:8080/graphql`
- **GraphiQL UI:** `http://localhost:8080/api` (interactive client)

### Data Model: `Movie`

| Field                 | Type           | Description                |
|-----------------------|----------------|----------------------------|
| `id`                  | `ID!`          | Auto-generated ID          |
| `title`               | `String`       | Movie/show title           |
| `description`         | `String`       | Synopsis                   |
| `genres`              | `[String]`     | Genre list                 |
| `release_year`        | `Int`          | Release year               |
| `imdb_score`          | `Float`        | IMDB rating                |
| `runtime`             | `Float`        | Runtime (e.g. minutes)     |
| `type`                | `String`       | e.g. "MOVIE" / "SHOW"      |
| `age_certification`   | `String`       | Age rating                 |
| `production_countries`| `[String]`     | Country list               |

### Queries

**Fetch all movies:**

```graphql
query {
  getAllMovies {
    id
    title
    description
    genres
    release_year
    imdb_score
    runtime
    type
  }
}
```

**Fetch movies by title:**

```graphql
query {
  getMovieByTitle(title: "Inception") {
    id
    title
    description
    imdb_score
  }
}
```

### Mutations

**Add a movie:**

```graphql
mutation {
  addMovie(
    title: "Inception"
    description: "A mind-bending heist thriller."
    genres: ["Sci-Fi", "Thriller"]
    release_year: 2010
    imdb_score: 8.8
    runtime: 148
    type: "MOVIE"
  ) {
    id
    title
  }
}
```

**Update movies by title:**

```graphql
mutation {
  updateMovies(
    title: "Inception"
    description: "Updated description."
    imdb_score: 8.9
  ) {
    id
    title
    description
    imdb_score
  }
}
```

**Delete movie(s) by title:**

```graphql
mutation {
  deleteMovie(title: "Inception")
}
```

Returns a success or error message string.

## API Behavior

- **Add movie:** Fails if a movie with the same `title` already exists (no duplicate titles).
- **Update:** Updates all movies matching the given `title` with the provided fields.
- **Delete:** Deletes all movies with the given `title`.

## Testing

Run tests with:

```bash
./mvnw test
```

## License

This project is for educational/demo use.
