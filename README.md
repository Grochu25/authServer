# auth server
This is a part of library application created to understand jwt tokens and oauth2 authentication server.

This server handles loging in with user credentials and new users registration. It issues and validate jwt tokens.

## Database
To work this application requires an **external MySQL** server with databases:
- *library_users_credentials* - structure and example data stored in library_users_credentials.sql
- *library_data* - structure and example data stored in library_data.sql

Server address and port are specified in environmental variables

There are 4 example users in database:
- users: adam@gmail.com, agnieszka@gmail.com, stefan@gmail.com all with password 'test'
- admin with password 'admin'

Users can login into client appliaciotn and admin can login into admin application.

## Environmental variables
To allow changing addresses and porst of all servers that make up library app, they are specified in environmental variables. Basic setup is placed in **library.env** file:
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
