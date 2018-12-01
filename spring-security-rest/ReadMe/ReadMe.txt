POST
http://localhost:8080/spring-security-rest/j_spring_security_check?j_username=user&j_password=userPass

Store the cookie, but it is optional

Then use the following url to get the value
http://localhost:8080/spring-security-rest/api/foos


http://www.baeldung.com/2011/10/31/securing-a-restful-web-service-with-spring-security-3-1-part-3/