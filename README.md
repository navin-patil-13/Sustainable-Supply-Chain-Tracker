# Sustainable Supply Chain Tracker 🌱🚛
The Sustainable Supply Chain Tracker is a full-stack Spring Boot application that audits and visualizes eco-friendly supply chains, using a blockchain-inspired immutable ledger to track suppliers, shipments, and sustainability metrics like carbon footprints.

**Week 1 Milestone COMPLETE** - Production-ready CRUD APIs

## Live Features ✅
| Endpoint | Method | Auth | Description |
|----------|--------|------|-------------|
| `/api/suppliers` | GET | Yes | List all suppliers |
| `/api/suppliers/{id}` | GET | Yes | Single supplier |
| `/api/suppliers` | POST | Yes | Create supplier |
| `/api/suppliers/{id}` | PUT | Yes | Update supplier |
| `/api/suppliers/{id}` | DELETE | Yes | Delete supplier |
| `/api/products` | GET/POST | Yes | Products CRUD |

**Credentials**: `supplychain_user:supplychaindb`

## Tech Stack
Backend: Java 21 + Spring Boot 3.2
Database: PostgreSQL 16
Security: Spring Security Basic Auth
Observability: Actuator + Micrometer
Tests: JUnit 5 + MockMvc


## Quick Start
```bash
mvn spring-boot:run
curl -u supplychain_user:supplychaindb http://localhost:8080/api/suppliers
