# Setup and Installation Guide

## Prerequisites
- Docker and Docker Compose
- Java 17+ (Core Backend)
- Node.js 16+ and Yarn (Frontend)
- Python 3.9+ (Gateway)
- PostgreSQL, InfluxDB, and Redis installed

---

## Installation Steps

### 1. Clone the Repository
```bash
git clone https://github.com/<username>/HAS.git
cd HAS
```

### 2. Start Backend
```bash
cd components/backend
mvn spring-boot:run
```

### 3. Start Admin Console
```bash
cd components/admin
yarn install
yarn serve
```

### 4. Start Gateway
```bash
cd components/gateway
pip install -r requirements.txt
python main.py
```

### 5. Docker Setup
Start all services using Docker Compose:
```bash
docker-compose up
```

---

## Future Enhancements
- Kubernetes deployment for scalability.

