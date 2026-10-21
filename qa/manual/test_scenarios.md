
# Hotel Reservation API - Manual Test Scenarios

## 1. Hotel Management

| ID | Test Scenario | Test Type |
|---|---|---|
| TS-01 | Verify successful hotel creation with valid data | Positive |
| TS-02 | Verify that hotel creation is allowed only when the star rating is between 1 and 5 | Validation |
| TS-03 | Verify that an existing hotel's details can be successfully updated with valid data | Positive |
| TS-04 | Verify that all existing hotels can be successfully retrieved | Positive |
| TS-05 | Verify that an existing hotel can be successfully deleted by its ID | Positive |
| TS-06 | Verify that an existing hotel can be successfully retrieved by its ID | Positive |

## 2. Customer Management

| ID | Test Scenario | Test Type |
|---|---|---|
| TS-07 | Verify successful customer creation with valid data | Positive |
| TS-08 | Verify that each customer must have a unique email address | Validation |
| TS-09 | Verify that all customers registered in the system can be successfully retrieved | Positive |
| TS-10 | Verify that an existing customer can be successfully retrieved by their ID | Positive |

## 3. Reservation Management

| ID | Test Scenario | Test Type |
|---|---|---|
| TS-11 | Verify successful reservation creation with valid data | Positive |
| TS-12 | Verify successful reservation cancellation | Positive |
| TS-13 | Verify that reservations cannot overlap for the same customer | Validation |
| TS-14 | Verify that cancelling a reservation updates its status instead of permanently deleting it | Functional |
| TS-15 | Verify that the check-out date must be later than the check-in date | Validation |
| TS-16 | Verify that all reservations registered in the system can be successfully retrieved | Positive |
| TS-17 | Verify that an existing reservation can be successfully retrieved by its ID | Positive |
| TS-18 | Verify that reservation total price cannot be negative | Validation |

## 4. Reservation Search

| ID | Test Scenario | Test Type |
|---|---|---|
| TS-19 | Verify that reservations can be successfully searched using individual or combined search criteria (hotel name, customer name, city, status, check-in date, and check-out date). | Positive |

## 5. Error Handling

| ID | Test Scenario | Test Type |
|---|---|---|
| TS-20 | Verify that invalid API requests return appropriate HTTP status codes and meaningful error messages | Negative |



## Requirement Clarifications

- **Reservation overlap:** Confirm whether overlapping reservations are prohibited for the same customer across all hotels or only at the same hotel.
