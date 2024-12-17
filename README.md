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

## Structure

HAS/
├── components/           # Contains all main components/applications
│   ├── backend/          # Core Backend (EchoStream)
│   │   ├── src/          # Source code
│   │   ├── config/       # Configuration files
│   │   ├── test/         # Unit and integration tests
│   │   └── README.md     # Documentation for EchoStream
│   ├── admin/            # Admin Console (AdminTool)
│   │   ├── src/          # Vue.js code
│   │   ├── public/       # Static assets
│   │   ├── test/         # Unit tests
│   │   └── README.md     # Documentation for AdminTool
│   ├── visualization/    # Visualization and Analysis (DataTrendz)
│   │   ├── src/          # Vue.js code
│   │   ├── public/       # Static assets
│   │   ├── test/         # Unit tests
│   │   └── README.md     # Documentation for DataTrendz
│   ├── mobile/           # Mobile App (SmartControl)
│   │   ├── src/          # MAUI code
│   │   ├── resources/    # Assets
│   │   ├── test/         # Unit tests
│   │   └── README.md     # Documentation for SmartControl
│   ├── gateway/          # Gateway (EdgeLink)
│   │   ├── src/          # Python code
│   │   ├── config/       # Protocol configurations
│   │   ├── logs/         # Gateway logs
│   │   ├── test/         # Unit tests
│   │   └── README.md     # Documentation for EdgeLink
│
├── docs/                 # Centralized project documentation
│   ├── architecture.md   # High-level architecture documentation
│   ├── protocols.md      # Protocol integration details
│   ├── database.md       # Database schema and usage
│   ├── setup.md          # Setup and installation guide
│   └── overview.md       # Project overview and goals
│
├── docker/               # Docker configurations
│   ├── docker-compose.yml
│   ├── backend/          # Backend Docker setup
│   ├── admin/            # Admin Console Docker setup
│   ├── gateway/          # Gateway Docker setup
│   ├── database/         # Database Docker setup
│
├── scripts/              # Utility scripts
│   ├── setup.sh
│   ├── deploy.sh
│   └── test.sh
│
└── README.md             # Main project documentation
