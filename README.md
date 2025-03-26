# auth server
This is a part of a library application created to understand JWT tokens and the OAuth2 authentication server.

The server handles user login with credentials and new user registration. It also issues and validates JWT tokens.

Other parts of application:
- [Resource server](https://github.com/Grochu25/library-resource)
- [Admin client app](https://github.com/Grochu25/library-admin-client)
- client app (in progress)

Server allows only for login from admin app and client app.

## Database
To run this application, an external **MySQL server** is required with the following databases:
- *library_users_credentials* - Structure and example data are stored in library_users_credentials.sql
- *library_data* - Structure and example data are stored in library_data.sql

The server address and port are specified in environmental variables.

There are 4 example users in the database:
- users: adam@gmail.com, agnieszka@gmail.com, stefan@gmail.com all with password 'test'
- admin with password 'admin'

Users can log in to the client application, and the admin can log in to the admin application.

## Environmental variables
To allow changing the addresses and ports of all servers that make up the library app, they are specified in environmental variables. The basic setup is placed in the **library.env** file:
- MYSQL_HOSTNAME=localhost
- ADMIN_HOSTNAME=127.0.0.1
- AUTH_HOSTNAME=localhost
- RESOURCE_HOSTNAME=localhost
- CLIENT_HOSTNAME=localhost
- MYSQL_PORT=3306
- ADMIN_PORT=8000
- AUTH_PORT=9000
- RESOURCE_PORT=8080
- CLIENT_PORT=5173

## Docker
To dockerize this application segment there is ready to use **Dockerfile** inside project root folder.

To use whole application with all segments there is a **docker-compose.yml**, that pulls all necessary images and sets up the network between them. Only thing user have to do to use compose file without changes is to add alias AUTH_HOSTNAME for localhost
