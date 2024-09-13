const STATUS_CODES = require('../utils/statusCodes');
const userService = require('../services/userService');

const getAllUsers = (req, res) => {
    userService.getAllUsers(req.query)
        .then(users => {
            res.status(STATUS_CODES.OK).json(users);
        })
        .catch(err => {
            console.error('Service error:', err.message);
            res.status(STATUS_CODES.INTERNAL_SERVER_ERROR)
                .json({ error: `${STATUS_CODES.INTERNAL_SERVER_ERROR} Internal Server Error. Error: ${err.message}` });
        });
};

const getOneUser = (req, res) => {
    userService.getOneUser(req.params.userId) // if error, will not go into 'then'
        .then(user => {
            res.status(STATUS_CODES.OK).json(user);
        })
        .catch(err => {
            console.error('Service error:', err.message);
            res.status(STATUS_CODES.INTERNAL_SERVER_ERROR)
                .json({ error: `${STATUS_CODES.INTERNAL_SERVER_ERROR} Internal Server Error. Error: ${err.message}` });
        });
};

const createNewUser = (req, res) => {
    userService.createNewUser(req.body)
        .then(newUser => {
            res.status(STATUS_CODES.CREATED).json(newUser);
        })
        .catch(err => {
            console.error('Service error:', err.message);
            res.status(STATUS_CODES.INTERNAL_SERVER_ERROR)
                .json({ error: `${STATUS_CODES.INTERNAL_SERVER_ERROR} Internal Server Error. Error: ${err.message}` });
        });
};

const updateOneUser = (req, res) => {
    userService.updateOneUser(req.params.userId, req.body)
        .then(updatedUser => {
            res.status(STATUS_CODES.OK).json(updatedUser);
        })
        .catch(err => {
            console.error('Service error:', err.message);
            res.status(STATUS_CODES.INTERNAL_SERVER_ERROR)
                .json({ error: `${STATUS_CODES.INTERNAL_SERVER_ERROR} Internal Server Error. Error: ${err.message}` });
        });
};

const deleteOneUser = (req, res) => {
    userService.deleteOneUser(req.params.userId)
        .then(result => {
            res.status(STATUS_CODES.OK).json(result);
        })
        .catch(err => {
            console.error('Service error:', err.message);
            res.status(STATUS_CODES.INTERNAL_SERVER_ERROR)
                .json({ error: `${STATUS_CODES.INTERNAL_SERVER_ERROR} Internal Server Error. Error: ${err.message}` });
        });
};

module.exports = {
    getAllUsers,
    getOneUser,
    createNewUser,
    updateOneUser,
    deleteOneUser
};
