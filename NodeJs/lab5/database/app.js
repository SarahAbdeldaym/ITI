require('dotenv').config();
const express = require('express')
const app = express()

const connectDB = require("./database/connectDB");

const indexRoutes = require('./routes/index_routes')
const clientRoutes = require('./routes/client_routes')

connectDB(process.env.MONGO_DB_URI);

app.use(express.json())

indexRoutes(app)
clientRoutes(app)

app.use((err, req, res, next) => {
    res.status(422).send({ error: err.message })
})

module.exports = app;