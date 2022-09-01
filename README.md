# security-jwt

security.version 5.7.3

jdk11

spring boot 2

demo for https://www.toptal.com/spring/spring-security-tutorial


## login


curl -i -X POST \
   -H "Content-Type:application/json" \
   -d \
'{
  "username":"admin",
  "password":"admin"
}' \
 'http://localhost:8888/jwt/api/login'
 
 
curl -i -X POST \
   -H "Content-Type:application/json" \
   -d \
'{
  "username":"user",
  "password":"user"
}' \
 'http://localhost:8888/jwt/api/login' 


## bizRequest

curl -i -X GET \
   -H "Authorization:Bearer eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJpc3N1ZXIiLCJhdWQiOiJhdXQiLCJqdGkiOiJhZG1pbiIsImlhdCI6MTY2MjAyMTQ0OSwiZXhwIjoxNjYyMDUwMjQ5LCJzdWIiOiJbe1wiYXV0aG9yaXR5XCI6XCJST0xFX0FETUlOXCJ9LHtcImF1dGhvcml0eVwiOlwiUk9MRV9VU0VSXCJ9XSJ9.TWlfoN12991_0LV2wua-wgNu6E55JQMXdxzR3ffYi1A" \
 'http://localhost:8888/jwt/user'
 
 
 curl -i -X GET \
   -H "Authorization:Bearer eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJpc3N1ZXIiLCJhdWQiOiJhdXQiLCJqdGkiOiJhZG1pbiIsImlhdCI6MTY2MjAyMTQ0OSwiZXhwIjoxNjYyMDUwMjQ5LCJzdWIiOiJbe1wiYXV0aG9yaXR5XCI6XCJST0xFX0FETUlOXCJ9LHtcImF1dGhvcml0eVwiOlwiUk9MRV9VU0VSXCJ9XSJ9.TWlfoN12991_0LV2wua-wgNu6E55JQMXdxzR3ffYi1A" \
 'http://localhost:8888/jwt/admin'
