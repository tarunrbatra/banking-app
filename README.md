# Banking Application

## Overview
This is a simple Banking Application built in Java, designed to manage customer accounts and handle basic banking operations such as withdrawals, deposits, and account management. The application exposes a RESTful API for interaction.

## Features
- Create new accounts
- Retrieve details of existing accounts
- Deposit and withdraw money
- List all accounts
- Delete accounts

## Technologies Used
- Java
- Spring Boot
- RESTful API
- MySQL Database

## REST Endpoints

### Account Management

#### Create a New Account
**POST** `/api/accounts`
- **Description**: Creates a new bank account.
- **Request Body**:
```json
{
  "name": "Customer Name",
  "initialBalance": 1000.0
}
```
- **Response**:
    - `201 Created` on success.

#### Retrieve All Accounts
**GET** `/api/accounts`
- **Description**: Fetches a list of all bank accounts.
- **Response**:
```json
[
  {
    "id": 1,
    "name": "Customer Name",
    "balance": 1000.0
  },
  ...
]
```

#### Retrieve an Account by ID
**GET** `/api/accounts/{id}`
- **Description**: Fetches details of a specific account by its ID.
- **Response**:
```json
{
  "id": 1,
  "name": "Customer Name",
  "balance": 1000.0
}
```

#### Delete an Account
**DELETE** `/api/accounts/{id}`
- **Description**: Deletes a specific account by its ID.
- **Response**:
    - `200 OK` on success.

### Transactions

#### Withdraw from an Account
**PUT** `/api/accounts/{id}/withdraw`
- **Description**: Withdraws a specified amount from the account.
- **Request Body**:
```json
{
  "amount": 500.0
}
```
- **Response**:
```json
{
  "id": 1,
  "name": "Customer Name",
  "balance": 500.0
}
```

#### Deposit to an Account
**PUT** `/api/accounts/{id}/deposit`
- **Description**: Deposits a specified amount to the account.
- **Request Body**:
```json
{
  "amount": 500.0
}
```
- **Response**:
```json
{
  "id": 1,
  "name": "Customer Name",
  "balance": 1500.0
}
```

## Getting Started

### Prerequisites
- Java 17 or later
- Maven
- A REST client (e.g., Postman or cURL)

### Running the Application
1. Clone the repository.
2. Navigate to the project directory.
3. Run the following command to build and start the application:
   ```bash
   mvn spring-boot:run
   ```
4. The application will be accessible at `http://localhost:8080`.

### Testing the API
- Use any REST client to interact with the endpoints listed above.

## Future Enhancements
- Add authentication and authorization.
- Implement transfer functionality between accounts.
- Add unit and integration tests.

## License
This project is licensed under the MIT License.

---
Feel free to contribute to the project by submitting issues or pull requests!
