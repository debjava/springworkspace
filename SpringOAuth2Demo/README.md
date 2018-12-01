SpringOAuth2.0Demo
==================

Spring OAuth 2.0 Demo With Password Grant Type
----------------------------------------------
http://aurorateam.wordpress.com/2013/03/04/how-to-oauth-2-0-with-spring-security-2/

Protected Resource
------------------
#### URL
http://localhost:8080/oauth2/test/ateam
#### URI
/test/ateam


OAuth2 Token Request
--------------------
#### URL
http://localhost:8080/oauth2/oauth/token?grant_type=password&client_id=my-trusted-client-with-secret&client_secret=somesecret&username=user&password=password
#### URI
/oauth/token?grant_type=password&client_id=my-trusted-client-with-secret&client_secret=somesecret&username=user&password=password

Secure Resource Access With OAuth Token 
---------------------------------------
#### URL
http://localhost:8080/oauth2/test/ateam?access_token=987aab49-3ccf-43db-a9d4-8a10198ec5d0
#### URI
/test/ateam?access_token=987aab49-3ccf-43db-a9d4-8a10198ec5d0
