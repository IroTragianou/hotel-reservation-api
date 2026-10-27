# Hotel Reservation API - Manual Test Cases

## 1. Hotel Management

### TC-01: Create Hotel with Valid Data

**Related Scenario:** TS-01  
**Test Type:** Positive  
**Preconditions:** API and DB available.

**Test Data:**
- Name: Sea Breeze Hotel
- City: Paros
- Stars: 4

**Test Steps:**
1. Send POST `/hotels` with valid data.
2. Check API response.
3. Verify data in DB.

**Expected Result:**
- HTTP 2xx.
- Data saved in DB.

**Actual Result:** HTTP 200 OK. DB verified.

**Status:** PASSED

### TC-02: Create Hotel with Invalid Star Rating (Below Minimum)

**Related Scenario:** TS-02  
**Test Type:** Negative  
**Preconditions:** API and DB available.

**Test Data:**
- Name: Sea Breeze Hotel
- City: Paros
- Stars: 0

**Test Steps:**
1. Send POST `/hotels` with stars = 0.
2. Check API response.
3. Verify no data saved in DB.

**Expected Result:**
- HTTP 400 Bad Request.
- No data saved in DB.

**Actual Result:** HTTP 400 Bad Request. DB verified.

**Status:** PASSED

### TC-03: Create Hotel with Invalid Star Rating (Above Maximum)

**Related Scenario:** TS-02  
**Test Type:** Negative  
**Preconditions:** API and DB available.

**Test Data:**
- Name: Sea Breeze Hotel
- City: Paros
- Stars: 6

**Test Steps:**
1. Send POST `/hotels` with stars = 6.
2. Check API response.
3. Verify no data saved in DB.

**Expected Result:**
- HTTP 400 Bad Request.
- No data saved in DB.

**Actual Result:** HTTP 400 Bad Request. DB verified.

**Status:** PASSED

### TC-04: Create Hotel with Minimum Valid Star Rating (BVA)

**Related Scenario:** TS-02  
**Test Type:** Positive  
**Preconditions:** API and DB available.

**Test Data:**
- Name: Sea Breeze Hotel
- City: Paros
- Stars: 1

**Test Steps:**
1. Send POST `/hotels` with stars = 1.
2. Check API response.
3. Verify data in DB.

**Expected Result:**
- HTTP 2xx.
- Data saved in DB.

**Actual Result:** HTTP 200 OK. DB verified.

**Status:** PASSED

### TC-05: Create Hotel with Maximum Valid Star Rating (BVA)

**Related Scenario:** TS-02  
**Test Type:** Positive  
**Preconditions:** API and DB available.

**Test Data:**
- Name: Sea Breeze Hotel
- City: Paros
- Stars: 5

**Test Steps:**
1. Send POST `/hotels` with stars = 5.
2. Check API response.
3. Verify data in DB.

**Expected Result:**
- HTTP 2xx.
- Data saved in DB.

**Actual Result:** HTTP 200 OK. DB verified.

**Status:** PASSED

### TC-06: Create Hotel with Invalid Star Rating (Negative Number)

**Related Scenario:** TS-02  
**Test Type:** Negative  
**Preconditions:** API and DB available.

**Test Data:**
- Name: Sea Breeze Hotel
- City: Paros
- Stars: -1

**Test Steps:**
1. Send POST `/hotels` with stars = -1.
2. Check API response.
3. Verify no data saved in DB.

**Expected Result:**
- HTTP 400.
- Data not saved in DB.

**Actual Result:** HTTP 400 Bad Request. DB verified.

**Status:** PASSED

### TC-07: Create Hotel with Invalid Star Rating (String)

**Related Scenario:** TS-02
**Test Type:** Negative
**Preconditions:** API and DB available.

**Test Data:**
- Name: Sea Breeze Hotel
- City: Paros
- Stars: "five"

**Test Steps:**
1. Send POST `/hotels` with stars = "five".
2. Check API response.
3. Verify no data saved in DB.

**Expected Result:**
- HTTP 400 Bad Request.
- No data saved in DB.

**Actual Result:** HTTP 400 Bad Request. DB verified.

**Status:** PASSED

### TC-08: Update Existing Hotel with Valid Data

**Related Scenario:** TS-03

**Test Type:** Positive

**Preconditions:**
- API and DB available.
- An existing hotel in DB.

**Test Steps:**
1. Send PUT `/hotels/{id}` with valid updated hotel data.
2. Check API response.
3. Verify updated hotel data in DB.
4. Verify no new hotel was created.

**Expected Result:**
- HTTP 200 OK.
- Existing hotel updated successfully.
- Updated data saved in DB.
- No duplicate hotel created.

**Actual Result:** HTTP 200 OK. Hotel updated successfully. DB verified. No duplicate created.

**Status:** PASSED

### TC-11: Create Reservation with Valid Data
**Related Scenario:** TS-11
**Test Type:** Positive

**Preconditions:**
- API and DB available.
- An existing hotel and customer in the DB.

**Test Steps:**
1. Send POST `/reservations` with valid data.
2. Check API response.
3. Verify reservation data in DB.

**Expected Result:**
- HTTP 201 Created.
- Reservation created successfully.
- Correct reservation data saved in DB.

**Actual Result:** HTTP 201 Created. DB verified.

**Status:** PASSED

### TC-12: Cancel Reservation
**Related Scenarios:** TS-12, TS-14
**Test Type:** Positive

**Preconditions:**
- API and DB available.
- An existing reservation with status ACTIVE.

**Test Steps:**
1. Send DELETE `/reservations/{id}` with a valid reservation ID.
2. Check API response.
3. Verify reservation status in DB.

**Expected Result:**
- HTTP 200 OK.
- Reservation status changed to CANCELLED.
- Reservation remains in DB.

**Actual Result:** HTTP 200 OK. Reservation status changed to CANCELED in DB.

**Status:** PASSED


### TC-15: Reject Reservation When Check-Out Is Before Check-In
**Related Scenario:** TS-15
**Test Type:** Negative

**Preconditions:**
- API and DB available.
- An existing hotel and customer in the DB.

**Test Steps:**
1. Send POST `/reservations` with checkIn = 2026-11-15 and checkOut = 2026-11-14.
2. Check API response.
3. Verify no reservation saved in DB.

**Expected Result:**
- HTTP 400 Bad Request.
- Reservation not created.
- No data saved in DB.

**Actual Result:** HTTP 400 Bad Request. No reservation saved in DB.

**Status:** PASSED

### TC-16: Retrieve All Reservations
**Related Scenario:** TS-16
**Test Type:** Positive

**Preconditions:**
- API and DB available.
- Existing reservations in DB.

**Test Steps:**
1. Send GET `/reservations`.
2. Check API response.
3. Compare returned reservations with DB.

**Expected Result:**
- HTTP 200 OK.
- All reservations returned successfully.
- Response data matches DB.

**Actual Result:** HTTP 200 OK. All reservations retrieved and verified in DB.

**Status:** PASSED

### TC-17: Retrieve Reservation by ID

**Related Scenario:** TS-17
**Test Type:** Positive

**Preconditions:**
- API and DB available.
- An existing reservation with ID = 9.

**Test Steps:**
1. Send GET `/reservations/9`.
2. Check API response.
3. Verify reservation data in DB.

**Expected Result:**
- HTTP 200 OK.
- Reservation with ID = 9 returned successfully.
- Response data matches DB.

**Actual Result:** HTTP 200 OK. Reservation with ID = 9 retrieved and verified in DB.

**Status:** PASSED

### TC-17.1: Retrieve Non-Existent Reservation by ID

**Related Scenarios:** TS-17, TS-20

**Test Type:** Negative

**Preconditions:**
- API and DB available.
- Reservation ID 99999 does not exist in DB.

**Test Steps:**
1. Send GET `/reservations/99999`.
2. Check API response and error message.
3. Verify reservation ID 99999 does not exist in DB.

**Expected Result:**
- HTTP 404 Not Found.
- Meaningful error message returned.
- No reservation found in DB.

**Actual Result:** HTTP 404 Not Found. Error message returned. DB verified.

**Status:** PASSED

### TC-18: Reject Reservation with Negative Total Price

**Related Scenario:** TS-18

**Test Type:** Negative

**Preconditions:**
- API and DB available.
- An existing hotel and customer in the DB.

**Test Data:**
- Total Price: -100

**Test Steps:**
1. Send POST `/reservations` with totalPrice = -100 and other valid data.
2. Check API response.
3. Verify no reservation saved in DB.

**Expected Result:**
- HTTP 400 Bad Request.
- Reservation not created.
- No data saved in DB.

**Actual Result:** HTTP 400 Bad Request. No reservation saved in DB.

**Status:** PASSED