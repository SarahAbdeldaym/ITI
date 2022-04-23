

const fs = require('fs');


const readline = require('readline');
const file = readline.createInterface({
    input: fs.createReadStream('txtfile.txt'),
    output: process.stdout,
    terminal: false
});
file.on('line', (line) => {
    console.log(line);
});
console.log("----------------------------");
