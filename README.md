# Cyber Cafe Management & Booking System (Backend)

The central backend repository for an all-in-one web platform designed for modern gaming lounges and cyber cafes. This project is built using the **Modular Monolith** architectural pattern on top of modern Spring Boot.

---

## 🛠️ Tech Stack
* **Language:** Java 21
* **Framework:** Spring Boot 3.x (Spring Security, Spring Data JPA)
* **Database:** MySQL
* **Migration:** Liquibase
* **Build Tool:** Maven
* **Testing:** JUnit 5, Testcontainers

---

## 📦 Domain Split & Responsibilities

The system is split into two isolated business domains to allow smooth, parallel development for two Java backend engineers:

### ☕ Developer 1: User Domain & Loyalty System
* **Authentication & Profiles:** Secure registration, JWT-based login, and user profile management including a digital wallet balance.
* **Tariff & Pricing Engine:** CRUD operations for dynamic pricing plans and packages (e.g., "1 Hour", "Night Package", "VIP Boot Camp rate").
* **Loyalty & Rewards:** Automated cashback calculations, bonus points accumulation, and reward rules logic (e.g., play for 10 hours, get 1 hour free).

### 🖥️ Developer 2: Hardware Management & Booking Engine
* **PC Inventory & Statuses:** Database management of gaming rigs, specifications, zone partitioning (Main/VIP), and real-time state tracking (`AVAILABLE`, `OCCUPIED`, `MAINTENANCE`).
* **Core Booking Engine:** Time-slot validation logic to prevent double-booking a specific PC.
* **Session Simulator:** A background scheduler (Cron jobs) running every minute to monitor active gaming sessions, deduct credits from user balances, and automatically release PCs when time runs out.

---

## 🗄️ Database Schema (Core MVP)

The Minimum Viable Product relies on 4 core tables:

1. `users` — `id`, `username`, `phone`, `balance_credits`, `loyalty_points`
2. `computers` — `id`, `pc_number`, `zone_type (MAIN/VIP)`, `status (AVAILABLE/OCCUPIED/MAINTENANCE)`
3. `tariffs` — `id`, `name`, `duration_minutes`, `price_credits`
4. `bookings` — `id`, `user_id`, `computer_id`, `tariff_id`, `start_time`, `end_time`, `payment_status`

---

## 👥 Git Workflow & Rules

To maintain codebase stability and smooth teamwork, strict repository rules (Rulesets) are enforced:

1. **Feature Branching:** Pushing directly to `main` is strictly prohibited. All new features must be developed in dedicated branches (e.g., `feature/auth-service`).
2. **Mandatory Code Review:** Code integration happens exclusively via **Pull Requests (PR)**.
3. **Peer Approval Required:** A PR cannot be merged into `main` without at least **1 approval** from the other backend developer.
4. **Squash Merging:** All commit histories from a feature branch are squashed into a single clean commit upon merging to keep the `main` history readable.

---
*Developed for educational purposes by the Group265 development team.*
