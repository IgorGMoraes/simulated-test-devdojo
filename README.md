# Simulated Test for DevDojo

This project is a Spring Boot simulated test created by [DevDjo YouTube channel](https://www.youtube.com/channel/UCjF0OccBT05WxsJb2zNkL4g). The purpose of the application is to return
a list of financial transactions of a bank client.

The endpoint to get the transactions is `/transactions/{accountId} `

****
#### Functional requirements:
- Develop an endpoint that returns a list of bank transactions based on the mapped json
- Only authenticated users can access this endpoint.
- Each user must have 1 accountId, and it must be unique per user. <br> Example: William has an account 123, David has an
account 890. User William will not be able to see transactions for account 890 and user David will not be able to see
transactions for account 123. If he tries, status 403 should be returned.

****
#### The clients are:
accountId: 123<br>
username: william <br>
password: password<br>

accountId: 890<br>
username: david<br>
password: password<br>

***
#### Technologies used:
- Java
- Spring Boot
- MapStruct to map JSON attributes to desired attributes
- PostgreSQL