# Car-lease-Platform-API

## starting the application
jdk25 is required for this application\
In intellij:\
The application can be started using `mvn spring-boot:run`\
Or by pressing the play button in CarleaseApplication.java


## Authentication
Within the authentication in the application roles get added to the jwt.\
For testing purposes using the username 'broker' will give you the broker role and 'leaser' will give you the leaser role.

The signin call url is `http://localhost:8080/signin/{username}` \
Sending a get request to the url gives you the jwt as response which needs to be added as bearer in all subsequent calls.

For instance as a broker:
```
curl -X 'GET' \
'http://localhost:8080/signin/broker' \
-H 'accept: application/json'
```

## available calls
Swagger ui starts automatically on startup of spring boot.\
It can be found at: http://localhost:8080/swagger-ui/index.html \
The jwt can be requested using swagger-ui, and added for the calls using the authorize button.
