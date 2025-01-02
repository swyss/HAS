# Setup and Installation Guide

## Prerequisites
- Docker and Docker Compose
- Java 17+ (Core Backend)
- Node.js 16+ and Yarn (Frontend)
- Python 3.9+ (Gateway)
- PostgreSQL, InfluxDB, and Redis installed
- ASP.NET Core SDK for SimulaX

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

### 5. Start Sensor Monitoring (SensGuard)
```bash
cd components/sensguard
pip install -r requirements.txt
python monitor.py
```

### 6. Start SimulaX Backend
```bash
cd components/simulax/backend
dotnet build
dotnet run
```

### 7. Docker Setup
Update `docker-compose.yml` to include SimulaX:
```yaml
simulax:
  image: simulax-backend:latest
  build:
    context: ./components/simulax/backend
  ports:
    - "5005:5005"
  environment:
    - DATABASE_URL=postgresql://user:password@db:5432/simulax
    - INFLUXDB_URL=http://influxdb:8086
  depends_on:
    - db
    - influxdb
```
Start all services using Docker Compose:
```bash
docker-compose up
```

---

## Future Enhancements
- Kubernetes deployment for scalability.
- Enhanced setup automation for new components like SimulaX.
