
# Life Insurance Management System

## 📝 Project Overview

This project is a comprehensive backend system for managing life insurance policies. It facilitates:

- **Agent Operations**: Agents can create and manage policies for customers.
- **Customer Access**: Customers can view their policies and related details.
- **Commission Tracking**: Automatic calculation and tracking of agent commissions.

## 🛠️ Tech Stack

- **Backend**: Spring Boot
- **Frontend**: Angular
- **Database**: Aiven Cloud MySQL
- **API Testing**: Postman

- ## 🔐 Security

- **Authentication**: Currently, authentication is disabled for testing purposes. Planning to implement JWT-based authentication.
- **Role-Based Access**: Designed to support different roles such as Agent, Customer, and Admin.

## 🚀 Features

- **User Registration**: Agents and customers can register.
- **Login**: Users can log in to access their dashboards.
- **Policy Management**: Agents can create policies for customers.
- **Policy Viewing**: Customers can view their policies.
- **Commission Calculation**: Automatic calculation of agent commissions upon policy creation.

## 📊 Database Schema

_Cloud Database Hosted on Aiven MySQL_

## 📬 API Endpoints

### Authentication

- `POST /api/auth/register`: Register a new user.
- `POST /api/auth/login`: Log in a user.

### Users

- `GET /api/users/customers`: Retrieve all customers.
- `GET /api/users/{id}`: Retrieve user details by ID.

### Policies

- `POST /api/policies`: Create a new policy.
- `GET /api/policies/{customer_id}`: Retrieve policies for a specific customer.

### Commissions

- `GET /api/commissions/my`: Retrieve commissions for the logged-in agent.

## 📝 Future Improvements

- Implement JWT-based authentication.
- Add validation annotations (`@NotNull`, `@Size`, etc.) on DTOs for request validation.
- Enhance error handling with a global exception handler.
- - Create Admin APIs for:
  - Managing agents and customers
  - Viewing all policies and commissions globally
- Add Email Notifications on policy creation and premium due dates.
- Implement Policy Renewal and Premium Payment APIs.
- Introduce Dashboard Metrics APIs (total policies, total commissions, active customers, etc.)

