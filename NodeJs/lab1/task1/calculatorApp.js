/*
 * Author: Sarah Abdeldaym 
 * Node.js Lab 1 - Task 1
 * Date: 06-04-2022
 * File: calculator.js
  */



/* requiring of module class to import its funtions*/
var module = require('./module');


/*check the output of add method*/
console.log("check adding method with all possible inputes");
module.add(10,10);
module.add('num1', 'num2');
module.add('num1',10);
module.add(10, 'num2');
console.log("..................................................................");

/*check the output of add method*/
console.log("check sub method with all possible inputes");
module.sub(20,10);
module.sub('num1', 'num2');
module.sub('num1', 10);
module.sub(10, 'num2');
console.log("..................................................................");

/*check the output of add method*/
console.log("check multi method with all possible inputes");
module.multi(10, 10);
module.multi('num1', 'num2');
module.multi('num1', 10);
module.multi(10, 'num2');




