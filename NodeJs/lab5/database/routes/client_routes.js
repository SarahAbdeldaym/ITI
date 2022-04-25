

const ClientsController = require('../controllers/clients_controller')

module.exports = (app) => {
    app.get('/api/clients', ClientsController.getAllClients)

    app.post('/api/clients', ClientsController.createNewClient)

    app.put('/api/clients/:id', ClientsController.editClient)

    app.delete('/api/clients/:id', ClientsController.deleteClient)

    app.get('/api/clients/:id', ClientsController.getClient)
}