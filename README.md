# **EchoStream - Home Automation System**

## **Project Description**
**EchoStream** is a modular, scalable, and powerful Home Automation System (HAS) designed to integrate modern smart-home solutions. It enables central collection, processing, and analysis of sensor data, provides control functionalities for devices, and supports popular smart-home protocols such as **ZigBee**, **Z-Wave**, **Philips Hue**, and **Google Home**.

---

## **Table of Contents**
1. [Project Goals](#project-goals)  
2. [System Architecture](#system-architecture)  
3. [Technology Stack](#technology-stack)  
4. [Key Features](#key-features)  
5. [Applications](#applications)  
6. [Protocol Integration](#protocol-integration)  
7. [Data Flow](#data-flow)  
8. [Databases](#databases)  
9. [Setup and Installation](#setup-and-installation)  
10. [Future Enhancements](#future-enhancements)  

---

## **Project Goals**
- **Modularity and Scalability:** Flexible integration of new devices and protocols.  
- **Centralized Control:** Manage and monitor all connected devices through a unified interface.  
- **Data Analysis:** Real-time and historical analytics with trend visualizations.  
- **User-Friendliness:** Cross-platform applications for web, desktop, and mobile.  
- **Protocol Support:** Integration of major smart-home protocols (see [Protocol Integration](#protocol-integration)).  

---

## **System Architecture**
EchoStream is based on a service-oriented architecture with the following main components:

### **1. Core Backend (EchoStream)**  
- **Technology:** Java (Spring Boot).  
- **Functions:**  
  - Business logic and data processing.  
  - RESTful APIs for applications.  
  - Support for time-series data and event-driven processing.  

### **2. Admin Console (AdminTool)**  
- **Technology:** Vue.js with Quasar Framework.  
- **Functions:**  
  - Management of users, devices, and configurations.  
  - Real-time monitoring of system components.  

### **3. Visualization and Analysis (DataTrendz)**  
- **Technology:** Vue.js with Quasar Framework.  
- **Functions:**  
  - Visualization of sensor data and trends.  
  - Integration with Grafana for advanced analytics.  

### **4. Mobile Application (SmartControl)**  
- **Technology:** MAUI (C#).  
- **Functions:**  
  - Control and monitoring of devices.  
  - Push notifications and real-time updates.  

### **5. Gateway Application (EdgeLink)**  
- **Technology:** Python.  
- **Functions:**  
  - Local data collection and protocol conversion.  
  - Support for ZigBee, Z-Wave, and Philips Hue.  

---

## **Technology Stack**
| Component           | Technology                     | Description                          |
|---------------------|---------------------------------|--------------------------------------|
| **Backend**         | Java (Spring Boot)             | Core business logic and APIs         |
| **Web Frontend**    | Vue.js + Quasar Framework      | AdminTool and analysis dashboard     |
| **Mobile**          | MAUI (C#)                     | Mobile control and notifications     |
| **Gateway**         | Python                         | Local data collection and protocol handling |
| **Time-Series Data**| InfluxDB                       | Storage for sensor data              |
| **Relational DB**   | PostgreSQL                    | Users, roles, devices, configurations |
| **Caching**         | RedisDB                        | API caching and temporary storage    |
| **Monitoring**      | Grafana + Prometheus           | Visualization and system monitoring  |

---

## **Key Features**
- **Integration of Major Protocols:**  
  ZigBee, Z-Wave, Philips Hue, Google Home.  
- **RESTful API:**  
  For custom sensors and actuators.  
- **Real-Time Data:**  
  MQTT and WebSockets for live updates.  
- **Data Analysis:**  
  Trend visualization, pattern recognition, anomaly detection.  
- **User Management:**  
  Role-based access control (RBAC).  

---

## **Protocol Integration**
EchoStream supports the following protocols:  
1. **ZigBee:** Communication for wireless sensors and actuators.  
2. **Z-Wave:** Energy-efficient protocol for smart devices.  
3. **Philips Hue:** REST API integration via local Hue Bridge.  
4. **Google Home:** Integration via Smart Home SDK.  
5. **REST APIs:** Support for custom sensors and actuators.  

---

## **Data Flow**
1. **Devices → Gateway:**  
   Data from sensors and actuators are processed locally.  
2. **Gateway → Core Backend:**  
   Data is transferred via MQTT, REST, or WebSockets.  
3. **Backend → Applications:**  
   Visualization and control through AdminTool, DataTrendz, and SmartControl.  

---

## **Databases**
- **PostgreSQL:** Stores user, device, role, and configuration data.  
- **InfluxDB:** Specialized time-series database for sensor data.  
- **RedisDB:** Used for caching and API performance optimization.  

---

## **Setup and Installation**

### **Requirements**
1. **Docker:** For containerization of applications.  
2. **Databases:** PostgreSQL, InfluxDB, and Redis installed.  
3. **Tools:** Maven, npm/Yarn, .NET SDK.  

### **Step-by-Step Setup**
1. **Clone the repository:**  
   ```bash
   git clone https://github.com/<username>/EchoStream.git
   cd EchoStream
   ```
2. **Start the backend:**  
   ```bash
   cd backend
   mvn spring-boot:run
   ```
3. **Start the frontend:**  
   ```bash
   cd frontend
   yarn install
   yarn serve
   ```
4. **Start the gateway:**  
   ```bash
   cd gateway
   python main.py
   ```
