# digitalrreceipts

The Application sets up the Spring Boot application. The @SpringBootApplication enables auto-configuration and component scanning.

  `$ mvn spring-boot:run`

With mvn spring-boot:run command, we run the application. The application is deployed on embedded Tomcat server.

If you use the Spring Boot Maven to create an executable jar, you can run your application using **java -jar**, as shown in the following example:

  `$ java -jar target/digitalrreceipts-0.0.1-SNAPSHOT.jar`

To access the application enter below url in browser

**http://localhost:8086/api/receipts/all**

which retrieves all the transaction. _(currently it generate transaction logs for last two weeks)_

We can retrieve transactions between two business date, here is the url

**http://localhost:8086/api/receipts?from=yyyy-mm-dd&to=yyyy-mm-dd**
