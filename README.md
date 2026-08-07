<div align="center">

# 🚀 CrowdPulse
### AI Crowd Monitoring & Smart Event Analytics Platform

**A cloud-native platform that transforms crowd management through real-time queue intelligence, predictive analytics, and production-ready DevOps infrastructure.**

<p align="center">

![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=springboot)
![React](https://img.shields.io/badge/React-19-61DAFB?style=for-the-badge&logo=react)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker)
![Kubernetes](https://img.shields.io/badge/Kubernetes-326CE5?style=for-the-badge&logo=kubernetes)
![Jenkins](https://img.shields.io/badge/Jenkins-D24939?style=for-the-badge&logo=jenkins)
![Prometheus](https://img.shields.io/badge/Prometheus-E6522C?style=for-the-badge&logo=prometheus)
![Grafana](https://img.shields.io/badge/Grafana-F46800?style=for-the-badge&logo=grafana)
![Redis](https://img.shields.io/badge/Redis-DC382D?style=for-the-badge&logo=redis)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql)

</p>

*"Built as a production-style cloud-native application to demonstrate scalable backend engineering, DevOps automation, and real-time analytics."*

</div>

---

# 🌍 Why CrowdPulse?

Managing crowds at temples, tourist destinations, and public events is still largely reactive. Visitors often have no idea about actual waiting times, administrators lack real-time operational insights, and existing systems rarely provide predictive intelligence.

**CrowdPulse** addresses these challenges by combining:

- 📊 Real-time crowd analytics
- ⏳ Intelligent wait-time estimation
- 📡 Live community-driven updates
- 📈 Crowd trend prediction
- ☁️ Cloud-native deployment
- 🔄 Automated CI/CD pipeline
- 📉 Production-grade monitoring

The project was designed not only as a crowd management solution but also as a demonstration of **modern backend engineering and DevOps practices.**

---

# ✨ Key Features

### 🚶 Virtual Queue Management

- Join and leave virtual queues
- Live queue position tracking
- Dynamic wait-time calculation

---

### 📈 Intelligent Wait-Time Estimation

Wait time is calculated using multiple operational parameters such as:

- Queue Length
- Average Group Size
- Throughput
- Efficiency Factor
- Community Reports

instead of relying on static estimates.

---

### 🤝 Community Intelligence

Temple volunteers or administrators can submit live crowd reports.

Updates are instantly broadcast to connected users using **WebSocket**, eliminating continuous polling.

---

### 📊 Crowd Prediction Engine

The prediction service analyzes:

- Historical queue metrics
- Current queue conditions
- Operational throughput

to generate:

- Best time to visit
- Peak crowd hours
- Crowd trend
- Smart recommendations

---

### 📡 Real-Time Communication

Implemented using:

- WebSocket
- STOMP
- SockJS

allowing connected clients to receive live updates instantly.

---

### ⚡ High-Performance Queue Tracking

Redis is used for:

- Heartbeat management
- Active user tracking
- Automatic cleanup of inactive users
- Fast in-memory operations

---

### ☁️ Cloud Native Deployment

Entire application is containerized and orchestrated using Kubernetes.

Includes:

- Backend
- Frontend
- MySQL
- Redis

running as independent services.

---

### 🔄 Complete CI/CD Pipeline

Automated using Jenkins.

Pipeline performs:

- Source Checkout
- Backend Build
- Frontend Build
- Docker Image Creation
- Docker Hub Push
- Kubernetes Deployment

---

### 📊 Observability

Production-style monitoring implemented using:

- Spring Boot Actuator
- Micrometer
- Prometheus
- Grafana

Monitoring includes:

- JVM Metrics
- CPU Usage
- HTTP Requests
- Kubernetes Pods
- Cluster Resources

---

# 🏗️ System Architecture

```text
                    React Frontend
                          │
                 REST API / WebSocket
                          │
                  Spring Boot Backend
        ┌─────────────────┼─────────────────┐
        │                 │                 │
     MySQL             Redis          Prediction
 (Persistent Data)   (Heartbeat)       Engine
        │
        ▼
 Kubernetes Cluster
        │
 Jenkins CI/CD Pipeline
        │
 Docker Containers
        │
 Prometheus + Grafana
```

---

# 🛠 Technology Stack

| Category | Technologies |
|-----------|--------------|
| Backend | Java, Spring Boot, Spring MVC, Spring Data JPA, Hibernate |
| Frontend | React.js, Vite, Tailwind CSS, Recharts |
| Database | MySQL |
| Cache | Redis |
| Communication | REST APIs, WebSocket (STOMP + SockJS) |
| Build Tool | Maven |
| Containerization | Docker, Docker Compose |
| Orchestration | Kubernetes |
| CI/CD | Jenkins |
| Monitoring | Spring Boot Actuator, Micrometer, Prometheus, Grafana |
| Version Control | Git, GitHub |

---

# ⚙️ Project Workflow

```text
User

↓

React Dashboard

↓

Spring Boot REST APIs

↓

Business Logic

↓

MySQL + Redis

↓

Prediction Engine

↓

WebSocket

↓

Live Dashboard Updates

↓

Prometheus Metrics

↓

Grafana Monitoring
```

---

# 📂 Backend Architecture

The backend follows a layered architecture.

```text
Controller

↓

Service

↓

Repository

↓

Database
```

This separation improves:

- Maintainability
- Scalability
- Testability

---

# 📈 Monitoring Stack

Application metrics are exposed using Spring Boot Actuator and Micrometer.

Prometheus periodically scrapes metrics from:

```text
/actuator/prometheus
```

Grafana visualizes:

- JVM Memory
- CPU Usage
- Live Threads
- HTTP Requests
- Kubernetes Metrics

---

# 🚀 DevOps Highlights

✅ Dockerized Microservice-style Architecture

✅ Kubernetes Deployments & Services

✅ Jenkins Automated CI/CD

✅ Docker Hub Integration

✅ Production Monitoring

✅ Cloud-native Deployment

---

# 📚 What I Learned

This project helped me gain practical experience with technologies beyond traditional backend development.

Some major learnings include:

- Designing scalable Spring Boot applications
- Redis for in-memory queue management
- WebSocket-based real-time communication
- Docker containerization
- Kubernetes orchestration
- Jenkins CI/CD automation
- Prometheus & Grafana monitoring
- Production deployment practices

More importantly, it taught me how all these technologies work together in a real-world cloud-native application.

---

# 🔮 Future Roadmap

- 🔐 Spring Security + JWT Authentication
- 🤖 AI/ML Crowd Prediction (LSTM / Prophet)
- 📷 Computer Vision-based Crowd Detection
- 📱 Mobile Application
- 📬 AlertManager Integration
- ⚖️ Horizontal Pod Autoscaling (HPA)
- ☁️ AWS Cloud Deployment
- 🌎 Multi-region Scaling

---

# 💡 Why This Project Stands Out

Unlike a traditional CRUD application, CrowdPulse combines:

- Backend Engineering
- Real-Time Communication
- Distributed Systems
- Cloud-Native Architecture
- CI/CD Automation
- Observability
- DevOps Best Practices

into a single production-style platform.

---

<div align="center">

## ⭐ If you found this project interesting, consider giving it a Star!

**Built with ❤️ using Java, Spring Boot, React & DevOps**

</div>
