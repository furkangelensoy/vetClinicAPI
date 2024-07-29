# Vet Clinic Management API
This project developed for a veterinary clinic to manage its own affairs. The project is designed to be used by veterinary staff.
N layer architecture and java spring boot were used in this project. This project consists of controller, core, dto, entity, service and repository packages.

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


## UML Diagram

<details close>
<summary>UML Diagram</summary>
<br>

![UML](https://github.com/furkangelensoy/vetClinicAPI/assets/134130366/b79c393c-a19f-46ef-8c25-fdcaa9dafeda)

</details>


## Database Screenshots

<details close>
<summary>Database Screenshots</summary>
<br>

<details close>
<summary>Animal</summary>
<br>

![animals](https://github.com/furkangelensoy/vetClinicAPI/assets/134130366/c6a4fe12-7753-4002-943c-c4d59c80757a)

</details>

<details close>
<summary>Customer</summary>
<br>
    
![customers](https://github.com/furkangelensoy/vetClinicAPI/assets/134130366/91165657-ac2c-4395-b382-dc9c59334187)


</details>


<details close>
<summary>Doctor</summary>
<br>

![doctors](https://github.com/furkangelensoy/vetClinicAPI/assets/134130366/3a7bed2f-40a6-43d6-b8df-c09b0b4dd406)

</details>


<details close>
<summary>Vaccine</summary>
<br>
    
![vaccines](https://github.com/furkangelensoy/vetClinicAPI/assets/134130366/2e2ee11c-0a54-46f8-9180-9cc8d0f01ff2)


</details>

<details close>
<summary>Appointment</summary>
<br>

![appointments](https://github.com/furkangelensoy/vetClinicAPI/assets/134130366/8b5c9b21-1e1a-4041-9967-1b6debd37e1a)


</details>


<details close>
<summary>Available Date</summary>
<br>

![available](https://github.com/furkangelensoy/vetClinicAPI/assets/134130366/ea2ee607-bae5-41e6-bc49-c557ce93fb27)

</details>


</details>



## API Endpoints

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


## Swagger Screenshots

<details close>
<summary>Swagger Screenshots</summary>
<br>


<details close>
<summary>Animal Controller</summary>
<br>

![id](https://github.com/furkangelensoy/vetClinicAPI/assets/134130366/449af901-c76b-4f16-9412-f76d8833e959)
![put](https://github.com/furkangelensoy/vetClinicAPI/assets/134130366/64803263-cc10-4032-82d7-3363524e5e9f)
![delete](https://github.com/furkangelensoy/vetClinicAPI/assets/134130366/6e86bbad-2f19-4d1b-839a-cfe9a4a72851)
![get](https://github.com/furkangelensoy/vetClinicAPI/assets/134130366/c43d742a-7b40-4b7d-bad3-d828a3d039b6)
![post](https://github.com/furkangelensoy/vetClinicAPI/assets/134130366/eef4be82-966d-4b8a-93b7-c5c4e5c276a1)

</details>


<details close>
<summary>Customer Controller</summary>
<br>
    
![id](https://github.com/furkangelensoy/vetClinicAPI/assets/134130366/43088560-864f-413f-a7dc-ae869264b661)
![put](https://github.com/furkangelensoy/vetClinicAPI/assets/134130366/4f4dcf21-5d50-411f-ab59-ef120f25f556)
![delete](https://github.com/furkangelensoy/vetClinicAPI/assets/134130366/2a047b0a-cb23-4b36-83a2-e40a9fbd9d28)
![get](https://github.com/furkangelensoy/vetClinicAPI/assets/134130366/a884f59d-3873-48cb-8f6c-a989a443bd30)
![post](https://github.com/furkangelensoy/vetClinicAPI/assets/134130366/42aa1d0d-6855-4739-98fa-741430e51415)

</details>


<details close>
<summary>Doctor Controller</summary>
<br>

![id](https://github.com/furkangelensoy/vetClinicAPI/assets/134130366/9137a569-7fd4-446b-bb41-16ba5fde9f54)
![put](https://github.com/furkangelensoy/vetClinicAPI/assets/134130366/e6eec754-f4e6-434c-9f72-91e6a500de7b)
![delete](https://github.com/furkangelensoy/vetClinicAPI/assets/134130366/ccbe2988-8131-48eb-9c95-4be079244891)
![get](https://github.com/furkangelensoy/vetClinicAPI/assets/134130366/bff284e6-7fc4-4891-9a89-686145bb57ad)
![post](https://github.com/furkangelensoy/vetClinicAPI/assets/134130366/0c1ef8f8-cfae-4f3c-afe9-addaa5025c27)

</details>


<details close>
<summary>Vaccine Controller</summary>
<br>
    
![get](https://github.com/furkangelensoy/vetClinicAPI/assets/134130366/63a718d1-c31d-4bc4-9ac6-34ae5638ab5d)
![put](https://github.com/furkangelensoy/vetClinicAPI/assets/134130366/86fb6164-2e0e-44af-991a-b465259af60b)
![delete](https://github.com/furkangelensoy/vetClinicAPI/assets/134130366/2e31f1c1-bfeb-4098-908f-7b8f4989536f)
![all](https://github.com/furkangelensoy/vetClinicAPI/assets/134130366/5486bfaf-a185-405f-b7ee-210035998241)
![post](https://github.com/furkangelensoy/vetClinicAPI/assets/134130366/8afda5f2-fdbd-43e6-a3c7-fa13dac64306)
![filter](https://github.com/furkangelensoy/vetClinicAPI/assets/134130366/2e2f8892-cc60-4df8-8448-42938fa44975)


</details>


<details close>
<summary>Appointment Controller</summary>
<br>
    
![id](https://github.com/furkangelensoy/vetClinicAPI/assets/134130366/a48f3d4b-3f0c-41b7-ad80-874d05fb2f76)
![put](https://github.com/furkangelensoy/vetClinicAPI/assets/134130366/d51a6a71-8d9a-4073-8f6d-2651310be14a)
![delete](https://github.com/furkangelensoy/vetClinicAPI/assets/134130366/96d5e334-1884-47cb-958c-c596eeeb7513)
![get](https://github.com/furkangelensoy/vetClinicAPI/assets/134130366/9eb7f3c0-3286-42dc-9800-dfc016f7f353)
![post](https://github.com/furkangelensoy/vetClinicAPI/assets/134130366/90c57591-07ff-4109-ad7e-e5538645f0eb)
![get-by-animal](https://github.com/furkangelensoy/vetClinicAPI/assets/134130366/e1db48f3-0f54-4669-845c-2552452b05f3)
![get-by-doctor](https://github.com/furkangelensoy/vetClinicAPI/assets/134130366/a4650b48-0d13-45c0-b296-11d1cd3562b9)


</details>


<details close>
<summary>Available-Date Controller</summary>
<br>

![id](https://github.com/furkangelensoy/vetClinicAPI/assets/134130366/c259c12a-86c4-42f4-bd0e-ba664a101ac0)
![put](https://github.com/furkangelensoy/vetClinicAPI/assets/134130366/2f2e11f0-754c-4dd5-9a2c-0d1b8c06faa6)
![delete](https://github.com/furkangelensoy/vetClinicAPI/assets/134130366/bab22e52-ea30-439d-aca3-14fc263b6057)
![get](https://github.com/furkangelensoy/vetClinicAPI/assets/134130366/efe061f2-0d03-401e-bf81-bdd6bdebafa6)
![post](https://github.com/furkangelensoy/vetClinicAPI/assets/134130366/22d78aed-ccf3-4e53-8954-2dd602e181ea)

</details>



</details>
