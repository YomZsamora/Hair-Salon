# Hair Salon

A Hair Salon java application that basically manages a stylist's details together with their respective clients.

[![hairsalon.png](https://i.postimg.cc/VLPPf334/hairsalon.png)](https://postimg.cc/fkCr5gW0)

## Getting Started

This application generally manages the basic operations of a hair salon. The owner should be able to add a list of the stylists, and for each stylist, add clients who see that stylist. The stylists work independently, so each client only belongs to a single stylist.

## Specifications

### Behaviour Driven Development

1. add stylists to records
   - INPUT:"Enter stylists details"
2. add client to stylist
   - INPUT:"select saved stylists"
   - INPUT:"click on add client button"
   - INPUT:"Enter client's details"
   - OUTPUT:"Success message"
3. view stylist's clients
   - INPUT:"go to all stylists page"
   - INPUT:"select a stylist and click on view clients link"
   - OUTPUT:"Display clients for the respective stylist"
4. delete a stylist
   - INPUT:"go to all stylists page"
   - INPUT:"select a stylist and click on delete stylist link"
5. update stylist details
   - INPUT:"go to all stylists page"
   - INPUT:"select a stylist and click on update details link"
   - INPUT:"enter updated info for respective stylist"
   - OUTPUT:"Display clients for the respective stylist"
6. delete client from stylist
   - INPUT:"go to all stylists page"
   - INPUT:"select a stylist and click on view clients link"
   - INPUT:"select a client and click on delete client link"


## Prerequisites

- Basic Git knowledge, including an installed version of Git.
- Your application must run on the OpenJDK version 6, 7 or 8.

## Technologies Used 

- Java v9
- Gradle
- Spark Framework
- CSS (Bootstrap)
- JUnit v4.12
- Jacoco Plugin
- PostgreSQL
- Velocity Templating Engine


## Setup Installations Requirements
   * To run the application, in your terminal:

    1. Clone or download the Repository
    2. cd into directory then run `gradle run` command on the terminnal
    3. Database Setup: (Remember to recreate the database, tables and columns accordingly).
		- In PSQL:
			- CREATE DATABASE hair_salon;
			- CREATE TABLE stylists (id serial PRIMARY KEY, first_name varchar, last_name varchar, age integer, phone_no varchar, department varchar);
			- CREATE TABLE clients (id serial PRIMARY KEY, client_first_name varchar, client_last_name varchar, client_phone_no varchar);
			- ALTER TABLE clients ADD stylistId int;
    4. Open terminal command line then navigate to the root folder of the application.
    5. Run `gradle run` command.
    6. Navigate to `http://localhost:4567/` in your browser.
  

### Development

Want to contribute? Great!

To fix a bug or enhance an existing module, follow these steps:

- Fork the repo
- Create a new branch (`git checkout -b improve-feature`)
- Make the appropriate changes in the files
- Add changes to reflect the changes made
- Commit your changes (`git commit -am 'Improve feature'`)
- Push to the branch (`git push origin improve-feature`)
- Create a Pull Request 

## Known Bugs

If you find a bug (the website couldn't handle the query and / or gave undesired results), kindly open an issue [here](https://github.com/yomZsamora/Hair-Salon/issues/new) by including your search query and the expected result.

If you'd like to request a new function, feel free to do so by opening an issue [here](https://github.com/yomZsamora/Hair-Salon/issues/new). Please include sample queries and their corresponding results.

### License

*MIT*
Copyright (c) 2018 **Yommie Samora**

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.



