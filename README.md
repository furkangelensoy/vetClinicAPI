# Vet Clinic Management API

## Technologies

- Java
- Spring Boot
- Spring Data JPA
- PostgresSQL, MySQL
- Lombok
- Mapstruct
- Swagger

## Installation

1. **Clone this repository**

```
git clone https://github.com/furkangelensoy/vetClinicAPI.git
```

2. **Database Setup**

    1. Create a PostgresSQL database or Mysql database.
    2. Set your database connection details in `application.properties` file.


3. **Run the Application**

   Navigate to the project directory and run the following command:

    ```
    mvn spring-boot:run
    ```


## UML Diagram, API Endpoints and Database Screenshots

<details close>
<summary>UML Diagram</summary>
<br>

![UML](https://github.com/furkangelensoy/vetClinicAPI/assets/134130366/b79c393c-a19f-46ef-8c25-fdcaa9dafeda)

</details>


<details close>
<summary>Database Screenshots</summary>
<br>

<details close>
<summary>Animal</summary>
<br>


</details>

<details close>
<summary>Customer</summary>
<br>


</details>


<details close>
<summary>Doctor</summary>
<br>


</details>


<details close>
<summary>Vaccine</summary>
<br>


</details>

<details close>
<summary>Appointment</summary>
<br>



</details>


<details close>
<summary>Available Date</summary>
<br>


</details>



</details>

<details close>
<summary>API Endpoints</summary>
<br>

<details close>
<summary>Vaccine</summary>
<br>

| HTTP Method | Endpoint                    | Description                                                          |
   |-------------|-----------------------------|----------------------------------------------------------------------|
| GET         | /v1/vaccines/{id}           | Gets a vaccine according to id                                       |
| PUT         | /v1/vaccines/{id}           | Updates a vaccine according to id                                    |
| DELETE      | /v1/vaccines/{id}           | Deletes a vaccine according to id                                    |
| GET         | /v1/vaccines                | Lists all vaccines, you can also list vaccines according to animalId |
| POST        | /v1/vaccines                | Creates a vaccine                                                    |
| GET         | /v1/vaccines/filter-by-date | Lists vaccines according to startDate and endDate                    |

</details>

<details close>
<summary>Doctor</summary>
<br>

| HTTP Method | Endpoint                 | Description                      |
   |-------------|--------------------------|----------------------------------|
| GET         | /v1/doctors/{id}         | Gets a doctor according to id    |
| PUT         | /v1/doctors/{id}         | Updates a doctor according to id |
| DELETE      | /v1/doctors/{id}         | Deletes a doctor according to id |
| GET         | /v1/doctors              | Gets all doctors                 |
| POST        | /v1/doctors              | Creates a doctor                 | 

</details>

<details close>
<summary>Customer</summary>
<br>

| HTTP Method | Endpoint           | Description                                                                |
   |-------------|--------------------|----------------------------------------------------------------------------|
| GET         | /v1/customers/{id} | Gets a customer according to id                                            |
| PUT         | /v1/customers/{id} | Updates a customer according to id                                         |
| DELETE      | /v1/customers/{id} | Deletes a customer according to id                                         |
| GET         | /v1/customers      | Lists all customers, you can also list customers according to customerName |
| POST        | /v1/customers      | Creates a customer                                                         |

</details>

<details close>
<summary>Available Date</summary>
<br>

| HTTP Method | Endpoint                 | Description                               |
   |-------------|--------------------------|-------------------------------------------|
| GET         | /v1/available-dates/{id} | Gets an available date according to id    |
| PUT         | /v1/available-dates/{id} | Updates an available date according to id |
| DELETE      | /v1/available-dates/{id} | Deletes an available date according to id |
| GET         | /v1/available-dates      | Lists all available dates                 |
| POST        | /v1/available-dates      | Creates an available date                 |

</details>


<details close>
<summary>Appointment</summary>
<br>

| HTTP Method | Endpoint                        | Description                                                              |
   |-------------|---------------------------------|--------------------------------------------------------------------------|
| GET         | /v1/appointments/{id}           | Gets an appointment according to id                                      |
| PUT         | /v1/appointments/{id}           | Updates an appointment according to id                                   |
| DELETE      | /v1/appointments/{id}           | Deletes an appointment according to id                                   |
| GET         | /v1/appointments                | Lists all appointments                                                   |
| POST        | /v1/appointments                | Creates an appointment                                                   |
| GET         | /v1/appointments/get-by-doctor  | Gets an appointment date according to start date, end date and doctor id |
| GET         | /v1/appointments/get-by-animal  | Gets an appointment date according to start date, end date and animal id |
</details>


<details close>
<summary>Animal</summary>
<br>

| HTTP Method | Endpoint         | Description                                                                        |
   |-------------|------------------|------------------------------------------------------------------------------------|
| GET         | /v1/animals/{id} | Gets an animal according to id                                                     |
| PUT         | /v1/animals/{id} | Updates an animal according to id                                                  |
| DELETE      | /v1/animals/{id} | Deletes an animal according to id                                                  |
| GET         | /v1/animals      | Lists all animals, you can also list animals according to customerId or animalName |
| POST        | /v1/animals      | Creates an animal                                                                  |

</details>


</details>

<details close>
<summary>Swagger Screenshots</summary>
<br>


<details close>
<summary>Animal Controller</summary>
<br>


</details>


<details close>
<summary>Customer Controller</summary>
<br>


</details>


<details close>
<summary>Doctor Controller</summary>
<br>


</details>


<details close>
<summary>Vaccine Controller</summary>
<br>


</details>


<details close>
<summary>Appointment Controller</summary>
<br>


</details>


<details close>
<summary>Available-Date Controller</summary>
<br>


</details>



</details>