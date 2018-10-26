
SOAP RESTful Web Service Wallet

TASK:
1. Create a Web-based service "Wallet" that emulates the work of an electronic wallet in one currency. By default, you have 100 standard units. 
The wallet has the opportunity:
- to provide information on the balance;
- to pay a certain amount of money for any product (to withdraw money);
- to receive money for the account.
The account has a credit limit of 50 USD. and a maximum of 1000 USD. Calculations are rounded up to 2 characters after a comma. The server has an error handler with corresponding messages.

2. Create a client of the Web-service "Wallet". Create tests for at least 10 cases with the expected result. All operations must be logged in the log file and the result of the test should be logged.


Step to run application:
1. Install Tomcat 7.x or later https://tomcat.apache.org/download-70.cgi on your computer
2. Clone OlehSikorskyiServer file and run with Mavan command: mvn clean install tomcat:run-war
3. Tomcat server will start on http://localhost:8080/OlehSikorskyiService
4. WSDL file you can find on http://localhost:8080/OlehSikorskyiService/wallet?wsdl
5. Clone OlehSikorskyiClient file and run test with Maven command: mvn clean test 
