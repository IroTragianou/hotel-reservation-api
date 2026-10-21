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