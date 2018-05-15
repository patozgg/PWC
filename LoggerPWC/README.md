**Logger Example – Using Spring Boot and Camunda**

This example uses Spring Boot and Camunda. The purpose of this project is to show you how you can 
print out or log the HTTP requests and responses between the Camunda webapps and the internal Camunda Rest Api service using Java Filters. 

**How to Run:**

1.	Download project to your favorite IDE
2.  Run SpringBootProcessApplication.java
3.  Log in into the webapp @http://localhost:8080/ with  Username and Password : demo
4.  Start a process(I've included a BPMN process model by default)
5.  Watch how all the request and response get printed out with the Java Servlet Filter. (You can log them if you want to as well) 
6.  More about filters can be learned here https://docs.oracle.com/javaee/7/api/javax/servlet/ServletRequest.html or http://www.oracle.com/technetwork/java/filters-137243.html
7. Comments have been added in the code for your documentation. 

**Any questions? Please use the issues tab**
