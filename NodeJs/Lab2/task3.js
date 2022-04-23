const fs = require('fs');


console.log("Rename file from test.txt to info.txt");
console.log("...............................................");

function ls() {
    console.log("Files:");
    fs.readdirSync(__dirname).forEach(file => {
        console.log(file);
    });
}

ls();

fs.rename('test.txt', 'info.txt', () => {
    console.log("\nDone (Renamed)\n");
    ls();
});

console.log("----------------------------");

//////////////////////////////////////////////////////////////////////////////////
console.log("removev file");
console.log("...............................................");

try {
    fs.unlinkSync("./txt.txt")
    console.log('file \nDone (Removed)\n');
} catch (err) {
    console.error(err)
}

console.log("----------------------------");
////////////////////////////////////////////////////////////////////////////////////////
console.log(" Read data from data.json file as sync");
console.log("...............................................");

let fileData = fs.readFileSync('./data.json', 'utf8');
console.log(JSON.parse(fileData));
console.log("\nDone (Synchronous)\n");
console.log("----------------------------");

///////////////////////////////////////////////////////////////////////////////////////
console.log(" Read data from data.json file as sync");
console.log("...............................................");

var readfile = fs.createReadStream('./data.json', { encoding: 'utf8', highWaterMark: 32 * 1024 })
readfile.on('data', function (chunk) {
    console.log(JSON.parse(chunk))
})

console.log("\nDone (Asynchronous)\n");
console.log("----------------------------");

//////////////////////////////////////////////////////////////////////////////
console.log("  Write file inside file info.txt “hello iti”");
console.log("...............................................");

fs.writeFileSync('./info.txt', "Hello iti");
console.log("\nDone (Write)\n");
console.log("----------------------------");

///////////////////////////////////////////////////////////////////////////
console.log("  Create directory");
console.log("...............................................");

fs.access('./DIR', (error) => {
    if (error) {
        fs.mkdir('./DIR', (error) => {
            if (error) {
                throw error;
            }
            console.log("\nDone (Directory is created)\n");
        });
    } else {
        console.log("\nERROR (Directory is already exist)\n");
    }
});
console.log("----------------------------");