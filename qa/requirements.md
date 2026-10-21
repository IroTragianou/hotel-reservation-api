
# Hotel Reservation API - Functional Requirements

## Overview

This document summarizes the functional requirements and business rules used for manual API testing of the Hotel Reservation API.

## 1. Hotel Management

| ID | Requirement |
|---|---|
| REQ-01 | The system must allow the creation of hotels. |
| REQ-02 | The system must allow retrieval of all hotels. |
| REQ-03 | The system must allow retrieval of a hotel by ID. |
| REQ-04 | The system must allow updating an existing hotel. |
| REQ-05 | The system must allow deletion of a hotel by ID. |
| REQ-06 | Hotel star ratings must be between 1 and 5. |

### Hotel Fields

| Field | Data Type |
|---|---|
| id | Long |
| name | String |
| city | String |
| stars | Integer |

## 2. Customer Management

| ID | Requirement |
|---|---|
| REQ-07 | The system must allow the creation of customers. |
| REQ-08 | The system must allow retrieval of all customers. |
| REQ-09 | The system must allow retrieval of a customer by ID. |
| REQ-10 | Customer email addresses must be unique. |

### Customer Fields

| Field | Data Type |
|---|---|
| id | Long |
| firstName | String |
| lastName | String |
| email | String |

## 3. Reservation Management

| ID | Requirement |
|---|---|
| REQ-11 | The system must allow the creation of reservations. |
| REQ-12 | The system must allow retrieval of all reservations. |
| REQ-13 | The system must allow retrieval of a reservation by ID. |
| REQ-14 | The system must allow cancellation of reservations. |
| REQ-15 | Reservation cancellation must update the status to CANCELLED without physically deleting the record. |
| REQ-16 | Reservations must not overlap for the same customer. |
| REQ-17 | The check-out date must be later than the check-in date. |
| REQ-18 | Reservation total price cannot be negative. |

### Reservation Fields

| Field | Data Type |
|---|---|
| id | Long |
| hotel_id | Foreign Key |
| customer_id | Foreign Key |
| checkIn | Date |
| checkOut | Date |
| totalPrice | Decimal |
| status | ACTIVE / CANCELLED |

## 4. Reservation Search

| ID | Requirement |
|---|---|
| REQ-19 | The system must support reservation searches using hotel name, customer name, city, status, check-in date, and check-out date. |

### Search Criteria

- hotelName
- customerName
- city
- status
- checkIn
- checkOut

## 5. Error Handling

| ID | Requirement |
|---|---|
| REQ-20 | Invalid API requests must return meaningful error responses. |


