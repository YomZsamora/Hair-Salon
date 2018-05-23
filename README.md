# Hair Salon
A Hair Salon java application that basically manages a stylist's details together with their respective clients.

## Getting Started
This application generally manages the basic operations of a hair salon. The owner should be able to add a list of the stylists, and for each stylist, add clients who see that stylist. The stylists work independently, so each client only belongs to a single stylist.

##### Technologies Used
- Java
- Spark
- JUnit
- Velocity Template Engine

##### Prerequisites
- Basic Git knowledge, including an installed version of Git.
- Your application must run on the OpenJDK version 6, 7 or 8.

##### Installation

- Clone this repository to a location in your file system.
- Database Setup: (Remember to recreate the database, tables and columns accordingly).
	- In PSQL:
		- CREATE DATABASE hair_salon;
		- CREATE TABLE stylists (id serial PRIMARY KEY, first_name varchar, last_name varchar, age integer, phone_no varchar, department varchar);
		- CREATE TABLE clients (id serial PRIMARY KEY, client_first_name varchar, client_last_name varchar, client_phone_no varchar);
		- ALTER TABLE clients ADD stylistId int;

- Open terminal command line then navigate to the root folder of the application.
- Run `gradle run` command.
- Navigate to `http://localhost:4567/` in your browser.


