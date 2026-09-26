# Spring Boot Introduction — Production Project Structure

A **production-ready** Spring Boot project showing the standard layered architecture and naming conventions. No JPA/Security here — each concept gets its own repo. This repo is the **foundation/template**: how a real Spring Boot service is organized.

## Standards demonstrated

| Layer | Package | Class(es) |
|-------|---------|-----------|
| Entry point | `com.naresh.introduction` | `SpringBootIntroductionApplication` |
| Web | `controller` | `CustomerController` |
| Business | `service` / `service.impl` | `CustomerService` (interface) + `CustomerServiceImpl` |
| Data access | `repository` / `repository.impl` | `CustomerRepository` + `InMemoryCustomerRepository` |
| Domain | `model` | `Customer` |
| Contracts | `dto` | `CustomerRequest`, `CustomerResponse` |
| Errors | `exception` | `CustomerNotFoundException`, `GlobalExceptionHandler` |
| Config | `config` | `AppProperties` (`@ConfigurationProperties`) |

## Production conventions used
- **Package**: `com.naresh.<artifact>` (reverse domain: groupId `com.naresh`)
- **Dependency injection**: constructor injection, final fields
- **Interface + impl**: controllers depend on `CustomerService`, services on `CustomerRepository`
- **DTOs**: API returns DTOs, never the model directly — stable API contract
- **Exceptions**: single `@RestControllerAdvice` → RFC-7807 `ProblemDetail`
- **Properties**: type-safe `@ConfigurationProperties` record (`app.*` prefix)
- **Logging**: SLF4J throughout, DEBUG for this package in dev profile

## Run

```bash
mvn spring-boot:run
```

API (base path `/api/v1/customers`):
```
GET    /api/v1/customers        -> list all
GET    /api/v1/customers/{id}   -> one customer (404 via ProblemDetail if missing)
POST   /api/v1/customers        -> create (body: CustomerRequest)
PUT    /api/v1/customers/{id}   -> update
DELETE /api/v1/customers/{id}   -> delete (204)
```

Example:
```bash
curl -X POST localhost:8080/api/v1/customers \
  -H "Content-Type: application/json" \
  -d '{"name":"Alice","email":"alice@example.com","phone":"+919000000000","active":true}'
```

## Why this layout
- Clear separation of concerns → testable, maintainable, team-friendly
- Swappable implementations (in-memory now → JPA later, no callers change)
- Same skeleton reused across all other Spring repos in this profile