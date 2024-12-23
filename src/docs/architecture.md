# Architecture Documentation

## Overview
The Home Automation System (**HAS**) follows a modular and scalable architecture, enabling seamless integration of devices, protocols, and applications. The system comprises multiple components that communicate via APIs, messaging protocols, and data streams.

---

## High-Level Architecture
The HAS architecture is divided into the following components:

### **1. Core Backend (EchoStream)**
- **Role:** Central processing unit for business logic, APIs, and data aggregation.
- **Key Features:**
  - REST APIs for device management and data integration.
  - Time-series data storage using InfluxDB.
  - Communication with gateways and devices via MQTT and WebSockets.

### **2. Admin Console (AdminTool)**
- **Role:** Web interface for system administration and monitoring.
- **Key Features:**
  - User and device management.
  - Real-time system status monitoring.
  - Configuration management.

### **3. Visualization and Analysis (DataTrendz)**
- **Role:** Dashboards and analytics for real-time and historical data visualization.
- **Key Features:**
  - Integration with InfluxDB and Grafana.
  - Interactive charts and graphs for trend analysis.

### **4. Mobile Application (SmartControl)**
- **Role:** Cross-platform mobile application for users.
- **Key Features:**
  - Device control and monitoring.
  - Push notifications for events and anomalies.

### **5. Gateway (EdgeLink)**
- **Role:** Local gateway for collecting and forwarding device data.
- **Key Features:**
  - Protocol translation for ZigBee, Z-Wave, Philips Hue, and Google Home.
  - Data transmission to the Core Backend via MQTT.

### **6. Sensor Monitoring (SensGuard)**
- **Role:** Ensures reliability of devices and sensors.
- **Key Features:**
  - Anomaly detection for real-time and historical data.
  - Health monitoring and error diagnostics.

---

## Data Flow
1. **Devices → Gateway:**
   Sensors and actuators communicate with the gateway using supported protocols (e.g., ZigBee, Z-Wave).
2. **Gateway → Backend:**
   The gateway forwards data to the Core Backend using MQTT or REST APIs.
3. **Backend → Applications:**
   The backend provides data to the Admin Console, Visualization, and Mobile Application via RESTful APIs and WebSockets.

---

## Deployment Architecture
The system is containerized and deployed using **Docker**. The following services are deployed:
1. **Core Backend**
2. **Admin Console**
3. **Visualization Service**
4. **Gateway Service**
5. **Sensor Monitoring Service**
6. **Databases (PostgreSQL, InfluxDB, Redis)**

Orchestration is managed using **Docker Compose** or Kubernetes for scalability.

---

## Future Enhancements
- High availability deployment using Kubernetes.
- Cloud integration for additional scalability.
- Machine learning models for advanced anomaly detection.

# Updated Setup Documentation

## Prerequisites
- Docker and Docker Compose
- Java 17+ (Core Backend)
- Node.js 16+ and Yarn (Frontend)
- Python 3.9+ (Gateway and SensGuard)
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

### 5. Start Sensor Monitoring (SensGuard)
```bash
cd components/sensguard
pip install -r requirements.txt
python monitor.py
```

### 6. Docker Setup
Start all services using Docker Compose:
```bash
docker-compose up
```

---

## Future Enhancements
- Kubernetes deployment for scalability.