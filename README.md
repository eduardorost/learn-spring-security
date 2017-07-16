# learn-spring-security

Insert admin user in database
```
INSERT INTO USER VALUES (1, 1, 'admin', 'admin', CURDATE());
INSERT INTO ROLE VALUES (1, 'ROLE_ADMIN', 1);
```

Register a new user
```
curl -H "Content-Type: application/json" -X POST -d '{ "login":"user", "password":"user" }' http://localhost:9000/v1/api/users
```

Testing roles
```
curl -X GET http://user:user@localhost:9000/v1/api/actions/user (STATUS 200)
curl -X GET http://user:user@localhost:9000/v1/api/actions/admin (STATUS 403)
curl -X GET http://admin:admin@localhost:9000/v1/api/actions/admin (STATUS 200)
```

If you want the x-auth-token, you will need to login using this url
```
curl -u user:user http://localhost:9000/v1/api/login
```
