# Very Good Hair Salon

#### By **Matthew F Nicholas**

## Description
A salon webpage with interface for clients and employees

## Setup/Installation Requirements
* open the directory in the console
* build the database with the following command:
    -Connect to psql and run:
        # CREATE DATABASE hair_salon;
    -Now from the command line run:
        $ psql hair_salon < hair_salon.sql
* compile and run App.class


### BDD
| Behavior:                              | Input Example:                             | Output Example:                            |
|----------------------------------------|--------------------------------------------|--------------------------------------------|
| Can create stylist                     | "Bill"                                     |  "Bill"                                    |
| Can edit stylist info                  | "Marge"                                    | "Marge"                                    |
| Can delete stylist                     | "delete"                                   | null                                       |
| Can create client                      | "Alana "                                   | "Alana"                                    |
| Can edit client info                   | "5551010"                                  | "5551010"                                  |
| Can delete client                      | "delete"                                   | null                                       |


## Support and contact details
Matt Nicholas: fostermatt82@gmail.com

## Technologies Used
This site was designed using HTML, CSS, Bootstrap, Java, Spark, Junit and Velocity
View the source code at https://github.com/Matt-Nicholas/java-w3-solo-hair-salon

### License
*This site is Licensed under the MIT licensing*

Copyright (c) 2016 **_Matt Nicholas_**
