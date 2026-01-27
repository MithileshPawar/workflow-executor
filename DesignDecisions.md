## Design
1) In memory database (H2) is used as it is lightweight, fast and integrates well with Java and Springboot.
2) Using best practices, the code is appropriately placed in Controller, Service and Repository classes ensuring
each class follows Single Responsibility Principle.

## Trade-offs
1) In memory database (H2) is used to store the data for the application since the application is relatively small. 
The data is lost whenever the application is restarted.
2) Basic authentication using username and password to keep the application simple and easy to use, but still protecting all the endpoints in the app.
