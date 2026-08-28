# java-client-server-chat
A Java Socket Programming project demonstrating real-time communication between a client and server.
# 🌐 Java UDP DNS Client–Server

> **What happens when you enter a hostname and ask for its IP address?**

This project is a simple **DNS Client–Server application developed using Java UDP Socket Programming**.

The client sends a hostname to the server, and the server performs a DNS lookup to find the corresponding IP address and sends the result back to the client.

## 🚀 Project Overview

The project demonstrates the basic working of **DNS communication using UDP**.

### Communication Flow

Client
↓
Hostname
↓
UDP Datagram Packet
↓
DNS Server
↓
DNS Lookup
↓
IP Address
↓
UDP Response
↓
Client

## ✨ Features

- 🌐 Hostname to IP address resolution
- 📡 UDP-based communication
- 🔄 Client–server request and response
- 🔌 Uses `DatagramSocket`
- 📦 Uses `DatagramPacket`
- ⚡ Lightweight communication using UDP
- ❌ Handles unknown hostnames

## 🛠️ Technologies Used

- **Java**
- **UDP (User Datagram Protocol)**
- **DatagramSocket**
- **DatagramPacket**
- **InetAddress**
- **Networking Fundamentals**

## 📂 Project Structure

```text
java-udp-dns-client-server/
│
├── udpdnsclient.java
├── udpdnsserver.java
├── screenshots/
│   ├── client-output.png
│   └── server-output.png
│
└── README.md