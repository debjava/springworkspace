http://localhost:8080/spring-rest-service-oauth/oauth/token?password=spring&username=roy&grant_type=password&scope=read&client_secret=123456

POST

Click on Authentication
Provide username as clientapp
password as 123456

Actual Curl Request
curl -X POST -vu clientapp:123456 http://localhost:8080/spring-rest-service-oauth/oauth/token -H "Accept: application/json" -d "password=spring&username=roy&grant_type=password&scope=read%20write&client_secret=123456&client_id=clientapp"

2)

http://localhost:8080/spring-rest-service-oauth/greeting

GET

Request Header as

Authorization

Bearer 8157c482-f65d-4c63-a157-cd618200299a



Reference
---------
https://github.com/royclarkson/spring-rest-service-oauth


http://porterhead.blogspot.in/2013/01/writing-rest-services-in-java-part-6.html


http://porterhead.blogspot.co.uk/2014/05/securing-rest-services-with-spring.html


