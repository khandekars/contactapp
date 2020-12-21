# Contact Application

The application is implemented as a web application using Spring Boot.
It uses H2 as the in-memory database to store contacts. There are only
four fields - id, firstName, lastName, email. Only constraint is that they
are not null. But in production there null be more like max. length.
Email address has a unique constraint.

Tests and API documentation is not implemented.

To start the application, on the command line type

`java -jar contactapp-0.0.1-SNAPSHOT.jar`

This will start application and listen on port 8080. Two contacts
are added on startup.

###### List all contacts

`curl --request GET
   --url "http://localhost:8080/contact"`
   
###### Add contact

`curl --request POST 
   --url http://localhost:8080/contact 
   --header 'Content-Type: application/json' 
   --data '{
 	"firstName": "John",
 	"lastName": "Connor",
 "email": "sh5@email.com"
 }'`
 
######  Delete contact
 
 `curl --request DELETE 
    --url http://localhost:8080/contact/1 
    --header 'Content-Type: application/json'`
    
######  Update contact
 
 `curl --request PUT 
    --url http://localhost:8080/contact/1 
    --header 'Content-Type: application/json' 
    --data '{
  	"firstName": "J",
  	"lastName": "Connor",
  "email": "sh3@email.com"
  }'`


