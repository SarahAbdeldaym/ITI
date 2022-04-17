/*
 * Author: Sarah Abdeldaym 
 * Node.js Lab 1 - Task 2
 * Date: 06-04-2022
 * File: module.js
  */


function calculateAge(name , birthYear){
    if((birthYear > 1990) && (birthYear < 2020)){
        var currentDate = new Date();
        var currentYear = currentDate.getFullYear();
        var age = currentYear - birthYear;
        console.log(`Hello ,${name} you age now is: ${age}`)
    }else {
        console.log("your age is impossiple")
    }
}

module.exports = {
    calculateAge : calculateAge
}