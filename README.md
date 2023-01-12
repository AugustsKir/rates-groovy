# Groovy/Spring Exchange Rate App 💵

Exchange rate API made with Groovy and Spring Boot. Similar to [Java Exchange Rate App](https://github.com/AugustsKir/exchange-rates), but made in Groovy and Spring Boot 


## Instructions

1. Clone the project to your local computer,

2. Create a docker container for the database:

```bash
docker run --name currency-database -e MARIADB_USER=user -e MARIADB_PASSWORD=password -e MYSQL_ROOT_PASSWORD=rootpassword -e MARIADB_DATABASE=currency-database -p 3306:3306 -d mariadb:latest
```
3. To run the application:
- Locate the project folder and open the terminal, and type the following command:

```bash
./mvnw spring-boot:run

``` 
**OR**

- Start the application from your IDE

**APP WILL BE RUNNING ON *LOCALHOST:8080***
## Endpoints

Endpoint bellow will return a list of the latest rates in relation to EUR **[GET]**
```
/api/latest
```
Endpoint below will return historical rates of a given currency. **[GET]** (Given example for USD)
```
/api/usd
```
To load data **[POST]**
```
/admin/rates
```
to clear data **[DELETE]**
```
/admin/rates
```

## Passwords

- Spring Security
```
user: admin
password: admin
```

- Database

```
user: user
password: password

```

## About
- Data is gathered from [this RSS feed](https://www.bank.lv/vk/ecb_rss.xml), and stored in a database. 
- Liquibase is used for table creation


## JSON Example for /api/sek

```json
[
    {
        "id": "SEK10",
        "currency": "SEK",
        "rate": 11.1963,
        "date": "2023-01-10"
    },
    {
        "id": "SEK11",
        "currency": "SEK",
        "rate": 11.2783,
        "date": "2023-01-11"
    },
    {
        "id": "SEK9",
        "currency": "SEK",
        "rate": 11.1960,
        "date": "2023-01-09"
    }
]
```
