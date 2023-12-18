# Inventory Stock Tracker

## Overview

This is a robust Inventory Management System developed using Spring Boot, designed to efficiently manage and track inventory records for various parts stored in warehouses.

## 🚀 Key Features

- **SA-IN and SA-OUT Operations:**
  - Seamlessly adjust stock quantities through Stock Adjustment In (SA-IN) and Stock Adjustment Out (SA-OUT) operations.

- **Data Model:**
  - Utilizes the `Inventory` class to represent unique inventory records identified by a combination of Part Number and Serial Number.

- **In-Memory Storage:**
  - Employs an in-memory ArrayList for storing inventory records, eliminating the need for a dedicated database.

- **Validation Service:**
  - Implements a ValidationService to ensure input integrity, preventing negative quantities and providing clear error responses.

- **RESTful API Endpoints:**
  - Offers intuitive and RESTful endpoints (/sa-in, /sa-out, /addinventory, /get) for seamless interaction with the system.

- **GitHub Actions Integration:**
  - Leverages GitHub Actions to automate the synchronization of inventory highlights, ensuring real-time updates.

🤝 Contributions
Contributions are welcome! Feel free to add extra features and new integrations.

👤 Author
Vaibhav Kubal
