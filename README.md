# Home Automation System (HAS)

## Overview
The **Home Automation System (HAS)** is a modular and scalable platform for managing smart home devices and systems. It integrates multiple components to enable centralized control, real-time data processing, and analytics.

---

## Components
1. **Core Backend (EchoStream):** Manages business logic, data aggregation, and provides APIs.
2. **Admin Console (AdminTool):** A web-based interface for user and device management.
3. **Visualization and Analysis (DataTrendz):** Offers dashboards and analytics for real-time and historical data.
4. **Mobile Application (SmartControl):** A cross-platform app for controlling and monitoring devices.
5. **Gateway (EdgeLink):** Local data collection and protocol integration for devices.

---

## Key Features
- Centralized control for all connected devices.
- Real-time data processing and analytics.
- Integration with major protocols: ZigBee, Z-Wave, Philips Hue, Google Home.
- REST APIs for custom sensors and actuators.
- Modular architecture for scalability.

---

## Technology Stack
| Component            | Name                   | Technology                   | Description                          |
|----------------------|------------------------|------------------------------|--------------------------------------|
| **Backend**          | EchoStream             | Java (Spring Boot)           | Business logic and API management    |
| **Admin Console**    | AdminTool              | Vue.js + Quasar Framework    | Web-based management                 |
| **Visualization**    | DataTrendz             | Vue.js + Quasar Framework    | Dashboards and analytics             |
| **Mobile**           | SmartControl           | MAUI (C#)                    | Cross-platform mobile app            |
| **Gateway**          | EdgeLink               | Python                       | Local protocol integration           |
| **Databases**        | -                      | PostgreSQL, InfluxDB, Redis  | Relational, time-series, and caching |
| **Monitoring**       | -                      | Grafana + Prometheus         | System performance and analytics     |

---

## Setup
Refer to the individual component README files for setup instructions:
- [EchoStream - Core Backend](./components/backend/README.md)
- [AdminTool- Admin Console](./components/admin/README.md)
- [DataTrendz - Visualization and Analysis](./components/visualization/README.md)
- [SmartControl- Mobile Application](./components/mobile/README.md)
- [EdgeLink - Gateway](./components/gateway/README.md)
