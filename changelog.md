# Project 5- Quoco REST
## Parth Parmar - 22200205


## Task 1

- Created project structure with all 6 modules and added the spring boot dependency on the services and broker pom on all of them.
- Modified the Quotation and ClientInfo classes to be java beans by setting variables to private and initializing the getter and setter methods for them.
- Added a private and public constructor of both classes.
- Removed implementation of the QuotationService and deleted the class.
- Installed and compiled the core project with version as 0.0.1.

## Task 2

- Removed the reference of quotationservice interface. Annotated the AFQService class with @RestController to make it a controller on the web.
- Added the createQuotation method in AFQService which is a post request and generates the auldfellas quotation and returns them.
- Added a method to represent the resource by method getResource which will return the specific quotation
- Added the method NoSuchQuotationException method to throw a proper error in case our api call fails.
- In the generateQuotation method replaced the interface variable calls with getter methods for the variable.
- Created the application class for auldfellas to make it a spring application and added the run method from the spring package in the main method.
- Tested the api through postman by passing in a json input.
- Made the displayProfile and displayQuotation methods in the client file and the clients data-field from the old client class.
- In the main method called the quotation list on auldfellas service to display it.(for testing purposes, it will be replaced with its own url /application later)
- 

## Task 3

- Implemented the dodgydrivers and girlpower services.
- Created application.properties file in resources of all three services and declared the port using server.port as 8081,8082 and 8083 for the three services.

## Task 4

- Converted the LocalBrokerService as a REST controlller.
- Stored the urls in an array list and made it a static variable so it can be called to the spring application class and to loop over in getquotations method.
- Created method getQuotations and looped over all three services to get their quotations and store them in the ClientInfo.
- Created method getApplication which is a POST request on /application and it gets the quotation lists from the clientinfo and returns the quotations with an application number(seed_id) and all this is stored in a hashmap
- To implement the hashmap a java bean called clientApplication is created in the core service which stores the quotation list, application number and clientinfo with setter and getter methods.
- Created a method returnApplication to get the clientinfo objects and display them when client run /application GET request.
- Created a GET method getSpecificApplication to fetch an individual application which takes seed_id as its parameter.
- Compiled and ran all three services and broker and tested it with the client.

## Task 5

- Ran the mvn package command after adding maven-assembly-plugin to all the services and broker to create their jar files.
- Added the docker file in all modules except client using package openjdk1.8 and gave references to their jar files.
- In the docker-compose files defined the services with ports accordingly and depends on broker so it starts the broker first.
- Made Broker expose at port 8080.
- Gave container names to all three services and in the dockerfile of the broker specified the services with their container names and ports so broker can listen to all 3 services.
- Ran docker compose up and mvn exec:java -pl client to test the client with the broker.