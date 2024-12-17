# Database Documentation

## Overview
The HAS system uses multiple databases to manage relational data, time-series data, and caching for optimal performance.

---

## Database Overview

| **Type**       | **Technology** | **Purpose**                             |
|----------------|----------------|-----------------------------------------|
| Relational     | PostgreSQL     | User management, devices, roles, configurations. |
| Time-Series    | InfluxDB       | Storage of real-time sensor and event data. |
| Caching        | Redis          | API performance optimization and temporary storage. |

---

## PostgreSQL Schema
### **Tables**
1. **Users**
   - `id`: Primary key  
   - `username`: Unique name  
   - `role`: Role of the user  
   - `created_at`: Timestamp  

2. **Devices**
   - `device_id`: Primary key  
   - `type`: Device type (sensor, actuator)  
   - `status`: Current status  
   - `location`: Device location  

3. **Configuration**
   - `config_id`: Primary key  
   - `key`: Configuration key  
   - `value`: Configuration value  

---

## InfluxDB Schema
### **Measurements**
1. **SensorData**
   - `time`: Timestamp  
   - `device_id`: ID of the device  
   - `value`: Recorded sensor value  

---

## Redis Usage
- **Session Storage:** User authentication tokens.  
- **Caching:** Frequently accessed device data.  

---

## Future Enhancements
- Database migration scripts for version control.
- Backup and recovery strategy.
