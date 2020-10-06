# demo-integration
Spring Integration Rest Service Example

To run the application 

`./gradlew bootRun`

or 
`java -jar build/libs/demo-integration-0.0.1-SNAPSHOT.jar`

#### Send an valid request

`curl --location --request POST 'http://localhost:8080/demo' --header 'Content-Type: application/json' --data-raw '{"msisdn":"69999999",  "notificationType":"Renewal",  "serviceClassId":4123,  "languageId":1,  "transactionId":"WEB_11.131.13.109_5c81deb8-8317-4737-a24f-30d6579a5fcf"}'`

#### Send an invalid request

`curl --location --request POST 'http://localhost:8080/demo' --header 'Content-Type: application/json' --data-raw '{"msisdn":"",  "notificationType":"Renewal",  "serviceClassId":4123,  "languageId":1,  "transactionId":"WEB_11.131.13.109_5c81deb8-8317-4737-a24f-30d6579a5fcf"}'`