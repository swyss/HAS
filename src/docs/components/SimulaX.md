# SimulaX Documentation

## Overview
SimulaX is a versatile data simulation application designed to generate and manage simulated datasets for various use cases, such as production and environmental data. The application integrates seamlessly into the Home Automation System (HAS) architecture, providing simulated data for testing and development.

## Features
- **Simulations Module**: Generate simulated datasets based on predefined parameters and scenarios.
- **Data Persistence**: Store simulation data in PostgreSQL or InfluxDB.
- **API Interfaces**: Access simulated data via REST APIs and WebSocket for real-time updates.
- **Real-Time Communication**: WebSocket integration for live data streaming.
- **Configuration Dashboard**: Manage and monitor simulations through an intuitive UI.

## Architecture
### Backend
- **Framework**: ASP.NET Core
- **Responsibilities**:
  - Managing simulation configurations.
  - Generating real-time simulation data.
  - Providing REST and WebSocket APIs.

### Frontend
- **Framework**: Vue.js with Quasar
- **Responsibilities**:
  - Interactive dashboards for managing simulations.
  - Visualization of real-time simulation data.

### Database
- **Relational**: PostgreSQL for storing structured data such as simulation configurations.
- **Time-Series**: InfluxDB for high-frequency data storage.

### Real-Time Communication
- WebSocket for delivering live data feeds to client applications.

## Integration with HAS
SimulaX is designed to be an independent yet integrable module within the HAS ecosystem:
1. **Backend Integration**:
   - Extend HAS’s REST API Gateway to route simulation-related requests to SimulaX.
   - Utilize shared services such as user authentication.
2. **Frontend Integration**:
   - Add a dedicated SimulaX dashboard in the Admin Console for unified management.
3. **Database Integration**:
   - Use shared database resources for consistent data management.

## Setup and Deployment
### Prerequisites
- Docker and Docker Compose
- ASP.NET Core SDK
- Node.js and Yarn
- PostgreSQL and InfluxDB

### Installation Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/<username>/SimulaX.git HAS/components/simulax
   ```
2. Build the backend:
   ```bash
   cd HAS/components/simulax/backend
   dotnet build
   ```
3. Start the frontend:
   ```bash
   cd HAS/components/simulax/frontend
   yarn install
   yarn serve
   ```
4. Update Docker Compose:
   Add SimulaX to the HAS’s `docker-compose.yml` file:
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
5. Start all services:
   ```bash
   docker-compose up --build
   ```

## Usage
1. Access the dashboard via the Admin Console.
2. Configure simulation parameters and start simulations.
3. Use REST APIs or WebSocket endpoints to retrieve simulated data.

## API Endpoints
### REST API
- **GET /api/simulax/configurations**: Retrieve simulation configurations.
- **POST /api/simulax/start**: Start a simulation with specified parameters.

### WebSocket
- **Endpoint**: `/ws/simulax`
- **Messages**:
  - **Simulation Update**: Live data updates for active simulations.

## Future Enhancements
- Support for additional simulation scenarios.
- Enhanced analytics and reporting.
- Machine learning-based scenario generation.

