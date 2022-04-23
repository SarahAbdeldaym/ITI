
let emitter = require('events')
let util = require('util')

function emitterCopy() {
    emitter.call(this)

    this.greet = function() {
        console.log("Hello I am the function")
        this.emit('greet')
    }
}

util.inherits(emitterCopy, emitter)

module.exports = {
    emitter: emitterCopy
}

let em = require('./task1').emitter

let event = new em()

event.on('greet', function() {
    console.log("Hello I am the Event")
})

event.greet()