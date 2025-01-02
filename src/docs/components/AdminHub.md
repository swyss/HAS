# AdminHub Documentation

## Overview
AdminHub is a centralized administration console designed for managing and monitoring the Home Automation System (HAS). It provides tools for user and device management, real-time system monitoring, and configuration of system settings, ensuring efficient and secure operation.

---

## Features

### 1. **User Management**
- Create, read, update, and delete (CRUD) operations for users.
- Role-based access control (RBAC) with predefined roles (e.g., Admin, User).
- View active user sessions and session history.
- Secure authentication with optional two-factor authentication (2FA).

### 2. **Device Management**
- Display all connected devices with statuses (e.g., Online, Offline).
- Add, configure, and manage devices.
- Group devices by categories (e.g., by room, type).
- Update device firmware.

### 3. **System Monitoring**
- Real-time system health dashboard.
- Metrics for CPU usage, memory, network traffic, and system uptime.
- Log viewer for events, errors, and activities.
- Alert notifications for critical conditions.

### 4. **Configuration Management**
- Manage application and module-specific configurations.
- Export and import configuration settings.
- SimulaX integration for managing simulation parameters and monitoring data.

### 5. **Visualization and Reporting**
- Customizable dashboards with graphs and charts.
- Real-time and historical data visualization.
- Reports on system activity, user actions, and device performance.

---

## Architecture

### **Frontend**
- **Framework**: Vue.js + Quasar
- **Key Features**:
  - Responsive design for desktops and tablets.
  - Dynamic components for real-time updates.

### **Backend**
- **Framework**: Spring Boot
- **Key Features**:
  - REST APIs for user, device, and system management.
  - Integration with HAS core backend (EchoStream).

### **Database**
- **Relational**: PostgreSQL for structured data.
- **Caching**: Redis for session and frequently accessed data.

### **Deployment**
- **Platform**: Dockerized for scalability and ease of deployment.
- **Network Access**: Restricted to private networks.

---

## Core Components

### **1. Dashboard**
- **Panels**:
  - Summary Panel: Overview of users, devices, and simulations.
  - Health Panel: System metrics like uptime and resource utilization.
  - Logs Panel: Recent events and error logs.

### **2. User Management**
- **Functions**:
  - Search, filter, and sort users.
  - Manage roles and permissions.
  - Password reset and user deactivation.

### **3. Device Management**
- **Functions**:
  - Real-time device status updates.
  - Device grouping and location mapping.
  - Historical data access for individual devices.

### **4. Configuration Management**
- **Functions**:
  - Modify global and module-specific settings.
  - Backup and restore configuration settings.
  - Manage SimulaX simulation parameters.

### **5. Monitoring and Alerts**
- **Features**:
  - Customizable thresholds for system metrics.
  - Email and push notifications for alerts.
  - Audit logging for all admin actions.

---

## Setup and Installation

### Prerequisites
- Docker and Docker Compose
- Node.js 16+ and Yarn (Frontend)
- Java 17+ (Backend)
- PostgreSQL and Redis

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/<username>/AdminHub.git
   cd AdminHub
   ```
2. Start the backend:
   ```bash
   cd backend
   mvn spring-boot:run
   ```
3. Start the frontend:
   ```bash
   cd frontend
   yarn install
   yarn serve
   ```
4. Start services using Docker Compose:
   ```bash
   docker-compose up --build
   ```

---

## API Endpoints

### User Management
- **GET /api/users**: Retrieve list of users.
- **POST /api/users**: Create a new user.
- **PUT /api/users/{id}**: Update user details.
- **DELETE /api/users/{id}**: Delete a user.

### Device Management
- **GET /api/devices**: Retrieve list of devices.
- **POST /api/devices**: Add a new device.
- **PUT /api/devices/{id}**: Update device details.
- **DELETE /api/devices/{id}**: Delete a device.

### System Monitoring
- **GET /api/metrics**: Retrieve system metrics.
- **GET /api/logs**: Retrieve logs.

---

## Future Enhancements
- Integration with additional protocols (e.g., KNX, BACnet).
- Enhanced analytics with machine learning models.
- Mobile-friendly admin interface.
- Kubernetes support for high availability.

---

## Contributors
- **Project Lead**: [Your Name]
- **Backend Developer**: [Your Name/Team]
- **Frontend Developer**: [Your Name/Team]
- **Documentation**: [Your Name/Team]

---

## License
This project is licensed under the MIT License. See the LICENSE file for details.

