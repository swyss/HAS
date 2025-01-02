# Supported Protocols Documentation

## Overview
The HAS system integrates various smart home protocols to enable communication with a wide range of devices and services. SimulaX expands this capability by adding support for REST APIs and WebSocket for real-time simulation data.

---

## Supported Protocols

### **1. ZigBee**
- **Purpose:** Wireless communication for smart devices (sensors, actuators).
- **Integration:** ZigBee2MQTT.
- **Use Cases:**
  - Smart lighting (e.g., Philips Hue).
  - Motion sensors and temperature monitoring.

### **2. Z-Wave**
- **Purpose:** Energy-efficient mesh network for smart devices.
- **Integration:** OpenZWave.
- **Use Cases:**
  - Smart locks, thermostats, and switches.

### **3. MQTT**
- **Purpose:** Lightweight messaging protocol for real-time communication.
- **Integration:** paho-mqtt library in Python (EdgeLink).
- **Use Cases:**
  - Gateway-to-Backend data transfer.
  - Real-time sensor updates.

### **4. Philips Hue API**
- **Purpose:** REST API for Philips Hue smart lighting systems.
- **Integration:** Local bridge API.
- **Use Cases:**
  - Light control and scene management.

### **5. Google Home API**
- **Purpose:** Integration with Google Smart Home SDK.
- **Integration:** Actions on Google.
- **Use Cases:**
  - Voice control and synchronization of smart devices.

### **6. REST APIs**
- **Purpose:** Standard communication for custom sensors and actuators.
- **Use Cases:**
  - Integration of proprietary or custom-built devices.
  - Dynamic status updates using SystemMessage models.

### **7. SimulaX REST and WebSocket APIs**
- **Purpose:** Real-time simulation data management and retrieval.
- **Use Cases:**
  - Retrieve simulation configurations.
  - Stream real-time data updates for active simulations via WebSocket.

---

## Future Protocols
- **KNX:** Wired communication for building automation.
- **BACnet:** HVAC system management.
- **Custom Protocols:** Integration with proprietary systems using REST APIs.

---

## Enhanced Use Cases
The addition of **SimulaX** introduces advanced monitoring capabilities for:
- Testing system responses with simulated data.
- Generating data for predictive maintenance and analytics scenarios.