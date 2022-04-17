/*
 * Author: Sarah Abdeldaym 
 * Node.js Lab 1 - Task 1
 * Date: 06-04-2022
 * File: module.js
  */


// add function with error handeling 
function add (num1 , num2){
    if(isNaN(num1) && isNaN(num2)){
        console.log(`${num1} & ${num2} are not numbers`);
    }else if(isNaN(num1)){
        console.log(`${num1} is not a number`);
    }else if(isNaN(num2)){
        console.log(`${num2} is not a number`);
    }else{
        console.log(num1 + num2);
    }
}


// sub function with error handeling 
function sub (num1 , num2){
    if(isNaN(num1) && isNaN(num2)){
        console.log(`${num1} & ${num2} are not numbers`);
    }else if(isNaN(num1)){
        console.log(`${num1} is not a number`);
    }else if(isNaN(num2)){
        console.log(`${num2} is not a number`);
    }else{
        console.log(num1 - num2);
    }
}

//multi function with error handeling 
function multi (num1 , num2){
    if(isNaN(num1) && isNaN(num2)){
        console.log(`${num1} & ${num2} are not numbers`);
    }else if(isNaN(num1)){
        console.log(`${num1} is not a number`);
    }else if(isNaN(num2)){
        console.log(`${num2} is not a number`);
    }else{
        console.log(num1 * num2);
    }
}


// method that can be exported in calciulator class 
module.exports = {
    add: add,
    sub: sub,
    multi: multi
}

