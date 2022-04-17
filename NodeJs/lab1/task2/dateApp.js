/*
 * Author: Sarah Abdeldaym 
 * Node.js Lab 1 - Task 2
 * Date: 06-04-2022
 * File: dateApp.js
  */

var module = require('./module')

/*if the user entered date before 2020*/ 
module.calculateAge("sarah", 1999);
console.log("........................");

/*if the user entered date after 2020*/ 
module.calculateAge("sarah", 2021);